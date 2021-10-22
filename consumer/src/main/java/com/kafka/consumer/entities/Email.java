package com.kafka.consumer.entities;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Email extends BaseEntity {
    private String email;
}
