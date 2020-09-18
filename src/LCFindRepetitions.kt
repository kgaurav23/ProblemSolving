/**
https://leetcode.com/problems/count-the-repetitions/
 - HARD -

Define S = [s,n] as the string S which consists of n connected strings s. For example, ["abc", 3] ="abcabcabc".

On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from
s2 such that it becomes s1. For example, “abc” can be obtained from “abdbec” based on our definition, but it can not be
obtained from “acbbe”.

You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 ≤ n1 ≤ 106
and 1 ≤ n2 ≤ 106. Now consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M
such that [S2,M] can be obtained from S1.

Input-1:
"bacaba"
3
"abacab"
1
Expected:2

Input-2:
"aaa"
3
"aa"
1
Expected:4

 **/

object LCFindRepetitions {
    fun getMaxRepetitions(s1: String, n1: Int, s2: String, n2: Int): Int {

        val S1 = s1.repeat(n1)
        val S2 = s2.repeat(n2)
        val S1Length = S1.length
        val S2Length = S2.length
        var count = 0
        var currentS1Index = 0

        while (currentS1Index < S1Length) {
            val substringLength = findSubstringLengthOfS1containingS2(S2, S1, currentS1Index, S1Length, S2Length)

            if (substringLength != -1) {
                count++
                currentS1Index += substringLength
            } else {
                break
            }
        }

        return count
    }

    private fun findSubstringLengthOfS1containingS2(
        S2: String,
        S1: String,
        startIndex: Int,
        s1Length: Int,
        s2Length: Int
    ): Int {
        var s1Index = startIndex
        var s2Index = 0

        while (s1Index < s1Length) {
            if (S1[s1Index] == S2[s2Index]) {
                s2Index++
            }
            s1Index++

            if (s2Index == s2Length) {
                return (s1Index - startIndex)
            }
        }

        return -1
    }
}

fun main() {
    val s1 = "aaa"
    val s2 = "aa"
    val n1 = 3
    val n2 = 1

    print(LCFindRepetitions.getMaxRepetitions(s1, n1, s2, n2))
}