package nupterp.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import nupterp.pageModel.DataGrid;
import nupterp.pageModel.Json;
import nupterp.pageModel.PageHelper;
import nupterp.pageModel.Register;
import nupterp.pageModel.SessionInfo;
import nupterp.service.RegisterServiceI;
import nupterp.util.ConfigUtil;
import nupterp.util.StringUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/registerController")
public class RegisterController extends BaseController {

	private RegisterServiceI registerService;

	public RegisterServiceI getRegisterService() {
		return registerService;
	}

	@Resource
	public void setRegisterService(RegisterServiceI registerService) {
		this.registerService = registerService;
	}

	@RequestMapping("/reg")
	public String manager() {
		return "/admin/reg";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(Register register, PageHelper ph) {
		return registerService.dataGrid(register, ph);
	}

	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		return "/admin/regAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public Json add(Register register) {
		Json j = new Json();
		try {
			register.setId(UUID.randomUUID().toString());
			registerService.add(register);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
		//	e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}
	
	@RequestMapping("/noSession_add")
	@ResponseBody
	public Json noSession_add(Register register) {
		Json j = new Json();
		try {
			register.setId(UUID.randomUUID().toString());
			register.setName(StringUtil.filterAll(register.getName()));
			register.setMajor(StringUtil.filterAll(register.getMajor()));
			register.setQq(StringUtil.filterAll(register.getQq()));
			register.setPhone(StringUtil.filterAll(register.getPhone()));
			register.setDepartments(StringUtil.filterAll(register.getDepartments()));
			register.setSex(StringUtil.filterAll(register.getSex()));
			register.setSid(StringUtil.filterAll(register.getSid()));
			register.setSpeciality(StringUtil.filterAll(register.getSpeciality()));
			registerService.add(register);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			//e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		return "/admin/regEdit";
	}

	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Register register) {
		Json j = new Json();
		try {
			registerService.edit(register);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			//e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String ids, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		Json j = new Json();
		if (ids != null && !ids.equalsIgnoreCase(sessionInfo.getId())) {// 不能删除自己
			for (String id : ids.split(",")) {
				registerService.delete(id);
			}
		}
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}
	
	@RequestMapping("/regIO")
	public String regIO(){
		return "/admin/regIO";
	}
}
