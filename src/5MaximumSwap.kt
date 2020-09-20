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

Note: The given number is in the range [0, 108]

 **/

fun main() {
    val input = listOf(2736, 9973, 98368, 921456)
    for (number in input) {
        println("Output: ${maximumSwap(number)}")
    }
}

fun maximumSwap(num: Int): Int {
    val numStr = num.toString().toCharArray()
    for (i in 1 until numStr.size) {
        var index = i
        while (index < numStr.size && numStr[index] <= numStr[index - 1]) {
            index++
        }

        if (index == numStr.size) {
            return num
        }

        var lastIndex = i - 1

        var currentMax = numStr[i]
        var currentMaxIndex = i
        for (j in i + 1 until numStr.size) {
            if (numStr[j] > currentMax) {
                currentMax = numStr[j]
                currentMaxIndex = j
            }
        }

        while (lastIndex > 0 && numStr[lastIndex] < currentMax) {
            lastIndex--
        }

        if (lastIndex != -1) {
            val temp = numStr[lastIndex]
            numStr[lastIndex] = numStr[currentMaxIndex]
            numStr[currentMaxIndex] = temp
        }
    }

    return numStr.joinToString("").toInt()
}