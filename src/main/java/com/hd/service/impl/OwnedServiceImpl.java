package com.hd.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import com.hd.dao.IOwnedDao;
import com.hd.model.OwnedVehicle;
import com.hd.service.IOwnedService;
@Service
public class OwnedServiceImpl implements IOwnedService {
	@Resource
	private IOwnedDao dao;
	
	@Override
	public List<OwnedVehicle> query() {
		// TODO Auto-generated method stub
		return dao.query();
	}

@Override
public void update(OwnedVehicle ownedvehicle) {
	// TODO Auto-generated method stub
	dao.update(ownedvehicle);
}
@Override
public void remove(OwnedVehicle ownedVehicle) {
	// TODO Auto-generated method stub
	dao.remove(ownedVehicle);
}
	
	/**
	 * 通过POI获取Excel中的信息，并保存到数据库中
	 * @throws IOException 
	 */
	@Override
	public void readExcel(File upload) throws IOException {
		InputStream in = new FileInputStream(upload);
		HSSFWorkbook wb = new HSSFWorkbook(in);
		HSSFSheet sheet = wb.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		// 保存所有的数据
		List<OwnedVehicle> list = new ArrayList<OwnedVehicle>();
		for (int i = 2; i <= rows; i++) {
			// 获取每一行
			HSSFRow row = sheet.getRow(i);
			HSSFCell c0 = row.getCell(0);
			HSSFCell c1 = row.getCell(1);
			HSSFCell c2 = row.getCell(2);
			HSSFCell c3 = row.getCell(3);
			HSSFCell c4 = row.getCell(4);
			// 根据单元格获取对应的数据
			// id
			String id = getValue(c0);
			// 车辆编号
			String vehicleId = getValue(c1);
			// 使用单位
			String memo = getValue(c2);
			// 车辆类型
			String model = getValue(c3);
			// 车牌号码
			String licenseCode = getValue(c4);
			OwnedVehicle ov = new OwnedVehicle();
			ov.setVehicleId(vehicleId);
			ov.setMemo(memo);
			ov.setModel(model);
			ov.setLicenseCode(licenseCode);
			list.add(ov);
		}
		
		// 通过循环将Excel中的所有的数据保存到集合中
		dao.saveOwnedExcel(list);
		
	}
	
	private  String getValue(HSSFCell cell) {
		String cellValue="";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			double d= cell.getNumericCellValue();
			int intd=(int)d;
			cellValue=String.valueOf(intd);
			break;
		case HSSFCell.CELL_TYPE_STRING:
			cellValue=cell.getStringCellValue();
			
		default:
			break;
		}
		return cellValue;
	}
	@Override
	public InputStream exportExcel() throws IOException {
		
		String title[] = {"id","车辆编号","使用单位","车辆类型","车牌号码"};
		List<OwnedVehicle> list = dao.query(); // new ArrayList<OwnedVehicle>();
		/*for (int i = 0; i < 10; i++) {
			list.add(new OwnedVehicle(i+1, (1000+i)+"", "QQ", "粤B00"+i, "销售部"));
		}*/
		
		
		// TODO Auto-generated method stub
		// 1.获取一个HSSFWorkbook对象
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.通过HSSFWorkbook创建一个sheet页
		HSSFSheet sheet = wb.createSheet("自有车辆数据");
		/******************************/
		HSSFCellStyle style = wb.createCellStyle();
		//  设置居中
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 设置垂直居中
		
		HSSFFont font = wb.createFont();
		// 加粗
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 将font添加到样式中
		style.setFont(font);
		// 单元格合并
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
		// 创建第一行 第一个单元格
		HSSFRow r0 = sheet.createRow(0);
		HSSFCell c00 = r0.createCell(0);
		c00.setCellValue("自有车辆信息");
		// 给单元格添加样式
		c00.setCellStyle(style);
		
		// 创建第二行，设置第二行中的信息
		HSSFRow r1 = sheet.createRow(1);
		for (int i = 0; i < title.length; i++) {
			HSSFCell cell = r1.createCell(i);
			cell.setCellValue(title[i]);
		}
		// 生成具体的业务数据
		for (int i = 0; i < list.size(); i++) {
			// 每循环一次 取出一条数据，创建一行
			HSSFRow row = sheet.createRow(i+2);
			// 获取保存的数据
			OwnedVehicle ow = list.get(i);
			// 创建的这一行 有5列【根据title得到】
			row.createCell(0).setCellValue(ow.getId());
			row.createCell(1).setCellValue(ow.getVehicleId());
			row.createCell(2).setCellValue(ow.getMemo());
			row.createCell(3).setCellValue(ow.getModel());
			row.createCell(4).setCellValue(ow.getLicenseCode());
			
		}
		/******************************/
		// 生成具体的Excel文件
		OutputStream out = new FileOutputStream("test.xls");
		wb.write(out);
		out.close();
		
		InputStream in = new FileInputStream("test.xls");
		return in;

	}

 
}
