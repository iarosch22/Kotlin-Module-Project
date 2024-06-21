import java.util.Scanner

class MenuUtils( private val menuName: String ) {

    private val scanner = Scanner(System.`in`)

    fun userInput(): String {
        var value: String

        do {
            value = scanner.nextLine().trim().lowercase()
            if (value.isEmpty()) {
                println("Введите значение, поле не должно быть пустым.")
            }
        } while (value.isEmpty())

        if (value == "назад") return "-1"

        return value
    }

    fun chooseMenu( printMenu: () -> Unit, intRange: IntRange ): Int {
        val answer: Int
        println("$menuName:")
        printMenu()

        while (true) {
            val input = userInput().toIntOrNull()

            if (input == -1) return -1

            if (input != null) {
                if (input in intRange) {
                    answer = input
                    break
                } else {
                    println("Необходимо ввести цифру из предложенных.")
                    println("$menuName:")
                    printMenu()
                }
            } else {
                println("Необходимо ввести цифру.")
                println("$menuName:")
                printMenu()
            }
        }

        return answer
    }

}
