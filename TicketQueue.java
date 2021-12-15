/*
Name: Farhan Valli
Problem: Final Project
Date: December 16 2021
Description: Cinema Ticketing Queue
Input: Number of test cases, and people in the queue, separated by spaces
Output: ith integer denoting the seat number occupied by the person i, separated by spaces
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class TicketQueue {
    public static void main(String[] args) {
        //creating a linked list constructor for the test cases, which reads an input
        LinkedList<LinkedList<Ticket>> testCases = readInput();
        //for loop based on the number of test cases,
        for (int i = 0; i < testCases.size(); i++) {
            //linked list for the test cases
            LinkedList<Ticket> currentTestCaseList = testCases.get(i);
            //copy of list, for order retention
            LinkedList<Ticket> copyOfCurrentList = createCopy(currentTestCaseList);
            //creating a set for the assigned seats
            Set<Integer> assignedSeats = new HashSet<>();
            //if seat is taken, remove first element, add to end, and increment ticket number
            while (currentTestCaseList.size() > 0) {
                Ticket currentTicket = currentTestCaseList.pollFirst();
                if (assignedSeats.contains(currentTicket.getTicketNum())) {
                    currentTicket.incrementTicketNum();
                    currentTestCaseList.addLast(currentTicket);
                } else {
                    //if not taken, assign the seat to the ticket number
                    assignedSeats.add(currentTicket.getTicketNum());
                }
            }
            //for loop iterating through the copy and prints ticket numbers, separated by spaces
            for (int j = 0; j < copyOfCurrentList.size(); j++) {
                System.out.print(copyOfCurrentList.get(j).getTicketNum());
                System.out.print(" ");
            }
            //new line between outputs
            System.out.println();
        }
    }

    //creating a copy of the linked list to retain the original order
    private static LinkedList<Ticket> createCopy(LinkedList<Ticket> listToCopy) {
        return new LinkedList<>(listToCopy);
    }

    private static LinkedList<LinkedList<Ticket>> readInput() {
        //linked list for test cases
        LinkedList<LinkedList<Ticket>> testCases = new LinkedList<>();
        //scanner to read input
        Scanner scanner = new Scanner(System.in);
        //try statement to test code for errors while executed
        try {
            //scanner reads the test cases inputted, and returns IllegalArgumentException if 0 or negative
            int numTestCases = scanner.nextInt();
            if (numTestCases <= 0) {
                throw new IllegalArgumentException("Invalid number of test cases: " + numTestCases);
            }
            for (int i = 0; i < numTestCases; i++) {
                //scanner reads the people in the line inputted, and returns IllegalArgumentException if 0 or negative, in a for loop iterating through the number of test cases
                int numPeopleInLine = scanner.nextInt();
                if (numPeopleInLine <= 0) {
                    throw new IllegalArgumentException("Invalid number of people in line for test case #" + (i+1) + ": " + numPeopleInLine);
                }
                //linked list for the people still in the queue
                LinkedList<Ticket> currentTestCasePeopleInLine = new LinkedList<>();
                //for loop iterating through this list, and using the scanner to assign a ticket number
                for (int j = 0; j < numPeopleInLine; j++) {
                    int ticketNum = scanner.nextInt();
                    //throw IllegalArgumentException if 0 or negative
                    if (ticketNum <= 0) {
                        throw new IllegalArgumentException("Invalid ticket number for test case #" + (i+1) + ": " + ticketNum);
                    }
                    //add ticket number to the current test case for the people in line
                    currentTestCasePeopleInLine.add(new Ticket(ticketNum));
                }
                //add current test cases for the people in line to the test cases
                testCases.add(currentTestCasePeopleInLine);
            }
        //catch statement to execute code, if there is an error in try statement
        } catch (Exception e) {
            //throw an exception if there is
            throw new IllegalArgumentException("Caught exception while reading input", e);
        }
        //return list of test cases
        return testCases;
    }
}
