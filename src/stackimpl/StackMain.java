package stackimpl;

import stackimpl.arrayImpl.StackArrayImpl;

public class StackMain {

    public static void main(String[] args) {
        try{
            StackArrayImpl stackArray = new StackArrayImpl(3);
            System.out.println(stackArray.isEmpty());
            System.out.println(stackArray.getSize());
            stackArray.push(10);
            stackArray.push(20);
            System.out.println(stackArray.peek());
            System.out.println(stackArray.pull());
            stackArray.push(20);
            stackArray.push(30);
            System.out.println(stackArray.peek());
            System.out.println(stackArray.pull());
            System.out.println(stackArray.pull());
            System.out.println(stackArray.pull());
            System.out.println(stackArray.getSize());

            System.out.println("Linked List Impl");
            StackLinkedListImpl stackLinkedList = new StackLinkedListImpl();
            System.out.println(stackLinkedList.isEmpty());
            System.out.println(stackLinkedList.size());
            stackLinkedList.push(10);
            stackLinkedList.push(20);
            System.out.println(stackLinkedList.peek());
            System.out.println(stackLinkedList.pull());
            stackLinkedList.push(20);
            stackLinkedList.push(30);
            System.out.println(stackLinkedList.peek());
            System.out.println(stackLinkedList.pull());
            System.out.println(stackLinkedList.pull());
            System.out.println(stackLinkedList.pull());
            System.out.println(stackLinkedList.size());

        }catch (IllegalStateException e){
            System.out.println(e);
        }
    }
}
