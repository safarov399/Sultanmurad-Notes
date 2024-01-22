package com.example.sultanmuradnotes.utility



data class NoteColor(
    val mainColor: Long,
    val textColor: Long
) {



    companion object {
        private val navy = NoteColor(0xFF000080, 0xFFFFFFFF)
        private val mint = NoteColor(0xFF98FB98, 0xFF000000)
        private val royalPurple = NoteColor(0xFF4B006E, 0xFFFFFFFF)
        private val antique = NoteColor(0xFFFAEBD7, 0xFFFFFFFF)
        private val azure = NoteColor(0xFF007FFF, 0xFFFFFFFF)
        private val forest = NoteColor(0xFF0B6623, 0xFFFFFFFF)
        private val cyber = NoteColor(0xFFFFD300, 0xFFFFFFFF)
        private val carmine = NoteColor(0xFFFF0038, 0xFFFFFFFF)
        val colorList: List<NoteColor> = listOf(navy, mint, royalPurple, antique, azure, forest, cyber, carmine)
    }
}