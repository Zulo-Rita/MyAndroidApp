package com.example.lecture_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lecture_2.data.dao.NoteDao
import com.example.lecture_2.data.database.AppDB
import com.example.lecture_2.data.entities.Users
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RegistrationActivity : AppCompatActivity() {
    private lateinit var db: AppDB
    private lateinit var dao: NoteDao

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)

        db = AppDB.get(this)
        dao = db.noteDao()


        val emailInput = findViewById<EditText>(R.id.txtemail) // this is temp field for data_Test
        val nameInput = findViewById<EditText>(R.id.txtename)
        val nicknameInput = findViewById<EditText>(R.id.textnicname)
        val passwordInput = findViewById<EditText>(R.id.txtpassword)
        val registerButton = findViewById<Button>(R.id.btnregister) //this is temp button for save
        val logInButton = findViewById<Button>(R.id.btngotologin) // this is temp button for show

        val tv = findViewById<TextView>(R.id.textView_temp) // this is temp FOR TESTING



        registerButton.setOnClickListener {
//            val emailData = emailInput.text.toString()
//            val nameData = nameInput.text.toString()
//            val nicknameData = nicknameInput.text.toString()
//            val passwordData = passwordInput.text.toString()
//            val passMessage = isValidPassword(passwordData)

            val emailData = "Rita@TRZ.lt"
            val nameData = nameInput.text.toString()
            val nicknameData = nicknameInput.text.toString()
            val passwordData = passwordInput.text.toString()
            val passMessage = isValidPassword(passwordData)

            when {
                emailData.isEmpty() || passwordData.isEmpty() || nameData.isEmpty() || nicknameData.isEmpty() ->
                    Toast.makeText(this, "Fill all fields", Toast.LENGTH_LONG).show()
                !emailData.contains("@") || !emailData.contains(".") ->
                    Toast.makeText(this, "Invalid email, check the email address", Toast.LENGTH_LONG).show()
                passMessage != null ->
                    Toast.makeText(this, passMessage, Toast.LENGTH_LONG).show()
                else ->
                    Toast.makeText(this, "Registration was successful", Toast.LENGTH_LONG).show()
            }

//            val salt = PasswordUtil.generateSalt()
//            val passwordHash = PasswordUtil.hashPassword("myPassword123".toCharArray(), salt)



            registerButton.setOnClickListener {
                val user = Users(
                    email = emailData,
                    fullName = nameData,
                    nickname = nicknameData,
                    passwordHash = passwordData
                )
                val newId = GlobalScope.launch {
                    dao.insert(Users(text = user))

                }

//                val newId: Long = withContext(Dispatchers.IO) {
//                    dao.insert(user)
//                }

                println("Inserted user with ID: $newId")

                emailInput.text.clear()
                nameInput.text.clear()
                nicknameInput.text.clear()
                passwordInput.text.clear()
            }
        }
    }

    internal fun isValidPassword(password: String): String? {
        if (password.length < 8) return "Password must be at least 8 characters long"
        if (password.none { it.isDigit() }) return "Password must contain at least one digit"
        if (password.none { it.isUpperCase() }) return "Password must contain at least one uppercase letter"
        if (password.none { it.isLowerCase() }) return "Password must contain at least one lowercase letter"
        if (password.none { !it.isLetterOrDigit() }) return "Password must contain at least one special character"
        return null

    }


}

