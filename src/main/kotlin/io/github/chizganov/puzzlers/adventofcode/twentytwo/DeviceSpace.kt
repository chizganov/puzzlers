package io.github.chizganov.puzzlers.adventofcode.twentytwo

/**
 * Advent of Code 2022 Day 7: No Space Left On Device
 * https://adventofcode.com/2022/day/7
 * */
class DeviceSpace {

    private val commands = listOf(CdCommand(), LsCommand())

    fun sumDirectoriesTotalSizeAtMost(atMostValue: Int, terminalOutput: List<String>): Int =
        restoreDeviceState(terminalOutput).rootDirectory.flattenDirectoriesAsSequence()
            .map { it.totalSize }
            .sorted()
            .takeWhile { it <= atMostValue }
            .sum()

    fun smallestFreeUpForUpdateDirectorySize(terminalOutput: List<String>): Int =
        restoreDeviceState(terminalOutput).let { deviceState ->
            val requiredSpace = deviceState.updateRequiredSpace -
                    (deviceState.totalSpace - deviceState.rootDirectory.totalSize)
            deviceState.rootDirectory.flattenDirectoriesAsSequence()
                .map { it.totalSize }
                .sorted()
                .first { it >= requiredSpace }
        }


    private fun restoreDeviceState(terminalOutput: List<String>): DeviceState {
        val deviceState = DeviceState()
        val terminalOutputWords = terminalOutput.map { it.split(' ') }
            .dropWhile { it.first() != COMMAND_SIGN }.toMutableList()
        while (terminalOutputWords.isNotEmpty()) {
            val commandInput = terminalOutputWords.removeFirst()
            if (commandInput[0] != COMMAND_SIGN || commandInput.size < 2) continue

            val command = requireNotNull(commands.find { commandInput[1] in it.aliases })
            val commandArguments = commandInput.subList(2, commandInput.size)
            val commandOutput = terminalOutputWords.takeWhile { it.first() != COMMAND_SIGN }
            val commandContext = CommandContext(deviceState, commandArguments, commandOutput)
            command.parse(commandContext)

            repeat(commandOutput.size) { terminalOutputWords.removeFirst() }
        }

        return deviceState
    }

    private interface TerminalParseCommand {
        val aliases: List<String>
        fun parse(context: CommandContext)
    }

    private class CdCommand : TerminalParseCommand {

        override val aliases: List<String>
            get() = listOf("cd")

        override fun parse(context: CommandContext) {
            when (val directoryName = context.commandArguments.first()) {
                ".." -> context.deviceState.currentDirectory.parent?.let { context.deviceState.currentDirectory = it }
                "/" -> context.deviceState.currentDirectory = context.deviceState.rootDirectory
                else -> context.deviceState.currentDirectory.directories.first { it.name == directoryName }
                    .also { context.deviceState.currentDirectory = it }
            }
        }
    }

    private class LsCommand : TerminalParseCommand {

        override val aliases: List<String>
            get() = listOf("ls")

        override fun parse(context: CommandContext) {
            val currentDirectory = context.deviceState.currentDirectory
            context.commandOutput.forEach { directoryElement ->
                if (directoryElement.first() == "dir") {
                    if (currentDirectory.directories.none { it.name == directoryElement[1] }) {
                        val directory = Directory(
                            parent = currentDirectory,
                            name = directoryElement[1],
                        )
                        currentDirectory.directories.add(directory)
                    }
                } else {
                    val file = File(
                        size = directoryElement[0].toInt(),
                        name = directoryElement[1],
                    )
                    currentDirectory.files.add(file)
                    var directoryIterator: Directory? = currentDirectory
                    while (directoryIterator != null) {
                        directoryIterator.totalSize += file.size
                        directoryIterator = directoryIterator.parent
                    }
                }
            }
        }
    }

    private class DeviceState(
        val rootDirectory: Directory = Directory(name = "/"),
        var currentDirectory: Directory = rootDirectory,
        val totalSpace: Int = 70_000_000,
        val updateRequiredSpace: Int = 30_000_000,
    )

    private class CommandContext(
        val deviceState: DeviceState,
        val commandArguments: List<String> = emptyList(),
        val commandOutput: List<List<String>> = emptyList(),
    )

    private class Directory(
        val parent: Directory? = null,
        var name: String,
        val directories: MutableList<Directory> = mutableListOf(),
        val files: MutableList<File> = mutableListOf(),
        var totalSize: Int = 0,
    ) {
        fun flattenDirectoriesAsSequence(): Sequence<Directory> =
            directories.asSequence().flatMap { it.flattenDirectoriesAsSequence() }.plus(this)
    }

    private data class File(var size: Int, var name: String)

    companion object {
        private const val COMMAND_SIGN = "$"
    }
}