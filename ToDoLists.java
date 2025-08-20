/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package todolists;
import java.util.Scanner;
/**
 *
 * @author BED
 */
public class ToDoLists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        ToDoList todoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Search for a Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String titleToAdd = scanner.nextLine();
                    todoList.addTask(titleToAdd);
                    System.out.println("Task added.");
                    break;
                case 2:
                    System.out.print("Enter task title to delete: ");
                    String titleToDelete = scanner.nextLine();
                    todoList.deleteTask(titleToDelete);
                    System.out.println("Task deleted.");
                    break;
                case 3:
                    System.out.println("Tasks:");
                    todoList.printTasks();
                    break;
                case 4:
                    System.out.print("Enter task title to search: ");
                    String titleToSearch = scanner.nextLine();
                    if (todoList.contains(titleToSearch)) {
                        System.out.println("Task found.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

