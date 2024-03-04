package model;

public class Account {
    private int AccountId;
    private String branch;
    private int balance;


    public Account(int AccountId, String branch, int balance) {
        this.setAccountId(AccountId);
        this.setBranch(branch);
        this.setBalance(balance);

    }

    public Account() {

    }


    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int accountId) {
        AccountId = accountId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
