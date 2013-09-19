package nupterp.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import nupterp.dao.ResourceDaoI;
import nupterp.dao.UserDaoI;
import nupterp.model.Tresource;
import nupterp.model.Tuser;
import nupterp.service.InitServiceI;

import org.springframework.stereotype.Service;

@Service
public class InitServiceImpl implements InitServiceI {

	@Resource
	private UserDaoI userDao;

	@Resource
	private ResourceDaoI resourceDao;

	@Override
	synchronized public void init() {
		initResource();// 初始化资源
		initUser();// 初始化用户
	}

	private void initResource() {
		Tresource sy = new Tresource();
		sy.setId("0");
		sy.setIcon("icon-tip");
		sy.setName("首页");
		sy.setSeq(1);
		resourceDao.saveOrUpdate(sy);
		
		Tresource xtgl = new Tresource();
		xtgl.setId("xtgl");
		xtgl.setName("系统管理");
		xtgl.setSeq(1);
		xtgl.setIcon("icon-sum");
		xtgl.setPid("0");
		resourceDao.saveOrUpdate(xtgl);

		Tresource yhgl = new Tresource();
		yhgl.setId("yhgl");
		yhgl.setName("用户管理");
		yhgl.setSeq(2);
		yhgl.setIcon("icon-print");
		yhgl.setUrl("/userController/manager");
		yhgl.setPid("0");
		resourceDao.saveOrUpdate(yhgl);
		
		Tresource hrgl = new Tresource();
		hrgl.setId("hrgl");
		hrgl.setName("HR管理");
		hrgl.setIcon("icon-blank");
		hrgl.setSeq(3);
		hrgl.setPid("0");
		resourceDao.saveOrUpdate(hrgl);
		
		Tresource xsgl = new Tresource();
		xsgl.setId("xsgl");
		xsgl.setName("新生管理");
		xsgl.setSeq(1);
		xsgl.setUrl("/registerController/manager");
		xsgl.setPid("hrgl");
		resourceDao.saveOrUpdate(xsgl);
		
		Tresource xszldrdc = new Tresource();
		xszldrdc.setId("xszldrdc");
		xszldrdc.setName("新生资料导入导出");
		xszldrdc.setSeq(2);
		xszldrdc.setUrl("/registerController/regIO");
		xszldrdc.setPid("hrgl");
		resourceDao.saveOrUpdate(xszldrdc);

	}

	private void initUser() {
		Tuser t = userDao.findById("0");
		if (t != null ) {
			userDao.delete(t.getId());
		}

		Tuser admin = new Tuser();
		admin.setId("0");
		admin.setSid("0");
		admin.setName("admin");
		admin.setPwd("admin");
		admin.setCreatetime(new Date());
		admin.setRole("admin");
		userDao.saveOrUpdate(admin);

		Tuser guest = new Tuser();
		guest.setId("guest");
		guest.setSid("guest");
		guest.setName("guest");
		guest.setPwd("123456");
		guest.setCreatetime(new Date());
		guest.setRole("guest");
		userDao.saveOrUpdate(guest);
	}
}
