package extensions

fun String.formatFromEnum() =
    this.lowercase().capitalizeEachWord(originalSeparator = '_')

fun String.capitalizeEachWord(originalSeparator: Char = ' ', newSeparator: Char = ' '): String =
    this
        .lowercase()
        .split(originalSeparator)
        .joinToString(separator = newSeparator.toString()) {
            it.capitalize()
        }

