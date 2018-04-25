package com.hd.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hd.model.TMenu;
import com.hd.model.TRole;
import com.hd.service.IMenuService;
import com.hd.service.IRoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class RoleAction  extends ActionSupport implements ModelDriven<TRole>{

	
		private TRole model =  new TRole();
		@Resource
		private IRoleService     roleService;
		@Resource
		private IMenuService menuService;
		private List<TRole> list;
		private List<TMenu> menusList;
	
		public  String query(){
			list=roleService.queryAll(null);
			return  super.SUCCESS;
			
		}
		
		public String saveRole(){
			roleService.save(model);
			return "query";
		}
		public String update(){
			roleService.update(model);
			return "query";
		}
		
		public String delete(){
			roleService.remove(model);
			return "query";
		}
		/**
		 * 查询出更新需要的数据
		 * @return
		 */
		public String updatePage(){
			// 根据id查询出相关的角色信息
			model = roleService.findUserById(model.getId());
			System.out.println(model.getMenus().size());
			// 角色和菜单是多对多的关系 -- 延迟加载
			ActionContext.getContext().getValueStack().push(model);
			// 查询出所有的菜单信息
			setMenusList(menuService.queryAll(null));
			return "update";
		}
		
		
		/**
		 * 查询所有菜单信息
		 * 
		 */
	public String getMenuList(){
		setMenusList(menuService.queryAll(null));
		return "save";
	}	
		
		
		
		
		
	@Override
	public TRole getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	public List<TRole> getList() {
		return list;
	}

	public void setList(List<TRole> list) {
		this.list = list;
	}

	public List<TMenu> getMenusList() {
		return menusList;
	}

	public void setMenusList(List<TMenu> menusList) {
		this.menusList = menusList;
	}

	
	
}
