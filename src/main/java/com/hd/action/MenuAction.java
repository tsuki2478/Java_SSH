package com.hd.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hd.model.TMenu;
import com.hd.service.IMenuService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class MenuAction  extends ActionSupport implements ModelDriven<TMenu> {

	private TMenu model = new TMenu();
	@Resource
	private IMenuService menuService;
	private List<TMenu> list;
	
	public  String  query(){
		list= menuService.queryAll(model);
		return  this.SUCCESS;		
	}
	/**
	 * 查询出所有的菜单信息
	 * 
	 * 
	 */
	public String getMenuList(){
		list=  menuService.queryAll(model);
		return "save";
	}
	
	public String saveMenu(){
		menuService.save(model);
		return  "query";
	}	
	
	public String updateMenu(){
		menuService.update(model);
		return "query";
	}
	
	/**
	 * 查询修改的相关数据
	 * @return
	 */				
	public String updatePage(){
		// 根据主键查询出具体的菜单信息
		model = menuService.findUserById(model.getId());
		// 手动的将结果保存到值栈中
		ActionContext.getContext().getValueStack().push(model);
		// 查询出所有的菜单信息
		list = menuService.queryAll(model);
		return "update";
	}
	
	/**
	 * 根据id删除菜单数据
	 * @return
	 */
	public String delete(){
		menuService.remove(model);
		return "query";
	}
	
	
	
	
	@Override
	public TMenu getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	public List<TMenu> getList() {
		return list;
	}
	public void setList(List<TMenu> list) {
		this.list = list;
	}
	
}
