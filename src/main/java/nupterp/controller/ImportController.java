package nupterp.controller;

import org.apache.log4j.Logger;

import java.io.File;

import javax.annotation.Resource;

import nupterp.pageModel.Json;
import nupterp.service.PoiServiceI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/importController")
public class ImportController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ImportController.class);

	private File file;
	private PoiServiceI poiService;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public PoiServiceI getPoiService() {
		return poiService;
	}

	@Resource
	public void setPoiService(PoiServiceI poiService) {
		this.poiService = poiService;
	}
	
	@ResponseBody
	@RequestMapping("/importUserExcel")
	public Json importUserExcel() {
		Json j = new Json();
		try {
			poiService.importUserExcel(file);
			j.setSuccess(true);
			j.setMsg("导入成功");
		} catch (Exception e) {
		//	e.printStackTrace();
			j.setMsg("导入失败");
			logger.error(e.getMessage(), e);
		}
		return j;
	}
	
	@ResponseBody
	@RequestMapping("/importRegisterExcel")
	public Json importRegisterExcel(){
		Json j = new Json();
		try {
			poiService.importRegisterExcel(file);
			j.setSuccess(true);
			j.setMsg("没有该功能，不要乱点");
		} catch (Exception e) {
		//	e.printStackTrace();
			j.setMsg("导入失败");
			logger.error(e.getMessage(), e);
		}
		return j;
	}
}
