package nupterp.pageModel;

import java.util.Date;

public class User implements java.io.Serializable {

	private static final long serialVersionUID = -3701231116700969099L;
	private String id;
	private String ids;
	private String sid;
	private String name;
	private String pwd;
	private Date createtime;
	private Date modifytime;
	private String role;
	
	private String q;

	// private Date createdatetimeStart;
	// private Date createdatetimeEnd;
	// private Date modifydatetimeStart;
	// private Date modifydatetimeEnd;

	private String roleIds;
	private String roleNames;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}


	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


}
