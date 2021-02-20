package com.harding.classschedulerkyleharding.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.harding.classschedulerkyleharding.Entity.CourseNotes;
import com.harding.classschedulerkyleharding.Entity.Term;

import java.util.List;

@Dao
public interface TermDAO {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Term term);

    @Query("DELETE FROM terms")
    void deleteAllTerms();

    @Delete
    void delete(Term term);


    @Query("SELECT * FROM terms ORDER BY termID ASC")
    List<Term> getAllTerms();
}
