package com.example.myfirsttests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myfirsttests.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val emailValidator = EmailValidator()
    private val emailValidator2 = EmailValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            emailInput.addTextChangedListener(emailValidator)
            emailInput2.addTextChangedListener(emailValidator2)

            saveButton.setOnClickListener {
                val email = emailInput.text.toString()
                val cEmail = emailInput2.text.toString()
                if (!(emailValidator.isValid && emailValidator2.isValid)){
                    Toast.makeText(this@MainActivity, getString(R.string.invalid_email), Toast.LENGTH_SHORT).show()
                } else if(isTheSameEmails(email, cEmail)) {
                    val errorEmail = getString(R.string.email_mismatch)
                    emailInput.error = errorEmail
                    Toast.makeText(this@MainActivity, errorEmail, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}