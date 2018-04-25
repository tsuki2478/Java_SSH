package com.hd.interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hd.model.TMenu;
import com.hd.model.TUser;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * 负责页面安全的拦截器
 * 
 * @author Administrator
 *
 */
public class SecurityInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	/**
	 * 拦截除了登录以外的所有的请求 如果是登录状态放过。。否则跳转回登录界面
	 */
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		// 非OIC 直接方式
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("LOGIN_USER");
		if (obj != null) {
			// 表示已经登录了。。放过
			// 验证当前用户是否具有该请求的权限。
//			1获取用户提交的请求---》sys/user_query
//			2获取当前用户具有的权限[/sys/user_query,sys/menu_query....]
			String path = request.getServletPath();
			System.out.println(path);
			// 验证通过。。
			TUser user =(TUser)obj;
			// 验证不通过。。权限提示
			List<TMenu>  list  = user.getUserMenus();
//			默认不具有权限
			boolean  type  =false;
			for (TMenu m : list) {
				if (m.getMenulink() !=null && (m.getMenulink().equals(path)||(m.getMenulink()+".action").equals(path))) {
//					表示具有权限
					type=  true;
					break;
				}
				
			}if (type) {
//				验证通过
				ai.invoke();
			}else{
//				验证不通过 权限提示
				response.setCharacterEncoding("utf-8");
				 response.setContentType("text/html;charset=utf-8"); PrintWriter
				 out = response.getWriter();
				  
				  out.append("<script type='text/javascript'>");
				  out.append("alert('权限不够。请联系管理员！！！');");
				  out.append("location.href='"+request.getContextPath()+"/noAccess.jsp';");
				  out.append("</script>");
			}
			} else {
			// 表示没有登录需要拦截。跳转回首页
			/*
			 * response.setCharacterEncoding("utf-8");
			 * response.setContentType("text/html;charset=utf-8"); PrintWriter
			 * out = response.getWriter();
			 * 
			 * out.append("<script type='text/javascript'>");
			 * out.append("alert('您还没有登录，请先登录');");
			 * out.append("location.href='"+
			 * request.getContextPath()+"/login.jsp';");
			 * out.append("</script>");
			 */
			request.setAttribute("msg", "没有登录，请先登录");
			return "login";
		}
		return null;
	}

}
