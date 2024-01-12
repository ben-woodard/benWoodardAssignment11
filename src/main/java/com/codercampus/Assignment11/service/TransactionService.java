package com.codercampus.Assignment11.service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transRepo;

    public List<Transaction> findAll() {
       return transRepo.findAll();
    }

    public List<Transaction> sortTransactionsByDate () {
      return transRepo.findAll().stream()
               .sorted(Comparator.comparing(transaction -> transaction.getDate()))
               .collect(Collectors.toList());
    }
}