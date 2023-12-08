import ui.interaction.CommandOrchestrator
import ui.interaction.Interaction

class Paint(private val interaction: Interaction) {

    fun run() {
        val commandOrchestrator = CommandOrchestrator(interaction)

        do {
            val continueProgram = commandOrchestrator.run()
        } while (continueProgram)
    }
}