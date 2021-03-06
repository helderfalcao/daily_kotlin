package bgsong.com.br.dojokotlin.adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import bgsong.com.br.dojokotlin.model.Member

class MembersAdapter(private val memberList: List<Member>,
                     private val context: Context,
                     private val listener: (Member) -> Unit) : RecyclerView.Adapter<MembersAdapter.ViewHolder>() {

    var currentMemberPosition = -1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val member = memberList[position]

        holder.memberName.text = member.name

        if (currentMemberPosition == position) {
            holder.memberName.setBackgroundColor(Color.RED)
        } else {
            holder.memberName.setBackgroundColor(Color.TRANSPARENT)
        }
    }

    override fun getItemCount(): Int {
        return memberList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,
                parent, false)
        val holder = ViewHolder(view.findViewById(android.R.id.text1))

        holder.listen { pos, type ->
            val item = memberList[pos]
            listener(item)
        }

        return holder
    }

    class ViewHolder(memberViewHolder: TextView) : RecyclerView.ViewHolder(memberViewHolder) {
        val memberName = memberViewHolder
    }

    fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(adapterPosition, itemViewType)
        }
        return this
    }
}
