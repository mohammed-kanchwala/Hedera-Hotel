package io.github.neferupito.hederahotel.controller;

import io.github.neferupito.hederahotel.model.customer.Customer;
import io.github.neferupito.hederahotel.model.room.Category;
import io.github.neferupito.hederahotel.model.room.Room;
import io.github.neferupito.hederahotel.model.user.User;
import io.github.neferupito.hederahotel.repository.booking.BookingRepository;
import io.github.neferupito.hederahotel.repository.customer.CustomerRepository;
import io.github.neferupito.hederahotel.repository.room.CategoryRepository;
import io.github.neferupito.hederahotel.repository.room.RoomRepository;
import io.github.neferupito.hederahotel.repository.user.UserRepository;
import io.github.neferupito.hederahotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Controller
public class DefaultController {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home1() {
        createDatabase();
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    private void createDatabase() {
        Category c0 = categoryRepository.findOne(1L);
        if (c0 == null) {
            Category c1 = categoryRepository.save(Category.builder()
                    .name("Standard")
                    .maxAdults(2)
                    .maxChildren(0)
                    .defaultPrice(BigDecimal.valueOf(85.00))
                    .build());
            Category c2 = categoryRepository.save(Category.builder()
                    .name("Family")
                    .maxAdults(2)
                    .maxChildren(2)
                    .defaultPrice(BigDecimal.valueOf(120.00))
                    .build());
            roomRepository.save(Room.builder()
                    .number(101)
                    .floor(1)
                    .category(c1)
                    .build());
            roomRepository.save(Room.builder()
                    .number(102)
                    .floor(1)
                    .category(c1)
                    .build());
            roomRepository.save(Room.builder()
                    .number(103)
                    .floor(1)
                    .category(c1)
                    .build());
            roomRepository.save(Room.builder()
                    .number(201)
                    .floor(2)
                    .category(c2)
                    .build());
            roomRepository.save(Room.builder()
                    .number(202)
                    .floor(2)
                    .category(c2)
                    .build());
            roomRepository.save(Room.builder()
                    .number(203)
                    .floor(2)
                    .category(c2)
                    .build());
            customerRepository.save(Customer.builder()
                    .lastName("Queraux")
                    .firstName("Yoann")
                    .build());
//            userService.saveUser(User.builder().login("yo").password("yo").build());
        }
    }


}
