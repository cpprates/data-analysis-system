package com.cpprates.test.dataanalysissystem.model;

public class Customer {
    private final String ID = "002";
    private String name;
    private String cnpj;
    private String businessArea;

    public Customer(String name, String cnpj, String businessArea) {
        this.name = name;
        this.cnpj = cnpj;
        this.businessArea = businessArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getID() {
        return ID;
    }
}
