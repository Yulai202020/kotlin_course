import kotlin.random.Random

fun main() {
    // Random.nextInt() // any int
    // Random.nextDouble() // from 0 to 1
    // Random.nextDouble(5.0, 10.0) // from 5 to 10 (including double)

    val random_number = Random.nextInt(0, 10); // from 0 to 9

    print("Guess number from 0 to 9: ")
    val input_number: Int = readln().toIntOrNull() ?: 0;

    if (input_number == random_number) {
        println("You right!")
    } else {
        println("You wrong...");
    }
}