package com.company;

public class CsvGenerator extends Generator {
    @Override
    protected void preparedData() {
        System.out.println("CsvGenerator: prepare data for CSV ...");
    }

    @Override
    protected void generateFile() {
        System.out.println("CsvGenerator: generate CSV file ...");
    }
}
