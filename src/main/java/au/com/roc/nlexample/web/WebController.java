package au.com.roc.nlexample.web;

import java.util.List;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import au.com.roc.nlexample.entity.BorrowRecord;
import au.com.roc.nlexample.service.BorrowerService;

/**
 * Web Controller
 * 
 * @author Roc 29/04/2016
 */
@Controller
public class WebController {

	@Autowired
	private BorrowerService borrowerService;

	
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		model.put("borrowers", borrowerService.getAllBorrower());

		return "index";
	}

	@RequestMapping(value = "/record/{borrowerID}", method = RequestMethod.GET)
	@ResponseBody
	public List<BorrowRecord> getBorrowRecords(@PathVariable("borrowerID") int borrowerID) {

		List<BorrowRecord> borrowRecords = borrowerService.getBorrowRecords(borrowerID);

		return borrowRecords;

	}

}