package bgsong.com.br.dojokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import bgsong.com.br.dojokotlin.model.Member
import kotlinx.android.synthetic.main.activity_create_member.*

class CreateMemberActivity : AppCompatActivity() {

    var list_cargo = arrayOf("Desenvolvedor","SM","Arquiteto");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_member)

        val adapterCargo = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_cargo);
        spinner!!.adapter = adapterCargo


        fabCreateMember.setOnClickListener {
            createNewMember()
        }
    }

    private fun createNewMember() {
        val name = editName.text.toString()
        val email = editEmail.text.toString()
        val role = spinner.selectedItem.toString()

        val member = Member(name, email, role)

    }
}
