package bgsong.com.br.dojokotlin

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import bgsong.com.br.dojokotlin.model.Member
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_create_member.*
import org.json.JSONObject

class CreateMemberActivity : AppCompatActivity() {

    val list_cargo = arrayOf("Desenvolvedor", "SM", "Arquiteto", "QA")
    var membersList = ArrayList<Member>()
    var prefs: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_member)

        val adapterCargo = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_cargo)
        spinner.adapter = adapterCargo
        prefs = getSharedPreferences(Constants.SHARED_KEY, 0);

        fabCreateMember.setOnClickListener {
            createNewMember()
        }
    }

    private fun createNewMember() {
        val name = editName.text.toString()
        val email = editEmail.text.toString()
        val role = spinner.selectedItem.toString()

        val member = Member(name, email, role)

        prefs.edit().putString(Constants.MEMBERS_KEY, Gson(member))

        Constants.MEMBERS_KEY

    }
}
