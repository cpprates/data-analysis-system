package com.cpprates.test.dataanalysissystem.model;

public class Salesperson {
    private final String ID = "001";
    private String name;
    private String cpf;
    private double salary;

    public Salesperson(String name, String cpf, double salary) {
        this.name = name;
        this.cpf = cpf;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getID() {
        return ID;
    }
}
