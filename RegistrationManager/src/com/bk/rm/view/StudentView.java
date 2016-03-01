/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bk.rm.view;

import com.bk.rm.dao.StudentDAO;
import com.bk.rm.dao.implement.StudentDAOimplement;
import com.bk.rm.entity.Person;
import com.bk.rm.entity.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 1:27:39 PM
 */
public class StudentView {

    private Scanner input;
    private int sid;

    private StudentDAO studentDAO;

    public StudentView(Scanner input, StudentDAO studentDAO) {
        this.input = input;
        this.sid = 1;
        this.studentDAO = studentDAO;
    }

    public void studentController() {

        studentMenu();

        switch (input.nextInt()) {
            case 1:
                registerStudent();

                break;

            case 2:
                showAllStudents();
                break;
            case 3:
                findStudentByID();
                break;
            case 4:
                searchStudent();
                break;
            case 5:
                deleteStudent();
                break;
            case 6:
                deleteAllStudent();
                break;
            case 7:
                mainMenu();
                break;

        }
    }

    public void studentMenu() {

        System.out.println("******************************************");
        System.out.println("**** [Welcome to Registration Manager] *****");
        System.out.println("******************************************");
        System.out.println("+++++++ [Student Menu ]++++++");

        System.out.println("[1]. Register Student: ");
        System.out.println("[2]. Show All Students: ");
        System.out.println("[3]. Find Student by ID : ");
        System.out.println("[4]. Search Students: ");
        System.out.println("[5]. Delete Student: ");
        System.out.println("[6]. Delete All Students: ");
        System.out.println("[7]. Back to Main Menu: ");
        System.out.println("----------------------------------------");
        System.out.println("Select the option between [1-7]:");

    }

    public void registerStudent() {

        boolean addMore = true;
        while (true) {

            System.out.println("********* Registration For Student **********");
            //Register Student
            // instantiate Studnet object
            // set all the student object setter from user unput 
            Student student = new Student();
//                        System.out.println("Enter ID: ");
            student.setId(sid++);
            student.setPersonType("Student");
            System.out.println("Enter First Name: ");
            student.setFirstName(input.next());

            System.out.println("Enter Last Name");
            student.setLastName(input.next());
            System.out.println("Enter Email Address: ");
            student.setEmail(input.next());
            System.out.println("Enter Phone Number: ");
            student.setPhoneNo(input.next());
            System.out.println("Enter Address: ");
            student.setAddress(input.next());

            // add the student object in collecion
            studentDAO.addStudent(student);

            System.out.println("Do you want to add more student[Y/N]?:]");

            while (true) {
                String x = input.next();
                if (x.equalsIgnoreCase("y")) {
                    System.out.println("right");
                    break;

                } else if (x.equalsIgnoreCase("n")) {
                    addMore = false;
                    studentController();
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

    public void showAllStudents() {

        System.out.println("+++++[ Listing All Students ]++++++");

        studentDAO.showAllStudent().forEach(allStudents -> {
            allStudents.personDetails();
                                studentController();


        });
    }

    private void searchStudent() {

        boolean searchMore =true;
        while (true) {

            System.out.println("+++++[ Searching  Students ]++++++");
            System.out.println("Enter name/address etc to Search.... ");

            String param = input.next();
            System.out.println("-----------------------------------");

            System.out.println("Search Results for [" + param + "] below.... ");
            System.out.println("-----------------------------------");

            studentDAO.searchStudent(param).forEach(student -> {
                student.personDetails();

            });
            if (studentDAO.searchStudent(param).isEmpty()) {
                System.out.println("Sorry!! I coudn't find student " + param);
            }
            System.out.println("Do you want to serach more Students......[Y/N]?");
            while (true) {
                String x = input.next();
                if (x.equalsIgnoreCase("y")) {
                    break;

                } else if (x.equalsIgnoreCase("n")) {
                    searchMore = false;
                                        studentController();

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

    private void findStudentByID() {
        boolean searchMore = true;
        while (true) {
            System.out.println("+++++[ Finding  Students  by ID ]++++++");
            System.out.println("Enter Student ID to Search Record.... ");
            //search student with input id passed and store as a variable
            Student student = studentDAO.findStudentById(input.nextInt());
            //
            if (student != null) {
                System.out.println("Search Results..");
                student.personDetails();
            } else {
                System.out.println("Record not found");
            }

            System.out.println("Do you want to find more Students......[Y/N]?");
             while (true) {
                String x = input.next();
                if (x.equalsIgnoreCase("y")) {
                    break;

                } else if (x.equalsIgnoreCase("n")) {
                    searchMore = false;
                                        studentController();

                    break;
                } else {
                    System.out.println("Invalid Commant please enter Y or N");
                    continue;
                }
            }
            if (!searchMore) {
                break;
            }
        }
    }

    private void deleteStudent() {
        boolean deleteMore = true;

        while (true) {
            System.out.println("+++++[ Delete  Students   ]++++++");
            System.out.println("Enter Student ID to Delete... ");

            studentDAO.deleteStudent(input.nextInt());
            System.out.println("Do you want to delete more......[Y/N]?");
            
             while (true) {
                String x = input.next();
                if (x.equalsIgnoreCase("y")) {
                    break;

                } else if (x.equalsIgnoreCase("n")) {
                    deleteMore = false;
                                        studentController();

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

    private void deleteAllStudent() {

        System.out.println("Deleting All Student");
        studentDAO.deleteAllStudent();
                            studentController();

    }

    private void mainMenu() {

        MainView mv = new MainView();
        mv.mainMenu();
    }

}
