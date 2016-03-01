/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bk.rm;

import com.bk.rm.view.MainView;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 12:48:33 PM
 */
public class MainProgram {

    public static void main(String[] args) {

        MainView mv = new MainView();

        while (true) {
            mv.mainController();
        }

    }

}
