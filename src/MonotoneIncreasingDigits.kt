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
    val input = listOf(10, 1234, 332)
    val answer = mutableListOf<Int>()
    for(number in input) {
        answer.add(MonotoneIncreasingDigits.monotoneIncreasingDigits(number))
    }
    print(answer)
}

object MonotoneIncreasingDigits {
    fun monotoneIncreasingDigits(N: Int): Int {
        var currentMax = Int.MIN_VALUE
        for (i in 1..N) {
            if (doesNumberContainMonotoneIncreasingDigits(i) && i > currentMax) {
                currentMax = i
            }
        }

        return currentMax
    }

    private fun doesNumberContainMonotoneIncreasingDigits(N: Int): Boolean {
        var result = true
        val numberStr = N.toString()
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
}