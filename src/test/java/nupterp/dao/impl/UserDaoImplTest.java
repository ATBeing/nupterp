//package nupterp.dao.impl;
//
//import org.apache.log4j.Logger;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//import java.util.UUID;
//
//import javax.annotation.Resource;
//
//import nupterp.dao.UserDaoI;
//import nupterp.model.Tuser;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-dhcp.xml" })
//@Transactional
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//public class UserDaoImplTest {
//	/**
//	 * Logger for this class
//	 */
//	private static final Logger logger = Logger.getLogger(UserDaoImplTest.class);
//
//	@Resource
//	private UserDaoI userDao;
//
//	@Test
//	public void testSave() {
//		Tuser t  = new Tuser();
//		String uuid = UUID.randomUUID().toString();
//		t.setId(uuid);
//		t.setSid(uuid);
//		t.setName(uuid);
//		t.setPwd(uuid);
//		try {
//			userDao.save(t);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testSaveOrUpdate() {
//		Tuser t = new Tuser();
//		t.setId("1111");
//		t.setName("111111");
//		t.setSid("1111111111");
//		t.setPwd("1");
//		try {
//			userDao.saveOrUpdate(t);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	@Test
//	public void testFindAll() {
//		List<Tuser> list = userDao.findAll();
//		for(Tuser t:list){
//			logger.info(t.getName());
//		}
//	}
//
//	@Test
//	public void testFindStringMapOfStringObject() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindStringMapOfStringObjectIntInt() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCountStringMapOfStringObject() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testFindById(){
////		Tuser t = new Tuser();
////		String _2 = "2";
////		t.setId(_2);
////		t.setName(_2);
////		t.setPwd(_2);
////		t.setSid(_2);
//		try {
//			Tuser tuser = userDao.findById("1111111");
//			logger.info("-------------"+tuser);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testCheckTuserSidExits(){
//	//	t.setName("11111");
//	//	t.setSid("1111");
//	//	t.setPwd("1");
//		try {
//			boolean i = userDao.checkTuserSidExits("111");
//			logger.info("-----------------"+i);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testUpdate(){
//		Tuser t  = new Tuser();
//		t.setId("111");
//		t.setSid("11111111111");
//		t.setName("1");
//		t.setPwd("222");
//		try {
//			userDao.update(t);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	@Rollback(true)
//	public void testDelete(){
//		try {
//			userDao.delete("111");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testFind(){
//		String sql = "SELECT id,name,pwd,sid,createtime,modifytime,role FROM tuser LIMIT ?,?";
//		Object[] objects = new Object[]{0,10};
//		try {
//			List<Tuser> list = userDao.find(sql, objects);
//			if(list!=null){
//				for(Tuser t:list){
//					logger.info(t.getName());
//				}
//			}else {
//				logger.info("---------------");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testCount(){
//		String sql = "SELECT count(1) FROM tuser WHERE name=? LIMIT ?,?";
//		Object[] objects = new Object[]{"11",0,10};
//		try {
//			Long l = userDao.count(sql, objects);
//			logger.info(l);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
