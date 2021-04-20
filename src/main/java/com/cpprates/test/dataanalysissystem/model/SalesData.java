package com.cpprates.test.dataanalysissystem.model;

public class SalesData {
    private final String id = "003";
    private String saleId;
    private String info;
    private String salespersonName;

    public SalesData(String saleId, String info, String salespersonName) {
        this.saleId = saleId;
        this.info = info;
        this.salespersonName = salespersonName;
    }

    public String getId() {
        return id;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSalespersonName() {
        return salespersonName;
    }

    public void setSalespersonName(String salespersonName) {
        this.salespersonName = salespersonName;
    }
}
