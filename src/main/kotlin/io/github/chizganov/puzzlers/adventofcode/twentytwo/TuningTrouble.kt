package io.github.chizganov.puzzlers.adventofcode.twentytwo

/**
 * Advent of Code 2022 Day 6: Tuning Trouble
 * https://adventofcode.com/2022/day/8
 * */
open class TuningTrouble {

    open fun findFirstMarkerOccurrence(markerSize: Int, buffer: String): Int {
        for (i in 0..buffer.lastIndex - markerSize) {
            if ((i until i + markerSize)
                    .none { buffer.subSequence(it + 1, i + markerSize).contains(buffer[it]) }
            ) return i + markerSize
        }
        return -1
    }
}

class WindowedTuningTrouble : TuningTrouble() {

    // Windowed solution based on https://github.com/LiquidFun/adventofcode/blob/main/2022/06/06.kt
    override fun findFirstMarkerOccurrence(markerSize: Int, buffer: String) =
        buffer.windowed(markerSize).indexOfFirst { it.toSet().size == it.length } + markerSize
}