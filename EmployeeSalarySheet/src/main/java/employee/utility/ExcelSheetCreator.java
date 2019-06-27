package employee.utility;

import employee.models.Employee;
import employee.styling.UtilForStyling;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelSheetCreator {

    public static final String[] monthList = {"JAN", "FEB", "MAr", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

    public static final String[] columnLsit = {"Sr.No.", "Month", "Pay", "D.A", "T.A", "C.A/Other A.", "W.A", "H.R.A.", "N.P.A", "Total From pay to NPA", "P.T", "D.C.P.S", "Pay", "GradePay", "D.A", "T.A", "C.A/Other A.", "W.A", "H.R.A", "N.P.A", "Total From pay to NPA", "P.T", "D.C.P.S", "Pay", "D.A", "T.A", "C.A/Other A.", "WA", "H.R.A", "N.P.A", "Total From pay to NPA", "P.T", "D.C.P.S", "Net Amount"};

    public static final String[] columnLsitFor2019 = {"Sr.No.", "Month", "Pay", "D.A", "T.A", "C.A/Other A.", "W.A", "H.R.A.", "N.P.A", "Total From pay to NPA", "P.T", "D.C.P.S", "Pay", "GradePay", "D.A", "T.A", "C.A/Other A.", "W.A", "H.R.A", "N.P.A", "Total From pay to NPA", "P.T", "D.C.P.S", "Pay", "D.A", "T.A", "C.A/Other A.", "WA", "H.R.A", "N.P.A", "Total From pay to NPA", "P.T", "D.C.P.S", "Net Amt."};

    public static String statementDuration = "";
    public static String statementDuration2019 = "";

    public static void createExcelSheetFromDiffValues(List<Employee> employeeSheetList, boolean dcpsFlag, String nameOfEmployee, int recoveredAmt) throws IOException {


        employeeSheetList = EmplyeeListSplitter.getSplittedList(employeeSheetList);
        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet("2016-2018_salary_Detail");

        XSSFCellStyle xtyleForTextAlignement = UtilForStyling.textAlignmentAtCenter(workbook);
        XSSFCellStyle borderboldStyle = UtilForStyling.setBorderBold1(workbook);
        // 2019 spreadsheet
        int[] AdditionFor2019 = new int[34];
        XSSFSheet spreadsheetFor2019;
        int rowidFor2019 = 1;
        XSSFRow xrowFor2019;
        spreadsheetFor2019 = workbook.createSheet("2019_Salary_Detail");

        Util.setDuratonStatement(employeeSheetList);
        UtilForStyling.setDurationTital(workbook, rowidFor2019, spreadsheetFor2019, statementDuration2019);
        rowidFor2019++;
        // TITAL + COLUMN NAME STYLING FOR 2019
        UtilForStyling.setTitleStyle(workbook, rowidFor2019, spreadsheetFor2019, columnLsitFor2019, true);
        rowidFor2019 = rowidFor2019 + 2;
        xrowFor2019 = spreadsheetFor2019.createRow(rowidFor2019++);
        Cell cellFor2019EMployeeName = xrowFor2019.createCell(0);
        cellFor2019EMployeeName.setCellValue(nameOfEmployee);
        cellFor2019EMployeeName.setCellStyle(UtilForStyling.getStyleForName(workbook));
        for (int i = 1; i <= 33; i++)
            xrowFor2019.createCell(i).setCellStyle(UtilForStyling.getStyleForName(workbook));

        spreadsheetFor2019.addMergedRegion(new CellRangeAddress(4, 4, 0, 33));

        // tita for sheeet before 2019
        int[] Addition = new int[34];
        XSSFRow row;
        int rowid = 1;


        UtilForStyling.setDurationTital(workbook, rowid, spreadsheet, statementDuration);
        rowid++;

        // TITAL + COLUMN NAME STYLING
        UtilForStyling.setTitleStyle(workbook, rowid, spreadsheet, columnLsit, dcpsFlag);
        rowid = rowid + 2;

        row = spreadsheet.createRow(rowid++);
        Cell cellFor2016EMployeeName = row.createCell(0);
        cellFor2016EMployeeName.setCellValue(nameOfEmployee);
        cellFor2016EMployeeName.setCellStyle(UtilForStyling.getStyleForName(workbook));
        for (int i = 1; i <= 33; i++)
            row.createCell(i).setCellStyle(UtilForStyling.getStyleForName(workbook));
        spreadsheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 33));

        // row counter for both sheet
        int rowNumber = 1;
        int rowNumberFor2019 = 1;
        for (Employee employeeSheet : employeeSheetList) {
            int fromMonth = employeeSheet.getFromMonth();
            int fromYear = employeeSheet.getFromYear();
            int toMonth = employeeSheet.getToMonth();
            int toYear = employeeSheet.getToYear();
            int[] data = Util.getEmplyeeDataColumnwise(employeeSheet, columnLsit.length);
            boolean flag = true;   // to coontrol loopfor last month
            for (int i = fromYear; i <= toYear && flag; i++) {
                for (int j = fromMonth; j <= 12; j++) {
                    int admissibleDa = 0;
                    int drwanDa = 0;
                    int diffDa = 0;
                    int drawnDcps = 0;
                    int admissibleDcps = 0;
                    int diffddcps = 0;
                    if (i == 2019) {
                        xrowFor2019 = spreadsheetFor2019.createRow(rowidFor2019++);
                        for (int k = 0; k < columnLsit.length; k++) {

                            Cell cell = xrowFor2019.createCell(k);
                            cell.setCellStyle(xtyleForTextAlignement);
                            if (k == columnLsit.length - 1) {
                                cell.setCellStyle(borderboldStyle);
                            }

                            if (k == 0) {
                                cell.setCellValue(rowNumberFor2019++);
                                AdditionFor2019[k] = rowNumberFor2019;
                            } else if (k == 1)     // month
                            {
                                if (employeeSheet.isMonthFlag()) {
                                    String fmonthDay = employeeSheet.getFromDay() < 10 ? "0" + employeeSheet.getFromDay() : "" + employeeSheet.getFromDay();
                                    String Tmonth = employeeSheet.getToDay() < 10 ? "0" + employeeSheet.getToDay() : "" + employeeSheet.getToDay();
                                    cell.setCellValue(fmonthDay + " - " + Tmonth + "  " + monthList[j - 1] + "-" + i % 100);
                                } else {
                                    cell.setCellValue(monthList[j - 1] + "-" + i % 100);
                                }
                            } else {
                                if (k == 10 || k == 21) //proffessional tax logic   (|| k==31) -- REMOVED TO MAKE DIFFRENCE OF PT 0
                                {
                                    if (j == 2)     //feb
                                    {
                                        cell.setCellValue(300);
                                        AdditionFor2019[k] = 300 + AdditionFor2019[k];    /// Addition of Amounts
                                    } else {
                                        AdditionFor2019[k] = 200 + AdditionFor2019[k];    /// Addition of Amounts
                                        cell.setCellValue(200);
                                    }
                                } else if (k == 3)  // admssble da
                                {
                                    admissibleDa = Util.getAdmissibeDA(data[2], i, j);
                                    AdditionFor2019[k] = admissibleDa + AdditionFor2019[k];    /// Addition of Amounts
                                    cell.setCellValue(admissibleDa); //i year and j month
                                } else if (k == 14)    // Drawn Da
                                {
                                    drwanDa = Util.getDrawnDa(data[12] + data[13], i, j);
                                    AdditionFor2019[k] = drwanDa + AdditionFor2019[k];    /// Addition of Amounts
                                    cell.setCellValue(drwanDa); //i year and j month
                                } else if (k == 24)   // difference da
                                {
                                    diffDa = admissibleDa - drwanDa;
                                    AdditionFor2019[k] = diffDa + AdditionFor2019[k];    /// Addition of Amounts
                                    cell.setCellValue(diffDa);
                                } else if (k == 9)  // add da in admssibbe total
                                {
                                    cell.setCellValue(data[k] + admissibleDa);
                                    AdditionFor2019[k] = data[k] + admissibleDa + AdditionFor2019[k];    /// Addition of Amounts

                                } else if (k == 20)   //add da + dcps in drawn total
                                {
                                    cell.setCellValue(data[k] + drwanDa);
                                    AdditionFor2019[k] = data[k] + drwanDa + AdditionFor2019[k];    /// Addition of Amounts

                                } else if (k == 30)    //add da + dcps in diff total
                                {
                                    cell.setCellValue(data[k] + diffDa);
                                    AdditionFor2019[k] = data[k] + diffDa + AdditionFor2019[k];    /// Addition of Amounts

                                } else if (k == 33) {
                                    cell.setCellValue(data[k] + diffDa - diffddcps);
                                    AdditionFor2019[k] = data[k] + diffDa - diffddcps + AdditionFor2019[k];    /// Addition of Amounts
                                } else if (k == 11)   //calculate admissibble dcps
                                {
                                    admissibleDcps = dcpsFlag ? (int) Math.round((data[2] + admissibleDa) * 10 / 100.0) : 0;
                                    AdditionFor2019[k] = admissibleDcps + AdditionFor2019[k];    /// Addition of Amounts
                                    cell.setCellValue(admissibleDcps);
                                } else if (k == 22)   //calculate drwan dcps
                                {
                                    drawnDcps = dcpsFlag ? (int) Math.round((data[12] + data[13] + drwanDa) * 10 / 100.0) : 0;
                                    AdditionFor2019[k] = drawnDcps + AdditionFor2019[k];    /// Addition of Amounts
                                    cell.setCellValue(drawnDcps);
                                } else if (k == 32)   //diff dcps
                                {
                                    diffddcps = admissibleDcps - drawnDcps;
                                    AdditionFor2019[k] = diffddcps + AdditionFor2019[k];    /// Addition of Amounts
                                    cell.setCellValue(diffddcps);
                                } else {
                                    cell.setCellValue(data[k]);
                                    AdditionFor2019[k] = data[k] + AdditionFor2019[k];    /// Addition of Amounts
                                }
                            }

                        }

                    } else {
                        row = spreadsheet.createRow(rowid++);
                        for (int k = 0; k < columnLsit.length; k++) {

                            Cell cell = row.createCell(k);
                            cell.setCellStyle(xtyleForTextAlignement);
                            if (k == columnLsit.length - 1) {
                                cell.setCellStyle(borderboldStyle);
                            }
                            if (k == 0) {
                                cell.setCellValue(rowNumber++);
                                AdditionFor2019[k] = rowNumber;
                            } else if (k == 1)     // month
                            {
                                if (employeeSheet.isMonthFlag()) {
                                    String fmonthDay = employeeSheet.getFromDay() < 10 ? "0" + employeeSheet.getFromDay() : "" + employeeSheet.getFromDay();
                                    String Tmonth = employeeSheet.getToDay() < 10 ? "0" + employeeSheet.getToDay() : "" + employeeSheet.getToDay();
                                    cell.setCellValue(fmonthDay + " - " + Tmonth + "  " + monthList[j - 1] + "-" + i % 100);
                                } else {
                                    cell.setCellValue(monthList[j - 1] + "-" + i % 100);
                                }
                            } else {
                                if (k == 10 || k == 21) //proffessional tax logic
                                {
                                    if (j == 2)     //feb
                                    {
                                        cell.setCellValue(300);
                                        Addition[k] = 300 + Addition[k];    /// Addition of Amounts
                                    } else {
                                        Addition[k] = 200 + Addition[k];    /// Addition of Amounts
                                        cell.setCellValue(200);
                                    }
                                } else if (k == 3)  // admssble da
                                {
                                    admissibleDa = Util.getAdmissibeDA(data[2], i, j);
                                    Addition[k] = admissibleDa + Addition[k];    /// Addition of Amounts
                                    cell.setCellValue(admissibleDa); //i year and j month
                                } else if (k == 14)    // Drawn Da
                                {
                                    drwanDa = Util.getDrawnDa(data[12] + data[13], i, j);
                                    Addition[k] = drwanDa + Addition[k];    /// Addition of Amounts
                                    cell.setCellValue(drwanDa); //i year and j month
                                } else if (k == 24)   // difference da
                                {
                                    diffDa = admissibleDa - drwanDa;
                                    Addition[k] = diffDa + Addition[k];    /// Addition of Amounts
                                    cell.setCellValue(diffDa);
                                } else if (k == 9)  // add da in admssible total
                                {
                                    cell.setCellValue(data[k] + admissibleDa);
                                    Addition[k] = data[k] + admissibleDa + Addition[k];    /// Addition of Amounts

                                } else if (k == 20)   //add da in drawn total
                                {
                                    cell.setCellValue(data[k] + drwanDa);
                                    Addition[k] = data[k] + drwanDa + Addition[k];    /// Addition of Amounts

                                } else if (k == 30)    //add da  in diff total
                                {
                                    cell.setCellValue(data[k] + diffDa);
                                    Addition[k] = data[k] + diffDa + Addition[k];    /// Addition of Amounts

                                } else if (k == 33)      /// net ammunt equall to  basic to napay additon - dcps
                                {
                                    cell.setCellValue(data[k] + diffDa - diffddcps);
                                    Addition[k] = data[k] + diffDa - diffddcps + Addition[k];    /// Addition of Amounts
                                } else if (k == 11)   //calculate admissibble dcps
                                {
                                    admissibleDcps = dcpsFlag ? (int) Math.round((data[2] + admissibleDa) * 10 / 100.0) : 0;
                                    Addition[k] = admissibleDcps + Addition[k];    /// Addition of Amounts
                                    cell.setCellValue(admissibleDcps);
                                } else if (k == 22)   //calculate drwan dcps
                                {
                                    drawnDcps = dcpsFlag ? (int) Math.round((data[12] + data[13] + drwanDa) * 10 / 100.0) : 0;
                                    Addition[k] = drawnDcps + Addition[k];    /// Addition of Amounts
                                    cell.setCellValue(drawnDcps);
                                } else if (k == 32)   //diff dcps
                                {
                                    diffddcps = admissibleDcps - drawnDcps;
                                    Addition[k] = diffddcps + Addition[k];    /// Addition of Amounts
                                    cell.setCellValue(diffddcps);
                                } else {
                                    cell.setCellValue(data[k]);
                                    Addition[k] = data[k] + Addition[k];    /// Addition of Amounts
                                }
                            }

                        }

                    }
                    if (j == toMonth && i == toYear) {
                        flag = false;
                        break;
                    }

                }
                fromMonth = 1;
            }
        }

        // SPREADSHEET FROM 2016-18
        UtilForStyling.setColumnWidth(spreadsheet);

        // SPREADSHEET FOR 2019
        UtilForStyling.setColumnWidth(spreadsheetFor2019);


        //FOR TOTAL ROW BEFORE 2018
        UtilForStyling.setTotalRowStyle(workbook, spreadsheet, rowid++, Addition, rowNumber);

        //FOR TOTAL ROW BEFORE 2019
        UtilForStyling.setTotalRowStyle(workbook, spreadsheetFor2019, rowidFor2019, AdditionFor2019, rowNumberFor2019);


        UtilForStyling.setInstallments1(workbook, spreadsheet, Addition, recoveredAmt,dcpsFlag);
        //Write the workbook in file system


        spreadsheet.setColumnWidth(34,350); // to set the minimum gap between main table and right side small table

        // auto column width
        for (int i = 0; i < 39; i++) {
            spreadsheet.autoSizeColumn(i);
            spreadsheetFor2019.autoSizeColumn(i);
        }

        FileOutputStream out = new FileOutputStream(new File(nameOfEmployee + ".xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("Writesheet.xlsx written successfully");

    }


}