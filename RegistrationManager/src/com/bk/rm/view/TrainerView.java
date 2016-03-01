/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bk.rm.view;

import com.bk.rm.dao.TrainerDAO;
import com.bk.rm.entity.Trainer;
import java.util.Scanner;

/**
 *
 * @author bkawan
 * @date Feb 29, 2016
 * @time 8:02:30 PM
 */
public class TrainerView {

    public Scanner input;
    public int tid;
    public TrainerDAO trainerDAO;

    public TrainerView() {

    }

    TrainerView(Scanner input, TrainerDAO trainerDAO) {
        this.input = input;
        this.trainerDAO = trainerDAO;
        this.tid = 1;

    }

    public void trainerMenu() {
        System.out.println("******************************************");
        System.out.println("**** [Welcome to Registration Manager] *****");
        System.out.println("******************************************");
        System.out.println("+++++++ [Trainer Menu ]++++++");

        System.out.println("[1]. Register Trainer: ");
        System.out.println("[2]. Show All Trainer: ");
        System.out.println("[3]. Find Trainer by ID : ");
        System.out.println("[4]. Search Trainer: ");
        System.out.println("[5]. Delete Trainer: ");
        System.out.println("[6]. Delete All Trainer: ");
        System.out.println("[7]. Back to Main Menu: ");
        System.out.println("----------------------------------------");
        System.out.println("Select the option between [1-7]:");

    }

    public void trainerController() {

        trainerMenu();
        switch (input.nextInt()) {
            case 1:
                registerTrainer();
                break;

            case 2:
                showAllTrainer();
                break;
            case 3:
                findTrainerById();
                break;
            case 4:
                searchTrainer();
                break;
            case 5:
                deleteTrainer();

                break;
            case 6:
                deleteAllTrainers();
                break;
            case 7:
                mainMenu();
                break;

        }
    }

    private void registerTrainer() {

        boolean addMore = true;
        while (true) {
            Trainer trainer = new Trainer();
            System.out.println("********* Registration For Trainer **********");

            trainer.setId(tid++);
            trainer.setPersonType("Trainer");

            System.out.println("Enter First Name: ");
            trainer.setFirstName(input.next());
            System.out.println("Enter Last Name: ");
            trainer.setLastName(input.next());
            System.out.println("Enter Email Address: ");
            trainer.setEmail(input.next());
            System.out.println("Enter  phone number: ");
            trainer.setPhoneNo(input.next());
            System.out.println("Enter  Address: ");
            trainer.setAddress(input.next());

            trainerDAO.addTrainer(trainer);

            System.out.println("Do you want to Add More trainers..[Y/N]:?");

            while (true) {
                String x = input.next();
                if (x.equalsIgnoreCase("y")) {
                    break;

                } else if (x.equalsIgnoreCase("n")) {
                    addMore = false;
                    trainerController();
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

    private void showAllTrainer() {
        System.out.println("+++++[ Listing All Trainers ]++++++");

        trainerDAO.showAllTrainer().forEach(trainer -> {
            trainer.personDetails();
                                trainerController();


        });
    }

    private void findTrainerById() {
        boolean searchMore = true;

        while (true) {
            System.out.println("+++++[ Finding  TRainer  by ID ]++++++");
            System.out.println("Enter trainer ID to Search Record.... ");
            //search trainer with input id passed and store as a variable
            Trainer trainer = trainerDAO.findTrainerById(input.nextInt());
            //
            if (trainer != null) {
                System.out.println("Search Results..");
                trainer.personDetails();
            } else {
                System.out.println("Record not found");
            }

            System.out.println("Do you want to find more trainer......[Y/N]?");
            while (true) {
                String x = input.next();
                if (x.equalsIgnoreCase("y")) {
                    break;

                } else if (x.equalsIgnoreCase("n")) {
                    searchMore = false;
                                        trainerController();

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

    private void searchTrainer() {
        boolean searchMore = true;

        while (true) {

            System.out.println("+++++[ Searching  Trainer ]++++++");
            System.out.println("Enter name/address etc to Search.... ");

            String param = input.next();
            System.out.println("-----------------------------------");

            System.out.println("Search Results for [" + param + "] below.... ");
            System.out.println("-----------------------------------");

            trainerDAO.searchTrainer(param).forEach(trainer -> {
                trainer.personDetails();

            });
            if (trainerDAO.searchTrainer(param).isEmpty()) {
                System.out.println("Sorry!! I coudn't find Trainer " + param);
            }
            System.out.println("Do you want to serach more trainer......[Y/N]?");
            while (true) {
                String x = input.next();
                if (x.equalsIgnoreCase("y")) {
                    break;

                } else if (x.equalsIgnoreCase("n")) {
                    searchMore = false;
                                        trainerController();

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

    private void deleteTrainer() {
        boolean deleteMore = true;
        while (true) {
            System.out.println("+++++[ Delete  Trainer   ]++++++");
            System.out.println("Enter trainer ID to Delete... ");

            trainerDAO.deleteTrainer(input.nextInt());
            System.out.println("Do you want to delete more......[Y/N]?");
            while (true) {
                String x = input.next();
                if (x.equalsIgnoreCase("y")) {
                    break;

                } else if (x.equalsIgnoreCase("n")) {
                    deleteMore = false;
                                        trainerController();

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

    private void deleteAllTrainers() {
        System.out.println("Deleting All Student");
        System.out.println("Are you sure you want to delete all trainer[Y/N]:");

        if (input.next().equalsIgnoreCase("Y")) {
            trainerDAO.deleteAllTrainer();
                                trainerController();

        }
    }

    private void mainMenu() {

        MainView mv = new MainView();
        mv.mainMenu();
    }

}
