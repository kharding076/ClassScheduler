package com.harding.classschedulerkyleharding.Entity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="assessments")
public class Assessment {
    @PrimaryKey
    private int assessmentID;

    private String name;
    private int courseID;
    private String assessmentType;

    public int getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getAssessmentType() {

        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }
}
