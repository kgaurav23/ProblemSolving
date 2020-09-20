/**
https://leetcode.com/problems/maximum-swap/
- Medium -

Given a non-negative integer, you could swap two digits at most once to get the maximum
valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:
Input: 9973
Output: 9973
Explanation: No swap.

Example 3:
Input: 98368
Output: 98863

Example 4:
Input: 921456
Output: 961452

Example 5:
Input: 1993
Output: 9913

Note: The given number is in the range [0, 108]

 **/

fun main() {
    val input = listOf(2736, 9973, 98368, 921456, 1993)
    for (number in input) {
        println("Output: ${maximumSwap(number)}")
    }
}

fun maximumSwap(num: Int): Int {
    val numStr = num.toString().toCharArray()
    var i = 1
    while (i < numStr.size && numStr[i] <= numStr[i - 1]) {
        i++
        continue
    }

    if (i == numStr.size) {
        return num
    }

    var lastIndex = i - 1
    var currentMax = numStr[i]
    var currentMaxIndex = i
    for (j in i + 1 until numStr.size) {
        if (numStr[j] >= currentMax) {
            currentMax = numStr[j]
            currentMaxIndex = j
        }
    }

    while (lastIndex >= 0 && numStr[lastIndex] < currentMax) {
        lastIndex--
    }

    val temp = numStr[lastIndex + 1]
    numStr[lastIndex + 1] = numStr[currentMaxIndex]
    numStr[currentMaxIndex] = temp
    return numStr.joinToString("").toInt()
}