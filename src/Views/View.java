
package Views;

import Model.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public int displayMenu() {
        System.out.println("1. Find person info.");
        System.out.println("2. Copy Text to new file.");
        System.out.println("3. Exit.");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public String getInputFilePath() {
        System.out.print("Enter the file path: ");
        return scanner.next();
    }

    public double getInputMoney() {
        System.out.print("Enter the minimum salary: ");
        return scanner.nextDouble();
    }

    public String getOutputFilePath() {
        System.out.print("Enter the output file path: ");
        return scanner.next();
    }

    public void displayPersons(ArrayList<Person> persons, double money) {
        System.out.println("Persons with salary >= " + money + ":");
        System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Money");
        for (Person person : persons) {
            if (person.getMoney() >= money) {
                System.out.printf("%-20s%-20s%-20.1f\n", person.getName(), person.getAddress(), person.getMoney());
            }
        }
        Collections.sort(persons);
        System.out.println("Max: " + persons.get(0).getName());
        System.out.println("Min: " + persons.get(persons.size() - 1).getName());
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
