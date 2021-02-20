package com.harding.classschedulerkyleharding.DB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.harding.classschedulerkyleharding.DAO.AssessmentDAO;
import com.harding.classschedulerkyleharding.DAO.CourseDAO;
import com.harding.classschedulerkyleharding.DAO.CourseNotesDAO;
import com.harding.classschedulerkyleharding.DAO.TermDAO;
import com.harding.classschedulerkyleharding.Entity.Assessment;
import com.harding.classschedulerkyleharding.Entity.Course;
import com.harding.classschedulerkyleharding.Entity.CourseNotes;
import com.harding.classschedulerkyleharding.Entity.Term;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Assessment.class, Course.class, CourseNotes.class, Term.class}, version = 1)

public abstract class ClassSchedulerDatabase extends RoomDatabase {
    public abstract AssessmentDAO assessmentDAO();
    public abstract CourseDAO courseDAO();
    public abstract CourseNotesDAO courseNotesDAO();
    public abstract TermDAO termDAO();

    private static final int NUMBER_OF_THREADS = 4;
    /**
     * The Database write executor.
     */
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    private static volatile ClassSchedulerDatabase INSTANCE;

    static ClassSchedulerDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ClassSchedulerDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ClassSchedulerDatabase.class, "class_scheduler_database.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static Callback sRoomDatabaseCallback = new Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            databaseWriteExecutor.execute(() -> {

                AssessmentDAO assessmentDAO = INSTANCE.assessmentDAO();
                CourseDAO courseDAO = INSTANCE.courseDAO();
                CourseNotesDAO courseNotesDAO = INSTANCE.courseNotesDAO();
                TermDAO termDAO = INSTANCE.termDAO();

           });
        }
    };
}
