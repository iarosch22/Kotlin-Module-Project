class ArchiveMenu {

    private val menuItems = listOf( "Создать архив", "Это мой уже созданный архив", "Выход")

    private val menuUtils = MenuUtils("Список архивов", menuItems)

    private val archiveList: MutableList<Archive> = mutableListOf()

    fun start() {
        menuUtils.printMenu()

        askReply()
    }

    private fun createArchive() {
        println("Введите название")
        val name = menuUtils.userInput()

        archiveList.add(Archive(name, mutableSetOf()))

        println("$name архив успешно создан")
    }

    private fun printArchives() {
        archiveList.forEachIndexed { index, archive -> println("$index. $archive") }
    }

    private fun askReply() {
        while (true) {
            when(menuUtils.chooseMenu()) {
                0 -> {
                    createArchive()
                    menuUtils.printMenu()
                }
                1 -> {
                    printArchives()
                }
                2 -> {
                    println("Всего хорошего!")
                    break
                }
            }
        }
    }

}