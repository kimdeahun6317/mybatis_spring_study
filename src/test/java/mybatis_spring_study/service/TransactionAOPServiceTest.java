package mybatis_spring_study.service;

import static org.junit.Assert.fail;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mybatis_spring_study.config.ContextRoot;
import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionAOPServiceTest {
	private static final Log log = LogFactory.getLog(TransactionAOPServiceTest.class);

	@Autowired
	private TransactionAOPService service;

	@After
	public void testDown() throws Exception {
		System.out.println();
	}

	@Test(expected = DuplicateKeyException.class)
	public void test1TrRegister_Dept_Fail() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(1, "달나라", 77);
		Employee employee = new Employee(1008, "김새론", "과장", new Employee(4377), 4000000, new Department(1));
		service.trRegister(department, employee);
	}

	@Test(expected = DuplicateKeyException.class)
	public void test2TrRegister_Employee_Fail() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(7, "달나라", 77);
		Employee employee = new Employee(4377, "김새론", "과장", new Employee(4377), 4000000, new Department(1));
		service.trRegister(department, employee);
	}

	@Test
	public void test3TrRegister() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(7, "달나라", 77);
		Employee employee = new Employee(1008, "김새론", "과장", new Employee(4377), 4000000, new Department(1));
		service.trRegister(department, employee);
	}

	@Test(expected = RuntimeException.class)
	public void test4TrUnRegister_Dept_Fail() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(100);
		Employee employee = new Employee(1008);
		service.trUnRegister(department, employee);
	}

	@Test(expected = RuntimeException.class)
	public void test5TrUnRegister_Employee_Fail() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(7);
		Employee employee = new Employee(9999);
		service.trUnRegister(department, employee);
	}
	
	@Test
	public void test6TrUnRegister() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(7);
		Employee employee = new Employee(1008);
		service.trUnRegister(department, employee);
	}

}
