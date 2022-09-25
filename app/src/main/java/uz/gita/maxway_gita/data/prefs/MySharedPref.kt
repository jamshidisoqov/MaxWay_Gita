package uz.gita.maxway_gita.data.prefs

import android.content.Context
import android.content.SharedPreferences
import uz.gita.maxway_gita.utils.SharedPreference
import javax.inject.Inject

// Created by Jamshid Isoqov an 9/23/2022
class MySharedPref @Inject constructor(
    ctx: Context,
    sharedPreferences: SharedPreferences
) : SharedPreference(ctx, sharedPreferences) {

    var userId: String by Strings("")
}