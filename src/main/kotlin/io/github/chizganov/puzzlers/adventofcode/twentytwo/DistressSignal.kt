package io.github.chizganov.puzzlers.adventofcode.twentytwo

/**
 * Advent of Code 2022 Day 13: Distress Signal
 * https://adventofcode.com/2022/day/13
 * */
class DistressSignal {

    fun sumRightOrderPacketsIndices(packets: List<String>): Int =
        packets.asSequence()
            .filter { it.isNotBlank() }
            .chunked(2)
            .mapNotNull { isPacketsInTheRightOrder(it[0], it[1]) }
            .withIndex()
            .map { IndexedValue(it.index + 1, it.value) }
            .filter { it.value }
            .sumOf { it.index }

    fun getDecoderKey(packets: List<String>): Int =
        packets.toMutableList().apply { addAll(listOf("[[2]]", "[[6]]")) }
            .asSequence()
            .filter { it.isNotBlank() }
            .sortedWith(packetOrderComparator)
            .withIndex()
            .map { IndexedValue(it.index + 1, it.value) }
            .filter { it.value == "[[2]]" || it.value == "[[6]]" }
            .map { it.index }
            .reduce(Int::times)

    private val packetOrderComparator = Comparator<String> { p1, p2 ->
        when (isPacketsInTheRightOrder(p1, p2)) {
            true -> -1
            false -> 1
            null -> 0
        }
    }

    private fun isPacketsInTheRightOrder(first: String, second: String): Boolean? {
        var iFirst = 0
        var iSecond = 0
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] == ',') iFirst++
            if (second[iSecond] == ',') iSecond++
            when {
                first[iFirst].isDigit() && second[iSecond].isDigit() -> {
                    val firstNumber = first.drop(iFirst).takeWhile { it.isDigit() }
                    val secondNumber = second.drop(iSecond).takeWhile { it.isDigit() }
                    when {
                        firstNumber.toInt() > secondNumber.toInt() -> return false
                        firstNumber.toInt() < secondNumber.toInt() -> return true
                    }
                    iFirst += firstNumber.length
                    iSecond += secondNumber.length
                }

                first[iFirst].isOpenBracket() && second[iSecond].isOpenBracket() -> {
                    val firstList = first.getSubstringForBracket(iFirst)
                    val secondList = second.getSubstringForBracket(iSecond)
                    isPacketsInTheRightOrder(firstList, secondList)?.let { return it }
                    iFirst += firstList.length + 2
                    iSecond += secondList.length + 2
                }

                first[iFirst].isOpenBracket() && second[iSecond].isDigit() -> {
                    val firstList = first.getSubstringForBracket(iFirst)
                    val secondNumber = second.drop(iSecond).takeWhile { it.isDigit() }
                    isPacketsInTheRightOrder(firstList, secondNumber)?.let { return it }
                    iFirst += firstList.length + 2
                    iSecond += secondNumber.length
                }

                first[iFirst].isDigit() && second[iSecond].isOpenBracket() -> {
                    val firstNumber = first.drop(iFirst).takeWhile { it.isDigit() }
                    val secondList = second.getSubstringForBracket(iSecond)
                    isPacketsInTheRightOrder(firstNumber, secondList)?.let { return it }
                    iFirst += firstNumber.length
                    iSecond += secondList.length + 2
                }
            }
        }
        return when {
            iFirst > first.lastIndex && iSecond > second.lastIndex -> null
            iFirst > first.lastIndex -> true
            else -> false
        }
    }

    private fun String.getSubstringForBracket(openBracketIndex: Int): String {
        if (!this[openBracketIndex].isOpenBracket()) return ""
        var bracketsCounter = 1
        var i = openBracketIndex + 1
        while (bracketsCounter != 0) {
            when {
                this[i].isOpenBracket() -> bracketsCounter++
                this[i].isClosedBracket() -> bracketsCounter--
            }
            i++
        }

        return substring(openBracketIndex + 1, i - 1)
    }

    private fun Char.isOpenBracket() = this == '['
    private fun Char.isClosedBracket() = this == ']'

}