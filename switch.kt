fun main() {
    val number: Int = readln().toIntOrNull() ?: 0;

    print("You inputed number: ");
    when (number) {
        1 -> println("One")
        2 -> println("Two")
        3 -> println("Three")
        else -> println("Other")  // default case
    }

    // with many options
    print("Your number is: ")
    when (number) {
        1, 3, 5, 7, 9 -> println("Odd")
        2, 4, 6, 8, 10 -> println("Even")
        else -> println("Out of range")
    }
}