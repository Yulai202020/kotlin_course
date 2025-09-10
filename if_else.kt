fun main() {
    // readLine returns null if the end-of-file (EOF) is reached
    // readln is throw error on EOF

    print("Input any number: ")
    var number = readLine()?.toIntOrNull() ?: 0;

    if (number == 2) {
        println("number is equal 2");
    } else if (number != 2 && number != 3) {
        println("number is not equal 2 and 3");
    } else {
        println("number is 3");
    }
}