package io.github.chizganov.puzzlers.leetcode

interface RomanToInt {
    fun convert(s: String): Int
}

class RuleRomanToInt : RomanToInt {
    override fun convert(s: String): Int =
        s.plus(s.last())
            .zipWithNext { cur, next -> ROMAN_TO_INT.getOrDefault(cur, 0) to ROMAN_TO_INT.getOrDefault(next, 0) }
            .sumOf { (cur, next) -> if (cur >= next) cur else cur.unaryMinus() }

    companion object {
        val ROMAN_TO_INT = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000,
        )
    }

}

class DumbRomanToInt : RomanToInt {
    override fun convert(s: String): Int {
        var sum = 0
        var i = 0
        while (i < s.length) {
            if (i < s.lastIndex && ROMAN_TO_INT.contains(s.substring(i..i + 1))) {
                sum += ROMAN_TO_INT[s.substring(i..i + 1)] ?: 0
                i += 2
            } else {
                sum += ROMAN_TO_INT[s[i].toString()] ?: 0
                i += 1
            }
        }

        return sum
    }

    companion object {
        val ROMAN_TO_INT = mapOf(
            "I" to 1,
            "V" to 5,
            "X" to 10,
            "L" to 50,
            "C" to 100,
            "D" to 500,
            "M" to 1000,
            "IV" to 4,
            "IX" to 9,
            "XL" to 40,
            "XC" to 90,
            "CD" to 400,
            "CM" to 900
        )
    }
}