package com.smallworld;


import java.util.ArrayList;
import java.util.Objects;

public class Transaction {
    private Integer mtn;
    private Double amount;
    private String senderFullName;
    private Integer senderAge;
    private String beneficiaryFullName;
    private Integer beneficiaryAge;
    private Integer issueId;
    private Boolean issueSolved;
    private String issueMessage;

    private static ArrayList<Transaction> transactions;

    @Override
    public String toString() {
        return "Transaction{" +
                "mtn=" + mtn +
                ", amount=" + amount +
                ", senderFullName='" + senderFullName + '\'' +
                ", senderAge=" + senderAge +
                ", beneficiaryFullName='" + beneficiaryFullName + '\'' +
                ", beneficiaryAge=" + beneficiaryAge +
                ", issueId=" + issueId +
                ", issueSolved=" + issueSolved +
                ", issueMessage='" + issueMessage + '\'' +
                '}';
    }


    public Integer getMtn() {
        return mtn;
    }

    public void setMtn(Integer mtn) {
        this.mtn = mtn;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSenderFullName() {
        return senderFullName;
    }

    public void setSenderFullName(String senderFullName) {
        this.senderFullName = senderFullName;
    }

    public Integer getSenderAge() {
        return senderAge;
    }

    public void setSenderAge(Integer senderAge) {
        this.senderAge = senderAge;
    }

    public String getBeneficiaryFullName() {
        return beneficiaryFullName;
    }

    public void setBeneficiaryFullName(String beneficiaryFullName) {
        this.beneficiaryFullName = beneficiaryFullName;
    }

    public Integer getBeneficiaryAge() {
        return beneficiaryAge;
    }

    public void setBeneficiaryAge(Integer beneficiaryAge) {
        this.beneficiaryAge = beneficiaryAge;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public Boolean isIssueSolved() {
        return issueSolved;
    }

    public void setIssueSolved(Boolean issueSolved) {
        this.issueSolved = issueSolved;
    }

    public String getIssueMessage() {
        return issueMessage;
    }

    public void setIssueMessage(String issueMessage) {
        this.issueMessage = issueMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;
        return mtn.equals(that.mtn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mtn);
    }


}
