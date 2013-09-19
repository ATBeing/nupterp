package nupterp.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nupterp.dao.RegisterDaoI;
import nupterp.dao.UserDaoI;
import nupterp.model.Tregister;
import nupterp.model.Tuser;
import nupterp.pageModel.Register;
import nupterp.pageModel.SessionInfo;
import nupterp.pageModel.User;
import nupterp.service.PoiServiceI;
import nupterp.service.UserServiceI;
import nupterp.util.ClobUtil;
import nupterp.util.ConfigUtil;
import nupterp.util.poi.ExcelUtils;
import nupterp.util.poi.JsGridReportBase;
import nupterp.util.poi.TableData;
import nupterp.util.poi.leoUtil;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoiServiceImpl implements PoiServiceI {
	private static final Logger logger = Logger.getLogger(PoiServiceImpl.class);

	private UserServiceI userService;
	private FileInputStream fileStream;

	private UserDaoI userDao;
	private RegisterDaoI registerDao;

	public RegisterDaoI getRegisterDao() {
		return registerDao;
	}

	@Autowired
	public void setRegisterDao(RegisterDaoI registerDao) {
		this.registerDao = registerDao;
	}

	public UserDaoI getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDaoI userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	@Override
	public void importUserExcel(File file) throws Exception {
		if (leoUtil.isExcel(file)) {
			try {
				fileStream = new FileInputStream(file);
				logger.info("打开新的文件流");
				Workbook book = WorkbookFactory.create(fileStream);
				Sheet sheet = book.getSheetAt(0);
				User user = new User();
				// 从0开始，第一行对应sheet.getRow(0)
				for (int i = 4; i <= sheet.getLastRowNum(); i++) {
					Row ros = sheet.getRow(i);
					Tuser tuser = userDao.findById(leoUtil.ConvertCellToStr(ros.getCell(0)));
					if (tuser != null) {
						userDao.update(tuser);
					} else {
						// 还要做的工作，判断是否有数据，判断添加的信息是否unique（要求unique的），验证格式是否符合，
						logger.info("调用user的set方法");
						// user.setId()不需要，uesrService.reg(user) 后台自动添加了。
						user.setSid(leoUtil.ConvertCellToStr(ros.getCell(0))); // 学号
						user.setName(leoUtil.ConvertCellToStr(ros.getCell(1)));// 姓名
						user.setPwd(leoUtil.ConvertCellToStr(ros.getCell(2)));// 密码
						// logger.info(ros.getCell(3));
						// logger.info(leoUtil.ConvertCellToDate(ros.getCell(3)));
						// logger.info(ros.getCell(4));
						userService.add(user);
					}
					logger.info("调用user的reg()");
				}
			} catch (InvalidFormatException e) {
				logger.error(e.getMessage(), e);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			} finally {
				logger.info("importUserExcel() into finally");
				if (fileStream != null) {
					try {
						fileStream.close();
					} catch (IOException e) {
						logger.error(e.getMessage(), e);
					}
				} else {
					logger.info("空Excel表");
				}
			}
		} else {
			logger.info("不是excel文件");
		}
	}

	@Override
	public void exportUserModela(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/msexcel;charset=GBK");
		String title = "用户Excel表模版";
		String[] hearders = new String[] { "学号-----", "姓名-----", "密码-----", "角色-----" };// 表头数组
		String[] fields = new String[] { "sid", "name", "pwd", "role" };// People对象属性数组
		TableData td = ExcelUtils.createTableData(null, ExcelUtils.createTableHeader(hearders), fields);
		JsGridReportBase report;
		try {
			report = new JsGridReportBase(request, response);
			report.exportToExcel(title, "admin", td);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public void exportUserToExcela(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/msexcel;charset=GBK");

		// List<Tuser> list = getBeanData();//获取数据
		List<Tuser> list = userDao.find("select * from tuser");
		List<User> lUsers = new ArrayList<User>();
		if (list != null) {
			for (Tuser t : list) {
				User u = new User();
				BeanUtils.copyProperties(t, u, new String[] { "id" });
				lUsers.add(u);
			}
		}

		// System.out.print(list.size());
		String title = "用户数据Excel表";
		String[] hearders = new String[] { "编号-----", "学号-----", "姓名-----", "密码",  "创建时间-----", "修改时间-----", "角色-----" };// 表头数组
		String[] fields = new String[] { "id", "sid", "name", "pwd", "createtime", "modifytime", "role" };// People对象属性数组
		TableData td = ExcelUtils.createTableData(lUsers, ExcelUtils.createTableHeader(hearders), fields);
		JsGridReportBase report;
		try {
			report = new JsGridReportBase(request, response);
			report.exportToExcel(title, "admin", td);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	@Override
	public void exportRegisterModel(HttpServletRequest request, HttpServletResponse response) {
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.getSessionInfoName());
		String hrName = sessionInfo.getName();

		response.setContentType("application/msexcel;charset=GBK");
		String title = "学生Excel表模版";
		String[] hearders = new String[] { "学号----", "姓名----", "性别", "专业----------", "手机号----",
				"qq----------", "部门意向------", "特长------------------------------" };// 表头数组
		String[] fields = new String[] { "sid", "name", "sex", "major", "phone", "qq", "departments",
				"speciality" };
		TableData td = ExcelUtils.createTableData(null, ExcelUtils.createTableHeader(hearders), fields);
		JsGridReportBase report;
		try {
			report = new JsGridReportBase(request, response);
			report.exportToExcel(title, hrName, td);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	@Override
	public void exportRegisterToExcel(HttpServletRequest request, HttpServletResponse response) {

		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.getSessionInfoName());
		String hrName = sessionInfo.getName();

		response.setContentType("application/msexcel;charset=GBK");
		// List<Tuser> list = getBeanData();//获取数据
		List<Tregister> tregs = registerDao.find("select * from tregister");
		List<Register> regs = new ArrayList<Register>();
		if (tregs != null) {
			for (Tregister t : tregs) {
				Register r = new Register();
				BeanUtils.copyProperties(t, r, new String[] { "id","speciality" });
				r.setSpeciality(ClobUtil.getString(t.getSpeciality()));
				regs.add(r);
			}
		}

		String title = "新生Excel表";
		String[] hearders = new String[] { "学号----", "姓名----", "性别", "专业----------", "手机号----",
				"qq----------", "部门意向------", "特长------------------------------" };// 表头数组
		String[] fields = new String[] { "sid", "name", "sex", "major", "phone", "qq", "departments", "speciality" };
		TableData td = ExcelUtils.createTableData(regs, ExcelUtils.createTableHeader(hearders), fields);
		JsGridReportBase report;
		try {
			report = new JsGridReportBase(request, response);
			report.exportToExcel(title, hrName, td);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	@Override
	public void importRegisterExcel(File file) throws Exception {
		// TODO Auto-generated method stub

	}
}
