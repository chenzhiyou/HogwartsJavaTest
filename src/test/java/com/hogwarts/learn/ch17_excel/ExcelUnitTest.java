package com.hogwarts.learn.ch17_excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.endsWithIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExcelUnitTest {

    @Test
    void excelBaseTest(){
        try {
            // 获取文件名后缀
            String pathName ="src/test/resources/orderLines.xlsx";
            String excelType = pathName.substring(pathName.lastIndexOf(".") + 1, pathName.length());
            assertThat("当前文件不是Excel文件",excelType, anyOf(endsWithIgnoringCase("xlsx"), endsWithIgnoringCase("xls")));
            // 查看文件是否存在
            File file = new File(pathName);
            assertTrue(file.exists(), "文件不存在");
            // 获取工作簿对象
            FileInputStream stream = new FileInputStream(file);
            Workbook workbook = null;
            if (excelType.equalsIgnoreCase("xls")){
                workbook = new HSSFWorkbook(stream);
            }else{
                workbook = new XSSFWorkbook(stream);
            }
            // 读取第一个sheet, 对应的sheet是从0老师
            Sheet sheet = workbook.getSheetAt(0);
            // 当前工作簿有多少个sheet
            int numberOfSheets = workbook.getNumberOfSheets();

            // 一个sheet对应的Java的数据结构对象
            // Map<Integer, List<Object>> Map<行号，行的内容>
            Map<Integer, List<Object>> data = new HashMap<>();
            // 当前sheet有多少行：
            int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
            // 行号
            int i = 0;
            for (Row row: sheet){
                // 每一行是row
                // 一行有多少个单元格
                data.put(i, new ArrayList<>());
                int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                System.out.println(physicalNumberOfCells);
                for (Cell cell:row){
                    System.out.println(cell);
                    CellType cellType = cell.getCellType();
                    List<Object> objects = data.get(i);
                    switch (cellType){
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
                                double numericCellValue = cell.getNumericCellValue();
                                objects.add(numericCellValue);
                            }
                            break;
                        case BOOLEAN:
                            boolean booleanCellValue = cell.getBooleanCellValue();
                            objects.add(booleanCellValue);
                            break;
                        case FORMULA:
                            String cellFormula = cell.getCellFormula();
                            objects.add(cellFormula);
                            break;
                        default:
                            boolean add = data.get(Integer.valueOf(i)).add(" ");
                            objects.add(add);
                    }
                }
                i++;
            }
            System.out.println(data);
            // 关闭流
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
