package com.smallworld;

import java.util.*;
import java.util.stream.Collectors;

public class TransactionDataFetcher {

    TransactionLoader transactionLoader;
    public static TransactionDataFetcher instance;

    private TransactionDataFetcher(TransactionLoader transactionLoader) {
        this.transactionLoader = transactionLoader;
    }

    public static TransactionDataFetcher getInstance(TransactionLoader transactionLoader){
        if (instance == null) {
            instance = new TransactionDataFetcher(transactionLoader);
        }
        return instance;
    }

    /**
     * Returns the sum of the amounts of all transactions
     */
    public double getTotalTransactionAmount() {
        return transactionLoader.getTransactions().stream()
                .distinct()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    /**
     * Returns the sum of the amounts of all transactions sent by the specified client
     */
    public double getTotalTransactionAmountSentBy(String senderFullName) {
        return transactionLoader.getTransactions().stream()
                .filter(transaction -> transaction.getSenderFullName().equals(senderFullName))
                .distinct()
                .mapToDouble(transaction -> transaction.getAmount())
                .sum();
    }

    /**
     * Returns the highest transaction amount
     */
    public double getMaxTransactionAmount() {
        return transactionLoader.getTransactions().stream()
                .mapToDouble(Transaction::getAmount)
                .max().getAsDouble();

    }

    /**
     * Counts the number of unique clients that sent or received a transaction
     */
    public long countUniqueClients() {
        Set<String> uniqueClients = new HashSet<>();

        for (Transaction transaction : transactionLoader.getTransactions()) {
            String sender = transaction.getSenderFullName();
            String beneficiary = transaction.getBeneficiaryFullName();

            // Create a unique identifier for the combination of sender and beneficiary
            String combination = sender + "-" + beneficiary;

            // Add the combination to the set
            uniqueClients.add(combination);
        }

        // Return the count of unique combinations
        return uniqueClients.size();
    }

    /**
     * Returns whether a client (sender or beneficiary) has at least one transaction with a compliance
     * issue that has not been solved
     */
    public boolean hasOpenComplianceIssues(String clientFullName) {
        return transactionLoader.getTransactions().stream()
                .anyMatch(transaction ->
                        (clientFullName.equals(transaction.getSenderFullName()) || clientFullName.equals(transaction.getBeneficiaryFullName()))
                                && transaction.getIssueId() != null
                                && !transaction.isIssueSolved());
    }

    /**
     * Returns all transactions indexed by beneficiary name
     */
    public Map<String, Transaction> getTransactionsByBeneficiaryName() {
        return transactionLoader.getTransactions().stream()
                .distinct()
                .collect(Collectors.toMap(Transaction::getBeneficiaryFullName, transaction -> transaction));
    }

    /**
     * Returns the identifiers of all open compliance issues
     */
    public Set<Integer> getUnsolvedIssueIds() {
        return transactionLoader.getTransactions().stream()
                .filter(transaction -> !transaction.isIssueSolved())
                .map(Transaction::getIssueId)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a list of all solved issue messages
     */
    public List<String> getAllSolvedIssueMessages() {
        return transactionLoader.getTransactions().stream()
                .filter(transaction -> transaction.getIssueMessage() != null)
                .filter(Transaction::isIssueSolved)
                .map(Transaction::getIssueMessage).toList();
    }

    /**
     * Returns the 3 transactions with highest amount sorted by amount descending
     */
    public List<Transaction> getTop3TransactionsByAmount() {
        return transactionLoader.getTransactions().stream()
                .distinct()
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .limit(3)
                .toList();
    }

    /**
     * Returns the sender with the most total sent amount
     */
    public Optional<String> getTopSender() {
        Map<String, Double> senderTotalAmountMap = transactionLoader.getTransactions().stream()
                .distinct()
                .collect(Collectors.groupingBy(Transaction::getSenderFullName,
                        Collectors.summingDouble(Transaction::getAmount)));

        return senderTotalAmountMap.entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey);
    }

}
