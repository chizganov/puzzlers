package io.github.chizganov.puzzlers.leetcode

class CountAndSay {
    fun countAndSay(n: Int): String {
        val memResults = mutableListOf("1")

        while (memResults.size != n) {
            val digitStr = memResults.last()
            var uniqueDigit = digitStr[0]
            var count = 0
            val resBuilder = StringBuilder()
            for (i in digitStr.indices) {
                if (digitStr[i] == uniqueDigit) {
                    count++
                } else {
                    resBuilder.append(count)
                    resBuilder.append(uniqueDigit)
                    count = 1
                    uniqueDigit = digitStr[i]
                }
            }
            // last digit
            resBuilder.append(count)
            resBuilder.append(uniqueDigit)
            memResults.add(resBuilder.toString())
        }

        return memResults[n - 1]
    }
}