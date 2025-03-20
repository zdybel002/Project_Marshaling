package it.viko.elf.zdybel.first_spring_bot.db;

import it.viko.elf.zdybel.first_spring_bot.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
