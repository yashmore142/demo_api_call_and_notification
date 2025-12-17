package com.example.demoapi_call


fun main() {
    println("reverseString: "+reverseString("Hello World"))
    println("secondLargest: "+secondLargest(listOf(5, 2, 9, 1, 7)))
    println("sortNumbersAndStrings: "+sortNumbersAndStrings("Yash 123 more 3445"))
    println("isPalindrome: "+isPalindrome("madam"))
}

fun reverseString(input: String): String {
    val words = ArrayList<String>()
    var current = ""

    for (ch in input) {
        if (ch == ' ') {
            words.add(current)
            current = ""
        } else {
            current += ch
        }
    }
    words.add(current)
    return words.toString()
}
fun secondLargest(nums: List<Int>): Int {
    var largest = 0
    var second = 0

    for (num in nums) {
        if (num > largest) {
            second = largest
            largest = num
        } else if (num > second && num != largest) {
            second = num
        }
    }
    return second
}

fun sortNumbersAndStrings(input: String) : String{

    val letters = StringBuilder()
    val numbers = StringBuilder()
    for (ch in input) {
        if (ch in 'A'..'Z' || ch in 'a'..'z') {
            letters.append(ch)
        } else if (ch in '0'..'9') {
            numbers.append(ch)
        }
    }
    return "letters:-$letters  numbers:-$numbers"
}

fun isPalindrome(str: String): Boolean {
    var left = 0
    var right = str.length - 1

    while (left < right) {
        println("left: "+str[left]+" right: "+str[right])
        if (str[left] != str[right]) return false
        left++
        right--
    }
    return true
}