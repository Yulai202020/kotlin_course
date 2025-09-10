fun greet() {
    println("Hello!")
}

// using overloading (for overloading function must be different (different parameters)
fun greet(name: String) {
    println("Hello, $name!")
}

// with return
fun sum(a: Int, b: Int): Int // this is type of return
{
    return a + b
}

fun main() {
    greet(); // print Hello!

    greet("Yulai"); // print Hello, Yulai!

    println("sum of 1 and 2 is ${sum(1, 2)};")
}