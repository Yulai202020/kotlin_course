fun main() {
    for (i in 1..3) { // including 1 and 3
        println("*".repeat(i)); // making pyromid
    }

    // backwards
    for (i in 5 downTo 1) {  // 5 to 1
        println(i)
    }

    // without 5
    for (i in 1 until 5) {  // 1 to 4 (5 is excluded)
        println(i)
    }

    // with step (here is just even but if u will start with 1 its will be only odd numbers)
    for (i in 0..10 step 2) {  // 0, 2, 4, 6, 8, 10
        println(i)
    }

    // same as for
    repeat(5) { i ->
        println("Iteration $i")
    }

    // for in list
    val fruits = listOf("Apple", "Banana", "Cherry")
    for (fruit in fruits) {
        println(fruit)
    }

    fruits.forEach { fruit ->
        println(fruit)
    }

    // with index
    for ((index, fruit) in fruits.withIndex()) {
        println("$index: $fruit")
    }

    // while
    var input: String?;

    while (true) {
        print("Enter something (type 'exit' to quit): ")
        input = readLine();
        
        if (input == "exit") break
        
        println("You typed: $input")
    }

    // do while its minimun 1 time will make loop
    var i = 1
    do {
        println(i)
        i++
    } while (i <= 5)
}