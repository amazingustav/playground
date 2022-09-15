package br.com.amz.playground.mess

object BalanceBrackets {

    @JvmStatic
    fun main(args: Array<String>) {
        val s = "f(e(d))"
        println(isBalanced(s))
    }

    /**
     * Given a string with brackets -> (, ), [, ], { and } you must return "YES" if it is a valid string or "NO" if it isn't.
     * A valid String in that structure means that ALL BRACKETS can be closed correctly.
     * E.g.
     * (([])) -> valid
     * ((][)) -> invalid
     * ({[]}) -> valid
     * {{{[[]](()[]}}} -> invalid
     * f(e(0)) -> valid
     * */
    fun isBalanced(brackets: String): String {
        var s = brackets

        while (s.isNotEmpty()) {
            val temp = s
            s = s.replace(Regex("[^()\\[\\]{}]"), "")
                .replace("()", "")
                .replace("[]", "")
                .replace("{}", "");

            if (s == temp) break
        }

        return if (s.isEmpty()) "YES" else "NO"
    }

    fun isBalancedAlternative(s: String): String {
        if (s.first().isCloseBracket() || s.last().isOpenBracket()) return "NO"

        val openBrackets = mutableListOf<Char>()

        s.toCharArray().forEach {
            if (it.isCloseBracket()) {
                val lastOpenBracket = if (openBrackets.isEmpty()) null else openBrackets[openBrackets.size - 1]

                if (lastOpenBracket?.reverse() != it) return "NO" else openBrackets.removeLast()
            } else {
                openBrackets.add(it)
            }
        }

        return "YES"
    }

    private fun Char.reverse() = when {
        this == '(' -> ')'
        this == '{' -> '}'
        this == '[' -> ']'
        this == ')' -> '('
        this == '}' -> '{'
        this == ']' -> '['
        else -> throw IllegalArgumentException("Character must be a bracket!")
    }

    private fun MutableList<Char>.removeLast() = this.removeAt(this.size - 1)

    private fun Char.isCloseBracket() = this == '}' || this == ']' || this == ')'

    private fun Char.isOpenBracket() = this == '{' || this == '[' || this == '('
}
