package io.github.chizganov.puzzlers.adventofcode.twentytwo

class TuningTrouble {

    fun findFirstMarkerOccurrence(markerSize: Int, buffer: String): Int {
        for (i in 0..buffer.lastIndex - markerSize) {
            if ((i until i + markerSize)
                    .none { buffer.subSequence(it + 1, i + markerSize).contains(buffer[it]) }
            ) return i + markerSize
        }
        return -1
    }
}