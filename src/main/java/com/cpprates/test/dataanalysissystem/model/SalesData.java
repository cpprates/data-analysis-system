package com.cpprates.test.dataanalysissystem.model;

public class SalesData {
    private final String id = "003";
    private String saleId;
    private Item item;
    private String salespersonName;

    public SalesData(String saleId, Item item, String salespersonName) {
        this.saleId = saleId;
        this.item = item;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getSalespersonName() {
        return salespersonName;
    }

    public void setSalespersonName(String salespersonName) {
        this.salespersonName = salespersonName;
    }
}
