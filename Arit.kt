fun main() {
    // Function to add two numbers
    fun add(a: Double, b: Double): Double {
        return a + b
    }

    // Function to subtract two numbers
    fun subtract(a: Double, b: Double): Double {
        return a - b
    }

    // Function to multiply two numbers
    fun multiply(a: Double, b: Double): Double {
        return a * b
    }

    // Function to divide two numbers
    fun divide(a: Double, b: Double): Double {
        if (b == 0.0) {
            println("Error: Division by zero is not allowed.")
            return Double.NaN
        }
        return a / b
    }

    // Read the first number from the user
    println("Enter the first number:")
    val num1 = readLine()?.toDoubleOrNull() ?: run {
        println("Invalid input.")
        return
    }

    // Read the second number from the user
    println("Enter the second number:")
    val num2 = readLine()?.toDoubleOrNull() ?: run {
        println("Invalid input.")
        return
    }

    // Read the operation from the user
    println("Enter the operation (+, -, *, /):")
    val operation = readLine()

    // Perform the chosen operation and display the result
    val result = when (operation) {
        "+" -> add(num1, num2)
        "-" -> subtract(num1, num2)
        "*" -> multiply(num1, num2)
        "/" -> divide(num1, num2)
        else -> {
            println("Invalid operation.")
            return
        }
    }

    // Display the result
    println("Result: $result")
}