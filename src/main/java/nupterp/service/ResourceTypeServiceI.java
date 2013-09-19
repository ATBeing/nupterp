package nupterp.service;

import java.util.List;

import nupterp.pageModel.ResourceType;

/**
 * 资源类型服务
 * 
 */
public interface ResourceTypeServiceI {

	/**
	 * 获取资源类型
	 * 
	 * @return
	 */
	public List<ResourceType> getResourceTypeList();

}
