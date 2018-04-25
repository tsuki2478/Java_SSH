package com.hd.utils;
import java.util.List;


import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class BaseDao<T> {
	@Resource
	protected SessionFactory factory;
	
	protected Session getSession() {
		return factory.getCurrentSession();
		
	}
	
	/**
	 * 返回分页模型
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param querySql
	 * @param countSql
	 * @param whereSql
	 * @param params
	 * @param javaBeanType
	 * @return PageModel
	 */
	public PageModel queryPageModel(StringBuilder queryHql, StringBuilder countHql, StringBuilder whereHql,
			 int currentPage, int pageSize, Map params) {

		// 拼凑完成语句，用于计算总记录数
		countHql.append(whereHql);
		Query q=getSession().createQuery(countHql.toString());
		if(params!=null && params.size()>0){
			q.setProperties(params);
		}
		Long totalCount= (Long) q.uniqueResult();
		
		// 考虑下边界
		queryHql.append(whereHql);
		q=getSession().createQuery(queryHql.toString());
        q.setMaxResults(pageSize);
        q.setFirstResult((currentPage - 1) * pageSize);
        if(params!=null && params.size()>0){
			q.setProperties(params);
		}
        
	    List<T>  list= q.list();

		PageModel pageModel = new PageModel();
		pageModel.setTotalCount(totalCount.intValue());
		pageModel.setCurrentPage(currentPage);
		pageModel.setPageSize(pageSize);

		pageModel.setResult(list);
		return pageModel;

	}
}
