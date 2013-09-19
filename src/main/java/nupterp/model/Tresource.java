package nupterp.model;

import java.util.HashSet;
import java.util.Set;

public class Tresource implements java.io.Serializable {

	private static final long serialVersionUID = -1560429806132593544L;
	private String id;
	private Tresourcetype tresourcetype;
	private Tresource tresource;
	private String name;
	private String remark;
	private Integer seq;
	private String url;
	private String icon;
	private String pid;
	private String tresourcetypeid;
	private Set<Tresource> tresources = new HashSet<Tresource>(0);

	public Tresource() {
	}

	public Tresource(String id, Tresourcetype tresourcetype, String name) {
		this.id = id;
		this.tresourcetype = tresourcetype;
		this.name = name;
	}

	public Tresource(String id, Tresourcetype tresourcetype, Tresource tresource, String name, String remark, Integer seq, String url, String icon,  Set<Tresource> tresources) {
		this.id = id;
		this.tresourcetype = tresourcetype;
		this.tresource = tresource;
		this.name = name;
		this.remark = remark;
		this.seq = seq;
		this.url = url;
		this.icon = icon;
		this.tresources = tresources;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Tresourcetype getTresourcetype() {
		return this.tresourcetype;
	}

	public void setTresourcetype(Tresourcetype tresourcetype) {
		this.tresourcetype = tresourcetype;
	}

	public Tresource getTresource() {
		return this.tresource;
	}

	public void setTresource(Tresource tresource) {
		this.tresource = tresource;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Set<Tresource> getTresources() {
		return this.tresources;
	}

	public void setTresources(Set<Tresource> tresources) {
		this.tresources = tresources;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTresourcetypeid() {
		return tresourcetypeid;
	}

	public void setTresourcetypeid(String tresourcetypeid) {
		this.tresourcetypeid = tresourcetypeid;
	}

}
