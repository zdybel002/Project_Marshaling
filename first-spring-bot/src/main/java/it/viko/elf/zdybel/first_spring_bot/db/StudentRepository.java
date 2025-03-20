package it.viko.elf.zdybel.first_spring_bot.db;

import it.viko.elf.zdybel.first_spring_bot.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
