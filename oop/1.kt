// internal is public module but in other modules its private
// public (by defualt) is public for all modules
// private is private for everyone except file where class was created
// protected (just for parameters) is public for subclasses and in that class where its was inited
// same for parameters of class

class Person(val firstname:String = "Peter", val secondName:String = "Parker") { // init 2 const with defualts Peter and Parker (its changes if u in contructer input different names)
    init {
        print("Class is inited");
    }

    var nickname: String? = null
        set(value) {
            field = value; // updating value
            println("Value is setted to $value");
        }

        get() {
            println("Request to get nickname");
            return field;
        }

    public fun printFullName() [
        print("a");
        return "a";
    ]
}

fun main() {

}