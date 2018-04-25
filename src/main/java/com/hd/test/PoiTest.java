package com.hd.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * Poi读取测试。。。
 * 
 * @author Administrator
 *
 */
public class PoiTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 1.获取读取的文件
		InputStream in = new FileInputStream("c:/exportCar.xls");
		// 2.获取HSSFworbook对象{解析}
		HSSFWorkbook wb = new HSSFWorkbook(in);
		// 3.得到需要读取数据的sheet页
		Sheet sheet = wb.getSheetAt(0);
		System.out.println(sheet.getSheetName());
		// 4.获取所有的行数
		int rows = sheet.getLastRowNum();
		System.out.println(rows);
		for (int i = 2; i <= rows; i++) {
			// 循环取出每行的行号{没循环一次得到一行数据}
			Row row = sheet.getRow(i);
			Cell cell0 = row.getCell(0);
			Cell cell1 = row.getCell(1);
			Cell cell2 = row.getCell(2);
			Cell cell3 = row.getCell(3);
			Cell cell4 = row.getCell(4);
			System.out.println(getValue((HSSFCell) cell0)+ "	" + getValue((HSSFCell) cell1) + "		"
					+ cell2.toString() + "	" + cell3.toString() + "	"
					+ cell4.toString());

		}

	}
/**
 *   转换数据类型 。。  判断。。数字类型判断。字符串则直接获取 
 * @param cell
 * @return
 */
	private static String getValue(HSSFCell cell) {
		String cellValue = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			double d = cell.getNumericCellValue();
			int intd = (int) d;
			cellValue = String.valueOf(intd);
			break;
		case HSSFCell.CELL_TYPE_STRING:
			cellValue = cell.getStringCellValue();

		default:
			break;
		}
		return cellValue;
	}

}
