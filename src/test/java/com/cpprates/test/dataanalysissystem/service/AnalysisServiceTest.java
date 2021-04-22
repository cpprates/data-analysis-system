package com.cpprates.test.dataanalysissystem.service;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnalysisServiceTest {

    private AnalysisService analysisService = new AnalysisService();

    @Test
    public void shouldReadFile() {
        assertTrue(analysisService.readFile("flat_file_name.dat"));
    }

    @Test
    public void shouldGetTotalOfClients() {
        shouldReadFile();
        assertEquals(2, analysisService.getTotalOfCLients());
    }

    @Test
    public void shouldGetTotalOfSalesPerson() {
        shouldReadFile();
        assertEquals(2, analysisService.getTotalOfSalesPerson());
    }

    @Test
    public void shouldGetIdOfTheMostExpensiveSale() {
        shouldReadFile();
        assertEquals("10", analysisService.getIdOfTheMostExpensiveSale());
    }

    @Test
    public void shouldGetWorstSalespersonEver() {
        shouldReadFile();
        assertEquals("08", analysisService.getWorstSalespersonEver());
    }

    @Test
    void shouldCreateNewFile() {
        shouldReadFile();
        analysisService.writeFile();
    }
}