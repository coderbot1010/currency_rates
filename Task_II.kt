fun main()
{
    print(isAnagram("punishments","nine thumps"))
}

fun isAnagram(main: String, other: String): Boolean
{
    return if (main.length == other.length)
    {
        var allMatch = true
        other.forEach {
            if (!main.contains(it) || main.count { char -> char == it } != other.count{char -> char == it}) allMatch = false
        }
        allMatch
    }
    else false
}