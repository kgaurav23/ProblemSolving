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
    val input = 322

    print(MonotoneIncreasingDigits.monotoneIncreasingDigits(input))
}

object MonotoneIncreasingDigits {
    fun monotoneIncreasingDigits(N: Int): Int {
        
        return -1
    }
}