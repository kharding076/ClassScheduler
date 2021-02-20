package com.harding.classschedulerkyleharding.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.harding.classschedulerkyleharding.Entity.Assessment;
import com.harding.classschedulerkyleharding.Entity.Course;
import com.harding.classschedulerkyleharding.Entity.CourseNotes;

import java.util.List;

@Dao
public interface CourseNotesDAO {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(CourseNotes courseNotes);

    @Delete
    void delete(CourseNotes courseNotes);

    @Query("DELETE FROM course_notes")
    void deleteAllCourseNotes();

    @Query("SELECT * FROM course_notes ORDER BY courseID ASC")
    List<CourseNotes> getAllCourseNotes();
}
