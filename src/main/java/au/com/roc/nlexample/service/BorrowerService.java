package au.com.roc.nlexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.roc.nlexample.dao.BorrowRecordDAO;
import au.com.roc.nlexample.dao.BorrowerDAO;
import au.com.roc.nlexample.entity.BorrowRecord;
import au.com.roc.nlexample.entity.Borrower;

/**
 * provides services about borrower and borrow records
 * 
 * @author Roc 29/04/2016
 */
@Service
public class BorrowerService {
	@Autowired
	private BorrowerDAO borrowerDAO;

	@Autowired
	private BorrowRecordDAO borrowRecordDAO;

	public List<Borrower> getAllBorrower() {
		return borrowerDAO.findAllBorrowers();
	}

	public List<BorrowRecord> getBorrowRecords(int borrowerID) {
		return borrowRecordDAO.findBorrowRecordsForBorrower(borrowerID);

	}

}