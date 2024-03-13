# ATM System Design

this will use the Chain of responsibility design pattern and State design pattern.

- State Design Pattern
- Chain of responsibility Design pattern

## Flow

- As user come with card and goest to an ATM ,
- he insert the card in the ATM
    - Once the card ATM inserted , it will authenticate the PIN.
    - After successfull Authentication provide some options to perform operation
    - User perform one operation at a time
    - performOperation() once its completed -> again retry
    - On once return
- Ideal ATM -- card inserted --> ATM --> Authentication PIN -->OperationOption -> PerformOperation -> Ideal ATM (
  Circular)
- OperationOption
    - Cash deposit
    - cash withdrawal
    - Check Balance
    - Pin Change

- Atm has set of operation
    - InsertCard()
    - AuthenticatePIN()
    - SelectOperation ()
    - performTheParticularOperation()

- In `Ideal State` you can do only one operation that is `insertCard()`.
- As card Inserted state is changed to State is `HasCard State` , you can do `authenticatePin()`
- Suppose We have 10 operations and segregate the operations on the basis of STATE, that this state can perform only
  this set of operations.
- DeepDrive in to **Cash Withdrawal** Use case of `chain responsibility design pattern`
- 2K Note , 500 note , 100 Note. (Its always in decreasing order)
    - Here we are going to use the `chain responsibility design pattern`

-

## Requirements

## Objects

- User
- Card
- ATM
- enum TransactionType

We have four STATE

- we have one `abstract class` that is `ATMState` it has all the methods that need to perform by ATM as task.
- AtmIdealState
- HasCardState
- SelectOperationState
- CashWithdrawalState
- BalanceCheckState
- Once All the operations is done it change it to the Ideal state.

- Chain of responsibility
- CashWithdrawalProcessor
- TwoKcWProcessor extends CashWithdrawalProcessor
- OnwHcWProcessor extends CashWithdrawalProcessor
- FiveHcWProcessor extends CashWithdrawalProcessor

## LLD

```java

import java.util.concurrent.ConcurrentHashMap;

abstract class ATMState {

    public void insertCard(Atm atm, Card card) {

    }

    public void authenticatePin(Atm atm, Card card, int pin) {

    }

    public void selectOperation(Atm atm, Card card, TransactionType transactionType) {

    }

    public void cashWithdrawal(Atm atm, Card card, int withdrawalAmount) {

    }

    public void displayBalance(Atm atm, Card card) {

    }

    public void returnCard() {

    }

    public void exit(Atm atm) {

    }

}

// these are the state 
class AtmIdealState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        super.insertCard(atm, card);
        atm.setCurrentAtmState(new HasCardState());
    }
}


class HasCardState extends ATMState {

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        super.authenticatePin(atm, card, pin);
        if (pin.isCorrect()) {
            atm.setCurrentAtmState(new SelectOperationState());
        } else {
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentAtmState(new AtmIdealState());
    }

    @Override
    public void returnCard() {
        super.returnCard();
    }

}

class SelectOperationState extends ATMState {

    SelectOperationState() {
        showOperations();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        super.selectOperation(atm, card, transactionType);
        switch (transactionType) {
            case CASH_WITHDRAWAL -> atm.setCurrentAtmState(new CashWithDrawalState());
            case BALANCE_CHECK -> atm.setCurrentAtmState(new CheckBalanceState());
            default -> exit(atm);
        }
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentAtmState(new AtmIdealState());
    }

    @Override
    public void returnCard() {
        super.returnCard();
    }

    public void showOperations() {

    }
}

class CashWithdrawalState extends ATMState {

    CashWithdrawalState() {

    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawalAmount) {
        super.cashWithdrawal(atm, card, withdrawalAmount);

        if (!atmHasSufficientBalance) {
            // ATM do not have sufficient balance
            exit(atm);
        } else if (!userAccountHasSufficientBalance) {
            // User  do not have sufficient balance
            exit(atm);
        } else {
            card.deductBankBalance(withdrawalAmount);
            atm.deductAtmBalance(withdrawalAmount);

            CashWithdrawalProcessor cashWithdrawalProcessor =
                    new TwoKCWProcessor(new FiveHundredCWProcessor(new OneHundredCWProcessor(null)));
            cashWithdrawalProcessor.withdrawal(atm, withdrawalAmount);
            exit(atm);
        }
    }

    @Override
    public void exit(Atm atm) {
        returnCard();
        atm.setCurrentAtmState(new AtmIdealState());
    }

    @Override
    public void returnCard() {
        super.returnCard();
    }

}

class CheckBalanceState extends ATMState {
    @Override
    public void displayBalance(ATM atm, Card card) {
        super.displayBalance(atm, card);
    }

    @Override
    public void exit(Atm atm) {
        returnCard();
        atm.setCurrentAtmState(new AtmIdealState());
    }

    @Override
    public void returnCard() {
        super.returnCard();
    }
}

enum TransactionType {
    CASH_WITHDRAWAL, BALANCE_CHECK
}

// ========= end of states 

// Here we define the withdrawal process with the use of chain of responsibility 
class CashWithdrawalProcessor {
    CashWithdrawalProcessor nextCashWithdrawalProcessor;

    CashWithdrawalProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;
    }

    public void withdrawal(ATM atm, int remainingAmount) {
        if (nextCashWithdrawalProcessor != null) {
            nextCashWithdrawalProcessor.withdrawal(atm, remainingAmount);
        }
    }

}

class TwoKCWProcessor extends CashWithdrawalProcessor {

    TwoKCWProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withdrawal(ATM atm, int remainingAmount) {
      int required =  remainingAmount/2000;
      int balance = remainingAmount%2000;

      if(required <= atm.getNoOfTwoThousandNotes()) {
        atm.deductTwoThousandNotes(required);
      }
      else if(required > atm.getNoOfTwoThousandNotes()) {
        atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
        balance = balance + (required-atm.getNoOfTwoThousandNotes()) * 2000;
      }

      if(balance != 0){
        super.withdraw(atm, balance);
      }

    }
}

class FiveHundredCWProcessor extends CashWithdrawalProcessor {

    FiveHundredCWProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withdrawal(ATM atm, int remainingAmount) {

      int required =  remainingAmount/500;
      int balance = remainingAmount%500;

      if(required <= atm.getNoOfFiveHundredNotes()) {
        atm.deductFiveHundredNotes(required);
      }
      else if(required > atm.getNoOfFiveHundredNotes()) {
        atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
        balance = balance + (required-atm.getNoOfFiveHundredNotes()) * 500;
      }

      if(balance != 0){
        super.withdraw(atm, balance);
      }
    }
}

class OneHundredCWProcessor extends CashWithdrawalProcessor {

    OneHundredCWProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withdrawal(ATM atm, int remainingAmount) {
      int required =  remainingAmount/100;
      int balance = remainingAmount%100;

      if(required <= atm.getNoOfOneHundredNotes()) {
        atm.deductOneHundredNotes(required);
      }
      else if(required > atm.getNoOfOneHundredNotes()) {
        atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
        balance = balance + (required-atm.getNoOfOneHundredNotes()) * 100;
      }

      if(balance != 0){
        System.out.println("Something went wrong");
      }
    }
}

// it has ATM State 
// This will be singleton class 
class ATM {
    ATMState currentAtmState;

    int balance;
    int noOfTwoThousandsNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;

    private ATM() {

    }

    public void setCurrentAtmState(ATMState currentAtmState) {
        this.currentAtmState = currentAtmState;
    }

    public void setBalance(int balance, int noOfTwoThousandsNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.balance = balance;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfTwoThousandsNotes = noOfTwoThousandsNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }


}

// User has a Card , BankAccount
class User {
    int userId;
    Card card;
    BankAccount bankAccount;

}

// Card has BankAccount 
class Card {
    String CVVNo;
    BankAccount bankAccount;

}

// it has balance.
class BankAccount {
    Balance balance;

    void updateBalance() {

    }
}


class ATMRoom {
    ATM atm;
    User user;

    ATMRoom() {
        initialize();
    }

    private void initialize() {
        atm = ATM.getAtm();
        atm.setBalance(3500, 1, 2, 5);
        this.user = createUser();
    }

    private User createUser() {
        User user = new User();
        user.bankAccount = new BankAccount();
        user.card = new Card();
    }

}

```
