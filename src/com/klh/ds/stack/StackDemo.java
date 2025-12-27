package com.klh.ds.stack;

import java.util.Scanner;
import java.util.EmptyStackException;

public class StackDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStack<String> stack = new MyStack<>();

        while (true) {
            System.out.println("\n--- STACK MENU ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Size");
            System.out.println("5. Is Empty");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int ch;
            try {
                ch = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            switch (ch) {

                case 1:
                    System.out.print("Enter value to push: ");
                    String val = sc.nextLine();
                    stack.push(val);
                    System.out.println("Pushed: " + val);
                    break;

                case 2:
                    try {
                        String popped = stack.pop();
                        System.out.println("Popped: " + popped);
                    } catch (EmptyStackException e) {
                        System.out.println("Stack is empty. Cannot pop.");
                    }
                    break;

                case 3:
                    try {
                        String top = stack.peek();
                        System.out.println("Top element: " + top);
                    } catch (EmptyStackException e) {
                        System.out.println("Stack is empty. Nothing to peek.");
                    }
                    break;

                case 4:
                    System.out.println("Current stack size: " + stack.size());
                    break;

                case 5:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is NOT empty.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting Stack Demo.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
