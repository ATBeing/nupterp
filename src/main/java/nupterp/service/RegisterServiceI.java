package nupterp.service;

import nupterp.pageModel.DataGrid;
import nupterp.pageModel.PageHelper;
import nupterp.pageModel.Register;

public interface RegisterServiceI {

	public DataGrid dataGrid(Register register, PageHelper ph);
	
	public void add(Register register) throws Exception;
	
	public Register get(String id);
	
	public void edit(Register register) throws Exception;
	
	public void delete(String id);
}
