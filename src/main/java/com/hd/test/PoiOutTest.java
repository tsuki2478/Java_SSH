package com.hd.test;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.acl.Owner;
import java.util.ArrayList;


import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.hd.model.OwnedVehicle;




public class PoiOutTest {
	public static void main(String[] args) throws Exception {
//	模拟生成数据
		String  tilte[] = {"id","车辆编码","使用单位","车辆类型","车牌号码"};		
	List<OwnedVehicle> list= new ArrayList<OwnedVehicle>();
	for (int i = 0; i < 10; i++) {
list.add(new OwnedVehicle(i+1,"粤001"+i,"QQ",(1000+i)+"","销售部"));
	}	

		 
//***************************************************
		// 1 获取一个SSHworkbook对象
	HSSFWorkbook wb = new HSSFWorkbook();
	 	// 2通过HSSFWorkbook创建一个sheet页
	HSSFSheet sheet = wb.createSheet("自有车辆数据");
//***************************************************
	HSSFCellStyle  style = wb.createCellStyle();
//	设置居中
	style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
	style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//设置垂直
	
	HSSFFont font  =wb.createFont();
//	加粗
	font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//	将字体加入样式
	style.setFont(font);
	
//	单元格合并
	sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
//	创建第一行第一个单元格
	HSSFRow  r0= sheet.createRow(0);
	HSSFCell c00= r0.createCell(0);
	c00.setCellValue("自有车辆信息");
//	给单元格添加样式
	c00.setCellStyle(style);
	
//	创建第二行。设置第二行中信息
	HSSFRow  r1=sheet.createRow(1);
	for (int i = 0; i < tilte.length; i++) {
		HSSFCell cell= r1.createCell(i);
		cell.setCellValue(tilte[i]);
	}
//	生成具体的业务数据
	for (int i = 0; i < list.size(); i++) {
//		每循环一次 取出一条数据 创建一行
		HSSFRow  row = sheet.createRow(i+2);
//		获取保存数据
		OwnedVehicle  ow=list.get(i);
//		创建的这一环氧  有5列 【根据title得到】
		row.createCell(0).setCellValue(ow.getId());
		row.createCell(1).setCellValue(ow.getVehicleId());
		row.createCell(2).setCellValue(ow.getMemo());
		row.createCell(3).setCellValue(ow.getModel());
		row.createCell(4).setCellValue(ow.getLicenseCode());
	}
	
	
	
	// 生成具体的excel文件
	OutputStream out = new FileOutputStream("d:/自有车辆信息.xls");
	wb.write(out);
	out.close();
	
	}
}