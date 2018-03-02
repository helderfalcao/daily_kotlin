package bgsong.com.br.dojokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create_member.*

class CreateMemberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_member)

        fabCreateMember.setOnClickListener {
            createNewMember()
        }
    }

    private fun createNewMember() {
        val name = editName.text.toString()
        val email = editEmail.text.toString()
    }
}
