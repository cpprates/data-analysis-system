package com.cpprates.test.dataanalysissystem.dao;

import com.cpprates.test.dataanalysissystem.model.Customer;
import com.cpprates.test.dataanalysissystem.model.Item;
import com.cpprates.test.dataanalysissystem.model.SalesData;
import com.cpprates.test.dataanalysissystem.model.Salesperson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnalysisDao {
    private List<SalesData> salesDataList;
    private List<Customer> customerList;
    private List<Salesperson> salespersonList;
    private List<Item> itemList;
    private String fileName;

    public AnalysisDao() {
        salesDataList = new ArrayList<>();
        customerList = new ArrayList<>();
        salespersonList = new ArrayList<>();
        itemList = new ArrayList<>();
    }

    public boolean readFile(String fileName) {
        this.fileName = fileName;
        try {
            File f = new File("./src/main/java/data/in/" + fileName);
            Scanner reader = new Scanner(f);
            while (reader.hasNextLine()) {
                createObjects(reader.nextLine());
            }
            reader.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    public void writeFile() throws IOException {
        File f = new File("./src/main/java/data/out/" + fileName.replace(".dat",".done.dat"));
        FileWriter fw = new FileWriter(f);

        fw.write("Total quantity of clients in the input file: " + getTotalOfClients());
        fw.write("\n");
        fw.write("Total quantity of salesperson in the input file: " + getTotalOfSalesperson());
        fw.write("\n");
        fw.write("ID of the most expensive sale: " + getIdOfTheMostExpensiveSale());
        fw.write("\n");
        fw.write("Worst salesperson ever: " + getWorstSalespersonEver());
        fw.close();
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
                if (trimmed.contains(",")) {
                    String[] itemsString = trimmed.split(",");
                    for (String i : itemsString) {
                        String[] iSep = i.split("-");
                        Item item = new Item(iSep[0], Integer.parseInt(iSep[1]), Double.parseDouble(iSep[2]));
                        itemList.add(item);
                    }
                } else {
                    String[] iSep = trimmed.split("-");
                    Item item = new Item(iSep[0], Integer.parseInt(iSep[1]), Double.parseDouble(iSep[2]));
                    itemList.add(item);
                }
                SalesData salesData = new SalesData(separate[1], itemList, separate[3]);

                for (Salesperson sp : salespersonList) {
                    if (separate[3].equalsIgnoreCase(sp.getName())) {
                        sp.addSalesData(salesData);
                    }
                }

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
        String id = "";
        double mostExpensive = 0;

        for (SalesData sale : salesDataList) {
            if (mostExpensive < sale.getTotalOfSale()) {
                mostExpensive = sale.getTotalOfSale();
                id = sale.getSaleId();
            }
        }
        return id;
    }

    public String getWorstSalespersonEver() {
        double minComission = 0;
        Salesperson worstSalesperson = null;
        for (Salesperson sp : salespersonList) {
            minComission = sp.getSalesComission();
            worstSalesperson = sp;
            if (sp.getSalesComission() < minComission) {
                minComission = sp.getSalesComission();
                worstSalesperson = sp;
            }
        }
        return worstSalesperson.toString();
    }
}
