package com.sachin.sprigbootdocify.demo.config;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

/**
 * @Data
 * @AllArgsConstructor
 * @NoArgsConstructor
 * @EqualsAndHashCode(callSuper=false)
 * @Builder
 * @ToString(callSuper = true)
 * @Entity
 * @Table(name = "t_business_rules")
 */
@Getter
@AllArgsConstructor
public enum State {
    UNKNOWN("未知"),
    ACTIVE("正常"),
    INACTIVE("封禁"),
    ;

    private final String desc;

    @JsonCreator
    public static State fromStr(String strValue) {
        return Arrays.stream(State.values()).filter(value -> value.value().equals(strValue)).findFirst().orElse(UNKNOWN);
    }

    @JsonValue
    public String value() {
        return this.name();
    }

    @Converter(autoApply = true)
    public static class DatabaseColumnConverter implements AttributeConverter<State, String> {
        public String convertToDatabaseColumn(State state) {
            return state != null ? state.name() : UNKNOWN.name();
        }

        public State convertToEntityAttribute(String name) {
            return fromStr(name);
        }
    }
}