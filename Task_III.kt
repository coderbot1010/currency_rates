fun main()
{
    fibonacci(10)
    println("---------------------")
    fibonacciRecursive(10, 0, 1)
}

fun fibonacci(number: Int)
{
    var n1 = 0
    var n2 = 1
    for (i in 1..number)
    {
        val sum = n1 + n2
        println(sum)
        n1 = n2
        n2 = sum
    }
}

fun fibonacciRecursive(count: Int, n1: Int, n2: Int)
{
    println(n1 + n2)
    if (count > 1)
    {
        fibonacciRecursive(count - 1, n2, n1 + n2)
    }
}