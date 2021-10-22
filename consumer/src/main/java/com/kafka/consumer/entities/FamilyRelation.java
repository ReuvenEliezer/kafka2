package com.kafka.consumer.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FamilyRelation extends RelationBase {
    private FamilyRelationTypeEnum familyRelationTypeEnum;
}
