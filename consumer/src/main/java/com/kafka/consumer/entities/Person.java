package com.kafka.consumer.entities;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;
    private GenderTypeEnum genderTypeEnum;

}
