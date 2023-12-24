package com.java.empapp;

public class Employee {

    private int id;
    private String name;
    private double salary;
    private int age;

    public Employee(){

    }

    public Employee(int id, String name, double salary, int age){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    //getters
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
