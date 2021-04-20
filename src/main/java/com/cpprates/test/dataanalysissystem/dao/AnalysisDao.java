package com.cpprates.test.dataanalysissystem.dao;

import com.cpprates.test.dataanalysissystem.model.Customer;
import com.cpprates.test.dataanalysissystem.model.Item;
import com.cpprates.test.dataanalysissystem.model.SalesData;
import com.cpprates.test.dataanalysissystem.model.Salesperson;

import java.util.List;

public class AnalysisDao {
    private List<SalesData> salesDataList;
    private List<Customer> customerList;
    private List<Salesperson> salespersonList;


    public void readFile(String file) {
        // para cada linha do file
        // vai chamar o createObjects para criar os objetos

    }

    public void writeFile() {
        // vai escrever no file novo
        // todas as informações que descobriu

    }

    public void createObjects(String line) {
        String[] separate = line.split("ç");
        switch (separate[0]) {
            case "001":
                Salesperson salesperson = new Salesperson(separate[2], separate[1], Double.parseDouble(separate[3]));
                salespersonList.add(salesperson);
                break;
            case "002":
                Customer customer = new Customer(separate[2], separate[1], separate[3]);
                customerList.add(customer);
                break;
            case "003":
                String trimmed = separate[2].substring(1, separate[2].length() - 1);
                String[] iSep = trimmed.split("-");
                Item item = new Item(iSep[0], Integer.parseInt(iSep[1]), Double.parseDouble(iSep[2]));
                SalesData salesData = new SalesData(separate[1], item, separate[3]);
                salesDataList.add(salesData);
                break;
        }
    }

    public int getTotalOfClients() {
        return customerList.size();
    }

    public int getTotalOfSalesperson() {
        return salespersonList.size();
    }

    public String getIdOfTheMostExpensiveSale() {
        String id = salesDataList.get(0).getSaleId();
        double mostExpensive = salesDataList.get(0).getItem().getPrice();

        for (SalesData sale : salesDataList) {
            if (mostExpensive < sale.getItem().getPrice()) {
                mostExpensive = sale.getItem().getPrice();
                id = sale.getSaleId();
            }
        }
        return id;
    }

    public String worstSalespersonEver() {
        return "IDK what that means but I'll find out";
    }
}
