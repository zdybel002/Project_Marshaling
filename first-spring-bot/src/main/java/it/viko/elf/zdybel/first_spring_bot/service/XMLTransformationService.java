package it.viko.elf.zdybel.first_spring_bot.service;


import it.viko.elf.zdybel.first_spring_bot.models.StudentList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;
import java.util.List;
import java.io.File;


@Service
public class XMLTransformationService {

    public static void transformToXML(StudentList students) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(StudentList.class);
            Marshaller jaxbMarshaler = jaxbContext.createMarshaller();
            jaxbMarshaler.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


            // show XML in consol
            System.out.println("Generate XML:");
            jaxbMarshaler.marshal(students, System.out);


            // Path to save the file target/SendingFile
            String dirPath = "target/SendingFile";
            File dir = new File(dirPath);

            if (!dir.exists()) {
                dir.mkdirs(); // Create a folder id isnt exist
            }

            // Create a file XML
            File file = new File(dir, "students.xml");

            // Serializacja całej listy studentów do XML
            jaxbMarshaler.marshal(students, file);

            System.out.println("\nFile saved to: " + file.getAbsolutePath());
        } catch (JAXBException e) {
            System.out.println("Mistake XML: " + e.getLocalizedMessage());
        }
    }
}
