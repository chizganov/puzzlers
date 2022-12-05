package io.github.chizganov.puzzlers.adventofcode.twentytwo

/**
 * Advent of Code 2022 Day 5: Supply Stacks
 * https://adventofcode.com/2022/day/5
 * */
class SupplyStacks {
    fun rearrangeAndGetStacksTop(supplyStacksInput: List<String>, crateMoveStrategy: CrateMoveStrategy): String {
        val divider = supplyStacksInput.indexOfFirst { it.isBlank() }
        val cratesInput = supplyStacksInput.subList(0, divider - 1)
        val stacksPositions = supplyStacksInput[divider - 1]
        val commandLines = supplyStacksInput.subList(divider + 1, supplyStacksInput.size)

        val stacks: MutableList<MutableList<Char>> = mutableListOf()
        stacksPositions.forEachIndexed { index, char ->
            if (char.isDigit()) {
                val stack = mutableListOf<Char>()
                stacks.add(stack)
                cratesInput.dropWhile { index >= it.length || it[index].isWhitespace() }.reversed().forEach {
                    stack.add(it[index])
                }
            }
        }

        commandLines.forEach { command ->
            // In this simple single-input format, command words can be omitted.
            command.split(" ").mapNotNull(String::toIntOrNull).run {
                crateMoveStrategy.moveCrates(
                    number = this[0], fromStack = stacks[this[1] - 1], toStack = stacks[this[2] - 1]
                )
            }
        }
        return stacks.map(MutableList<Char>::last).joinToString("")
    }

    enum class CrateMoveStrategy {
        ONE_BY_ONE {
            override fun moveCrates(number: Int, fromStack: MutableList<Char>, toStack: MutableList<Char>) =
                repeat(number) { toStack.add(fromStack.removeLast()) }
        },
        PACK {
            override fun moveCrates(number: Int, fromStack: MutableList<Char>, toStack: MutableList<Char>) {
                (1..number).map { fromStack.removeLast() }.reversed().run { toStack.addAll(this) }
            }
        };

        abstract fun moveCrates(number: Int, fromStack: MutableList<Char>, toStack: MutableList<Char>)
    }
}
