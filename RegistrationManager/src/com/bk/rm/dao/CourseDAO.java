/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bk.rm.dao;

import com.bk.rm.entity.Course;
import java.util.ArrayList;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 1:00:21 PM
 */
public interface CourseDAO {

    void addCourse(Course course);
    ArrayList<Course> showAllCourse();
    ArrayList<Course> searchCourse(String param);
    Course findCourseById(int cid);
    boolean deleteCourse(int cid);
    void deleteAllCourses();
    
}
