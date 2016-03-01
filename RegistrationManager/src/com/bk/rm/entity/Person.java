/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bk.rm.entity;

/**
 *
 * @author bkawan
 * @date Feb 28, 2016
 * @time 12:50:19 PM
 */
public abstract class Person {

    
    protected int id;
    protected String firstName, LastName, email, phoneNo, address, personType;


    public Person() {

    }

    public Person(int id, String firstName, String LastName, String email, String phoneNo, String address) {
        this.id = id;
        this.firstName = firstName;
        this.LastName = LastName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address;
  
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getPersonType() {
        return personType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", LastName=" + LastName + ", email=" + email + ", phoneNo=" + phoneNo + ", address=" + address + ", personType=" + personType + '}';
    }

    public void personDetails() {
        System.out.println("++++ [" + personType + "] ++++");
        System.out.println("ID: " + getId());
        System.out.println("Full Name: " + getFirstName()
                + " " + getLastName() + ".");
        System.out.println("Email Address: " + getEmail());
        System.out.println("Phone Number: " + getPhoneNo());
        System.out.println("Address: " + getAddress());
       
        System.out.println("---------------------------");

    }
}
