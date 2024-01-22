package com.example.sultanmuradnotes.db.domain

import androidx.compose.ui.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.sultanmuradnotes.utility.Converters
import java.time.LocalDateTime

@TypeConverters(Converters::class)
@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "content") var content: String,
    @ColumnInfo(name = "background_color") var backgroundColor: Long = 0xFF000000,
    @ColumnInfo(name = "text_color") var textColor: Long = 0xFFFFFFFF,
    @ColumnInfo(name = "time_of_creation") var timeOfCreation: LocalDateTime = LocalDateTime.now(),
    @ColumnInfo(name = "time_of_modification") var timeOfModification: LocalDateTime = LocalDateTime.now(),

//    @ColumnInfo(name = "font_size") var fontSize: Int
) {

    constructor(): this(null, "")
    override fun toString(): String {
        return "Note{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timeOfCreation=" + timeOfCreation +
                ", timeOfModification=" + timeOfModification +
                '}'
    }
}
