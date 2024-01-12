package com.codercampus.Assignment11.web;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transService;

    @GetMapping("/transactions")
    public String getTransactions(ModelMap model) {
        List<Transaction> transactions = transService.sortTransactionsByDate();
        model.put("transactions", transactions);
        System.out.println(transactions);
        return "transactions";
    }

    @GetMapping("/transactions/{transactionId}")
    public String getTransactionById(@PathVariable Integer transactionId, ModelMap model) {
        transService.findById(transactionId);
        model.put("transactionId", transactionId);
        return "transactions";
    }
}
