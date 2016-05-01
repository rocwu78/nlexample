package au.com.roc.nlexample.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import au.com.roc.nlexample.entity.Borrower;
import au.com.roc.nlexample.spring.SpringJPAConfig;

/**
 * Test for BorrowerDAO
 * 
 * @author Roc 30/04/2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringJPAConfig.class })
@Transactional
public class BorrowerDAOTest {

	@Autowired
	private BorrowerDAO borrowerDAO;

	@Test
	public void testFindAllBorrowers() {
		List<Borrower> allBorrowers = borrowerDAO.findAllBorrowers();

		Assert.assertEquals(5, allBorrowers.size());
		Assert.assertEquals("Xavier Winston", allBorrowers.get(0).getName());
		Assert.assertEquals("Jaiden Woodcock", allBorrowers.get(4).getName());
	}

}
