package bgsong.com.br.dojokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configListenerCreateMember()
    }


    private fun configListenerCreateMember() {
        members_list_button.setOnClickListener {
            startActivity(Intent(this, ListMembersActivity::class.java))
        }
        dailyButton.setOnClickListener {
            startActivity(Intent(this, DailyActivity::class.java))
        }
    }
}
