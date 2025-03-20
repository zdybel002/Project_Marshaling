package it.viko.elf.zdybel.first_spring_bot.service;


import it.viko.elf.zdybel.first_spring_bot.CustomerList.StudentList;
import it.viko.elf.zdybel.first_spring_bot.models.Student;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;
import java.util.List;
import java.io.File;


@Service
public class XMLTransformationService {

    public static void transformToXML(List<Student> students) {
        try {
            // Utworzenie kontekstu JAXB dla klasy StudentList
            JAXBContext jaxbContext = JAXBContext.newInstance(StudentList.class);
            Marshaller jaxbMarshaler = jaxbContext.createMarshaller();
            jaxbMarshaler.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Formatowanie XML

            // Utworzenie obiektu StudentList, który przechowa listę studentów
            StudentList studentList = new StudentList();
            studentList.setStudents(students); // Ustawienie listy studentów

            // Wyświetlenie XML na konsoli
            System.out.println("Wygenerowany XML:");
            jaxbMarshaler.marshal(studentList, System.out); // Wyświetlenie XML w konsoli

            // Ścieżka do katalogu target/SendingFile
            String dirPath = "target/SendingFile";
            File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs(); // Tworzy katalog, jeśli nie istnieje
            }

            // Tworzenie pliku XML
            File file = new File(dir, "students.xml");

            // Serializacja całej listy studentów do XML
            jaxbMarshaler.marshal(studentList, file);

            System.out.println("\nPlik XML zapisany: " + file.getAbsolutePath());
        } catch (JAXBException e) {
            System.out.println("Błąd XML: " + e.getLocalizedMessage());
        }
    }
}
