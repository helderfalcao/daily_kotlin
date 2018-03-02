package bgsong.com.br.dojokotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_list_members.*

/**
 * A placeholder fragment containing a simple view.
 */
class ListMembersActivityFragment : Fragment() {

    var listMembers = arrayOf("Juba","Nelson","Guilherme");

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_members, container, false)
        recyclerMember.adapter = //ArrayAdapter(activity, android.R.layout.simple_list_item_1);
        return view;
    }
}
