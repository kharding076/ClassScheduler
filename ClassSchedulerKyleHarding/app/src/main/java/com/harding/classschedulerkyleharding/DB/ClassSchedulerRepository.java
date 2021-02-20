package com.harding.classschedulerkyleharding.DB;

import android.app.Application;


import com.harding.classschedulerkyleharding.DAO.AssessmentDAO;
import com.harding.classschedulerkyleharding.DAO.CourseDAO;
import com.harding.classschedulerkyleharding.DAO.CourseNotesDAO;
import com.harding.classschedulerkyleharding.DAO.TermDAO;
import com.harding.classschedulerkyleharding.Entity.Assessment;
import com.harding.classschedulerkyleharding.Entity.Course;
import com.harding.classschedulerkyleharding.Entity.CourseNotes;
import com.harding.classschedulerkyleharding.Entity.Term;

import java.util.List;

public class ClassSchedulerRepository {
    private AssessmentDAO assessmentDAO;
    private CourseDAO courseDAO;
    private CourseNotesDAO courseNotesDAO;
    private TermDAO termDAO;
    private List<Course> allCourses;
    private List<Assessment> allAssessments ;
    private List<CourseNotes> allCourseNotes ;
    private List<Term> allTerms ;



     public ClassSchedulerRepository(Application application){
        ClassSchedulerDatabase db=ClassSchedulerDatabase.getDatabase(application);
        assessmentDAO=db.assessmentDAO();
        courseDAO=db.courseDAO();
        courseNotesDAO=db.courseNotesDAO();
        termDAO=db.termDAO();

         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

    }
    public List<Assessment> getAllAssessments(){
        ClassSchedulerDatabase.databaseWriteExecutor.execute(()->{
            allAssessments=assessmentDAO.getAllAssessments();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         return allAssessments;
    }
    public List<Course> getAllCourses(){
        ClassSchedulerDatabase.databaseWriteExecutor.execute(()->{
                allCourses=courseDAO.getAllCourses();
            });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         return allCourses;
    }
    public List<CourseNotes> getAllCourseNotes(){
        ClassSchedulerDatabase.databaseWriteExecutor.execute(()->{
            allCourseNotes=courseNotesDAO.getAllCourseNotes();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return allCourseNotes;
    }
    public List<Term> getAllTerms(){
        ClassSchedulerDatabase.databaseWriteExecutor.execute(()->{
            allTerms=termDAO.getAllTerms();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return allTerms;
    }
    public void insert (Assessment assessment) {
        ClassSchedulerDatabase.databaseWriteExecutor.execute(()->{
            assessmentDAO.insert(assessment);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void insert (Course course) {
        ClassSchedulerDatabase.databaseWriteExecutor.execute(()->{
            courseDAO.insert(course);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void insert (CourseNotes courseNotes) {
        ClassSchedulerDatabase.databaseWriteExecutor.execute(()->{
            courseNotesDAO.insert(courseNotes);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void insert (Term term) {
        ClassSchedulerDatabase.databaseWriteExecutor.execute(()->{
            termDAO.insert(term);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete (Assessment assessment) {
        ClassSchedulerDatabase.databaseWriteExecutor.execute(() -> {
            assessmentDAO.delete(assessment);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void delete (Course course) {
        ClassSchedulerDatabase.databaseWriteExecutor.execute(() -> {
            courseDAO.delete(course);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void delete (CourseNotes courseNotes) {
        ClassSchedulerDatabase.databaseWriteExecutor.execute(() -> {
            courseNotesDAO.delete(courseNotes);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void delete (Term term) {
        ClassSchedulerDatabase.databaseWriteExecutor.execute(() -> {
            termDAO.delete(term);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
