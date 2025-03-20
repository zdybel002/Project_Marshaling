package it.viko.elf.zdybel.first_spring_bot.service;


import it.viko.elf.zdybel.first_spring_bot.models.Customer;
import it.viko.elf.zdybel.first_spring_bot.CustomerList.CustomerList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;
import java.util.List;
import java.io.File;

@Service
public class XMLTransformationService {

    public static void transformToXML(List<Customer> customers) {
        try {
            // Utworzenie kontekstu JAXB dla klasy CustomerList
            JAXBContext jaxbContext = JAXBContext.newInstance(CustomerList.class);
            Marshaller jaxbMarshaler = jaxbContext.createMarshaller();
            jaxbMarshaler.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Formatowanie XML

            // Utworzenie obiektu CustomerList, który przechowa listę klientów
            CustomerList customerList = new CustomerList();
            customerList.setCustomers(customers); // Ustawienie listy klientów

            // Wyświetlenie XML na konsoli
            System.out.println("Wygenerowany XML:");
            jaxbMarshaler.marshal(customerList, System.out); // Wyświetlenie XML w konsoli

            // Ścieżka do katalogu target/SendingFile
            String dirPath = "target/SendingFile";
            File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs(); // Tworzy katalog, jeśli nie istnieje
            }

            // Tworzenie pliku XML
            File file = new File(dir, "customers.xml");

            // Serializacja całej listy klientów do XML
            jaxbMarshaler.marshal(customerList, file);

            System.out.println("\nPlik XML zapisany: " + file.getAbsolutePath());
        } catch (JAXBException e) {
            System.out.println("Błąd XML: " + e.getLocalizedMessage());
        }
    }
}