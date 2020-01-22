package com.coviam.team9.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.kafka.common.protocol.types.Field;

@Getter
@Setter
@ToString
public class MessageDTO {
    private boolean status;
}
