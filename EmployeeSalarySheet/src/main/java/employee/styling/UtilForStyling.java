package employee.styling;

import employee.utility.Util;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

/**
 * Created with IntelliJ IDEA.
 * User: Bkendre
 * Date: 4/2/19
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class UtilForStyling {

    public static final int fontHeight = 9;
    public static final String[] allowances = {"Admissible pay and allowances", "Drawn pay and allowances", "Difference"};

    public static XSSFCellStyle getStyleForTital(XSSFWorkbook workbook, boolean flag) {
        XSSFCellStyle style1 = getStyle(workbook);
        if (flag) {
            style1.setBorderRight(BorderStyle.MEDIUM);
            style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
            style1.setBorderLeft(BorderStyle.MEDIUM);
            style1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            style1.setBorderTop(BorderStyle.MEDIUM);
            style1.setTopBorderColor(IndexedColors.BLACK.getIndex());
            style1.setBorderBottom(BorderStyle.MEDIUM);
            style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        }
        style1.setRotation((short) 90);
        return style1;

    }

    public static XSSFCellStyle getStyleForAdmiDrwanDifff(XSSFWorkbook workbook, int couunter) {
        XSSFCellStyle xssfCellStyle = getStyle(workbook);

        xssfCellStyle.setFillBackgroundColor(couunter == 1 ? IndexedColors.RED.getIndex() : couunter == 2 ? IndexedColors.BRIGHT_GREEN.getIndex() : IndexedColors.LIGHT_YELLOW.getIndex());
        xssfCellStyle.setFillPattern(CellStyle.LEAST_DOTS);
        XSSFFont font = workbook.createFont();
        font.setItalic(false);
        font.setColor(HSSFColor.BLACK.index);
        font.setBold(true);
        font.setBoldweight((short) 30);
        font.setFontHeight(fontHeight);
        xssfCellStyle.setFont(font);
        return xssfCellStyle;
        // style1.setFillBackgroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
        //style1.setFillPattern(CellStyle.LEAST_DOTS);

    }


    public static XSSFCellStyle getStyleForTotalRow(XSSFWorkbook workbook) {
        XSSFCellStyle style1;
        style1 = workbook.createCellStyle();
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setWrapText(true);
        style1.setBorderRight(BorderStyle.MEDIUM);
        style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderLeft(BorderStyle.MEDIUM);
        style1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderTop(BorderStyle.MEDIUM);
        style1.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderBottom(BorderStyle.MEDIUM);
        style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        XSSFFont font = workbook.createFont();
        font.setItalic(false);
        font.setColor(HSSFColor.BLACK.index);
        font.setBold(true);
        font.setBoldweight((short) 1);
        font.setFontHeight(fontHeight);
        style1.setFont(font);

        return style1;
    }

    public static XSSFCellStyle textAlignmentAtCenter(XSSFWorkbook workbook) {
        XSSFCellStyle style1 = getStyle(workbook);
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setWrapText(true);
        XSSFFont font = workbook.createFont();
        font.setFontHeight(fontHeight);
        style1.setFont(font);
        return style1;
    }

    public static XSSFCellStyle setBorderBold(XSSFWorkbook workbook, int flag) {
        XSSFCellStyle style1 = getStyle(workbook);
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setWrapText(true);
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setWrapText(true);
        style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderRight(BorderStyle.MEDIUM);
        style1.setBorderLeft(BorderStyle.MEDIUM);
        style1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style1.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        if (flag == 1) {
            style1.setBorderTop(BorderStyle.MEDIUM);
            style1.setBorderBottom(BorderStyle.NONE);

        } else if (flag == 2) {
            style1.setBorderTop(BorderStyle.NONE);
            style1.setBorderBottom(BorderStyle.THICK);
        } else {
            style1.setBorderTop(BorderStyle.NONE);
            style1.setBorderBottom(BorderStyle.NONE);
        }
        XSSFFont font = workbook.createFont();
        font.setFontHeight(fontHeight);
        style1.setFont(font);
        return style1;
    }


    public static XSSFCellStyle setBorderBold1(XSSFWorkbook workbook) {
        XSSFCellStyle style1 = getStyle(workbook);
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setWrapText(true);
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setWrapText(true);
        style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderRight(BorderStyle.MEDIUM);
        style1.setBorderLeft(BorderStyle.MEDIUM);
        style1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style1.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        style1.setBorderTop(BorderStyle.MEDIUM);
        style1.setBorderBottom(BorderStyle.MEDIUM);

        XSSFFont font = workbook.createFont();
        font.setFontHeight(fontHeight);
        style1.setFont(font);
        return style1;
    }

    public static XSSFCellStyle getStyle(XSSFWorkbook workbook) {
        XSSFCellStyle style1;
        style1 = workbook.createCellStyle();
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setWrapText(true);
        style1.setBorderRight(BorderStyle.THIN);
        style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderLeft(BorderStyle.THIN);
        style1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderTop(BorderStyle.THIN);
        style1.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderBottom(BorderStyle.THIN);
        style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        XSSFFont font = workbook.createFont();
        font.setItalic(false);
        font.setColor(HSSFColor.BLACK.index);
        font.setBold(true);
        font.setBoldweight((short) 1);
        font.setFontHeight(fontHeight);
        style1.setFont(font);

        return style1;
    }

    public static XSSFCellStyle getStyleForName(XSSFWorkbook workbook) {
        XSSFCellStyle style1;
        style1 = workbook.createCellStyle();
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setWrapText(true);
        style1.setBorderRight(BorderStyle.MEDIUM);
        style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderLeft(BorderStyle.MEDIUM);
        style1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderTop(BorderStyle.MEDIUM);
        style1.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderBottom(BorderStyle.MEDIUM);
        style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        XSSFFont font = workbook.createFont();
        font.setItalic(false);
        font.setColor(HSSFColor.BLACK.index);
        font.setBold(true);
        font.setBoldweight((short) 1);
        font.setFontHeight(fontHeight);
        style1.setFont(font);

        return style1;
    }

    public static void setTotalRowStyle(XSSFWorkbook workbook, XSSFSheet spreadsheet, int rowid, int[] Addition, int rowNumber) {
        // STYLE FOR TOTAL ROW
        XSSFCellStyle styleForTotalRow = UtilForStyling.getStyleForTotalRow(workbook);

        // for 2016 to 2018 total
        XSSFRow row = spreadsheet.createRow(rowid++);
        for (int cellIdforTotal = 0; cellIdforTotal < Addition.length; cellIdforTotal++) {
            Cell cellForTaoatl = row.createCell(cellIdforTotal);
            cellForTaoatl.setCellStyle(styleForTotalRow);
            if (cellIdforTotal == 1) {
                cellForTaoatl.setCellValue("Total");
            } else if (cellIdforTotal == 0) {
                cellForTaoatl.setCellValue(rowNumber);
            } else {
                cellForTaoatl.setCellValue(Addition[cellIdforTotal]);
            }


        }
    }


    //COMMON METHOD FOR BOTH SHEET
    public static void setTitleStyle(XSSFWorkbook workbook, int rowidFor2019, XSSFSheet spreadsheetFor2019, String[] columnLsit, boolean dcpsFlag) {
        // tital for 2019 sheet ++ style
        XSSFCellStyle admissibleStyle = UtilForStyling.getStyleForAdmiDrwanDifff(workbook, 1);
        XSSFRow xrowFor2019 = spreadsheetFor2019.createRow(rowidFor2019++);
        Cell cellForAdmissibleFor2019 = xrowFor2019.createCell(2);
        cellForAdmissibleFor2019.setCellValue(allowances[0]);
        cellForAdmissibleFor2019.setCellStyle(admissibleStyle);
        for (int i = 3; i <= 11; i++)
            xrowFor2019.createCell(i).setCellStyle(admissibleStyle);
        spreadsheetFor2019.addMergedRegion(new CellRangeAddress(2, 2, 2, 11));


        XSSFCellStyle drawnStyle = UtilForStyling.getStyleForAdmiDrwanDifff(workbook, 2);
        Cell cellFordrawnFor2019 = xrowFor2019.createCell(12);
        cellFordrawnFor2019.setCellValue(allowances[1]);
        cellFordrawnFor2019.setCellStyle(drawnStyle);
        for (int i = 13; i <= 22; i++)
            xrowFor2019.createCell(i).setCellStyle(drawnStyle);
        spreadsheetFor2019.addMergedRegion(new CellRangeAddress(2, 2, 12, 22));

        XSSFCellStyle diffStyle = UtilForStyling.getStyleForAdmiDrwanDifff(workbook, 3);
        Cell cellFordiiffFor2019 = xrowFor2019.createCell(23);
        cellFordiiffFor2019.setCellValue(allowances[2]);
        cellFordiiffFor2019.setCellStyle(diffStyle);
        for (int i = 24; i <= 32; i++)
            xrowFor2019.createCell(i).setCellStyle(diffStyle);
        spreadsheetFor2019.addMergedRegion(new CellRangeAddress(2, 2, 23, 32));

        xrowFor2019 = spreadsheetFor2019.createRow(rowidFor2019++);
        int cellidFor2019 = 0;

        // STYLE FOR COLUMN NAME
        XSSFCellStyle style1 = UtilForStyling.getStyleForTital(workbook, false);
        XSSFCellStyle styleForBoldBorder = UtilForStyling.getStyleForTital(workbook, true);

        int counter = 0;
        for (String columnName : columnLsit) {
            Cell cell = xrowFor2019.createCell(cellidFor2019++);
            cell.setCellValue(columnName);
            cell.setCellStyle(style1);

            if (counter == columnLsit.length - 1) {
                cell.setCellStyle(styleForBoldBorder);
                if(!dcpsFlag)
                cell.setCellValue("Credit to G.P.F ACC");
            }


            counter++;
        }

    }


    public static void setEmployeeName(XSSFSheet spreadsheetFor2019, int rowidFor2019, String nameOfEmployee, XSSFWorkbook workbook) {
        XSSFCellStyle styleForName = getStyle(workbook);
        styleForName.getFont().setBoldweight((short) 50);
        XSSFRow xrowFor2019 = spreadsheetFor2019.createRow(rowidFor2019++);
        Cell cellFor2019EMployeeName = xrowFor2019.createCell(1);
        cellFor2019EMployeeName.setCellValue(nameOfEmployee);
        cellFor2019EMployeeName.setCellStyle(styleForName);
        spreadsheetFor2019.addMergedRegion(new CellRangeAddress(3, 3, 2, 34));

    }

    public static void setDurationTital(XSSFWorkbook workbook, int rowidFor2019, XSSFSheet spreadsheetFor2019, String statement) {
        // tital for 2019 sheet ++ style
        XSSFCellStyle admissibleStyle = UtilForStyling.getStyle(workbook);

        XSSFRow xrowFor2019 = spreadsheetFor2019.createRow(rowidFor2019++);
        Cell cellForAdmissibleFor2019 = xrowFor2019.createCell(2);
        cellForAdmissibleFor2019.setCellValue(statement);
        cellForAdmissibleFor2019.setCellStyle(admissibleStyle);
        for (int i = 3; i <= 32; i++)
            xrowFor2019.createCell(i).setCellStyle(admissibleStyle);
        spreadsheetFor2019.addMergedRegion(new CellRangeAddress(1, 1, 2, 32));
    }


    public static void setColumnWidth(XSSFSheet spreadsheet) {


        for (int i = 8; i <= 34; i++) {
            spreadsheet.setColumnWidth(i, 1700);
        }

        spreadsheet.setColumnWidth(0, 670);
        spreadsheet.setColumnWidth(1, 1730);
        spreadsheet.setColumnWidth(2, 1730);
        spreadsheet.setColumnWidth(3, 1550);
        spreadsheet.setColumnWidth(4, 1450);
        spreadsheet.setColumnWidth(5, 1300);
        spreadsheet.setColumnWidth(6, 1050);
        spreadsheet.setColumnWidth(7, 1550);

        spreadsheet.setColumnWidth(12, 1750);
        spreadsheet.setColumnWidth(14, 1750);
        spreadsheet.setColumnWidth(15, 1350);
        spreadsheet.setColumnWidth(16, 1300);
        spreadsheet.setColumnWidth(17, 1050);
        spreadsheet.setColumnWidth(18, 1350);
        spreadsheet.setColumnWidth(23, 1750);

        spreadsheet.setColumnWidth(25, 470);
        spreadsheet.setColumnWidth(26, 470);
        spreadsheet.setColumnWidth(27, 470);

        spreadsheet.setColumnWidth(30, 1750);
        spreadsheet.setColumnWidth(31, 470);
        spreadsheet.setColumnWidth(33, 1750);
        spreadsheet.setColumnWidth(32, 1680);
        spreadsheet.setColumnWidth(9, 1900);

        spreadsheet.setColumnWidth(20, 1900);
        spreadsheet.setColumnWidth(24, 1850);
        spreadsheet.setColumnWidth(10, 1200);
        spreadsheet.setColumnWidth(21, 1200);

    }

    public static void setInstallments1(XSSFWorkbook workbook, XSSFSheet spreadsheet, int[] additionArray, int recoveryAmt,boolean dcpsFlag) {

        int payToNPA = additionArray[additionArray.length - 4];
        int dcpsTotal = additionArray[additionArray.length - 2];
        int netAmount = additionArray[additionArray.length - 1] - recoveryAmt;
        int[] installments = Util.getInstallmentAmount(netAmount);

        int totalBPArrear=dcpsTotal;
        for(int temp:installments)
            totalBPArrear+=temp;


        //  --------------Note ------------------------------
        int rowId = 5;
        XSSFCellStyle upper = setBorderBold(workbook, 1);
        XSSFCellStyle inner = setBorderBold(workbook, 3);
        XSSFCellStyle lower = setBorderBold(workbook, 2);
        XSSFRow xrowFor2019 = spreadsheet.getRow(rowId);
        Cell installment2019 = xrowFor2019.createCell(35);
        installment2019.setCellValue("Note :-");
        installment2019.setCellStyle(upper);
        for (int i = 36; i <= 38; i++)
            xrowFor2019.createCell(i).setCellStyle(upper);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId, rowId, 35, 38));

        //---------------------Basic Pay-----------------------------------
        rowId++;  // INCREASE ROW
        XSSFRow recoveryRow = spreadsheet.getRow(rowId);
        Cell recoveryCell = recoveryRow.createCell(35);
        recoveryCell.setCellValue("B.P Arrear Amt. = " + payToNPA);
        recoveryCell.setCellStyle(inner);
        for (int i = 36; i <= 38; i++)
            recoveryRow.createCell(i).setCellStyle(inner);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId, rowId, 35, 38));


        // ----------------------- Recovery Amt-----------------------------------------

        rowId++;  // INCREASE ROW
        XSSFRow netPayble = spreadsheet.getRow(rowId);
        Cell netInstCell = netPayble.createCell(35);
        netInstCell.setCellValue("Recovery Amt. = " + recoveryAmt);
        netInstCell.setCellStyle(inner);
        for (int i = 36; i <= 38; i++)
            netPayble.createCell(i).setCellStyle(inner);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId, rowId, 35, 38));


        // ----------------------- DCPS-----------------------------------------

        rowId++;  // INCREASE ROW
        XSSFRow firstInstRow = spreadsheet.getRow(rowId);
        Cell firstInstCell = firstInstRow.createCell(35);
        firstInstCell.setCellValue("D.C.P.S. Arrear = " + dcpsTotal);
        firstInstCell.setCellStyle(inner);
        for (int i = 36; i <= 38; i++)
            firstInstRow.createCell(i).setCellStyle(inner);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId, rowId, 35, 38));

        // ----------------------- NET AMT-----------------------------------------

        rowId++;  // INCREASE ROW
        XSSFRow secondInstRow = spreadsheet.getRow(rowId);
        Cell secondtInstCell = secondInstRow.createCell(35);
        if(dcpsFlag){
            secondtInstCell.setCellValue("Net Amt = " + netAmount);
        }else{
            secondtInstCell.setCellValue("Credit to G.P.F ACC = " + netAmount);
        }

        secondtInstCell.setCellStyle(inner);
        for (int i = 36; i <= 38; i++)
            secondInstRow.createCell(i).setCellStyle(inner);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId, rowId, 35, 38));


        // ----------------------- Net Amount Division-----------------------------------------

        rowId++;  // INCREASE ROW
        XSSFRow thirdInstRow = spreadsheet.getRow(rowId);
        Cell thirdInstCell = thirdInstRow.createCell(35);
        if(dcpsFlag) {
            thirdInstCell.setCellValue("Hence, Net Amt = " + netAmount + "/5");
        }else{
            thirdInstCell.setCellValue("Hence, Credit to G.P.F ACC = " + netAmount + "/5");
        }
        thirdInstCell.setCellStyle(lower);
        for (int i = 36; i <= 38; i++)
            thirdInstRow.createCell(i).setCellStyle(lower);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId, rowId, 35, 38));


        // Table Header part
        XSSFCellStyle headerStyle = getStyleForTotalRow(workbook);
        headerStyle.setWrapText(false);
        rowId++;  // INCREASE ROW
        XSSFRow heaer = spreadsheet.getRow(rowId);
        Cell headerCellFirst = heaer.createCell(35);
        headerCellFirst.setCellValue("Insta. No.");
        headerCellFirst.setCellStyle(headerStyle);

        Cell headerCellSecond = heaer.createCell(36);
        headerCellSecond.setCellValue("B.P. Arr.");
        headerCellSecond.setCellStyle(headerStyle);

        Cell headerCellThird = heaer.createCell(37);
        headerCellThird.setCellValue("DCPS P. Arr.");
        headerCellThird.setCellStyle(headerStyle);

        Cell headerCellForth = heaer.createCell(38);
        if(dcpsFlag){
            headerCellForth.setCellValue("Net Amt.");
        }else{
            headerCellForth.setCellValue("Cr to GPF Acc");
        }

        headerCellForth.setCellStyle(headerStyle);

        // FIRST INSTALLMENT
        rowId++;  // INCREASE ROW
        int installmentIndex = 0;
        XSSFRow firstInstallmentRow = spreadsheet.getRow(rowId);
        Cell cellFirst2019 = firstInstallmentRow.createCell(35);
        cellFirst2019.setCellValue("1st insta 2019+NPS ARR");
        cellFirst2019.setCellStyle(headerStyle);

        Cell cellSecond2019 = firstInstallmentRow.createCell(36);
        cellSecond2019.setCellValue(installments[installmentIndex] + " + " + dcpsTotal + " = " + (installments[0] + dcpsTotal));
        cellSecond2019.setCellStyle(headerStyle);

        Cell cellThird2019 = firstInstallmentRow.createCell(37);
        cellThird2019.setCellValue(dcpsTotal);
        cellThird2019.setCellStyle(headerStyle);

        Cell cellForth2019 = firstInstallmentRow.createCell(38);
        cellForth2019.setCellValue(installments[installmentIndex]);
        cellForth2019.setCellStyle(headerStyle);


        // Second  INSTALLMENT
        rowId++;  // INCREASE ROW
        installmentIndex++;
        XSSFRow secondInstallmentRow = spreadsheet.getRow(rowId);
        Cell cellFirst2020 = secondInstallmentRow.createCell(35);
        cellFirst2020.setCellValue(" 2nd Insta. 2020");
        cellFirst2020.setCellStyle(headerStyle);

        Cell cellSecond2020 = secondInstallmentRow.createCell(36);
        cellSecond2020.setCellValue(installments[installmentIndex]);
        cellSecond2020.setCellStyle(headerStyle);

        Cell cellThird2020 = secondInstallmentRow.createCell(37);
        cellThird2020.setCellValue("-");
        cellThird2020.setCellStyle(headerStyle);

        Cell cellForth2020 = secondInstallmentRow.createCell(38);
        cellForth2020.setCellValue(installments[installmentIndex]);
        cellForth2020.setCellStyle(headerStyle);


        // Third  INSTALLMENT
        rowId++;
        installmentIndex++;
        XSSFRow thirdInstallmentRow = spreadsheet.getRow(rowId);
        Cell cellFirst2021 = thirdInstallmentRow.createCell(35);
        cellFirst2021.setCellValue(" 3rd Insta. 2021");
        cellFirst2021.setCellStyle(headerStyle);

        Cell cellSecond2021 = thirdInstallmentRow.createCell(36);
        cellSecond2021.setCellValue(installments[installmentIndex]);
        cellSecond2021.setCellStyle(headerStyle);

        Cell cellThird2021 = thirdInstallmentRow.createCell(37);
        cellThird2021.setCellValue("-");
        cellThird2021.setCellStyle(headerStyle);

        Cell cellForth2021 = thirdInstallmentRow.createCell(38);
        cellForth2021.setCellValue(installments[installmentIndex]);
        cellForth2021.setCellStyle(headerStyle);

        // Forth  INSTALLMENT
        rowId++;  // INCREASE ROW
        installmentIndex++;
        XSSFRow forthInstallmentRow = spreadsheet.getRow(rowId);
        Cell cellFirst2022 = forthInstallmentRow.createCell(35);
        cellFirst2022.setCellValue(" 4th Insta. 2022");
        cellFirst2022.setCellStyle(headerStyle);

        Cell cellSecond2022 = forthInstallmentRow.createCell(36);
        cellSecond2022.setCellValue(installments[installmentIndex]);
        cellSecond2022.setCellStyle(headerStyle);

        Cell cellThird2022 = forthInstallmentRow.createCell(37);
        cellThird2022.setCellValue("-");
        cellThird2022.setCellStyle(headerStyle);

        Cell cellForth2022 = forthInstallmentRow.createCell(38);
        cellForth2022.setCellValue(installments[installmentIndex]);
        cellForth2022.setCellStyle(headerStyle);

        // Fifth  INSTALLMENT
        rowId++;  // INCREASE ROW
        installmentIndex++;
        XSSFRow fifthInstallmentRow = spreadsheet.getRow(rowId);
        Cell cellFirst2023 = fifthInstallmentRow.createCell(35);
        cellFirst2023.setCellValue(" 5th Insta. 2023");
        cellFirst2023.setCellStyle(headerStyle);

        Cell cellSecond2023 = fifthInstallmentRow.createCell(36);
        cellSecond2023.setCellValue(installments[installmentIndex]);
        cellSecond2023.setCellStyle(headerStyle);

        Cell cellThird2023 = fifthInstallmentRow.createCell(37);
        cellThird2023.setCellValue("-");
        cellThird2023.setCellStyle(headerStyle);

        Cell cellForth2023 = fifthInstallmentRow.createCell(38);
        cellForth2023.setCellValue(installments[installmentIndex]);
        cellForth2023.setCellStyle(headerStyle);


        // Total amount
        rowId++;  // INCREASE ROW
        installmentIndex++;
        XSSFRow totalRow = spreadsheet.getRow(rowId);
        Cell cellFirstToatl = totalRow.createCell(35);
        cellFirstToatl.setCellValue(" Total ");
        cellFirstToatl.setCellStyle(headerStyle);

        Cell cellSecondTotal = totalRow.createCell(36);
        cellSecondTotal.setCellValue(totalBPArrear);
        cellSecondTotal.setCellStyle(headerStyle);

        Cell cellThirdTotal = totalRow.createCell(37);
        cellThirdTotal.setCellValue(dcpsTotal);
        cellThirdTotal.setCellStyle(headerStyle);

        Cell cellForthTotal = totalRow.createCell(38);
        cellForthTotal.setCellValue(netAmount);
        cellForthTotal.setCellStyle(headerStyle);


        if(recoveryAmt>0){
            rowId=rowId+2;  // INCREASE ROW

            XSSFRow statementRow = spreadsheet.getRow(rowId);
            Cell statementCell = statementRow.createCell(35);
            statementCell.setCellValue("Note:- OverPayment Recovery Statement Copy Enclosed");
            statementCell.setCellStyle(headerStyle);
            for (int i = 36; i <= 38; i++)
                statementRow.createCell(i).setCellStyle(headerStyle);

            spreadsheet.addMergedRegion(new CellRangeAddress(rowId, rowId, 35, 38));
        }
    }


}
