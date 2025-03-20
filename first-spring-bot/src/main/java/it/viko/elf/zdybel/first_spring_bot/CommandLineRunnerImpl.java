package it.viko.elf.zdybel.first_spring_bot;

import it.viko.elf.zdybel.first_spring_bot.db.CustomerRepository;
import it.viko.elf.zdybel.first_spring_bot.menu.Menu;
import it.viko.elf.zdybel.first_spring_bot.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private Menu userMenu;

    @Override
    public void run(String... args) throws Exception {
        userMenu.showMenu();
    }
}



