package ua.turskyi.blockerlibrary.example

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ua.turskyi.blocker.Blocker.appIsBlocked
import ua.turskyi.blocker.Blocker.checkIfAppIsBlocked

class MainActivity : AppCompatActivity(R.layout.activity_main){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkIfAppIsBlocked (this, Constants.BLOCK_NAME, Constants.PROFILE_ID)
        if(!appIsBlocked(this)){
            findViewById<TextView>(R.id.textView).text = getString(R.string.app_is_not_blocked)
            Toast.makeText(this, "app is not blocked", Toast.LENGTH_LONG).show()
        }
    }
}