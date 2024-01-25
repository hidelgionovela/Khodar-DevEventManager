package com.bbm.khoevent.dto.request;


import lombok.Data;

@Data
public class TicketRequest {

    private String attendeeName;
    private String attendeeEmail;
    private boolean isChecked;
}
