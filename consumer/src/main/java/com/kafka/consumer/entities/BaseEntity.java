package com.kafka.consumer.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class BaseEntity {
    private String Id;
    private String comment;
}
