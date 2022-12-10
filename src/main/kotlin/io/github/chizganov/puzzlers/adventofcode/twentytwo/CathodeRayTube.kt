package io.github.chizganov.puzzlers.adventofcode.twentytwo

/**
 * Advent of Code 2022 Day 10: Cathode-Ray Tube
 * https://adventofcode.com/2022/day/10
 * */

sealed class CathodeRayTube {
    abstract fun sumSignalStrengths(program: List<String>): Int
    abstract fun renderCrtImage(program: List<String>): List<String>

    companion object {
        const val FIRST_SIGNAL = 20
        const val SIGNAL_RANGE = 40
        const val IMAGE_WIDE = 40
    }
}

object SimpleCathodeRayTube : CathodeRayTube() {
    override fun sumSignalStrengths(program: List<String>): Int =
        registerCycleHistoryExecuting(program)
            .filter { (it.index + 1) % SIGNAL_RANGE == FIRST_SIGNAL }
            .sumOf { (it.index + 1) * it.value }

    override fun renderCrtImage(program: List<String>): List<String> =
        registerCycleHistoryExecuting(program)
            .map { (cycle, x) -> if ((cycle % IMAGE_WIDE) in (x - 1..x + 1)) "#" else "." }
            .chunked(IMAGE_WIDE)
            .map { it.joinToString("") }

    private fun registerCycleHistoryExecuting(program: List<String>) =
        program.flatMap { it.split(' ') }
            .map { it.toIntOrNull() ?: 0 }
            .scan(1) { s, e -> s + e }
            .dropLast(1)
            .withIndex()

}


// Complex solution with a lot of boilerplate
object ComplexCathodeRayTube : CathodeRayTube() {

    private val operations = listOf(NoopOperation(), AddxOperation())

    override fun sumSignalStrengths(program: List<String>): Int {
        val cpu = CPU()
        program.map { it.split(" ") }.forEach { operationLine ->
            cpu.executeOperation(
                checkNotNull(operations.find { operationLine[0] in it.aliases }),
                operationLine.subList(1, operationLine.size)
            )
        }
        return cpu.signalStrengths.sum()
    }

    override fun renderCrtImage(program: List<String>): List<String> {
        val cpu = CPU()
        program.map { it.split(" ") }.forEach { operationLine ->
            cpu.executeOperation(
                checkNotNull(operations.find { operationLine[0] in it.aliases }),
                operationLine.subList(1, operationLine.size)
            )
        }
        return cpu.crt.getImage()
    }

    private class CPU(
        var x: Int = 1,
        var cycles: Int = 0,
    ) {
        var signalCheckCycle: Int = FIRST_SIGNAL
        var signalStrengths: MutableList<Int> = mutableListOf()
        val crt: CRT = CRT()
        fun executeOperation(operation: Operation, arguments: List<String>) {
            repeat(operation.cycles) {
                cycles++
                if (cycles == signalCheckCycle) {
                    signalStrengths.add(cycles * x)
                    signalCheckCycle += SIGNAL_RANGE
                }
                crt.drawPixel(x)
            }
            operation.execute(this, arguments)
        }
    }

    private class CRT(val wide: Int = IMAGE_WIDE, height: Int = 6) {
        private val screen = CharArray(height * wide) { '.' }
        private var drawPosition = 0

        fun drawPixel(x: Int) {
            if ((drawPosition % wide) in (x - 1..x + 1)) {
                screen[drawPosition] = '#'
            }
            drawPosition++
        }

        fun getImage() = screen.concatToString().chunked(wide)
    }

    private interface Operation {
        val aliases: List<String>
        val cycles: Int

        fun execute(cpu: CPU, arguments: List<String>)
    }

    private class NoopOperation : Operation {
        override val aliases: List<String>
            get() = listOf("noop")
        override val cycles: Int
            get() = 1

        override fun execute(cpu: CPU, arguments: List<String>) = Unit
    }

    private class AddxOperation : Operation {
        override val aliases: List<String>
            get() = listOf("addx")
        override val cycles: Int
            get() = 2

        override fun execute(cpu: CPU, arguments: List<String>) {
            cpu.x += arguments.first().toInt()
        }

    }
}