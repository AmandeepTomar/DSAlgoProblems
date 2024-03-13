# Split Wise Design pattern 

## Flow . 
1. Add N no of friends 
   1. N no of friends 
2. Create N no of groups 
   1. Home , Collage , Outing , trip
   2. Add friends in group
3. Add Expanse
   1. Split between person
   2. Add expanse to a group 
   3. Add expanse directly to person 

   
## Requirements 
1. Should be able to add friends 
2. Should be able to add / manage group 
3. Add friends inside a group /manage
4. Manage Expanse inside a group and outside a group.
5. Able to split the expanses 
   1. equal split 
   2. unequal split 
   3. % wise split
6. balance sheet of each user we wanted.


### Objects 

1. SpitWiseApp
2. User  -> UserController
3. Group -> GroupController
4. Expanse  -> ExpanseController
5. Split capabilities -> SplitFactory on the type of SplitType
6. BalanceSheet  -> BalanceSheetController

### Q. what happen when expanse is created? 
1. I am creating a expanse , lunch , amount 400 and paid by me and i am splitting (Equal type between friends)
2. We have 4 friends -> friends name and how much the amount they owe for this expanse.
3. If we want to divide on percentage wise where we need to add the percentage to the each friend.

#### now we will talk about the balance sheet 
- It show me total amount to owe or getBack 
- Give money and asking money 
- F1-> you owe 100. negative
- F2 -> you get back from him  positive 

// UML Bottom - Up Approach 
- Suppose from a group we are creating an expense  , now it need to update the balance sheet of user.
```java
import java.util.List;// Expanse has User , Split

// this one just like have the data not performing any operation.
class Expanse {
    long expanseId;
    String expanseDescription;
    double expanseAmount;
    User paidBy;
    SlpitType splitType;
    List<Split> splits;

    static enum SplitType {
        EQUAL, UNEQUAL, PERCENTAGEWISE
    }
}

class Split {
    User user;
    double amount;
    // if we want on teh basis of percentage
    int percentage;
}

interface SplitExpanse {
    // validate request 
    void validateRequest(List<Split> splitDetails, double expanseAmount);

    void computeAmount(List<Split> splitDetails, double expanseAmount);
}

class EquallySplitExpanse implements SplitExpanse {
    @Override
    public void validateRequest(List<Split> splitDetails, double expanseAmount) {

    }
}

class UnEquallySplitExpanse implements SplitExpanse {
    @Override
    public void validateRequest(List<Split> splitDetails, double expanseAmount) {

    }
}

class PercentageSplitExpanse implements SplitExpanse {
    @Override
    public void validateRequest(List<Split> splitDetails, double expanseAmount) {

    }
}

// creating , update and delete expanse.
// it has SplitFactory , BalanceSheetController
class ExpanseController {

    SplitFactory splitFactory;
    BalanceSheetController balanceSheetController;


    void createExpanse(long expanseId, Sring expanseDescription, double expanseAmount,
                       List<Split> splitDetails, Expanse.SplitType splitType,
                       User paidByUser) {

        SplitExpanse splitExpanse = SplitFactory.getSplitExpanseType(splitType);
        splitExpanse.validateRequest(splitDetails, expanseAmount);
    }
}

class SplitFactory {

    public static SplitExpanse getSplitExpanseType(Expanse.SplitType splitType) {
        if (splitType == Expanse.SplitType.EQUAL) {
            return new EquallySplitExpanse();
        } else if (splitType == Expanse.SplitType.PERCENTAGEWISE) {
            return new PercentageSplitExpanse();
        } else {
            ret new UnEquallySplitExpanse();
        }
    }
}


// Every user maintain their view , how much take and how much given. 
// user has UserExpanseBalanceSheet
class User {
    long userId;
    String userName;
    String emailId;
    UserExpanseBalanceSheet userExpanseBalanceSheet;
}

class UserController {
    List<User> userList;

    // CRUD 
    addUser();

    deleteuser();

    updateuser();
}


// Group 
// has expense controller , list of users , list of expenses
class Group {
    long groupId;
    String groupName;
    List<User> list;
    List<Expanse> expanseList;
    ExpanseController expanseController;
}


class GroupController {

    List<Group> groupList;


    // CRUD 
}


// 
class UserExpanseBalanceSheet {

    Map<User, Balance> friendBalanceSheet;
    double totalExpanse;
    double totalPayment;
    double totalOwe;
    double totalGetBack;

}

// update UserExpanseBalanceSheet and hold the business logic 
class BalanceSheetController {
    
    // logic to update the user amount , owe amount , total , total get back.

}

// jsut have details get back and owe money 
class Balance {
    double amountOwe;
    double amountGetBack;
}

// has userController , groupController 
// it is just a driver , separate all the logic of group and user separated using controller 
class SpiltWiseApp {
    UserController userController;
    GroupController groupController;
}




```
