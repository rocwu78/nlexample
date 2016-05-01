package au.com.roc.nlexample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import au.com.roc.nlexample.entity.BorrowRecord;
import au.com.roc.nlexample.spring.DAO;


/**
 * Access the BorrowerRecord table
 * 
 * @author Roc 29/04/2016
 */
@DAO
public class BorrowRecordDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    public BorrowRecord fetch(int id)
    {
        return entityManager.find(BorrowRecord.class, id);
    }

    public List<BorrowRecord> findBorrowRecordsForBorrower(int borrowerID)
    {
        Query query = entityManager.createQuery("from BorrowRecord where borrowerID = :borrowerID ");
        query.setParameter("borrowerID", borrowerID);
        @SuppressWarnings("unchecked")
        List<BorrowRecord> records = query.getResultList();
        return records;
    }
}
