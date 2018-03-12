package bgsong.com.br.dojokotlin

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import bgsong.com.br.dojokotlin.model.Member
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_create_member.*
import org.json.JSONObject

class CreateMemberActivity : AppCompatActivity() {

    val list_cargo = arrayOf("Desenvolvedor", "SM", "Arquiteto", "QA")
    var membersList = HashMap<String, Member>()
    lateinit var prefs: SharedPreferences
    var createSucess = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_member)

        val adapterCargo = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_cargo)
        spinner.adapter = adapterCargo
        prefs = getSharedPreferences(Constants.SHARED_KEY, 0)

        // TODO Verificar se vai funcionar a conversão
        val membersListJson = prefs.getString(Constants.MEMBERS_KEY, "{}")
        membersList = Gson().fromJson(membersListJson, HashMap<String, Member>()::class.java)

        fabCreateMember.setOnClickListener {
            createNewMember()

            //TODO tratamento os campos
        }
    }

    private fun createNewMember() {
        val name = editName.text.toString()
        val email = editEmail.text.toString()
        val role = spinner.selectedItem.toString()

        val member = Member(name, email, role)
        membersList.put(member.email, member)

        // TODO Adicionar o membro ao hashmap e slavar novamente no preferences

        prefs.edit().putString(Constants.MEMBERS_KEY, Gson().toJson(membersList))

        createSucess = prefs.edit().commit()
        if (createSucess) {
            Toast.makeText(this,"Sucess",Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }

        //TODO mensagem de sucesso
    }
}
