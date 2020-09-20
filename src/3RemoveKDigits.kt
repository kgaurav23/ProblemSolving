import java.util.*


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

    //val input = listOf("1432219", "10200", "10", "346", "436")
    val input = listOf("1234567890")
    val k = listOf(9)

    for (i in input.indices) {
        println("Answer: ${removeKdigitsV2(input[i], k[i])}")
    }
}

/*
        1230, k = 3
        7895, k = 3
        stack = 1 2 0, k = 2
 */

fun removeKdigits(num: String, k: Int): String {
    val lengthOfNum = num.length
    if (num.length == k) return "0"

    val stack = Stack<Char>()
    var itemsToRemove = k

    for (i in 0 until lengthOfNum) {
        while (itemsToRemove > 0 && !stack.isEmpty() && stack.peek() > num[i]) {
            stack.pop()
            itemsToRemove--
        }
        stack.push(num[i])
    }

    while (!stack.isEmpty() && itemsToRemove > 0) {
        stack.pop()
        itemsToRemove--
    }

    val sb = StringBuilder()
    while (!stack.isEmpty()) {
        sb.append(stack.pop())
    }
    sb.reverse()

    while (sb.isNotEmpty() && sb[0] == '0') sb.deleteCharAt(0)

    return if (sb.toString() == "") {
        "0"
    } else {
        sb.toString()
    }
}

fun removeKdigitsV2(num: String, k: Int): String? {
    var k = k
    if (num.length == k) return "0"
    val stack = Stack<Char>()
    for (i in num.indices) {
        while (k > 0 && !stack.isEmpty() && stack.peek()!! > num[i]) {
            stack.pop()
            k--
        }
        stack.push(num[i])
    }

    // 1111, k = 2
    while (!stack.isEmpty() && k > 0) {
        k--
        stack.pop()
    }
    val sb = StringBuilder()
    while (stack.size > 0) sb.append(stack.pop())
    sb.reverse()

    // remove the leading zeroes
    val i = 0
    while (i < sb.length && sb[0] == '0') sb.deleteCharAt(0)
    return if (sb.toString().isEmpty()) "0" else sb.toString()
}