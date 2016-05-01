package au.com.roc.nlexample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import au.com.roc.nlexample.entity.Borrower;
import au.com.roc.nlexample.spring.DAO;


/**
 * Access the Borrower table
 * 
 * @author Roc 29/04/2016
 */
@DAO
public class BorrowerDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    public Borrower fetch(int id)
    {
        return entityManager.find(Borrower.class, id);
    }

    public List<Borrower> findAllBorrowers()
    {
        Query query = entityManager.createQuery("from Borrower");
        @SuppressWarnings("unchecked")
        List<Borrower> borrowers = query.getResultList();
        return borrowers;
    }
}
