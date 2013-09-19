package nupterp.pageModel;

import java.util.List;

/**
 * EasyUI tree模型
 * 
 * @author 孙宇
 * 
 */
public class Tree implements java.io.Serializable {

	private static final long serialVersionUID = 1647545195931381328L;
	private String id;
	private String text;
	/*
	 * 采用树的平滑数据结构，state设置不影响显示，所以设置一个默认值，编程中不再修改
	 */
	private String state = "open";// open,closed
	private boolean checked = false;
	private Object attributes;
	private List<Tree> children;
	private String iconCls;
	private String pid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Object getAttributes() {
		return attributes;
	}

	public void setAttributes(Object attributes) {
		this.attributes = attributes;
	}

	public List<Tree> getChildren() {
		return children;
	}

	public void setChildren(List<Tree> children) {
		this.children = children;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

}
