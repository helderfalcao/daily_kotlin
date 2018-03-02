package bgsong.com.br.dojokotlin

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_list_members.*

class ListMembersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_members)
        setSupportActionBar(toolbar)

        fabCreateMember.setOnClickListener {
            startActivity(Intent(this, ListMembersActivity::class.java))
        }

        val fragment = ListMembersActivityFragment()
        val fragTransaction = supportFragmentManager.beginTransaction()
        fragTransaction.add(R.id.fragment, fragment)
        fragTransaction.commit()
    }

}
