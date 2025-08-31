package com.company;

public class ExcelGenerator extends Generator {
    @Override
    protected void preparedData() {
        System.out.println("ExcelGenerator: prepare data for EXCEL ...");
    }

    @Override
    protected void generateFile() {
        System.out.println("ExcelGenerator: generate EXCEL file ...");
    }
}
