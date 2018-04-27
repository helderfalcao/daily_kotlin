package bgsong.com.br.dojokotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import bgsong.com.br.dojokotlin.adapter.MembersAdapter
import bgsong.com.br.dojokotlin.model.Member
import bgsong.com.br.dojokotlin.utils.MemberUtils
import kotlinx.android.synthetic.main.activity_daily.*
import kotlinx.android.synthetic.main.fragment_list_members.*
import java.util.*

class DailyActivity : AppCompatActivity() {
    var membersList = ArrayList<Member>()
    lateinit var devList: MutableList<Member>
    lateinit var smMember: Member
    lateinit var arqMember: Member

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)

        membersList = MemberUtils.getMembersList(this) as ArrayList<Member>

        devList = membersList.filter { it.role == Constants.DEVELOPER || it.role == Constants.QA }.toMutableList()

        smMember = membersList.filter { it.role == Constants.SM }.first()

        arqMember = membersList.filter { it.role == Constants.ARCHITECT }.first()

        val shuffledList = devList.shuffled().toMutableList()


        initUsersList(shuffledList)
    }

    fun initUsersList() {
        sortedList.layoutManager = LinearLayoutManager(this)

        recyclerMember.adapter = MembersAdapter(membersList, this) {}

    }
}
