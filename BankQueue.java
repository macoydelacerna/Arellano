/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Customer {
    private String name;
    private int number;

    public Customer(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Customer " + number + ": " + name;
    }
}

public class BankQueue {
    private Queue<Customer> queue;
    private int customerNumber;

    public BankQueue() {
        queue = new LinkedList<>();
        customerNumber = 1;
    }

    
    public void addCustomer(String name) {
        Customer customer = new Customer(name, customerNumber++);
        queue.add(customer);
        System.out.println(name + " has been added to the queue.");
    }

    
    public void serveCustomer() {
        if (queue.isEmpty()) {
            System.out.println("No customers in the queue.");
        } else {
            Customer servedCustomer = queue.poll();
            System.out.println("Serving: " + servedCustomer);
        }
    }

   
    public void viewQueue() {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Current queue:");
            for (Customer customer : queue) {
                System.out.println(customer);
            }
        }
    }

    
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nBank Queue Menu:");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Serve next customer");
            System.out.println("3. View queue");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    addCustomer(name);
                    break;
                case 2:
                    serveCustomer();
                    break;
                case 3:
                    viewQueue();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    public static void main(String[] args) {
        BankQueue bankQueue = new BankQueue();
        bankQueue.displayMenu();
    }
}


