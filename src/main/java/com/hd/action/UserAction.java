package com.hd.action;

import java.util.List;






import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hd.model.TDepartment;
import com.hd.model.TRole;
import com.hd.model.TUser;
import com.hd.service.IDepartmentService;
import com.hd.service.IRoleService;
import com.hd.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class UserAction  extends BaseAction implements ModelDriven<TUser>{
	
	private TUser  model=new TUser();
// model 可以是查询条件
	@Resource
	private  IUserService userService;	
	@Resource
	private IDepartmentService deptService;
	@Resource
	private IRoleService roleService;
	
	private List<TDepartment> deptList;

	private List<TRole> roleList;
	
	
/*	  需要 set 和get  配合 setList
 * private  List<TUser> list;*/
	
	public String query(){
		
//		System.out.println(pageSize+"  "+currentPage);
		
		pageModel= userService.queryPage(model, currentPage, pageSize);
		return  super.SUCCESS;
		
//		setList(userService.queryAll(null));
		
	}
		/**
		 * 
		 * 查询所有的部门和角色
		 */
	public String queryData(){
		
		//		查询出所有部门
		deptList=deptService.queryAll(null);
		//		查询所有角色
		roleList=roleService.queryAll(null);
		return "save";
	}	
	
	/**
	 * 保存用户数据
	 * @return
	 */
	public String saveUser(){ 
		userService.save(model);
		return "query";
	}
	
	/**
	 * 同步用户数据
	 * @return
	 */
	public String synchroUser(){
		userService.saveSynchroUser();
		return "query";
	}
	
	public String update(){
		userService.update(model);
		return "query";
	}
	

	public String delete(){
		userService.remove(model);
		return "query";
	}
	
	/**
	 * 
	 * 查询所有的部门和角色
	 */
public String updatePage(){
	
	//		查询出所有部门
	deptList=deptService.queryAll(null);
	//		查询所有角色
	roleList=roleService.queryAll(null);
	
	// 手动的将结果保存到值栈中
	ActionContext.getContext().getValueStack().push(model);
	// 查询出所有的菜单信息
	List<TUser> list = userService.queryAll(model);
	return "update";
}	
	
	@Override
	public TUser getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	public List<TDepartment> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<TDepartment> deptList) {
		this.deptList = deptList;
	}
	public List<TRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<TRole> roleList) {
		this.roleList = roleList;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public IDepartmentService getDeptService() {
		return deptService;
	}
	public void setDeptService(IDepartmentService deptService) {
		this.deptService = deptService;
	}
	public IRoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	public void setModel(TUser model) {
		this.model = model;
	}
	

	
}
