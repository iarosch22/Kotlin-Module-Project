class NoteMenu() {

    private fun createNote( ): Note {
        println("Введите название")
        val name = menuUtils.userInput()

        println("Введите текст заметки")
        val content = menuUtils.userInput()

        println("Заметка \"$name\" успешно добавлена")

        return Note(name, content)
    }

    private fun showNote(noteList: MutableList<Note>) {
        if (noteList.isEmpty()) {
            println("Пока заметок нет")
            return
        }

        println("Для выбора заметки необходимо ввести ее номер. Чтобы вернуться назад введите - \"назад\"")
        val index = menuUtils.chooseMenu( printMenu = { noteList.forEachIndexed { index, note -> println("Заметка ${index}. ${note.name}") } }, noteList.indices )
        if (index == -1) return

        println(noteList[index])
    }

    private val menuUtils = MenuUtils("Список заметок")

    fun start(archive: Archive) {
        while (true) {
            when(menuUtils.chooseMenu( printMenu = { menuItems.forEachIndexed { index, s -> println("$index $s") } }, menuItems.indices )) {
                0 -> { archive.addNote(createNote()) }
                1 -> { showNote(archive.content) }
                else -> break
            }
        }
    }

    companion object {
        private val menuItems = listOf( "Добавить заметку в архив", "Это моя уже созданная заметка", "Выход")
    }

}