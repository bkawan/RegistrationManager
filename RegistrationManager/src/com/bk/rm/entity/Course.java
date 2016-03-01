/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bk.rm.entity;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 12:50:48 PM
 */
public class Course {

    public int cid;
    public String courseTitle, courseDesc;

    public Course() {
    }

    public Course(int cid, String courseTitle, String courseDesc) {
        this.cid = cid;
        this.courseTitle = courseTitle;
        this.courseDesc = courseDesc;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    @Override
    public String toString() {
        return "Course{" + "cid=" + cid + ", courseTitle=" + courseTitle + ", courseDesc=" + courseDesc + '}';
    }

    public void courseDetails() {

        System.out.println("++++ [ Courses ] ++++");
        System.out.println("Course Title: " + courseTitle);

        System.out.println("Course Description: " + courseDesc);

        System.out.println("---------------------------");
    }

}
