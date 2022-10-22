package com.serkanonder.studentdata

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface StudentDao {
    @Query("SELECT * FROM student_table")
    fun getAll(): List<Student>

    /* @Query("SELECT * FROM student_table WHERE uid IN (:userIds)")
     fun loadAllByIds(userIds: IntArray): List<Student>*/

    @Query("SELECT * FROM student_table WHERE roll_no LIKE :roll LIMIT 1")
     fun findByRoll(roll: Int): Student

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(student: Student)

    @Delete
     fun delete(student: Student)

    @Query("DELETE FROM student_table")
     fun deleteAll()

     @Query("UPDATE student_table SET `first name`=:firstName, `last name`=:lastName WHERE roll_no LIKE :roll")
     fun update(roll: Int, firstName: String, lastName: String)
}