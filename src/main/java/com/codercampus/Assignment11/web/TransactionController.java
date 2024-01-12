package com.codercampus.Assignment11.web;

import com.codercampus.Assignment11.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transService;

    @GetMapping("/transactions")
    public String displayTransactions(){
        System.out.println(transService.sortTransactionsByDate());
        return"transactions";
    }
}
