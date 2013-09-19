package nupterp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	/**
	 * 这个是为了直接输入网址就能跳转的Controller，个人觉得浪费了，无奈SAE需要
	 * @return
	 */
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/Index")
	public String Index() {
		return "redirect:/layout/index.jsp";
	}
}
