package com.example.agenda_compose.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.agenda_compose.constants.Constants

//conf tabela de dados
@Entity(tableName = Constants.TableContacts)
data class Contact (
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "phone") val phone: String,
){
    //para o id nao se repetir
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}

