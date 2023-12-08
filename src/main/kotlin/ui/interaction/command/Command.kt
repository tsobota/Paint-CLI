package ui.interaction.command

enum class Command {
    C, L, R, B, Q, UNKNOWN;

    companion object {
        fun byNameIgnoreCase(input: String): Command {
            val enumFromInput = entries.firstOrNull {
                it.name == input.uppercase()
            }

            return enumFromInput ?: UNKNOWN

        }
    }
}