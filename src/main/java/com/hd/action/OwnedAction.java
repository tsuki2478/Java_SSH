package com.hd.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hd.model.OwnedVehicle;
import com.hd.service.IOwnedService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class OwnedAction extends ActionSupport {
	@Resource
	private IOwnedService ownedService;
	private  OwnedVehicle model  = new OwnedVehicle();
	private List<OwnedVehicle> list;
	
	private File upload;

	public String query(){
		list = ownedService.query();
		return super.SUCCESS;
	}
	public String delete(){
		
		ownedService.remove(model);
		return "query";
	}
	public String updatePage(){
		ownedService.update(model);
		return "query";
	}
	
	
	public String download(){
		System.out.println("------开始下载-------");
		return "download";
	}
	/**
	 * 处理文件上传
	 * @return
	 */
	public String importExcel(){
		try {
			ownedService.readExcel(upload);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "query";
	}
	/**
	 * 文件下载的入口
	 * @return
	 */
	public InputStream getInputStream(){
		InputStream in = null;
		try {
			in = ownedService.exportExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;
	}

	public List<OwnedVehicle> getList() {
		return list;
	}

	public void setList(List<OwnedVehicle> list) {
		this.list = list;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public OwnedVehicle getModel() {
		return model;
	}
	public void setModel(OwnedVehicle model) {
		this.model = model;
	}
	
}
	
	
