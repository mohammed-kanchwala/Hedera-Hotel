package io.github.neferupito.hederahotel.model.booking;

import io.github.neferupito.hederahotel.model.customer.Customer;
import io.github.neferupito.hederahotel.model.room.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TemporaryBooking {

    private String bookingReference;

    private Customer customer;

    private String arrivalDate; //dd-MM-yyyy
    private String departureDate;

    private Category category;

}
