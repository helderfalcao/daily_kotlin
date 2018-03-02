package bgsong.com.br.dojokotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import bgsong.com.br.dojokotlin.model.Member

class MembersAdapter(val memberList: List<Member>)  : RecyclerView.Adapter<MembersAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(memberViewHolder: TextView) : RecyclerView.ViewHolder(memberViewHolder) {

    }

}
