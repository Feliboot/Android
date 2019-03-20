package br.com.felipea.android.appestagio.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Person  (var nome:String,var email:String,var empresa:String,var cidade:String, var estado:String, var pais:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeString(email)
        parcel.writeString(empresa)
        parcel.writeString(cidade)
        parcel.writeString(estado)
        parcel.writeString(pais)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}