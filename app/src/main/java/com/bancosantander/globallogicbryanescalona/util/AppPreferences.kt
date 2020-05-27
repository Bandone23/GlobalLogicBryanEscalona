package com.bancosantander.globallogicbryanescalona.util

import android.content.SharedPreferences
import androidx.core.content.edit
import org.koin.core.KoinComponent
import org.koin.core.inject

object AppPreferences: KoinComponent {

    private val preferences: SharedPreferences by inject()
    private const val LOCAL = "local"
    private const val PASS = "password"
    private const val EMAIL ="email"
    private const val TARIFF = "tariff"
    private const val TYPE_USERS = "typeUser"
    private const val NAME = "name"
    private const val IS_FORWARD ="isForWard"
    private const val DATE ="date"
    private const val PHONE="phone"
    private const val ASIST = "asistencia"
    private const val META = "meta"
    private const val PASSADMIN="passadmin"
    private const val PHONEADMIN="phoneadmin"
    private const val HORACIERRE="horacierre"
    private const val LOCALDISCOUNT="localDiscount"
    private const val CONDITION="condition"
    private const val TIPODISCOUNT="tipoDescuento"
    private const val PARKINGSIZE="parkingsize"



    const val SHARED_PREFERENCES_NAME = "parkingF"

    var localId: String?
        get() = preferences.getString(LOCAL, "")
        set(value) = preferences.edit {
            putString(LOCAL, value).apply()
        }
    var emailId: String?
        get() = preferences.getString(EMAIL, "")
        set(value) = preferences.edit {
            putString(EMAIL, value).apply()
        }
    var passId: String?
        get() = preferences.getString(PASS, "")
        set(value) = preferences.edit {
            putString(PASS, value).apply()
        }
    var tariff: String?
        get() = preferences.getString(TARIFF, "")
        set(value) = preferences.edit {
            putString(TARIFF, value).apply()
        }
    var typeUser: String?
        get() = preferences.getString(TYPE_USERS, "")
        set(value) = preferences.edit {
            putString(TYPE_USERS, value).apply()
        }
    var nameId: String?
        get() = preferences.getString(NAME, "")
        set(value) = preferences.edit {
            putString(NAME, value).apply()
        }
    var isForWard :Boolean?
        get() = preferences.getBoolean(IS_FORWARD, true)
        set(value) = preferences.edit {
            putBoolean(IS_FORWARD, value!!).apply()
        }

    var datep: String?
        get() = preferences.getString(DATE, "")
        set(value) = preferences.edit {
            putString(DATE, value).apply()
        }
    var asist :Boolean?
        get() = preferences.getBoolean(ASIST, false)
        set(value) = preferences.edit {
            putBoolean(ASIST, value!!).apply()
        }

    var phone: String?
        get() = preferences.getString(PHONE, "")
        set(value) = preferences.edit {
            putString(PHONE, value).apply()
        }

    var meta: String?
        get() = preferences.getString(META, "")
        set(value) = preferences.edit {
            putString(META, value).apply()
        }

    var passAdmin: String?
        get() = preferences.getString(PASSADMIN, "")
        set(value) = preferences.edit {
            putString(PASSADMIN, value).apply()
        }

    var phoneAdmin: String?
        get() = preferences.getString(PHONEADMIN, "")
        set(value) = preferences.edit {
            putString(PHONEADMIN, value).apply()
        }

    var horaCierre: String?
        get() = preferences.getString(HORACIERRE, "")
        set(value) = preferences.edit {
                putString(HORACIERRE, value).apply()
        }


    var localDiscount: String?
        get() = preferences.getString(LOCALDISCOUNT, "")
        set(value) = preferences.edit {
            putString(LOCALDISCOUNT, value).apply()
        }

    var condition: String?
        get() = preferences.getString(CONDITION, "")
        set(value) = preferences.edit {
            putString(CONDITION, value).apply()
        }

    var typeDiscount: String?
        get() = preferences.getString(TIPODISCOUNT, "")
        set(value) = preferences.edit {
            putString(TIPODISCOUNT, value).apply()
        }


    var parkingSize: Int?
        get() = preferences.getInt(PARKINGSIZE, 0)
        set(value) = preferences.edit {
            if (value != null) {
                putInt(PARKINGSIZE, value).apply()
            }
        }





}