package com.cpprates.test.dataanalysissystem.model;

import java.util.ArrayList;
import java.util.List;

public class Salesperson {
    private String name;
    private String cpf;
    private double salary;
    private List<SalesData> salesDataList;
    private double salesComission;

    public Salesperson(String name, String cpf, double salary) {
        this.name = name;
        this.cpf = cpf;
        this.salary = salary;
        salesDataList = new ArrayList<>();
        salesComission = 0;
    }

    public void addSalesData(SalesData salesData) {
        salesDataList.add(salesData);
        salesComission += salesData.getTotalOfSale();
    }

    public List<SalesData> getSalesDataList() {
        return salesDataList;
    }

    public double getSalesComission() {
        return salesComission;
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

    @Override
    public String toString() {
        return "Salesperson{" +
                "name='" + name + '\'' +
                ", salesComission=" + salesComission +
                '}';
    }
}
