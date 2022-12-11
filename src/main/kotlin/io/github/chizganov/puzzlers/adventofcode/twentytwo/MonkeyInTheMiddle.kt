package io.github.chizganov.puzzlers.adventofcode.twentytwo

/**
 * Advent of Code 2022 Day 10: Cathode-Ray Tube
 * https://adventofcode.com/2022/day/10
 * */
class MonkeyInTheMiddle {
    fun countMonkeyBusinessLevel(notes: List<String>): Long {
        val monkeys = notes.filterNot(String::isEmpty)
            .map(String::trim)
            .chunked(6) // works for given size, better to take while not empty and split
            .map { plan ->
                Monkey(
                    number = plan.first().filter(Char::isDigit).toInt(),
                    items = plan.first { it.contains(STARTING_ITEMS) }.removePrefix(STARTING_ITEMS)
                        .filterNot(Char::isWhitespace).split(',').map(String::toLong).toMutableList(),
                    operation = plan.first { it.contains(OPERATION) }
                        .takeLastWhile { it != '=' }
                        .parseOperation(),
                    test = plan.first { it.contains(TEST) }.removePrefix(TEST).parseTest(),
                    onTrue = plan.first { it.contains(IF_TRUE) }.takeLastWhile(Char::isDigit).toInt(),
                    onFalse = plan.first { it.contains(IF_FALSE) }.takeLastWhile(Char::isDigit).toInt()
                )
            }
        val monkeyBusinessLevel = generateSequence { monkeys }.take(ROUNDS).flatten()
            .fold(mutableMapOf<Int, Int>()) { numberToInspected, monkey ->
                numberToInspected.putIfAbsent(monkey.number, 0)
                while (monkey.items.isNotEmpty()) {
                    numberToInspected.computeIfPresent(monkey.number) { _, inspected -> inspected + 1 }
                    // TODO part 2: % lcm 9_699_690L gives 16792940265 rewrite
                    monkey.items[0] = monkey.operation(monkey.items.first()) / 3
                    if (monkey.test(monkey.items.first())) {
                        monkey.throwItemTo(monkeys[monkey.onTrue])
                    } else {
                        monkey.throwItemTo(monkeys[monkey.onFalse])
                    }
                }
                numberToInspected
            }
            .map(Map.Entry<Int, Int>::value)
            .sortedDescending()
            .take(2)
            .map(Int::toLong)
            .reduce(Long::times)

        return monkeyBusinessLevel
    }

    class Monkey(
        val number: Int,
        val items: MutableList<Long>,
        val operation: (Long) -> Long,
        val test: (Long) -> Boolean,
        val onTrue: Int,
        val onFalse: Int,
    ) {
        fun throwItemTo(monkey: Monkey) = monkey.items.add(items.removeFirst())
    }

    private enum class Operators(val sign: String, val operation: (Long, Long) -> Long) {
        PLUS("+", { a, b -> a + b }),
        MULTIPLY("*", { a, b -> a * b });
    }

    companion object {
        private const val STARTING_ITEMS = "Starting items:"
        private const val OPERATION = "Operation:"
        private const val TEST = "Test:"
        private const val IF_TRUE = "If true:"
        private const val IF_FALSE = "If false:"
        private const val ROUNDS = 20

        fun String.parseOperation(): (Long) -> Long {
            val tokens = trim().split(' ')
            val opIndex = tokens.indexOfFirst { it in Operators.values().map(Operators::sign) }
            val operator = Operators.values().first { it.sign == tokens[opIndex] }
            val number = tokens[opIndex - 1].toLongOrNull() ?: tokens[opIndex + 1].toLongOrNull()

            return if (number != null) { old -> operator.operation(old, number) }
            else { old -> operator.operation(old, old) }
        }

        private fun String.parseTest(): (Long) -> Boolean {
            return { item -> item % trim().takeLastWhile { it.isDigit() }.toLong() == 0L }
        }
    }
}