/**
https://leetcode.com/problems/remove-k-digits/
- MEDIUM -

Given a non-negative integer num represented as a string, remove k digits from the number
so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

 **/
fun main() {

    val input = listOf("1432219", "10200", "10", "346", "436")
    val k = listOf(3, 1, 2, 1, 1)

    for (i in input.indices) {
        println("Answer: ${removeKdigits(input[i], k[i])}")
    }
}

fun removeKdigits(num: String, k: Int): String {
    val lengthOfNum = num.length
    var inputNumber = num
    var startIndex = 0

    if (k == lengthOfNum) {
        return "0"
    }

    if (doWeHaveLeadingZeroesAfterKRemoval(num, k)) {
        startIndex = k
        while (num[startIndex] == '0') {
            startIndex++
        }
        return num.substring(startIndex)
    }

    val largestKDigits = findLargestKDigitsInNum(num, k)
    for (i in largestKDigits.indices) {
        val indexOfFirstOccurrence = inputNumber.indexOfFirst {
            it.toInt() == largestKDigits[i]
        }
        inputNumber = inputNumber.replaceFirst(inputNumber[indexOfFirstOccurrence].toString(), "")
    }

    return inputNumber
}

fun findLargestKDigitsInNum(num: String, k: Int): List<Int> {
    val largestKDigits = mutableListOf<Int>()
    var arr = num.toCharArray()


    return largestKDigits
}

fun doWeHaveLeadingZeroesAfterKRemoval(num: String, k: Int): Boolean = k < num.length && num[k] == '0'