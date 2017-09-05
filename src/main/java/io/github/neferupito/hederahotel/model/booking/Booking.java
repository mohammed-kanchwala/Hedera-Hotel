package io.github.neferupito.hederahotel.model.booking;

import io.github.neferupito.hederahotel.model.customer.Customer;
import io.github.neferupito.hederahotel.model.reporting.History;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Booking {

    @Id
    private String bookingReference;

    @ManyToOne
    private Customer customer;

    private Date arrivalDate;
    private Date departureDate;

    private int adults = 0;
    private int children = 0;

    private BigDecimal totalPrice;

    private boolean isCheckedIn = false;
    private boolean isCheckedOut = false;
    private boolean isCanceled = false;

    @OneToOne(cascade = CascadeType.ALL)
    private History history;

}
