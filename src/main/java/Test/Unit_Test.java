package Test;

import com.smallworld.Transaction;
import com.smallworld.TransactionDataFetcher;
import com.smallworld.TransactionLoader;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;


public class Unit_Test extends TestCase {

    TransactionLoader transactionLoader = TransactionLoader.getInstance();
    TransactionDataFetcher dataFetcher = TransactionDataFetcher.getInstance(transactionLoader);

    @BeforeClass
    public void setUp(){
        transactionLoader.initialize("transactions.json");
    }

    @Test
    public void testGetTotalTransactionAmount() {
        double totalAmount = dataFetcher.getTotalTransactionAmount();
        assertEquals(2889.17, totalAmount);
    }

    @Test
    public void testGetTotalTransactionAmountSentBy() {
        double totalAmount = dataFetcher.getTotalTransactionAmountSentBy("Tom Shelby");
        assertEquals(678.06, totalAmount);
    }

    @Test
    public void testGetMaxTransactionAmount() {
        double maxAmount = dataFetcher.getMaxTransactionAmount();
        assertEquals(985.0, maxAmount);
    }

    @Test
    public void testCountUniqueClients() {
        long uniqueClients = dataFetcher.countUniqueClients();
        assertEquals(10, uniqueClients);
    }

    @Test
    public void testHasOpenComplianceIssues() {
        assertTrue(dataFetcher.hasOpenComplianceIssues("Tom Shelby"));
        assertFalse(dataFetcher.hasOpenComplianceIssues("Winston Churchill"));
    }

    @Test
    public void testGetTransactionsByBeneficiaryName() {
        Map<String, Transaction> transactionsByBeneficiary = dataFetcher.getTransactionsByBeneficiaryName();
        Map<String, Transaction> expected = ExpectedData.getExpectedTransactionsByBeneficiaryName();
        assertEquals(expected, transactionsByBeneficiary);
    }

    @Test
    public void testGetUnsolvedIssueIds() {
        Set<Integer> unsolvedIssueIds = dataFetcher.getUnsolvedIssueIds();
        Set<Integer> expected = Set.of(1, 3, 99, 54, 15);
        assertEquals(expected, unsolvedIssueIds);
    }

    @Test
    public void testGetAllSolvedIssueMessages() {
        List<String> solvedIssueMessages = dataFetcher.getAllSolvedIssueMessages();
        List<String> expected = List.of("Never gonna give you up","Never gonna let you down","Never gonna run around and desert you");
        assertEquals(expected, solvedIssueMessages);
    }

    @Test
    public void testGetTop3TransactionsByAmount() {
        List<Transaction> top3Transactions = dataFetcher.getTop3TransactionsByAmount();
        List<Transaction> expected = ExpectedData.getExpectedTop3Transactions();;
        assertEquals(expected, top3Transactions);
    }

    @Test
    public void testGetTopSender() {
        Optional<String> topSender = dataFetcher.getTopSender();
        assertTrue(topSender.isPresent());
        assertEquals("Arthur Shelby", topSender.get());
    }
}

