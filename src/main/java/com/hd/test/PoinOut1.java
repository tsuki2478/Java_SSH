package com.hd.test;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class PoinOut1 {
	/**
	 * 打印 xls
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// 1.获取读取的文件
		InputStream in = new FileInputStream("d:/自有车辆信息.xls");
		// 2.获取HSSFWorkbook对象
		HSSFWorkbook wb = new HSSFWorkbook(in);
		// 3.得到需要读取数据的sheet页
		Sheet sheet = wb.getSheetAt(0);
		// System.out.println(sheet.getSheetName());
		// 4.获取所有的行数LastRowNum
		int rows = sheet.getLastRowNum();
		// System.out.println(row);
		for (int i = 2; i <= rows; i++) {
			// 循环取出每行的行号
			Row row = sheet.getRow(i);
			// 根据行获取每个单元格
			Cell c0 = row.getCell(0);
			Cell c1 = row.getCell(1);
			Cell c2 = row.getCell(2);
			Cell c3 = row.getCell(3);
			Cell c4 = row.getCell(4);
			System.out.println(getValue((HSSFCell) c0) + " " + c1.toString()
					+ " " + c2.toString() + " " + c3.toString() + " "
					+ c4.toString());
		}
	}

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