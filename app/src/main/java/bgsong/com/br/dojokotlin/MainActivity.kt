package bgsong.com.br.dojokotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
            if (isValidList()) {
                startActivity(Intent(this, DailyActivity::class.java))
            }
        }
    }

    private fun isValidList(): Boolean {
        var isValid = false
        var errorMessage: String = ""
        val memberList = MemberUtils.getMembersList(this)
        if (!MemberUtils.hasDevOrQa(memberList)) {
            errorMessage = getString(R.string.none_role_inserted,
                    getString(R.string.developer_or_qa))
        } else if (!MemberUtils.hasArchitect(memberList)) {
            errorMessage = getString(R.string.none_role_inserted,
                    getString(R.string.architect))
        } else if (!MemberUtils.hasSm(MemberUtils.getMembersList(this))) {
            errorMessage = getString(R.string.none_role_inserted,
                    getString(R.string.sm))
        } else {
            isValid = true
        }

        if (!isValid) {
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
        }

        return isValid
    }
}
