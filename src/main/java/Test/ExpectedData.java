package Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smallworld.Transaction;

import java.util.List;
import java.util.Map;

public class ExpectedData {

    public static Map<String, Transaction> getExpectedTransactionsByBeneficiaryName(){

        String response = "{\"MacTavern\":{\"mtn\":6516461,\"amount\":33.22,\"senderFullName\":\"Aunt Polly\",\"senderAge\":34,\"beneficiaryFullName\":\"MacTavern\",\"beneficiaryAge\":30,\"issueId\":null,\"issueSolved\":true,\"issueMessage\":\"null\"},\"Major Campbell\":{\"mtn\":645645111,\"amount\":215.17,\"senderFullName\":\"Billy Kimber\",\"senderAge\":58,\"beneficiaryFullName\":\"Major Campbell\",\"beneficiaryAge\":41,\"issueId\":null,\"issueSolved\":true,\"issueMessage\":\"null\"},\"Luca Changretta\":{\"mtn\":45431585,\"amount\":89.77,\"senderFullName\":\"Billy Kimber\",\"senderAge\":58,\"beneficiaryFullName\":\"Luca Changretta\",\"beneficiaryAge\":46,\"issueId\":null,\"issueSolved\":true,\"issueMessage\":\"null\"},\"Ben Younger\":{\"mtn\":5465465,\"amount\":985,\"senderFullName\":\"Arthur Shelby\",\"senderAge\":60,\"beneficiaryFullName\":\"Ben Younger\",\"beneficiaryAge\":47,\"issueId\":15,\"issueSolved\":false,\"issueMessage\":\"Something's fishy\"},\"Arthur Shelby\":{\"mtn\":1284564,\"amount\":150.2,\"senderFullName\":\"Tom Shelby\",\"senderAge\":22,\"beneficiaryFullName\":\"Arthur Shelby\",\"beneficiaryAge\":60,\"issueId\":2,\"issueSolved\":true,\"issueMessage\":\"Never gonna give you up\"},\"Aberama Gold\":{\"mtn\":96132456,\"amount\":67.8,\"senderFullName\":\"Aunt Polly\",\"senderAge\":34,\"beneficiaryFullName\":\"Aberama Gold\",\"beneficiaryAge\":58,\"issueId\":null,\"issueSolved\":true,\"issueMessage\":\"null\"},\"Winston Churchill\":{\"mtn\":36448252,\"amount\":154.15,\"senderFullName\":\"Billy Kimber\",\"senderAge\":58,\"beneficiaryFullName\":\"Winston Churchill\",\"beneficiaryAge\":48,\"issueId\":null,\"issueSolved\":true,\"issueMessage\":\"null\"},\"Oswald Mosley\":{\"mtn\":1651665,\"amount\":97.66,\"senderFullName\":\"Tom Shelby\",\"senderAge\":22,\"beneficiaryFullName\":\"Oswald Mosley\",\"beneficiaryAge\":37,\"issueId\":65,\"issueSolved\":true,\"issueMessage\":\"Never gonna let you down\"},\"Michael Gray\":{\"mtn\":32612651,\"amount\":666,\"senderFullName\":\"Grace Burgess\",\"senderAge\":31,\"beneficiaryFullName\":\"Michael Gray\",\"beneficiaryAge\":58,\"issueId\":54,\"issueSolved\":false,\"issueMessage\":\"Something ain't right\"},\"Alfie Solomons\":{\"mtn\":663458,\"amount\":430.2,\"senderFullName\":\"Tom Shelby\",\"senderAge\":22,\"beneficiaryFullName\":\"Alfie Solomons\",\"beneficiaryAge\":33,\"issueId\":1,\"issueSolved\":false,\"issueMessage\":\"Looks like money laundering\"}}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(response,new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            return null;
        }
    }


    public static List<Transaction> getExpectedTop3Transactions(){
        String response = "[{\"mtn\":5465465,\"amount\":985,\"senderFullName\":\"Arthur Shelby\",\"senderAge\":60,\"beneficiaryFullName\":\"Ben Younger\",\"beneficiaryAge\":47,\"issueId\":15,\"issueSolved\":false,\"issueMessage\":\"Something's fishy\"},{\"mtn\":32612651,\"amount\":666,\"senderFullName\":\"Grace Burgess\",\"senderAge\":31,\"beneficiaryFullName\":\"Michael Gray\",\"beneficiaryAge\":58,\"issueId\":54,\"issueSolved\":false,\"issueMessage\":\"Something ain't right\"},{\"mtn\":663458,\"amount\":430.2,\"senderFullName\":\"Tom Shelby\",\"senderAge\":22,\"beneficiaryFullName\":\"Alfie Solomons\",\"beneficiaryAge\":33,\"issueId\":1,\"issueSolved\":false,\"issueMessage\":\"Looks like money laundering\"}]";
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(response,new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
