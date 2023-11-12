package com.smallworld;



public class Main {
    public static void main(String[] args) {

        TransactionLoader transactionLoader = TransactionLoader.getInstance();
        transactionLoader.initialize("transactions.json");
        TransactionDataFetcher transactionDataFetcher = TransactionDataFetcher.getInstance(transactionLoader);

        System.out.println("Total transaction amount: " + transactionDataFetcher.getTotalTransactionAmount());
        System.out.println();
        System.out.println("Total amount sent by Tom Shelby: " + transactionDataFetcher.getTotalTransactionAmountSentBy("Tom Shelby"));
        System.out.println();
        System.out.println("Max transaction amount: " + transactionDataFetcher.getMaxTransactionAmount());
        System.out.println();
        System.out.println("Count of unique clients: " + transactionDataFetcher.countUniqueClients());
        System.out.println();
        System.out.println("Has Open Compliance Issues:" + transactionDataFetcher.hasOpenComplianceIssues("Billy Kimber"));
        System.out.println();
        System.out.println("Transaction indexed by beneficiary name: " + transactionDataFetcher.getTransactionsByBeneficiaryName().toString());
        System.out.println();
        System.out.println("Unsolved Issue IDs: " + transactionDataFetcher.getUnsolvedIssueIds());
        System.out.println();
        System.out.println("Solved Issue messages: " + transactionDataFetcher.getAllSolvedIssueMessages());
        System.out.println();
        System.out.println("Top 3 transactons by amount: " + transactionDataFetcher.getTop3TransactionsByAmount());
        System.out.println();
        System.out.println("Top sender" + transactionDataFetcher.getTopSender());

    }
}