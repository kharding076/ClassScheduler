package com.harding.classschedulerkyleharding.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.harding.classschedulerkyleharding.Entity.Assessment;

import java.util.List;

@Dao
public interface AssessmentDAO {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Assessment assessment);

    @Delete
    void delete(Assessment assessment);

    @Query("DELETE FROM assessments")
    void deleteAllAssessments();

    @Query("SELECT * FROM assessments ORDER BY assessmentID ASC")
    List<Assessment> getAllAssessments();
}
