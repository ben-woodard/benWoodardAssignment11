package com.codercampus.Assignment11.web;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transService;

    @GetMapping("/transactions")
    public String displayTransactions(ModelMap model){
      List<Transaction> transactions = transService.sortTransactionsByDate();
      model.put("transactions", transactions);
      for(Transaction transaction : transactions){
          Transaction savedTransaction = transService.save(transaction);
          model.put("savedTransaction", savedTransaction);
      }
        return"transactions";
    }
}
