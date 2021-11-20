package com.sl.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

abstract class Account {
    public abstract float getBalance();
}

class DepositeAccount extends Account {
    private String accountNo;
    private float accountBalance;

    public DepositeAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance() {
        return accountBalance;
    }

}

class SavingAccount extends Account {
    private String accountNo;
    private float accountBalance;

    public SavingAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance() {
        return accountBalance;
    }
}

class CompositeAccount extends Account {
    private float totalBalance;
    private List<Account> accountList = new ArrayList<Account>();

    public float getBalance() {
        totalBalance = 0;
        for (Account f : accountList) {
            totalBalance = totalBalance + f.getBalance();
        }
        return totalBalance;
    }

    public void addAccount(Account acc) {
        accountList.add(acc);
    }

    public void removeAccount(Account acc) {
        accountList.add(acc);
    }
}

/*
Composite Design pattern - Properties

- Structural design pattern
- Composite lets client treat individual objects (Leaf) and compositions
  of objects (Composite) uniformly
- Four Participangs : Component, Leaf (folha), Composite, Client
- If object is Leaf node, request is handled directly, If object is
  Composite, it forward request to child, so some operation & combine
  operations

  * Implementation

  - Component: Account class, which contains common method
  - Leaf: DepositeAccount & SavingAccount
  - Composite: Composite Account
  - Client: Client class

  - We'll get balance of all account for a Person

 */
public class Composite {


    public static void main(String[] args) {

        // Example clients account

        CompositeAccount component = new CompositeAccount();

        component.addAccount(new DepositeAccount("DA001", 100));
        component.addAccount(new DepositeAccount("DA002", 150));
        component.addAccount(new SavingAccount("SA001", 200));

        float totalBalance = component.getBalance();
        System.out.println("Total Balance : " + totalBalance);

    }
}
