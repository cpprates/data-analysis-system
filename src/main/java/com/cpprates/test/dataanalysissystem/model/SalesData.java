package com.cpprates.test.dataanalysissystem.model;

import java.util.List;

public class SalesData {
    private final String id = "003";
    private String saleId;
    private List<Item> itemList;
    private String salespersonName;

    public SalesData(String saleId, List<Item> itemList, String salespersonName) {
        this.saleId = saleId;
        this.itemList = itemList;
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

    public List<Item> getItems() {
        return itemList;
    }

    public void setItem(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String getSalespersonName() {
        return salespersonName;
    }

    public void setSalespersonName(String salespersonName) {
        this.salespersonName = salespersonName;
    }

    public double getTotalOfSale() {
        double total = 0;

        for (Item i : itemList) {
            total += i.getPrice() * i.getQuantity();
        }

        return total;
    }
}
