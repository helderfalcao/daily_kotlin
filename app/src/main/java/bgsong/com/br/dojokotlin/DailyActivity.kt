package bgsong.com.br.dojokotlin

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import bgsong.com.br.dojokotlin.model.Member
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DailyActivity : AppCompatActivity() {
    var membersList = ArrayList<Member>()
    lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)

        val membersListJson = prefs.getString(Constants.MEMBERS_KEY, "[]")
        membersList = Gson().fromJson(membersListJson, object : TypeToken<List<Member>>() {}.type)



    }
}
