package io.github.chizganov.puzzlers.adventofcode.twentyfour

/**
 * Advent of Code 2024 Day 3: Mull It Over
 * https://adventofcode.com/2024/day/3
 * */
class MullItOver {

    fun restoreCorruptedMul(memorySegment: String): Int {
        return Regex("mul\\(\\d{1,3},\\d{1,3}\\)").findAll(memorySegment).sumOf { match ->
            match.value
                .removePrefix("mul(")
                .removeSuffix(")")
                .split(",")
                .map(String::toInt)
                .reduce(Int::times)
        }
    }

    fun restoreCorruptedDoMul(memorySegment: String): Int {
        val dontOp = "don\'t()"
        val doOp = "do()"
        fun findNextIndex(op: String, from: Int): Int = memorySegment.indexOf(op, from).let {
            if (it != -1) it else memorySegment.lastIndex
        }

        var dontIndex = findNextIndex(dontOp, 0)
        if (dontIndex == -1) return restoreCorruptedMul(memorySegment)

        val processBuilder = StringBuilder(memorySegment.substring(0, dontIndex))
        while (dontIndex != -1 && dontIndex != memorySegment.lastIndex) {
            val doIndex = findNextIndex(doOp, dontIndex)
            dontIndex = findNextIndex(dontOp, doIndex)
            processBuilder.append(memorySegment.substring(doIndex, dontIndex))
        }

        return restoreCorruptedMul(processBuilder.toString())
    }
}