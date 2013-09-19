package nupterp.controller;

import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nupterp.pageModel.Json;
import nupterp.service.PoiServiceI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exportController")
public class ExportController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ExportController.class);

	private PoiServiceI poiService;

	public PoiServiceI getPoiService() {
		return poiService;
	}

	@Resource
	public void setPoiService(PoiServiceI poiService) {
		this.poiService = poiService;
	}
	
	@RequestMapping("/exportUserModela")
	public void exportUserModela(HttpServletRequest request,HttpServletResponse response) {
		Json j = new Json();
		try {
			poiService.exportUserModela(request,response);
			j.setSuccess(true);
			j.setMsg("导出Model成功");
		} catch (Exception e) {
			j.setMsg("导出Model失败，请重试");
			logger.error(e.getMessage(),e);
		}
	}
	
	@RequestMapping("/exportUserToExcela")
	public void exportUserToExcela(HttpServletRequest request,HttpServletResponse response) {
		Json j = new Json();
		try {
			poiService.exportUserToExcela(request,response);
			j.setSuccess(true);
			j.setMsg("导出成功");
		} catch (Exception e) {
			j.setMsg("导出失败，请重试");
			logger.error(e.getMessage(),e);
		}
	}
	
	@RequestMapping("/exportRegisterModel")
	public void exportRegisterModel(HttpServletRequest request,HttpServletResponse response){
		Json j = new Json();
		try {
			poiService.exportRegisterModel(request,response);
			j.setSuccess(true);
			j.setMsg("导出Model成功");
		} catch (Exception e) {
			j.setMsg("导出Model失败，请重试");
			logger.error(e.getMessage(),e);
		}
	}
	
	@RequestMapping("/exportRegisterToExcel")
	public void exportRegisterToExcel(HttpServletRequest request,HttpServletResponse response){
		Json j = new Json();
		try {
			poiService.exportRegisterToExcel(request,response);
			j.setSuccess(true);
			j.setMsg("导出成功");
		} catch (Exception e) {
			j.setMsg("导出失败，请重试");
			logger.error(e.getMessage(),e);
		}
	}
	
}
