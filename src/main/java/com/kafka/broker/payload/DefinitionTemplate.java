package com.kafka.broker.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefinitionTemplate {

    private int id;
    private int length;

    @Override
    public String toString() {
        return "DefinitionTemplate{" +
                "id=" + id +
                ", length=" + length +
                ", delimitLength=" + delimitLength +
                ", prefix='" + prefix + '\'' +
                '}';
    }

    private int delimitLength;
    private String prefix;
}
