package bgsong.com.br.dojokotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bgsong.com.br.dojokotlin.adapter.MembersAdapter
import bgsong.com.br.dojokotlin.model.Member
import kotlinx.android.synthetic.main.fragment_list_members.*

/**
 * A placeholder fragment containing a simple view.
 */
class ListMembersActivityFragment : Fragment() {

    var listMembers = arrayOf(Member("Nome", "", ""),
            Member("Gabriel", "", ""),
            Member("Juka", "", "")).toList();

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_members, container, false)
        return view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerMember.adapter = MembersAdapter(listMembers, activity)
    }
}
