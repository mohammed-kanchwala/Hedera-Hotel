package io.github.neferupito.hederahotel.model.reporting;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HistoryMessages {

    BOOKING_CREATED("", ""),
    BOOKING_MODIFIED("", "");

    private String englishMessage;
    private String frenchMessage;

}
