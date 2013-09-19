package nupterp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import nupterp.service.InitServiceI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 初始化数据库控制器
 */
@Controller
@RequestMapping("/initController")
public class InitController {

	@Resource
	private InitServiceI initService;

	/**
	 * 初始化数据库后转向到首页
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		initService.init();
		return "redirect:/";
	}

}
