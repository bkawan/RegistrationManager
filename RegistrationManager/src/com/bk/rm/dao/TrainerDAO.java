/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bk.rm.dao;

import com.bk.rm.entity.Student;
import com.bk.rm.entity.Trainer;
import java.util.ArrayList;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 1:00:13 PM
 */
public interface TrainerDAO {
    
     void addTrainer(Trainer trainer);
    ArrayList<Trainer> showAllTrainer();
    ArrayList<Trainer> searchTrainer(String param);
    Trainer findTrainerById(int tid);
    boolean deleteTrainer(int tid);
    void deleteAllTrainer();

}
