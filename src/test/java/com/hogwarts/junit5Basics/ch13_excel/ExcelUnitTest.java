package com.hogwarts.junit5Basics.ch13_excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 1、获取文件名后缀
 * 2、查看文件是否存在
 * 3、获取工作簿对象Workbook
 *      如果是xls结尾用HSSF
 *      如果是xlsx结尾用XSSF
 * 4、读取第一个sheet
 * 5、获取行
 * 6、读取每一行的单元格内容
 * 7、最后关闭行
 */
public class ExcelUnitTest {

    @Test
    void excelBaseTest() throws IOException {
        String pathName = "src/test/resources/orderLines.xlsx";
        String excelType = pathName.substring(pathName.lastIndexOf(".")+1, pathName.length());

        assertThat("不是Excel文件",excelType, anyOf(endsWithIgnoringCase("xlsx"), endsWithIgnoringCase("xls")));

        File file = new File(pathName);
        assertTrue(file.exists(), "文件Excel不存在！");
        FileInputStream stream = new FileInputStream(file);
        Workbook workbook;

        if (excelType.equalsIgnoreCase("xlsx")){
            workbook = new XSSFWorkbook(stream);
        }else{
            workbook = new XSSFWorkbook(stream);
        }
        // 对应sheet是从0开始
        Sheet sheet = workbook.getSheetAt(0);
        // 获取当前sheet的个数
        int numberOfSheet = workbook.getNumberOfSheets();
        // 获取当前sheet的行数
        int numberOfRows = sheet.getPhysicalNumberOfRows();
        Map<Integer, List<Object>> data = new HashMap<>();
        int i =0;
        for (Row row:sheet){
            data.put(i, new ArrayList<>());
            // 每一行是一个row对象
//            System.out.println(row);
//            一个sheet对应的java的数据结构  Map<Integer, List<Object>>
            // 一行有多少个单元格
            int physicalNumberOfCell = row.getPhysicalNumberOfCells();
            System.out.println(physicalNumberOfCell);
            for (Cell cell:row){
                System.out.println(cell);
                CellType cellType = cell.getCellType();
                List<Object> objects = data.get(i);
                switch (cell.getCellType()){
                    case STRING:
                        String string = cell.getRichStringCellValue().getString();
                        objects.add(string);
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)){
                            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                            String format = fmt.format(cell.getDateCellValue());
                            objects.add(format);
                        }else {
                           objects.add(cell.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        objects.add(cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        objects.add(cell.getCellFormula());
                        break;
                    default:data.get(Integer.valueOf(i)).add(" ");
                }

            }
            i++;
        }
        System.out.println("data:" + data);
        // 关闭流
        workbook.close();
    }
}
