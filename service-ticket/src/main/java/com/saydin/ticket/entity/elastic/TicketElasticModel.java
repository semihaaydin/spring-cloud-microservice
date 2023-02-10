package com.saydin.ticket.entity.elastic;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@EqualsAndHashCode(of={"id"})
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "ticket",createIndex = true)
public class TicketElasticModel implements Serializable {

    @Id //spring data dan gelmeli
    private String id;
    private String description;
    private String notes;
    private String assignee;
    private Date ticketDate;
    private String  priorityType;
    private String ticketStatus;
}
