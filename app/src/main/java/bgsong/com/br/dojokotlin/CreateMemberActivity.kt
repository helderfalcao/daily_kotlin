package bgsong.com.br.dojokotlin

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import bgsong.com.br.dojokotlin.model.Member
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_create_member.*

class CreateMemberActivity : AppCompatActivity() {

    val list_cargo = arrayOf(Constants.DEVELOPER, Constants.SM, Constants.ARCHITECT, Constants.QA)
    var membersList = ArrayList<Member>()
    lateinit var prefs: SharedPreferences
    lateinit var prefEditor: SharedPreferences.Editor
    var createSucess = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_member)

        val adapterCargo = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, list_cargo)
        spinner.adapter = adapterCargo
        prefs = getSharedPreferences(Constants.SHARED_KEY, 0)
        prefEditor = prefs.edit()
        val membersListJson = prefs.getString(Constants.MEMBERS_KEY, "[]")
        membersList = Gson().fromJson(membersListJson, object : TypeToken<List<Member>>() {}.type)

        createButton.setOnClickListener {
            createNewMember()
        }

        if (intent != null && intent.hasExtra(Constants.MEMBER_EMAIL)) {
            val memberEmail = intent.getStringExtra(Constants.MEMBER_EMAIL)

            val member = membersList.filter { it.email == memberEmail }[0]
            membersList = membersList.filter { it.email != memberEmail } as ArrayList<Member>

            editName.setText(member.name)
            editEmail.setText(member.email)

            val roleIndex = adapterCargo.getPosition(member.role)
            spinner.setSelection(roleIndex)
        } else {
            deleteButton.visibility = View.GONE
        }
    }

    private fun createNewMember() {
        val name = editName.text.toString()
        val email = editEmail.text.toString()
        val role = spinner.selectedItem.toString()

        val member = Member(name, email, role)

        if(!isMemberUnique(email)) {
            editEmail.error = "Email já cadastrado"
            return
        }
        membersList.add(member)

        val memberList = Gson().toJson(membersList)
        Log.d("Gson: ", memberList)

        prefEditor.putString(Constants.MEMBERS_KEY, Gson().toJson(membersList))
        createSucess = prefEditor.commit()
        if (createSucess) {
            Toast.makeText(this, "Sucess", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteMember (view: View) {
        val memberList = Gson().toJson(membersList)
        Log.d("Gson: ", memberList)

        prefEditor.putString(Constants.MEMBERS_KEY, Gson().toJson(membersList))
        createSucess = prefEditor.commit()
        if (createSucess) {
            Toast.makeText(this, "Sucess", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
    private fun isMemberUnique(email: String) = membersList
            .filter { it.email == email }.isEmpty()

}
