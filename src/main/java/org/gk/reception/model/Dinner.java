package org.gk.reception.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document(collection = "dinner")
@Builder
public class Dinner {
    @Id
    private String id;
    private String firstName;
    private String city;
    private String choice;
    private String notes;
    private boolean rsvp;
    private LocalDateTime localDateTime;
}