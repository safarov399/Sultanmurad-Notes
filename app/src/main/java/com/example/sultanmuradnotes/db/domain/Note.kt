package com.example.sultanmuradnotes.db.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.sultanmuradnotes.utility.Converters
import java.time.LocalDateTime

@TypeConverters(Converters::class)
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "content") var content: String,
    @ColumnInfo(name = "time_of_creation") var timeOfCreation: LocalDateTime = LocalDateTime.now(),
    @ColumnInfo(name = "time_of_modification") var timeOfModification: LocalDateTime = LocalDateTime.now(),
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
