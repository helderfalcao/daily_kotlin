package bgsong.com.br.dojokotlin.utils

import android.content.Context
import bgsong.com.br.dojokotlin.Constants
import bgsong.com.br.dojokotlin.model.Member
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MemberUtils {
    companion object {
        @JvmStatic fun getMembersList(context: Context) : List<Member> {
            prefs = activity.getSharedPreferences(Constants.SHARED_KEY, 0)
            val membersListJson = prefs.getString(Constants.MEMBERS_KEY, "[]")
            membersList = Gson().fromJson(membersListJson, object : TypeToken<List<Member>>() {}.type)

        }
    }
}