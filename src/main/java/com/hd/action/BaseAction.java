package com.hd.action;

import com.hd.utils.PageModel;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	int pageSize = 5;
 	int currentPage = 1;

	PageModel pageModel;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}

}
