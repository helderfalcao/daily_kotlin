package bgsong.com.br.dojokotlin

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bgsong.com.br.dojokotlin.adapter.MembersAdapter
import bgsong.com.br.dojokotlin.model.Member
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_list_members.*
import com.google.gson.reflect.TypeToken

/**
 * A placeholder fragment containing a simple view.
 */
class ListMembersFragment : Fragment() {

//    val listMembers = arrayOf(Member("Nome", "", ""),
//            Member("Gabriel", "", ""),
//            Member("Juka", "", "")).toList()

    var membersList = ArrayList<Member>()
    lateinit var prefs: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_members, container, false)
        prefs = activity.getSharedPreferences(Constants.SHARED_KEY, 0)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerMember.layoutManager = LinearLayoutManager(activity)
        updateList()
    }

    fun updateList() {
        val membersListJson = prefs.getString(Constants.MEMBERS_KEY, "[]")
        membersList = Gson().fromJson(membersListJson, object : TypeToken<List<Member>>() {}.type)

        recyclerMember.adapter = MembersAdapter(membersList, activity) {
            val intent = Intent(activity, CreateMemberActivity::class.java)
            intent.putExtra(Constants.MEMBER_EMAIL, it.email)
            startActivity(intent)
        }
    }



}
