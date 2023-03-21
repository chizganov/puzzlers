package io.github.chizganov.puzzlers.leetcode

/*
* https://leetcode.com/problems/spiral-matrix/
* */
class SpiralMatrix {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val spiral = mutableListOf<Int>()

        val height = matrix.size
        val width = matrix.first().size

        var delayUp = 0
        var delayDown = height - 1
        var delayRight = width - 1
        var delayLeft = 0
        var (x, y) = 0 to 0
        spiral.add(matrix[y][x])

        var currentDirection = Direction.RIGHT
        while (spiral.size != height * width) {
            when (currentDirection) {
                Direction.RIGHT -> {
                    for (i in x + 1..delayRight) {
                        spiral.add(matrix[y][i])
                    }
                    x = delayRight
                    delayUp++
                    currentDirection = Direction.DOWN
                }

                Direction.DOWN -> {
                    for (i in y + 1..delayDown) {
                        spiral.add(matrix[i][x])
                    }
                    y = delayDown
                    delayRight--
                    currentDirection = Direction.LEFT
                }

                Direction.LEFT -> {
                    for (i in x - 1 downTo delayLeft) {
                        spiral.add(matrix[y][i])
                    }
                    x = delayLeft
                    delayDown--
                    currentDirection = Direction.UP
                }

                Direction.UP -> {
                    for (i in y - 1 downTo delayUp) {
                        spiral.add(matrix[i][x])
                    }
                    y = delayUp
                    delayLeft++
                    currentDirection = Direction.RIGHT
                }
            }
        }
        return spiral
    }

    enum class Direction {
        RIGHT, DOWN, LEFT, UP;
    }
}