package org.main;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Main {
    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream("src\\main\\resources\\Q1.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);

        System.out.printf("%-20s%-20s%-20s%-30s%-20s%n", "Benefit", "Coverage", "Category", "Plan Name", "Coverage Value");
        System.out.println("============================================================================================================================");


        String benefit = "",coverage = "",category = "",planName = "",coverageValue = "";

        Plan plan = new Plan(benefit, coverage, category, planName, coverageValue);

        int planNum = (sheet.getRow(0).getPhysicalNumberOfCells()-4);

        for (int n = 1; n <= planNum; n++) {

            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

                Row row = sheet.getRow(i);

                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {

                    Cell cell = row.getCell(j);

                    if (row.getRowNum() != 0) {
                        if (j == 0) {
                            if (row.getPhysicalNumberOfCells() == 1) {
                                plan.setBenefit(cell.getStringCellValue() + ", ");
                            }
                            if (row.getPhysicalNumberOfCells() != 1) {
                                plan.setCoverage(cell.getStringCellValue() + ", ");
                            }
                        }

                        if (j == 1 && cell != null) {
                            plan.setCategory(cell.getStringCellValue() + ", ");
                        }
                    }

                    Cell planCell = sheet.getRow(0).getCell(j);

                    if ((j-4) == n && cell != null) {

                        plan.setPlanName(planCell.getStringCellValue()+", ");

                        if (cell.getCellType() == CellType.STRING) {
                            plan.setCoverageValue(cell.getStringCellValue());
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            plan.setCoverageValue(Double.toString(cell.getNumericCellValue()));
                        }

                    }
                }
                if (i > 1 && row.getPhysicalNumberOfCells() != 1) {
                    System.out.println(plan);
                }
            }
        }

        file.close();

    }
}
