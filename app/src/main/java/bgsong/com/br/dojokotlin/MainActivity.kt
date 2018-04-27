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

            if (MemberUtils.hasDevOrQa(MemberUtils.getMembersList(this))) {
                Toast.makeText(this, "Nenhum dev ou QA inserido", Toast.LENGTH_LONG).show()
            } else if (MemberUtils.hasArchitect(MemberUtils.getMembersList(this))) {
                Toast.makeText(this, "Nenhum Arquiteto inserido", Toast.LENGTH_LONG).show()
            } else if (MemberUtils.hasSm(MemberUtils.getMembersList(this))) {
                Toast.makeText(this, "Nenhum SM inserido", Toast.LENGTH_LONG).show()
            } else {
                startActivity(Intent(this, DailyActivity::class.java))
            }
        }
    }

    private fun isValidList(): Boolean {
        var isValid = true
        var errorMessage : String
        var memberList = MemberUtils.getMembersList(this)
        if (!MemberUtils.hasDevOrQa(memberList)) {
            errorMessage = getString(R.string.none_role_inserted,
                    getString(R.string.developer_or_qa))
            isValid = false
        } else if (MemberUtils.hasArchitect(memberList)) {
            errorMessage = getString(R.string.none_role_inserted,
                    getString(R.string.architect))
        } else if (MemberUtils.hasSm(MemberUtils.getMembersList(this))) {
            Toast.makeText(this, "Nenhum SM inserido", Toast.LENGTH_LONG).show()
        } else {
            startActivity(Intent(this, DailyActivity::class.java))
        }
        return isValid;
    }
}
