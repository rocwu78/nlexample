package au.com.roc.nlexample.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import au.com.roc.nlexample.entity.BorrowRecord;
import au.com.roc.nlexample.spring.SpringJPAConfig;

/**
 * Test for BorrowRecordDAO
 * 
 * @author Roc 30/04/2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringJPAConfig.class })
@Transactional
public class BorrowRecordDAOTest {

	@Autowired
	private BorrowRecordDAO borrowRecordDAO;

	@Test
	public void testFindBorrowRecordsForBorrower() {
		 List<BorrowRecord> borrowRecordsForBorrower = borrowRecordDAO.findBorrowRecordsForBorrower(5);

		Assert.assertEquals(2, borrowRecordsForBorrower.size());
		Assert.assertEquals("The C Programming Language", borrowRecordsForBorrower.get(0).getBook().getTitle());
		Assert.assertEquals("Design Patterns: Elements of Reusable Object-Oriented Software", borrowRecordsForBorrower.get(1).getBook().getTitle());
	}

}
