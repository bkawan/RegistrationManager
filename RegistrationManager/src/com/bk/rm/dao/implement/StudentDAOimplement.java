/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bk.rm.dao.implement;

import com.bk.rm.dao.StudentDAO;
import com.bk.rm.entity.Person;
import com.bk.rm.entity.Student;
import java.util.ArrayList;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 1:09:27 PM
 */
public class StudentDAOimplement implements StudentDAO {

    //to store student object
    ArrayList<Student> studentList;

    public StudentDAOimplement() {
        studentList = new ArrayList<>();
    }

    @Override
    public void addStudent(Student student) {

        studentList.add(student);
    }

    @Override
    public ArrayList<Student> showAllStudent() {
        return studentList;
    }

    @Override
    public ArrayList<Student> searchStudent(String param) {
        // new arraylist container to store from searh results
        ArrayList<Student> students = new ArrayList<>();

        for (Student student : studentList) {
            String firstName = student.getFirstName().toLowerCase();
            String lastName = student.getLastName().toLowerCase();
            String address = student.getAddress().toLowerCase();
            String email = student.getEmail().toLowerCase();

            param = param.toLowerCase();
            if (firstName.contains(param) || lastName.contains(param) || address.contains(param) || email.contains(param)) {
                // if contains character add that student to new array list
                students.add(student);

            }
        }
        //return all new student list

        return students;
    }

    @Override
    public Student findStudentById(int sid) {

        for (Student student : studentList) {
            if (student.getId() == sid) {

                return student;
            }
        }

        return null;
    }

    @Override
    public boolean deleteStudent(int sid) {
        boolean hasDelete = false;
        for (Student student : studentList) {

            if (student.getId() == sid) {
                studentList.remove(student);
                System.out.println("Sucessfully Deleted  the student");
                hasDelete = true;
                break;
            } else {
                
                System.out.println("No record found ");
                hasDelete = true;
                break;
            }

        }
        if(studentList.size() == 0){
                    System.out.println("No students");
                    hasDelete = false;
                }
        return hasDelete;
    }

    @Override
    public void deleteAllStudent() {

        studentList.clear();
    }

}
