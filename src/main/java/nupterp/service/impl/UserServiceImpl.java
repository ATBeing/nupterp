package nupterp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import nupterp.dao.UserDaoI;
import nupterp.model.Tuser;
import nupterp.pageModel.DataGrid;
import nupterp.pageModel.PageHelper;
import nupterp.pageModel.SessionInfo;
import nupterp.pageModel.User;
import nupterp.service.UserServiceI;
import nupterp.util.MD5Util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceI {

	@Resource
	private UserDaoI userDao;

	@Override
	public User login(User user) {
		Tuser t = userDao.get("SELECT * from tuser where name = ? and pwd = ?", user.getName(),
				MD5Util.md5(user.getPwd()));
		if (t != null) {
			BeanUtils.copyProperties(t, user);
			return user;
		}
		return null;
	}

	@Override
	synchronized public void reg(User user) throws Exception {
		if (userDao.count("select count(1) from tuser t where name = ?", new Object[] { user.getName() }) > 0) {
			throw new Exception("登录名已存在！");
		} else {
			Tuser u = new Tuser();
			u.setId(UUID.randomUUID().toString());
			u.setName(user.getName());
			u.setPwd(MD5Util.md5(user.getPwd()));
			u.setCreatetime(new Date());
			userDao.save(u);
		}
	}

	@Override
	public DataGrid dataGrid(User user, PageHelper ph) {
		DataGrid dg = new DataGrid();
		List<User> ul = new ArrayList<User>();
		List<Tuser> l = new ArrayList<Tuser>();
		String hql = "SELECT * from tuser t ";
		if (user != null) {
			hql = hql + whereHql(user) + orderHql(ph) + " LIMIT ?,?";
			if (user.getName() != null) {
				l = userDao.find(hql, "%%"+user.getName()+"%%", (ph.getPage() - 1), ph.getRows());
				dg.setTotal(userDao.count("select count(*) FROM tuser" + whereHql(user),"%%"+ user.getName()+"%%"));
			}else {
				l = userDao.find(hql,  (ph.getPage() - 1), ph.getRows());
				dg.setTotal(userDao.count("select count(*) FROM tuser" + whereHql(user)));
			}
		} else {
			hql = hql + orderHql(ph) + " LIMIT ?,?";
			l = userDao.find(hql, ph.getSort(), ph.getOrder(), (ph.getPage() - 1), ph.getRows());
			dg.setTotal(userDao.count("select count(*) From tuser"));
		}
		if (l != null && l.size() > 0) {
			for (Tuser t : l) {
				User u = new User();
				BeanUtils.copyProperties(t, u);
				ul.add(u);
			}
			dg.setRows(ul);
			return dg;
		}else {
			return null;
		}
		
	}

	private String whereHql(User user) {
		String hql = "";
		if (user != null) {
			hql += " where 1=1 ";
			if (user.getName() != null) {
				hql += " and name like ?";
			}
		}
		return hql;
	}

	private String orderHql(PageHelper ph) {
		String orderString = "";
		if (ph.getSort() != null && ph.getOrder() != null) {
			orderString = " order by t." + ph.getSort() + " " + ph.getOrder();
		}
		return orderString;
	}

	@Override
	synchronized public void add(User user) throws Exception {
		if (userDao.count("select count(1) from tuser where name = ?", user.getName()) > 0) {
			throw new Exception("登录名已存在！");
		} else {
			Tuser u = new Tuser();
			BeanUtils.copyProperties(user, u);
			u.setCreatetime(new Date());
			u.setPwd(MD5Util.md5(user.getPwd()));
			userDao.save(u);
		}
	}

	@Override
	public User get(String id) {
		Tuser t = userDao.findById(id);
		User u = new User();
		BeanUtils.copyProperties(t, u);
		return u;
	}

	@Override
	synchronized public void edit(User user) throws Exception {
		if (userDao.count("select count(1) from tuser where name = ? and id != ?", user.getName(),
				user.getId()) > 0) {
			throw new Exception("登录名已存在！");
		} else {
			Tuser u = userDao.findById(user.getId());
			BeanUtils.copyProperties(user, u, new String[] { "pwd", "createtime" });
			u.setModifytime(new Date());
			userDao.update(u);
		}
	}

	@Override
	public void delete(String id) {
		userDao.delete(id);
	}

	@Override
	public List<String> resourceList(String id) {
		List<String> resourceList = new ArrayList<String>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Tuser t = userDao.get("select * from Tresource where id=?", params);
		if (t != null) {

		}
		return resourceList;
	}

	@Override
	public void editPwd(User user) {
		if (user != null && user.getPwd() != null && !user.getPwd().trim().equalsIgnoreCase("")) {
			Tuser u = userDao.findById(user.getId());
			u.setPwd(MD5Util.md5(user.getPwd()));
			u.setModifytime(new Date());
		}
	}

	@Override
	public boolean editCurrentUserPwd(SessionInfo sessionInfo, String oldPwd, String pwd) {
		Tuser u = userDao.findById(sessionInfo.getId());
		if (u.getPwd().equalsIgnoreCase(MD5Util.md5(oldPwd))) {// 说明原密码输入正确
			u.setPwd(MD5Util.md5(pwd));
			u.setModifytime(new Date());
			return true;
		}
		return false;
	}

}
