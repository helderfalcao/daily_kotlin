package bgsong.com.br.dojokotlin

import android.app.Activity
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

/**
 * A placeholder fragment containing a simple view.
 */
class ListMembersFragment : Fragment() {

//    val listMembers = arrayOf(Member("Nome", "", ""),
//            Member("Gabriel", "", ""),
//            Member("Juka", "", "")).toList()

    var membersList = HashMap<String, Member>()
    lateinit var prefs: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_members, container, false)
        prefs = activity.getPreferences(0)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerMember.layoutManager = LinearLayoutManager(activity)

        // TODO Verificar se vai funcionar a conversão
        val membersListJson = prefs.getString(Constants.MEMBERS_KEY, "{}")
        membersList = Gson().fromJson(membersListJson, HashMap<String, Member>()::class.java)

        var members = ArrayList<Member>(membersList.values)

        recyclerMember.adapter = MembersAdapter(members, activity)
    }
}
