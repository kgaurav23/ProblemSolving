/**
https://leetcode.com/problems/monotone-increasing-digits/
- MEDIUM -

Given a non-negative integer N, find the largest number that is less than or equal to N
with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if
each pair of adjacent digits x and y satisfy x <= y.)

Example 1:
Input: N = 10
Output: 9
Example 2:
Input: N = 1234
Output: 1234
Example 3:
Input: N = 332
Output: 299
Note: N is an integer in the range [0, 10^9]

 **/
fun main() {
    val input = listOf(10, 1234, 332, 1289, 3287, 1321, 75456)
    val answer = mutableListOf<Int>()
    val answerV2 = mutableListOf<Int>()
    for (number in input) {
        answer.add(MonotoneIncreasingDigits.monotoneIncreasingDigits(number))
        answerV2.add(MonotoneIncreasingDigits.monotoneIncreasingDigitsV2(number))
    }

    print("Answer: $answer")
    print("AnswerV2: $answerV2")
}

object MonotoneIncreasingDigits {

    fun monotoneIncreasingDigitsV2(N: Int): Int {
        val inputArray = N.toString().toCharArray()
        val inputStrLength = inputArray.size
        var currentIndexFromEnd = inputStrLength - 1

        while (currentIndexFromEnd > 0) {
            if (inputArray[currentIndexFromEnd] < inputArray[currentIndexFromEnd - 1]) {
                changeAllDigitsTo9(inputArray, currentIndexFromEnd)
            }
            currentIndexFromEnd--
        }

        return inputArray.joinToString("").toInt()
    }

    private fun changeAllDigitsTo9(inputStr: CharArray, currentIndexFromEnd: Int) {
        val length = inputStr.size
        for (i in currentIndexFromEnd until length) {
            inputStr[i] = '9'
        }
        inputStr[currentIndexFromEnd - 1] = inputStr[currentIndexFromEnd - 1] - 1
    }

    private fun doesNumberContainMonotoneIncreasingDigits(numberStr: String): Boolean {
        var result = true
        val length = numberStr.length
        for (i in 0 until length - 1) {
            if (numberStr[i] <= numberStr[i + 1]) {
                continue
            } else {
                result = false
                break
            }
        }

        return result
    }

    fun monotoneIncreasingDigits(N: Int): Int {
        var currentMax = Int.MIN_VALUE

        for (i in 1..N) {
            if (i > currentMax && doesNumberContainMonotoneIncreasingDigits(i.toString())) {
                currentMax = i
            }
        }

        return currentMax
    }
}