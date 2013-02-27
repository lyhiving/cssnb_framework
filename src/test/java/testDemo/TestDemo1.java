package testDemo;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cssnb.nbzj.dao.TblmembersMapper;
import com.cssnb.nbzj.entity.Tblmembers;




public class TestDemo1 {
	private static ApplicationContext context;
	
//	private  static AccountMapper mapper;
	private  static TblmembersMapper mapper;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
		mapper = (TblmembersMapper)context.getBean("tblmembersMapper");
		System.out.println(mapper);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Test
	public void test(){
		List<Tblmembers> list=mapper.selectAll1();
		System.out.println(list.size());
	}
}

