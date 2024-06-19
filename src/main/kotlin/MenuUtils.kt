import java.util.Scanner

class MenuUtils(
    private val menuName: String,
    private val menuItems: List<String>
) {

    private val scanner = Scanner(System.`in`)

    fun printMenu() {
        println("$menuName:")
        menuItems.forEachIndexed { index, element -> println("$index. $element") }
    }

    fun userInput(): String {
        var value: String

        while (true) {
            value = scanner.nextLine()

            if (value.isNotEmpty()) break

            println("Введите значение, Поле не должно быть пустым.")
        }

        return value
    }

    fun chooseMenu(): Int {
        val answer: Int

        while (true) {
            val input = userInput().toIntOrNull()

            if (input != null) {
                if (input in 0..3) {
                    answer = input
                    break
                } else {
                    println("Необходимо ввести цифру из предложенных.")
                    printMenu()
                }
            } else {
                println("Необходимо ввести цифру.")
                printMenu()
            }
        }

        return answer
    }

}