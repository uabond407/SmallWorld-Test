package com.smallworld;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TransactionLoader {

    private static TransactionLoader instance;

    private static ArrayList<Transaction> transactions;

    private TransactionLoader() {

    }

    //This class is used to load data from JSON
    public void initialize(String fileName){
        loadTransactionData(fileName);
    }

    public static TransactionLoader getInstance() {

        if (instance == null) {
            instance = new TransactionLoader();
        }
        return instance;
    }
    private static void loadTransactionData(String fileName) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            transactions = objectMapper.readValue(new File(fileName).getAbsoluteFile(),
                    objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Transaction.class));

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

}
