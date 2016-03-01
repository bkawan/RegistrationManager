/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bk.rm.view;

import com.bk.rm.dao.CourseDAO;
import com.bk.rm.dao.StudentDAO;
import com.bk.rm.dao.TrainerDAO;
import com.bk.rm.dao.implement.CourseDAOimplement;
import com.bk.rm.dao.implement.StudentDAOimplement;
import com.bk.rm.dao.implement.TrainerDAOimplement;
import java.util.Scanner;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 1:28:01 PM
 */
public class MainView {

    public Scanner input;
    public StudentDAO studentDAO;
    public TrainerDAO trainerDAO;
    public CourseDAO courseDAO;

    public MainView() {
        this.input = new Scanner(System.in);
        this.studentDAO = new StudentDAOimplement();
        this.trainerDAO = new TrainerDAOimplement();
        this.courseDAO = new CourseDAOimplement();

    }

    public void mainController() {

        mainMenu();
        boolean invalid = false;

        int x = input.nextInt();

        if (5 < x || x > 0) {

            switch (x) {

                case 1:

                    studentContoller();

                    break;

                case 2:
                    trainerController();
                    break;
                case 3:
                    courseController();
                    break;
                case 4:
                    System.out.println("Do you want Quit Application[Y/N]:?");
                    if (input.next().equalsIgnoreCase("Y")) {
                        System.exit(0);

                    }
                    break;

            }

            invalid = false;
        }

        if (!invalid) {
            System.out.println("please enter the number between[1-4]");
        }

    }

    public void mainMenu() {
        System.out.println("******************************************");
        System.out.println("**** [Welcome to Registration Manager] *****");
        System.out.println("******************************************");
        System.out.println("+++++++ [Main Menu ]++++++");

        System.out.println("[1]. Student: ");
        System.out.println("[2]. Trainer: ");
        System.out.println("[3]. Course: ");
        System.out.println("[4]. Exit: ");
        System.out.println("----------------------------------------");
        System.out.println("Select the option between [1-4]:");

    }

    public void studentContoller() {

        StudentView sv = new StudentView(input, studentDAO);
        sv.studentController();

    }

    private void trainerController() {
        TrainerView tv = new TrainerView(input, trainerDAO);
        tv.trainerController();
    }

    private void courseController() {
        CourseView cv = new CourseView(input, courseDAO);
            cv.courseController();
          
        
    }

}
