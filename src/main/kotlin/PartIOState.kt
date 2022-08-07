import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class PartIOState(
    initName: String,
    initPpm: Float
) {
    var name by mutableStateOf(initName)
    var ppm by mutableStateOf(initPpm)

    fun onNameChange(name: String) {
        this.name = name
    }

    fun onPpmChange(ppm: Float) {
        this.ppm = ppm
    }
}