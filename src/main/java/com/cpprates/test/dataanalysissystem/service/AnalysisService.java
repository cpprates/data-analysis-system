package com.cpprates.test.dataanalysissystem.service;

import com.cpprates.test.dataanalysissystem.dao.AnalysisDao;

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

    public String worstSalespersonEver() {
        return analysisDao.worstSalespersonEver();
    }

}
