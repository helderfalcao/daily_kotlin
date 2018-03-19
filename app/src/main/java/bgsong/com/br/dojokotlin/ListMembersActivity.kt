package bgsong.com.br.dojokotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_members.*
import kotlinx.android.synthetic.main.fragment_list_members.*

class ListMembersActivity : AppCompatActivity() {

    lateinit var fragment: ListMembersFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_members)
        setSupportActionBar(toolbar)

        fabCreateMember.setOnClickListener {
            startActivityForResult(Intent(this, CreateMemberActivity::class.java),
                    Constants.MEMBER_ADD_SUCESS)
        }

        fragment = ListMembersFragment()
        val fragTransaction = supportFragmentManager.beginTransaction()
        fragTransaction.add(R.id.fragment, fragment)
        fragTransaction.commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Constants.MEMBER_ADD_SUCESS) {
            fragment.updateList()
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

}
