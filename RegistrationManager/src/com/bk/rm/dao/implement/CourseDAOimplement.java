/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bk.rm.dao.implement;

import com.bk.rm.dao.CourseDAO;
import com.bk.rm.entity.Course;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 1:11:49 PM
 */
public class CourseDAOimplement implements CourseDAO {
    
    // fisrst define variable generic arraylist of course
    
     ArrayList<Course> courseList;
   

    public CourseDAOimplement() {
       
        //instantiate  new arrayList object;
        this.courseList = new  ArrayList<>();
        
    }
   
    
    
    

    @Override
    public void addCourse(Course course) {
        
        // add course to the courseList 
        courseList.add(course);
    }

    @Override
    public ArrayList<Course> showAllCourse() {
        
        //return simply course list 
       return courseList;
    }

    @Override
    public ArrayList<Course> searchCourse(String param) {
        
        /**
         * 1 first instaniate new arrayList object to store results from the search
         * 2. loop through all the courses in our courseList
         * 3. convert all strings to lower case 
         * 4. check if param contain either any of course title or desc
         * 5. add to courses arrayList if found any
         * 6. return new course list
         * 
         */
        
        
        ArrayList<Course> courses = new ArrayList<>();
        for(Course course : courseList){
            String courseTitle = course.getCourseTitle().toLowerCase();
            String courseDesc = course.getCourseDesc().toLowerCase();
            param = param.toLowerCase();
            if(courseTitle.contains(param) || courseDesc.contains(param)){
                
              courses.add(course);
            }
                
            
            
        }
        return courses;
        
    }

    @Override
    public Course findCourseById(int cid) {
        
        for(Course course: courseList){
            if(course.getCid() == cid){
                
                return course;
            }
        }
        return null;
    }

    @Override
    public boolean deleteCourse(int cid) {
        
        boolean hasDelete = false;
        
        for(Course course:courseList){
        if(course.getCid() == cid){
            courseList.remove(course);
         System.out.println("Sucessfully Deleted  the student");
                hasDelete = true;
                break;
            } else {
                
                System.out.println("No record found ");
                hasDelete = true;
                break;
            }

        }
        if(courseList.size() == 0){
                    System.out.println("No students");
                    hasDelete = false;
                }
    return hasDelete;

}
    @Override
    public void deleteAllCourses() {
        
        if(courseList.size()>0){
            courseList.clear();
        }else{
            System.out.println("Sorry there no course to delete All the course. Try later");
        }
    }

}
