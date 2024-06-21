class ArchiveMenu {

    private val menuUtils = MenuUtils("Список архивов")

    private val noteMenu = NoteMenu()

    private fun createArchive() {
        println("Введите название")
        val name = menuUtils.userInput()

        archiveList.add(Archive(name, mutableListOf()))

        println("$name архив успешно создан")
    }

    private fun showArchives() {
        println("Чтобы выбрать архив для создания заметки введите его номер. Чтобы вернуться назад введите \"назад\"")
        val index = menuUtils.chooseMenu(
            printMenu = { archiveList.forEachIndexed { index, archive -> println("$index. $archive") } },
            archiveList.indices
        )

        if (index == -1) return

        noteMenu.start(archiveList[index])
    }

    fun start() {
        while (true) {
            when(menuUtils.chooseMenu( printMenu = { menuItems.forEachIndexed { index, s -> println("$index. $s") } }, menuItems.indices )) {
                0 -> { createArchive() }
                1 -> { showArchives() }
                else -> {
                    println("Всего хорошего!")
                    break
                }
            }
        }
    }

    companion object {
        private val menuItems = listOf( "Создать архив", "Это мой уже созданный архив", "Выход")
        private val archiveList: MutableList<Archive> = mutableListOf()
    }

}