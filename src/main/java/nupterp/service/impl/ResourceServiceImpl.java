package nupterp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nupterp.dao.ResourceDaoI;
import nupterp.model.Tresource;
import nupterp.pageModel.Resource;
import nupterp.pageModel.SessionInfo;
import nupterp.pageModel.Tree;
import nupterp.service.ResourceServiceI;

@Service
public class ResourceServiceImpl implements ResourceServiceI {

	private ResourceDaoI resourceDao;

	public ResourceDaoI getResourceDao() {
		return resourceDao;
	}

	@Autowired
	public void setResourceDao(ResourceDaoI resourceDao) {
		this.resourceDao = resourceDao;
	}

	@Override
	public List<Tree> tree(SessionInfo sessionInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tree> allTree(SessionInfo sessionInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> treeGrid(SessionInfo sessionInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Resource resource, SessionInfo sessionInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(Resource resource) {
		// TODO Auto-generated method stub

	}

	@Override
	public Resource get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tree> getTreeNode() {
		List<Tresource> tList = new ArrayList<Tresource>();
		List<Tree> trees = new ArrayList<Tree>();
		String sql = null;

		sql = "select * from tresource ";
		tList = resourceDao.find(sql);

		if (tList != null && tList.size() > 0) {
			for (Tresource r : tList) {
				Tree tree = new Tree();
				BeanUtils.copyProperties(r, tree);

				tree.setText(r.getName());
				tree.setIconCls(r.getIcon());
				Map<String, Object> attr = new HashMap<String, Object>();
				attr.put("url", r.getUrl());
				tree.setAttributes(attr);
				trees.add(tree);
			}
			return trees;
		}
		return null;
	}

}
