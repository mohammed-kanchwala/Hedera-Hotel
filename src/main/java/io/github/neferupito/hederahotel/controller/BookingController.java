package io.github.neferupito.hederahotel.controller;

import io.github.neferupito.hederahotel.model.booking.TemporaryBooking;
import io.github.neferupito.hederahotel.service.BookingService;
import io.github.neferupito.hederahotel.service.RoomService;
import io.github.neferupito.hederahotel.util.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.ParseException;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private RoomService roomService;


    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public ModelAndView booking() {
        ModelAndView modelAndView = new ModelAndView();
        TemporaryBooking tempBooking = new TemporaryBooking();
        modelAndView.addObject("tempBooking", tempBooking);
        modelAndView.setViewName("booking");
        return modelAndView;
    }

    @RequestMapping(value = "/findfreeroom", method = RequestMethod.POST)
    public ModelAndView findFreeRoom(@Valid TemporaryBooking temporaryBooking, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            temporaryBooking = bookingService.buildTemporaryBooking(temporaryBooking);

            modelAndView.addObject("tempBooking", temporaryBooking);
            modelAndView.addObject("availableRoom", roomService.findFreeRoom(
                    DateFormatter.parseComplete(temporaryBooking.getArrivalDate()),
                    DateFormatter.parseComplete(temporaryBooking.getDepartureDate()),
                    temporaryBooking.getCategory()));
            modelAndView.setViewName("bookingconfirmation");
        } catch (ParseException e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

//    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
//    public ModelAndView home() {
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByEmail(auth.getName());
//        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
//        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
//        modelAndView.setViewName("admin/home");
//        return modelAndView;
//    }


}