package io.github.chizganov.puzzlers.adventofcode.twentytwo

import kotlin.math.max

/**
 * Advent of Code 2022 Day 8: Treetop Tree House
 * https://adventofcode.com/2022/day/8
 * */
class TreetopTreeHouse {

    fun findVisibleTreesNumber(gridMap: List<String>): Int {
        val grid = gridMap.map { it.toCharArray().map(Char::digitToInt) }
        var visibleNumber = grid.size * 2 + grid.first().size * 2 - 4 // minus duplicate corners
        for (row in 1 until grid.lastIndex) {
            column@ for (column in 1 until grid[row].lastIndex) {
                // check in row left
                for (i in column - 1 downTo 0) {
                    if (grid[row][i] >= grid[row][column]) break
                    if (grid[row][i] < grid[row][column] && i == 0) {
                        visibleNumber++
                        continue@column
                    }
                }
                // check in row right
                for (i in column + 1..grid[row].lastIndex) {
                    if (grid[row][i] >= grid[row][column]) break
                    if (grid[row][i] < grid[row][column] && i == grid[row].lastIndex) {
                        visibleNumber++
                        continue@column
                    }
                }
                // check in column up
                for (i in row - 1 downTo 0) {
                    if (grid[i][column] >= grid[row][column]) break
                    if (grid[i][column] < grid[row][column] && i == 0) {
                        visibleNumber++
                        continue@column
                    }
                }
                // check in column down
                for (i in row + 1..grid.lastIndex) {
                    if (grid[i][column] >= grid[row][column]) break
                    if (grid[i][column] < grid[row][column] && i == grid.lastIndex) {
                        visibleNumber++
                        continue@column
                    }
                }
            }
        }
        return visibleNumber
    }

    fun findHighestScenicScore(gridMap: List<String>): Int {
        val grid = gridMap.map { it.toCharArray().map(Char::digitToInt) }
        var maxScenicScore = 0
        for (row in 1 until grid.lastIndex) {
            for (column in 1 until grid[row].lastIndex) {
                // check in row left
                var leftScore = 0
                for (i in column - 1 downTo 0) {
                    leftScore++
                    if (grid[row][i] >= grid[row][column]) break
                }
                // check in row right
                var rightScore = 0
                for (i in column + 1..grid[row].lastIndex) {
                    rightScore++
                    if (grid[row][i] >= grid[row][column]) break
                }
                // check in column up
                var upScore = 0
                for (i in row - 1 downTo 0) {
                    upScore++
                    if (grid[i][column] >= grid[row][column]) break
                }
                // check in column down
                var downScore = 0
                for (i in row + 1..grid.lastIndex) {
                    downScore++
                    if (grid[i][column] >= grid[row][column]) break
                }
                maxScenicScore = max(maxScenicScore, leftScore * rightScore * upScore * downScore)
            }
        }
        return maxScenicScore
    }
}