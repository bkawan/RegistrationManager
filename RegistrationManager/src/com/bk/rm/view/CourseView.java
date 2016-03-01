/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bk.rm.view;

import com.bk.rm.dao.CourseDAO;
import com.bk.rm.entity.Course;
import com.bk.rm.entity.Student;
import java.util.Scanner;

/**
 *
 * @author bkawan
 * @date Mar 1, 2016
 * @time 8:10:39 AM
 */
public class CourseView {

    // to get scranner reference from mainview
    Scanner input;
    // to get CourseDAO reference from mainView
    CourseDAO courseDAO;

    int cid;

    public CourseView(Scanner input, CourseDAO courseDAO) {
        this.input = input;
        this.courseDAO = courseDAO;
        this.cid = 1;

    }

   

    public void courseController() {
        courseMenu();

        switch (input.nextInt()) {
            case 1:
                addCourse();

                break;

            case 2:
                showAllCourse();
                break;
            case 3:
                findCourseById();
                break;
            case 4:
                searchCourse();
                break;
            case 5:
                deleteCourse();
                break;
            case 6:
                deleteAllCourses();
                break;
            case 7:
                mainMenu();
                break;

        }
    }

    private void courseMenu() {
        System.out.println("******************************************");
        System.out.println("**** [Welcome to Registration Manager] *****");
        System.out.println("******************************************");
        System.out.println("+++++++ [Course Menu ]++++++");

        System.out.println("[1]. Add Course: ");
        System.out.println("[2]. Show All Courses: ");
        System.out.println("[3]. Find Course by ID : ");
        System.out.println("[4]. Search Course: ");
        System.out.println("[5]. Delete Course: ");
        System.out.println("[6]. Delete All course: ");
        System.out.println("[7]. Back to Main Menu: ");
        System.out.println("----------------------------------------");
        System.out.println("Select the option between [1-7]:");

    }
    
     public void addCourse() {
         boolean addMore = true;
        while (true) {

            System.out.println("********* Registration For Student **********");
            //Register Course
            // instantiate Course object
            // set all the course object setter from user unput 
            Course course = new Course();
//                        System.out.println("Enter ID: ");
            course.setCid(cid++);
            System.out.println("Enter Course Title: ");
            String title = input.next();
            course.setCourseTitle(title);

            System.out.println("Enter course Description: ");
            String desc = input.next();
            
            course.setCourseDesc(desc);
            

            // add the student object in collecion
            courseDAO.addCourse(course);

            System.out.println("Do you want to add more Course [Y/N]?:]");

            while (true) {
                String x = input.next();
                if (x.equalsIgnoreCase("y")) {
                    System.out.println("right");
                    break;

                } else if (x.equalsIgnoreCase("n")) {
                    addMore = false;
                    break;
                } else {
                    System.out.println("Invalid Commant please enter Y or N");
                    continue;
                }
            }
            if (!addMore) {
                break;
            }
        }

    }

    private void deleteAllCourses() {
        System.out.println("Deleting All Course");
        courseDAO.deleteAllCourses();
    }

    private void deleteCourse() {
           boolean deleteMore = true;

        while (true) {
            System.out.println("+++++[ Delete  Course   ]++++++");
            System.out.println("Enter Course ID to Delete... ");

            courseDAO.deleteCourse(input.nextInt());
            System.out.println("Do you want to delete more......[Y/N]?");
            
             while (true) {
                String x = input.next();
                if (x.equalsIgnoreCase("y")) {
                    break;

                } else if (x.equalsIgnoreCase("n")) {
                    deleteMore = false;
                    break;
                } else {
                    System.out.println("Invalid Commant please enter Y or N");
                    continue;
                }
            }
            if (!deleteMore) {
                break;
            }
        }
    }

    private void searchCourse() {
        boolean searchMore = true;
        while (true) {
                System.out.println("+++++[ Searching  Course ]++++++");
            System.out.println("Enter course title/description etc to Search.... ");

            String param = input.next();
            System.out.println("-----------------------------------");

            System.out.println("Search Results for [" + param + "] below.... ");
            System.out.println("-----------------------------------");

            courseDAO.searchCourse(param).forEach(course -> {
                course.courseDetails();

            });
            if (courseDAO.searchCourse(param).isEmpty()) {
                System.out.println("Sorry!! I coudn't find course " + param);
            }
                        System.out.println("Do you want to Search more......[Y/N]?");

            while (true) {
                String x = input.next();
                if (x.equalsIgnoreCase("y")) {
                    break;

                } else if (x.equalsIgnoreCase("n")) {
                    searchMore = false;
                    break;
                } else {
                    System.out.println("Invalid Command please enter Y or N");
                    continue;
                }
            }
            if (!searchMore) {
                break;
            }
        }
    }

    private void findCourseById() {
        boolean searchMore = true;
        while (true) {
            System.out.println("******[ Finding course by ID]*****");

            Course course = courseDAO.findCourseById(input.nextInt());
            if (course != null) {
                System.out.println("Search results....");
                course.courseDetails();
            } else {
                System.out.println("Search results....");
                System.out.println("Record not found");
            }

            System.out.println("Do you want to find more course......[Y/N]?");
            while (true) {
                String x = input.next();
                if (x.equalsIgnoreCase("y")) {
                    break;

                } else if (x.equalsIgnoreCase("n")) {
                    searchMore = false;
                    break;
                } else {
                    System.out.println("Invalid Command please enter Y or N");
                    continue;
                }
            }
            if (!searchMore) {
                break;
            }

        }
    }

    private void showAllCourse() {
        System.out.println("++++++[ Listing All Courses ] ++++++++");
        System.out.println("+++ [ Course ]++++");

        courseDAO.showAllCourse().forEach(course -> {
            course.courseDetails();
            System.out.println("----------------------");
        });
    }

    private void mainMenu() {
        MainView mv = new MainView();
        mv.mainMenu();
    }
}
