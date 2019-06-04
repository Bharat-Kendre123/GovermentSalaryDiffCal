package employee.styling;
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

    public static final int fontHeight=9;
    public static final String[] allowances = {"Admissible pay and allowances","Drawn pay and allowances","Difference"};

    public static XSSFCellStyle getStyleForTital(XSSFWorkbook workbook, boolean flag)
    {
        XSSFCellStyle style1  = getStyle(workbook) ;
        if(flag)
        {
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

    public static XSSFCellStyle getStyleForAdmiDrwanDifff(XSSFWorkbook workbook,int couunter)
    {
        XSSFCellStyle xssfCellStyle  = getStyle(workbook) ;

        xssfCellStyle.setFillBackgroundColor(couunter==1?IndexedColors.RED.getIndex():couunter==2?IndexedColors.BRIGHT_GREEN.getIndex():IndexedColors.LIGHT_YELLOW.getIndex());
        xssfCellStyle.setFillPattern(CellStyle.LEAST_DOTS);
        XSSFFont font = workbook.createFont();
        font.setItalic(false);
        font.setColor(HSSFColor.BLACK.index);
        font.setBold(true);
        font.setBoldweight((short)30);
        font.setFontHeight(fontHeight);
        xssfCellStyle.setFont(font);
        return xssfCellStyle;
        // style1.setFillBackgroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
        //style1.setFillPattern(CellStyle.LEAST_DOTS);

    }


    public static XSSFCellStyle getStyleForTotalRow(XSSFWorkbook workbook)
    {
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
        font.setBoldweight((short)1);
        font.setFontHeight(fontHeight);
        style1.setFont(font);

        return  style1;
    }

    public static XSSFCellStyle textAlignmentAtCenter(XSSFWorkbook workbook)
    {
        XSSFCellStyle style1 = getStyle(workbook);
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setWrapText(true);
        XSSFFont font = workbook.createFont();
        font.setFontHeight(fontHeight);
        style1.setFont(font);
        return   style1;
    }

    public static XSSFCellStyle setBorderBold(XSSFWorkbook workbook)
    {
        XSSFCellStyle style1 = getStyle(workbook);
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setWrapText(true);
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
        font.setFontHeight(fontHeight);
        style1.setFont(font);
        return style1;
    }


    public static  XSSFCellStyle getStyle(XSSFWorkbook workbook)
    {
        XSSFCellStyle style1 ;
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
        font.setBoldweight((short)1);
        font.setFontHeight(fontHeight);
        style1.setFont(font);

        return  style1;
    }

    public static  XSSFCellStyle getStyleForName(XSSFWorkbook workbook)
    {
        XSSFCellStyle style1 ;
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
        font.setBoldweight((short)1);
        font.setFontHeight(fontHeight);
        style1.setFont(font);

        return  style1;
    }

    public static void setTotalRowStyle( XSSFWorkbook workbook, XSSFSheet spreadsheet,int rowid,int[]Addition,int rowNumber )
    {
        // STYLE FOR TOTAL ROW
        XSSFCellStyle styleForTotalRow =UtilForStyling.getStyleForTotalRow(workbook);

        // for 2016 to 2018 total
        XSSFRow row = spreadsheet.createRow(rowid++);
        for(int cellIdforTotal=0;cellIdforTotal<Addition.length;cellIdforTotal++)
        {
            Cell cellForTaoatl = row.createCell(cellIdforTotal);
            cellForTaoatl.setCellStyle(styleForTotalRow);
            if(cellIdforTotal==1)
            {
                cellForTaoatl.setCellValue("Total");
            }else if (cellIdforTotal==0){
                cellForTaoatl.setCellValue(rowNumber);
            }else {
                cellForTaoatl.setCellValue(Addition[cellIdforTotal]);
            }


        }
    }


    //COMMON METHOD FOR BOTH SHEET
    public static void setTitleStyle(XSSFWorkbook workbook,int rowidFor2019,XSSFSheet spreadsheetFor2019,String[] columnLsit,boolean is2019 )
    {
        // tital for 2019 sheet ++ style
        XSSFCellStyle admissibleStyle  =UtilForStyling.getStyleForAdmiDrwanDifff(workbook,1);
        XSSFRow xrowFor2019 = spreadsheetFor2019.createRow(rowidFor2019++);
        Cell cellForAdmissibleFor2019=xrowFor2019.createCell(2) ;
        cellForAdmissibleFor2019.setCellValue(allowances[0]);
        cellForAdmissibleFor2019.setCellStyle(admissibleStyle);
        for(int i=3;i<=11;i++)
            xrowFor2019.createCell(i).setCellStyle(admissibleStyle);
        spreadsheetFor2019.addMergedRegion(new CellRangeAddress(2,2,2,11)) ;


        XSSFCellStyle drawnStyle =UtilForStyling.getStyleForAdmiDrwanDifff(workbook,2);
        Cell cellFordrawnFor2019=xrowFor2019.createCell(12) ;
        cellFordrawnFor2019.setCellValue(allowances[1]);
        cellFordrawnFor2019.setCellStyle(drawnStyle);
        for(int i=13;i<=22;i++)
            xrowFor2019.createCell(i).setCellStyle(drawnStyle);
        spreadsheetFor2019.addMergedRegion(new CellRangeAddress(2,2,12,22)) ;

        XSSFCellStyle diffStyle  =UtilForStyling.getStyleForAdmiDrwanDifff(workbook,3);
        Cell cellFordiiffFor2019=xrowFor2019.createCell(23) ;
        cellFordiiffFor2019.setCellValue(allowances[2]);
        cellFordiiffFor2019.setCellStyle(diffStyle);
        for(int i=24;i<=32;i++)
            xrowFor2019.createCell(i).setCellStyle(diffStyle);
        spreadsheetFor2019.addMergedRegion(new CellRangeAddress(2,2,23,32)) ;

        xrowFor2019 = spreadsheetFor2019.createRow(rowidFor2019++);
        int cellidFor2019=0;

        // STYLE FOR COLUMN NAME
        XSSFCellStyle style1 =UtilForStyling.getStyleForTital(workbook,false);
        XSSFCellStyle styleForBoldBorder =UtilForStyling.getStyleForTital(workbook,true);

        int counter =0;
        for(String columnName:columnLsit)
        {
            Cell cell = xrowFor2019.createCell(cellidFor2019++);
            cell.setCellValue(columnName);
            cell.setCellStyle(style1);
            if(counter==columnLsit.length-1)
            {
                cell.setCellStyle(styleForBoldBorder);
            }
            counter++;
        }

    }


    public static void setEmployeeName(XSSFSheet spreadsheetFor2019, int rowidFor2019, String nameOfEmployee,XSSFWorkbook workbook)
    {
        XSSFCellStyle styleForName =getStyle(workbook);
        styleForName.getFont().setBoldweight((short)50);
        XSSFRow xrowFor2019 = spreadsheetFor2019.createRow(rowidFor2019++);
        Cell cellFor2019EMployeeName=xrowFor2019.createCell(1) ;
        cellFor2019EMployeeName.setCellValue(nameOfEmployee);
        cellFor2019EMployeeName.setCellStyle(styleForName);
        spreadsheetFor2019.addMergedRegion(new CellRangeAddress(3,3,2,34)) ;

    }

    public static void setDurationTital(XSSFWorkbook workbook, int rowidFor2019, XSSFSheet spreadsheetFor2019,String statement) {
        // tital for 2019 sheet ++ style
        XSSFCellStyle admissibleStyle  =UtilForStyling.getStyle(workbook);

        XSSFRow xrowFor2019 = spreadsheetFor2019.createRow(rowidFor2019++);
        Cell cellForAdmissibleFor2019=xrowFor2019.createCell(2) ;
        cellForAdmissibleFor2019.setCellValue(statement);
        cellForAdmissibleFor2019.setCellStyle(admissibleStyle);
        for(int i=3;i<=32;i++)
            xrowFor2019.createCell(i).setCellStyle(admissibleStyle);
        spreadsheetFor2019.addMergedRegion(new CellRangeAddress(1,1,2,32)) ;
    }

    public static void setInstallments(XSSFWorkbook workbook, XSSFSheet spreadsheet, int[] installmentAmounts,int totalAmount, int adjustableAmount,int toatlAfterRecovery) {

        //  --------------TOTAL AMOUNT------------------------------
        int rowId=5;
        XSSFCellStyle admissibleStyle  =setBorderBold(workbook);
        XSSFRow xrowFor2019 = spreadsheet.getRow(rowId);
        Cell installment2019=xrowFor2019.createCell(35) ;
        installment2019.setCellValue("TOTAL AMOUNT");
        installment2019.setCellStyle(admissibleStyle);
        for(int i=36;i<=36;i++)
            xrowFor2019.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,35,36)) ;

        // rowId++;
        Cell installmentAmount2019=xrowFor2019.createCell(37) ;
        installmentAmount2019.setCellValue(totalAmount);
        installmentAmount2019.setCellStyle(admissibleStyle);
        for(int i=38;i<=38;i++)
            xrowFor2019.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,37,38)) ;

        //---------------------RECOVERY AMOUNT-----------------------------------
        rowId++;  // INCREASE ROW
        XSSFRow recoveryRow = spreadsheet.getRow(rowId);
        Cell recoveryCell=recoveryRow.createCell(35) ;
        recoveryCell.setCellValue("RECOVERED AMOUNT");
        recoveryCell.setCellStyle(admissibleStyle);
        for(int i=36;i<=36;i++)
            recoveryRow.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,35,36)) ;

        // rowId++;
        Cell recoveryCellAmt=recoveryRow.createCell(37) ;
        recoveryCellAmt.setCellValue(adjustableAmount);
        recoveryCellAmt.setCellStyle(admissibleStyle);
        for(int i=38;i<=38;i++)
            recoveryRow.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,37,38)) ;

        
        // ----------------------- NET AMOUNT-----------------------------------------

        rowId++;  // INCREASE ROW
        XSSFRow netPayble = spreadsheet.getRow(rowId);
        Cell netInstCell=netPayble.createCell(35) ;
        netInstCell.setCellValue("NET AMOUNT");
        netInstCell.setCellStyle(admissibleStyle);
        for(int i=36;i<=36;i++)
            netPayble.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,35,36)) ;


        Cell netInstCellAmt=netPayble.createCell(37) ;
        netInstCellAmt.setCellValue(toatlAfterRecovery);
        netInstCellAmt.setCellStyle(admissibleStyle);
        for(int i=38;i<=38;i++)
            netPayble.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,37,38)) ;
        
        
        // ----------------------- 1st INSTALLEMENT-----------------------------------------

        rowId++;  // INCREASE ROW
        XSSFRow firstInstRow = spreadsheet.getRow(rowId);
        Cell firstInstCell=firstInstRow.createCell(35) ;
        firstInstCell.setCellValue("1st INST 2019");
        firstInstCell.setCellStyle(admissibleStyle);
        for(int i=36;i<=36;i++)
            firstInstRow.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,35,36)) ;

        Cell firstInstCellAmt=firstInstRow.createCell(37) ;
        firstInstCellAmt.setCellValue(installmentAmounts[0]);
        firstInstCellAmt.setCellStyle(admissibleStyle);
        for(int i=38;i<=38;i++)
            firstInstRow.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,37,38)) ;
      // ----------------------- 2nd INSTALLEMENT-----------------------------------------

        rowId++;  // INCREASE ROW
        XSSFRow secondInstRow = spreadsheet.getRow(rowId);
        Cell secondtInstCell=secondInstRow.createCell(35) ;
        secondtInstCell.setCellValue("2nd INST 2020");
        secondtInstCell.setCellStyle(admissibleStyle);
        for(int i=36;i<=36;i++)
            secondInstRow.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,35,36)) ;


        Cell secondInstCellAmt=secondInstRow.createCell(37) ;
        secondInstCellAmt.setCellValue(installmentAmounts[1]);
        secondInstCellAmt.setCellStyle(admissibleStyle);
        for(int i=38;i<=38;i++)
            secondInstRow.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,37,38)) ;


        // ----------------------- 3rd INSTALLEMENT-----------------------------------------

        rowId++;  // INCREASE ROW
        XSSFRow thirdInstRow = spreadsheet.getRow(rowId);
        Cell thirdInstCell=thirdInstRow.createCell(35) ;
        thirdInstCell.setCellValue("3rd INST 2021");
        thirdInstCell.setCellStyle(admissibleStyle);
        for(int i=36;i<=36;i++)
            thirdInstRow.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,35,36)) ;


        Cell thirdInstCellAmt=thirdInstRow.createCell(37) ;
        thirdInstCellAmt.setCellValue(installmentAmounts[2]);
        thirdInstCellAmt.setCellStyle(admissibleStyle);
        for(int i=38;i<=38;i++)
            thirdInstRow.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,37,38)) ;

        // ----------------------- 4th INSTALLEMENT-----------------------------------------

        rowId++;  // INCREASE ROW
        XSSFRow forthInstRow = spreadsheet.getRow(rowId);
        Cell forthInstCell=forthInstRow.createCell(35) ;
        forthInstCell.setCellValue("4th INST 2022");
        forthInstCell.setCellStyle(admissibleStyle);
        for(int i=36;i<=36;i++)
            forthInstRow.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,35,36)) ;


        Cell forthInstCellAmt=forthInstRow.createCell(37) ;
        forthInstCellAmt.setCellValue(installmentAmounts[3]);
        forthInstCellAmt.setCellStyle(admissibleStyle);
        for(int i=38;i<=38;i++)
            forthInstRow.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,37,38)) ;

        // ----------------------- 5th INSTALLEMENT-----------------------------------------

        rowId++;  // INCREASE ROW
        XSSFRow fifthInstRow = spreadsheet.getRow(rowId);
        Cell fifthInstCell=fifthInstRow.createCell(35) ;
        fifthInstCell.setCellValue("5th INST 2023");
        fifthInstCell.setCellStyle(admissibleStyle);
        for(int i=36;i<=36;i++)
            fifthInstRow.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,35,36)) ;


        Cell fifthInstCellAmt=fifthInstRow.createCell(37) ;
        fifthInstCellAmt.setCellValue(installmentAmounts[4]);
        fifthInstCellAmt.setCellStyle(admissibleStyle);
        for(int i=38;i<=38;i++)
            fifthInstRow.createCell(i).setCellStyle(admissibleStyle);
        spreadsheet.addMergedRegion(new CellRangeAddress(rowId,rowId,37,38)) ;

    }

    public static void setColumnWidth(XSSFSheet spreadsheet) {


        for(int i=8;i<=34;i++)
        {
            spreadsheet.setColumnWidth(i,1700);
        }

        spreadsheet.setColumnWidth(0,670);
        spreadsheet.setColumnWidth(1,1730);
        spreadsheet.setColumnWidth(2,1730);
        spreadsheet.setColumnWidth(3,1550);
        spreadsheet.setColumnWidth(4,1450);
        spreadsheet.setColumnWidth(5,1300);
        spreadsheet.setColumnWidth(6,1050);
        spreadsheet.setColumnWidth(7,1550);

        spreadsheet.setColumnWidth(12,1750);
        spreadsheet.setColumnWidth(14,1750);
        spreadsheet.setColumnWidth(15,1350);
        spreadsheet.setColumnWidth(16,1300);
        spreadsheet.setColumnWidth(17,1050);
        spreadsheet.setColumnWidth(18,1350);
        spreadsheet.setColumnWidth(23,1750);

        spreadsheet.setColumnWidth(25,470);
        spreadsheet.setColumnWidth(26,470);
        spreadsheet.setColumnWidth(27,470);

        spreadsheet.setColumnWidth(30,1750);
        spreadsheet.setColumnWidth(31,470);
        spreadsheet.setColumnWidth(33,1750);
        spreadsheet.setColumnWidth(32,1680);
        spreadsheet.setColumnWidth(9,1900);

        spreadsheet.setColumnWidth(20,1900);
        spreadsheet.setColumnWidth(24,1850);
        spreadsheet.setColumnWidth(10,1200);
        spreadsheet.setColumnWidth(21,1200);

    }
}
