package Controller;
import Model.Person;
import Model.PersonService;
import Views.View;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private PersonService personService = new PersonService();
    private View view = new View();

    public void run() {
        while (true) {
            int choice = view.displayMenu();
            switch (choice) {
                case 1:
                    findPersonInfo();
                    break;
                case 2:
                    copyNewFile();
                    break;
                case 3:
                    return;
            }
        }
    }

    public void findPersonInfo() {
        String filePath = view.getInputFilePath();
        double money = view.getInputMoney();
        personService.readPersonsFromFile(filePath);
        ArrayList<Person> persons = personService.getPersons();
        view.displayPersons(persons, money);
    }

    public void copyNewFile() {
        String inputFilePath = view.getInputFilePath();
        String outputFilePath = view.getOutputFilePath();
        String content = personService.getUniqueWordsFromFile(inputFilePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(content);
            view.showMessage("Content written to " + outputFilePath);
        } catch (IOException e) {
            view.showMessage("An error occurred while writing to the file.");
        }
    }
}
