package com.cpprates.test.dataanalysissystem.service;

import com.cpprates.test.dataanalysissystem.dao.AnalysisDao;

import java.io.IOException;

public class AnalysisService {

    private AnalysisDao analysisDao = new AnalysisDao();

    public int getTotalOfCLients() {
        return analysisDao.getTotalOfClients();
    }

    public int getTotalOfSalesPerson() {
        return analysisDao.getTotalOfSalesperson();
    }

    public String getIdOfTheMostExpensiveSale() {
        return analysisDao.getIdOfTheMostExpensiveSale();
    }

    public String getWorstSalespersonEver() {
        return analysisDao.getWorstSalespersonEver();
    }

    public boolean readFile(String file) {
        return analysisDao.readFile(file);
    }

    public void writeFile() {
        try {
            analysisDao.writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
