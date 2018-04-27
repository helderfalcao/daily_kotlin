package bgsong.com.br.dojokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import bgsong.com.br.dojokotlin.adapter.MembersAdapter
import bgsong.com.br.dojokotlin.model.Member
import bgsong.com.br.dojokotlin.utils.MemberUtils
import kotlinx.android.synthetic.main.activity_daily.*
import java.util.*

class DailyActivity : AppCompatActivity() {

    private lateinit var adapter: MembersAdapter
    private var currentMemberPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)

        val membersList = MemberUtils.getMembersList(this) as ArrayList<Member>

        val devList = membersList.filter { it.role == Constants.DEVELOPER || it.role == Constants.QA }.toMutableList()

        val smMember = membersList.filter { it.role == Constants.SM }.first()

        val arqMember = membersList.filter { it.role == Constants.ARCHITECT }.first()

        val shuffledList = devList.shuffled().toMutableList()
        shuffledList.add(arqMember)
        shuffledList.add(smMember)

        initUsersList(shuffledList)

        btNextUser.setOnClickListener({
            adapter.currentMemberPosition = currentMemberPosition++
            adapter.notifyDataSetChanged()

            if (currentMemberPosition == membersList.size) {
                Toast.makeText(this, "TRUCO", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initUsersList(shuffledList: MutableList<Member>) {
        sortedList.layoutManager = LinearLayoutManager(this)

        adapter = MembersAdapter(shuffledList, this) {}
        sortedList.adapter = adapter
    }
}
