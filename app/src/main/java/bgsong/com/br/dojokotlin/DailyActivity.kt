package bgsong.com.br.dojokotlin

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import bgsong.com.br.dojokotlin.model.Member
import bgsong.com.br.dojokotlin.utils.MemberUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DailyActivity : AppCompatActivity() {
    var membersList = ArrayList<Member>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)

        membersList = MemberUtils.getMembersList(this) as ArrayList<Member>

        membersList.filter { it.role == Constants.DEVELOPER }

    }
}
