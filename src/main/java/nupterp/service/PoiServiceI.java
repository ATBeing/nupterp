package nupterp.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PoiServiceI {

	// Excel数据导入到数据库中
	public void importUserExcel(File file) throws Exception;

	// 导出填写数据的Excel模版
	public void exportUserModela(HttpServletRequest request,HttpServletResponse response);

	// 从数据库中导出数据到excel中
	public void exportUserToExcela(HttpServletRequest request,HttpServletResponse response);
	
	// 导出填写数据的Excel模版
	public void exportRegisterModel(HttpServletRequest request,HttpServletResponse response);
	
	// 从数据库中导出数据到excel中
	public void exportRegisterToExcel(HttpServletRequest request,HttpServletResponse response);
	
	public void importRegisterExcel(File file) throws Exception;

}
