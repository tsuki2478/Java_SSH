package com.hd.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hd.model.TUser;
import com.hd.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 处理用户登录
 * @author think
 *
 */
@Controller
public class LoginAction extends ActionSupport implements ModelDriven<TUser>{
	
	private TUser model = new TUser();
	@Resource
	private IUserService userService;

	public String login(){
		TUser user = userService.login(model);
		if(user != null){
			// 表示登录成功,需要将登录的用户信息保存到session作用域中
			ActionContext.getContext().getSession().put("LOGIN_USER", user);
			return "home";
		}else{
			// 表示登录失败，重新返回登录界面
			this.addActionMessage("账号密码错误！请核对后在尝试！！！");
			return "login";
		}
	}
	
	@Override
	public TUser getModel() {
		return model;
	}
	
	

}
