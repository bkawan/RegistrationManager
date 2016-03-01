/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bk.rm.dao.implement;

import com.bk.rm.dao.TrainerDAO;
import com.bk.rm.entity.Trainer;
import java.util.ArrayList;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 1:10:49 PM
 */
public class TrainerDAOimplement implements TrainerDAO {

    ArrayList<Trainer> trainerList;

    public TrainerDAOimplement() {
        trainerList = new ArrayList<>();
    }

    @Override
    public void addTrainer(Trainer trainer) {
        trainerList.add(trainer);
    }

    @Override
    public ArrayList<Trainer> showAllTrainer() {
        return trainerList;
    }

    @Override
    public ArrayList<Trainer> searchTrainer(String param) {
        ArrayList<Trainer> trainers = new ArrayList<>();
        for (Trainer trainer : trainerList) {
            String firstName = trainer.getFirstName().toLowerCase();
            String lastName = trainer.getLastName().toLowerCase();
            String email = trainer.getEmail().toLowerCase();
            String address = trainer.getAddress().toLowerCase();
            param = param.toLowerCase();

            if (param.contains(firstName) || param.contains(lastName) || param.contains(email) || param.contains(address)) {

                // if contains character then add to the new list
                trainers.add(trainer);

            }

        }
        // return new list
        return trainers;
    }

    @Override
    public Trainer findTrainerById(int tid) {

        for (Trainer trainer : trainerList) {
            if (trainer.getId() == tid) {
                return trainer;
            }
        }
        return null;

    }

    @Override
    public boolean deleteTrainer(int tid) {

        boolean hasDelete = false;
        for (Trainer trainer : trainerList) {

            if (trainer.getId() == tid) {

                trainerList.remove(trainer);
                hasDelete = true;
                System.out.println("Sucessfully Deleted  the Trainer");

                break;
            } else {
                System.out.println("Sorry Coudn't find the ID you have entered..");
                hasDelete = false;
            }
            if (trainerList.isEmpty()) {
                System.out.println("There are no trainers in the List. please tryelater");
                hasDelete = false;
            }
        }
        return hasDelete;
    }

    @Override
    public void deleteAllTrainer() {
        if (trainerList.size() > 0) {
            trainerList.clear();
            System.out.println("Sucessfully delete all Trainers ");

        } else {
            System.out.println("There are no trainers in the list.Please try later..");
        }

    }

}
