package io.github.chizganov.puzzlers.adventofcode.twentytwo

import kotlin.math.max

/**
 * Advent of Code 2022 Day 8: Treetop Tree House
 * https://adventofcode.com/2022/day/8
 * */
open class TreetopTreeHouse {

    fun findVisibleTreesNumber(inputMap: List<String>): Int {
        val treeMap = inputMap.map { it.toCharArray().map(Char::digitToInt) }

        var visibleNumber = treeMap.size * 2 + treeMap.first().size * 2 - 4 // minus duplicate corners
        for (row in 1 until treeMap.lastIndex) {
            for (column in 1 until treeMap[row].lastIndex) {
                if (isVisibleFromEdge(treeMap, row, column, -1, 0) ||
                    isVisibleFromEdge(treeMap, row, column, 1, 0) ||
                    isVisibleFromEdge(treeMap, row, column, 0, -1) ||
                    isVisibleFromEdge(treeMap, row, column, 0, 1)
                ) {
                    visibleNumber++
                }
            }
        }

        return visibleNumber
    }

    private fun isVisibleFromEdge(grid: List<List<Int>>, row: Int, column: Int, dx: Int, dy: Int): Boolean {
        var curRow = row + dy
        var curColumn = column + dx

        while (curRow >= 0 && curRow < grid.size && curColumn >= 0 && curColumn < grid[curRow].size) {
            if (grid[curRow][curColumn] >= grid[row][column]) {
                return false
            }
            curRow += dy
            curColumn += dx
        }

        return grid[curRow - dy][curColumn - dx] < grid[row][column]
    }

    fun findHighestScenicScore(inputMap: List<String>): Int {
        val treeMap = inputMap.map { it.toCharArray().map(Char::digitToInt) }

        var maxScenicScore = 0
        for (row in 1 until treeMap.lastIndex) {
            for (col in 1 until treeMap[row].lastIndex) {
                val left = (col - 1 downTo 1)
                    .takeWhile { treeMap[row][it] < treeMap[row][col] }.count() + 1
                val right = (col + 1 until treeMap[row].lastIndex)
                    .takeWhile { treeMap[row][it] < treeMap[row][col] }.count() + 1
                val up = (row - 1 downTo 1)
                    .takeWhile { treeMap[it][col] < treeMap[row][col] }.count() + 1
                val down = (row + 1 until treeMap.lastIndex)
                    .takeWhile { treeMap[it][col] < treeMap[row][col] }.count() + 1
                maxScenicScore = max(maxScenicScore, left * right * up * down)
            }
        }

        return maxScenicScore
    }
}