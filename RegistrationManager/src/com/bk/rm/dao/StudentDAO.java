/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bk.rm.dao;


import com.bk.rm.entity.Person;
import com.bk.rm.entity.Student;
import java.util.ArrayList;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 12:59:54 PM
 */
public interface StudentDAO {
    
     void addStudent(Student student);
    ArrayList<Student> showAllStudent();
    ArrayList<Student> searchStudent(String param);
    Student findStudentById(int sid);
    boolean deleteStudent(int sid);
    void deleteAllStudent();

    

}
