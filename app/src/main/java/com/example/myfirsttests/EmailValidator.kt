package com.example.myfirsttests

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

class EmailValidator : TextWatcher {
    internal var isValid = false

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(email: Editable?) {
        isValid = isValidEmail(email)
    }

    companion object {

        private val EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        fun isValidEmail(email: CharSequence?): Boolean {
            return  email?.let{
                val matcher = EMAIL_PATTERN.matcher(email)
                matcher.matches()
            } ?: false
        }
    }
}