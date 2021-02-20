package com.harding.classschedulerkyleharding.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.harding.classschedulerkyleharding.Entity.Assessment;
import com.harding.classschedulerkyleharding.Entity.Course;

import java.util.List;

@Dao
public interface CourseDAO {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Course course);

    @Delete
    void delete(Course course);


    @Query("DELETE FROM courses")
    void deleteAllCourses();

    @Query("SELECT * FROM courses ORDER BY courseID ASC")
    List<Course> getAllCourses();
}
