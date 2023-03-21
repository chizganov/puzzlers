package io.github.chizganov.puzzlers.leetcode

/*
* https://leetcode.com/problems/valid-parentheses/
* */
class ValidParentheses {

    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        var isValid = true
        for (parenthesis in s) {
            when (parenthesis) {
                '(', '{', '[' -> stack.addLast(parenthesis)
                ')', '}', ']' -> {
                    val associatedParenthesis = stack.removeLastOrNull()
                    when {
                        associatedParenthesis == null -> isValid = false
                        openToClosed[associatedParenthesis] != parenthesis -> isValid = false
                    }
                }

                else -> isValid = false
            }
            if (!isValid) break
        }

        return stack.isEmpty() && isValid
    }

    companion object {
        val openToClosed = mapOf(
            '(' to ')',
            '{' to '}',
            '[' to ']'
        )
    }
}