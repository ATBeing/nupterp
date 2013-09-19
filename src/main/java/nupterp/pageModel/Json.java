package nupterp.pageModel;

import com.alibaba.fastjson.JSON;

/**
 * 
 * JSON模型
 * 
 * 用户后台向前台返回的JSON对象
 * 
 * @author 孙宇
 * 
 */
public class Json implements java.io.Serializable {

	private static final long serialVersionUID = -2073084046088942499L;

	private boolean success = false;

	private String msg = "";

	private Object obj = null;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public static String FormatToJson(Object object){
		return JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
	}

}
