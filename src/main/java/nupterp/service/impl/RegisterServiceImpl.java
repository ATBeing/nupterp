package nupterp.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import nupterp.dao.RegisterDaoI;
import nupterp.model.Tregister;
import nupterp.pageModel.DataGrid;
import nupterp.pageModel.PageHelper;
import nupterp.pageModel.Register;
import nupterp.service.RegisterServiceI;
import nupterp.util.ClobUtil;

@Service
public class RegisterServiceImpl implements RegisterServiceI {

	private RegisterDaoI registerDao;

	public RegisterDaoI getRegisterDao() {
		return registerDao;
	}

	@Resource
	public void setRegisterDao(RegisterDaoI registerDao) {
		this.registerDao = registerDao;
	}

	@Override
	public DataGrid dataGrid(Register register, PageHelper ph) {
		DataGrid dg = new DataGrid();
		List<Tregister> tList = new ArrayList<Tregister>();
		List<Register> rList = new ArrayList<Register>();
		String sql = "select * from tregister t ";
		if (register != null) {
			sql = sql + whereHql(register) + orderHql(ph) + " LIMIT ?,?";
			if (register.getName() != null) {
				tList = registerDao.find(sql, "%%" + register.getName() + "%%", (ph.getPage() - 1),
						ph.getRows());
				dg.setTotal(registerDao.count("select count(*) FROM tuser" + whereHql(register), "%%"
						+ register.getName() + "%%"));
			} else {
				tList = registerDao.find(sql, (ph.getPage() - 1), ph.getRows());
				dg.setTotal(registerDao.count("select count(*) FROM tuser" + whereHql(register)));
			}
		} else {
			sql = sql + orderHql(ph) + " LIMIT ?,?";
			tList = registerDao.find(sql, (ph.getPage() - 1), ph.getRows());
			dg.setTotal(registerDao.count("select count(*) From tuser"));
		}
		if (tList != null && tList.size() > 0) {
			for (Tregister t : tList) {
				Register r = new Register();
				BeanUtils.copyProperties(t, r,new String []{"speciality"});
				r.setSpeciality(ClobUtil.getString(t.getSpeciality()));
				rList.add(r);
			}
			dg.setRows(rList);
			return dg;
		} else {
			return null;
		}

	}

	private String orderHql(PageHelper ph) {
		String orderString = "";
		if (ph.getSort() != null && ph.getOrder() != null) {
			orderString = " order by t." + ph.getSort() + " " + ph.getOrder();
		}
		return orderString;
	}

	private String whereHql(Register register) {
		String hql = "";
		if (register != null) {
			hql += " where 1=1 ";
			if (register.getName() != null) {
				hql += " and name like ?";
			}
		}
		return hql;
	}

	@Override
	public void add(Register register) throws Exception {
		if (registerDao.count("select count(1) from tregister where sid = ?", register.getSid()) > 0) {
			throw new Exception("登录名已存在！");
		} else {
			Tregister t = new Tregister();
			BeanUtils.copyProperties(register, t, new String[] { "speciality" });
			if(register.getSpeciality()!=null&&!register.getSpeciality().equals("")){
				t.setSpeciality(ClobUtil.getClob(register.getSpeciality()));
			}else {
				t.setSpeciality(ClobUtil.getClob("未填"));
			}
			registerDao.save(t);
		}

	}

	@Override
	public Register get(String id) {
		Tregister t = registerDao.findById(id);
		Register r = new Register();
		BeanUtils.copyProperties(t, r,new String[]{"speciality"});
		r.setSpeciality(ClobUtil.getString(t.getSpeciality()));
		return r;
	}

	@Override
	public void edit(Register register) throws Exception {
		if (registerDao.count("select count(1) from tregister where sid = ?", register.getSid()) > 0) {
			throw new Exception("学号已存在！");
		} else {
			Tregister t = registerDao.findById(register.getId());
			BeanUtils.copyProperties(register, t,new String[]{"speciality"});
			t.setSpeciality(ClobUtil.getClob(register.getSpeciality()));
			registerDao.update(t);
		}

	}

	@Override
	public void delete(String id) {
		registerDao.delete(id);
	}

}
