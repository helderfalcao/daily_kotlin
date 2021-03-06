package bgsong.com.br.dojokotlin.utils

import android.content.Context
import bgsong.com.br.dojokotlin.Constants
import bgsong.com.br.dojokotlin.model.Member
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MemberUtils {

    companion object {
        @JvmStatic fun getMembersList(context: Context) : List<Member> {
            val prefs = context.getSharedPreferences(Constants.SHARED_KEY, 0)
            val membersListJson = prefs.getString(Constants.MEMBERS_KEY, "[]")
            return Gson().fromJson(membersListJson, object : TypeToken<List<Member>>() {}.type)
        }

        @JvmStatic fun hasDevOrQa (list: List<Member>): Boolean {
            return list.filter { it.role == Constants.DEVELOPER || it.role == Constants.QA }.isNotEmpty()
        }

        @JvmStatic fun hasSm (list: List<Member>): Boolean {
            return list.filter { it.role == Constants.SM }.isNotEmpty()
        }

        @JvmStatic fun hasArchitect (list: List<Member>): Boolean {
            return list.filter { it.role == Constants.ARCHITECT}.isNotEmpty()
        }
    }
}