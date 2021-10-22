package com.kafka.consumer.entities;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class RelationBase extends BaseEntity {

    private String relatedTo;
    private LocalDate startDate;
    private LocalDate endDate;
    private int intensity;
    private int reliability;

}
