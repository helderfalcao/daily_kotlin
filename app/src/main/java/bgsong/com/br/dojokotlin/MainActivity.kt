package bgsong.com.br.dojokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import bgsong.com.br.dojokotlin.utils.MemberUtils
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
            if (MemberUtils.getDevList(MemberUtils.getMembersList(this))) {
                Toast.makeText(this, "Nenhum dev ou QA inserido", Toast.LENGTH_LONG).show()
            } else if (MemberUtils.getArqList(MemberUtils.getMembersList(this))) {
                Toast.makeText(this, "Nenhum Arquiteto inserido", Toast.LENGTH_LONG).show()
            } else if (MemberUtils.getSMList(MemberUtils.getMembersList(this))) {
                Toast.makeText(this, "Nenhum SM inserido", Toast.LENGTH_LONG).show()
            } else {
                startActivity(Intent(this, DailyActivity::class.java))
            }
        }
    }
}
