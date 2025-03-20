package it.viko.elf.zdybel.first_spring_bot.menu;

import it.viko.elf.zdybel.first_spring_bot.CustomerList.CustomerList;
import it.viko.elf.zdybel.first_spring_bot.db.CustomerRepository;
import it.viko.elf.zdybel.first_spring_bot.models.Customer;
import it.viko.elf.zdybel.first_spring_bot.server.JavaClientSendingFile;
import it.viko.elf.zdybel.first_spring_bot.service.XMLTransformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

import static it.viko.elf.zdybel.first_spring_bot.server.JavaClientSendingFile.clientSendingFile;

@Component
public class Menu {
    private static List<Customer> customers;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private XMLTransformationService trantsformationService;

    public int displayMenu(Scanner input) {
        System.out.println("Make a selection ");
        System.out.println("-----------------");
        System.out.println("1 Create a pseudo code");
        System.out.println("2) Create XML and Save to the file");
        System.out.println("3) Send file");
        System.out.println("| 6) + Quit %7s");
        return input.nextInt();
    }

    public void showMenu() {
        Scanner input = new Scanner(System.in);
        int userChoice;
        do {
            userChoice = displayMenu(input);
            switch (userChoice) {
                case 1:
                    customers = customerRepository.findAll();
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    break;
                case 2:
                    XMLTransformationService service = new XMLTransformationService();
                    service.transformToXML(customers);  // Przekazujemy całą listę klientów
                    break;

                case 3:
                    JavaClientSendingFile.clientSendingFile();
                    break;
                case 6:
                    System.out.println("Thank you goodbye!");
                    System.out.println(0);
            }
        } while (userChoice != 6);
    }

}
