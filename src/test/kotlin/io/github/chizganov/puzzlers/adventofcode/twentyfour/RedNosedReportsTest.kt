package io.github.chizganov.puzzlers.adventofcode.twentyfour

import io.github.chizganov.puzzlers.util.TestSource
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldHaveSize
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

class RedNosedReportsTest {

    @ParameterizedTest
    @TestSource(RedNosedReports::class, pattern = "^safe-[a-zA-Z]+\\d{2}\\.txt\$")
    fun isSafe(redNosedReports: RedNosedReports, input: Path, output: Path) {
        testRedNosedReportWith(input, output) { report ->
            redNosedReports.isSafe(report)
        }
    }

    @ParameterizedTest
    @TestSource(RedNosedReports::class, pattern = "^problem-dampener-[a-zA-Z]+\\d{2}\\.txt\$")
    fun isSafeWithProblemDampener(redNosedReports: RedNosedReports, input: Path, output: Path) {
        testRedNosedReportWith(input, output) { report ->
            redNosedReports.isSafeWithProblemDampener(report)
        }
    }

    private fun testRedNosedReportWith(input: Path, output: Path, function: (List<Int>) -> Boolean) {
        val reports = input.readLines().map { report ->
            report.split(" ")
                .map { signal -> signal.toInt() }
        }

        val outputLines = output.readLines()
        val safeReportsNumber = outputLines[0].toInt()
        val isReportSafeList = outputLines.drop(1).map { it.toBoolean() }

        val results = reports.map { function(it) }
        results shouldContainExactly isReportSafeList
        results.filter { safe -> safe } shouldHaveSize safeReportsNumber
    }
}