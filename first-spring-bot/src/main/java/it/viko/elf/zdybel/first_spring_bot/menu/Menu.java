package it.viko.elf.zdybel.first_spring_bot.menu;

import it.viko.elf.zdybel.first_spring_bot.db.StudentRepository;
import it.viko.elf.zdybel.first_spring_bot.models.Student;
import it.viko.elf.zdybel.first_spring_bot.models.StudentList;
import it.viko.elf.zdybel.first_spring_bot.service.XMLTransformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Menu {
    private static List<Student> students;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private XMLTransformationService trantsformationService;

    public int displayMenu(Scanner input) {
        System.out.println("Make a selection ");
        System.out.println("-----------------");
        System.out.println("1 Create a pseudo code");
        System.out.println("2) Create XML and Save to the file");
        System.out.println("3) Send file");
        System.out.println("6) Quit ");
        return input.nextInt();
    }

    public void showMenu() {
        Scanner input = new Scanner(System.in);
        int userChoice;
        do {
            userChoice = displayMenu(input);
            switch (userChoice) {
                case 1:
                    students = studentRepository.findAll();
                    for (Student customer : students) {
                        System.out.println(customer);
                    }
                    break;
                case 2:
                    students = studentRepository.findAll();
                    StudentList studentList = new StudentList();
                    studentList.setStudents(students);

//                    System.out.println(studentList);
                    XMLTransformationService.transformToXML(studentList);

//                    XMLTransformationService service = new XMLTransformationService();
//                    service.transformToXML(studentList);  // Przekazujemy całą listę klientów
                    break;
                case 6:
                    System.out.println("Thank you goodbye!");
                    System.out.println(0);
            }
        } while (userChoice != 6);
    }

}
