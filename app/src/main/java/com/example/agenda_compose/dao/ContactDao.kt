package com.example.agenda_compose.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.agenda_compose.model.Contact

@Dao
interface ContactDao {

    @Insert
    fun save(contactList: MutableList<Contact>)

    @Query("SELECT * FROM table_contacts ORDER BY first_name ASC") //DESC
    fun getContact(): MutableList<Contact>

    @Query("UPDATE table_contacts SET first_name = :newFirstName, last_name = :newLastName, email = :newEmail, phone= :newPhone " + "WHERE uid = :id")
    fun update(id: Int, newFirstName: String, newLastName: String, newEmail: String, newPhone: String)

    @Query("DELETE FROM table_contacts WHERE uid = :id")
    fun delete(id: Int)
}