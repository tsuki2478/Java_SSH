package com.hd.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

class PoinOut {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 1 获取一个SSHworkbook对象
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2通过HSSFWorkbook创建一个sheet页
		HSSFSheet sheet = wb.createSheet("abc");

		// 样式设置
		HSSFCellStyle style1 = wb.createCellStyle();
		// 字体
		HSSFFont font1 = wb.createFont();
		font1.setColor((short) 123456);
		// 将字体设置到样式中
		style1.setFont(font1);
		// 创建第一行(0)开始
		HSSFRow r1 = sheet.createRow(0);
		// 获取第一行的第一个单元格(并且给予内容)
		HSSFCell c1r1 = r1.createCell(0);
		c1r1.setCellValue("die");
		// 给单元格设置样式
		c1r1.setCellStyle(style1);

		// 生成具体的excel文件
		OutputStream out = new FileOutputStream("d:/自有车辆信息.xls");
		wb.write(out);
		out.close();

	}

}
