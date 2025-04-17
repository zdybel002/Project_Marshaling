package it.viko.elf.zdybel.first_spring_bot.service;


import it.viko.elf.zdybel.first_spring_bot.models.StudentList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;



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

        } catch (JAXBException e) {
            System.out.println("Mistake XML: " + e.getLocalizedMessage());
        }
    }
}
