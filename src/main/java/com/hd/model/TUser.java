package com.hd.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_USER", schema = "CAR")
public class TUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String pwd;
	private String realname;
	private String sex;
	private Integer depid;
	private String phone;
	
	// 一个用户对应多个角色
	private Set<TRole> roles = new HashSet<TRole>();
	
	private List<TMenu> userMenus;

	// Constructors
	@Transient  // 设置临时属性
	public List<TMenu> getUserMenus() {
		return userMenus;
	}

	public void setUserMenus(List<TMenu> userMenus) {
		this.userMenus = userMenus;
	}

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TUser(Integer id, String username, String pwd, String realname,
			String sex, Integer depid, String phone) {
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.realname = realname;
		this.sex = sex;
		this.depid = depid;
		this.phone = phone;
	}

	// Property accessors
	/*
	 *  注解 你可以添加到属性上面，但是 getter方法和属性设置只能选择一种
	 *  strategy:指定主键的生成方式  generator指定名称
	 *  SequenceGenerator 序列生成的设置
	 *     name：上面声明的generator的值
	 *     sequenceName：数据库中具体的序列名称
	 *     initialValue：初始值
	 *     allocationSize：每次增长的值
	 */
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_user")
	@SequenceGenerator(name="seq_user",sequenceName="seq_t_user",
	schema="car",initialValue=1,allocationSize=1)
	@Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "USERNAME", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PWD", length = 20)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "REALNAME", length = 20)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "SEX", length = 2)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "DEPID", precision = 5, scale = 0)
	public Integer getDepid() {
		return this.depid;
	}

	public void setDepid(Integer depid) {
		this.depid = depid;
	}

	@Column(name = "PHONE", length = 22)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	 /*配置用户和角色多对多的关联关系 name 指定中间表 joinColumns指定关联的外键 
	inverseJoinColumns指定关联表在中间表中的外键*/
	@ManyToMany 
	@JoinTable(name="t_user_role",schema="car",joinColumns=@JoinColumn(name="userid"),
	inverseJoinColumns=@JoinColumn(name="roleid"))
	public Set<TRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<TRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "TUser [id=" + id + ", username=" + username + ", pwd=" + pwd
				+ ", realname=" + realname + ", sex=" + sex + ", depid="
				+ depid + ", phone=" + phone + ", roles=" + roles
				+ ", userMenus=" + userMenus + "]";
	}

	public TUser(Integer id, String username, String pwd, String realname,
			String sex, Integer depid, String phone, Set<TRole> roles,
			List<TMenu> userMenus) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.realname = realname;
		this.sex = sex;
		this.depid = depid;
		this.phone = phone;
		this.roles = roles;
		this.userMenus = userMenus;
	}
	

}