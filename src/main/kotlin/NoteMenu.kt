class NoteMenu {

    private val menuItems = listOf( "Создать заметку", "Это моя уже созданная заметка", "Выход")

    private fun createNote(archive: Archive, noteName: String, content: String): Note {
        return Note(noteName, content)
    }

    private val menuUtils = MenuUtils("Список заметок", menuItems)



}