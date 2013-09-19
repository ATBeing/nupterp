package nupterp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import nupterp.pageModel.Tree;
import nupterp.service.ResourceServiceI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/resourceController")
public class ResourceController extends BaseController{

	private ResourceServiceI resourceService;

	public ResourceServiceI getResourceService() {
		return resourceService;
	}

	@Resource
	public void setResourceService(ResourceServiceI resourceService) {
		this.resourceService = resourceService;
	}
	
	@RequestMapping("/getTreeNode")
	@ResponseBody
	public List<Tree> getTreeNode(HttpSession session, HttpServletRequest request){
		return resourceService.getTreeNode();
	}
	
}
