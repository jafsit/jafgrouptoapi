package com.restassured.todo.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    public LocalDateDeserializer() {
    }

    public LocalDate deserialize(final JsonParser jsonParser, final DeserializationContext context) throws IOException {
        return LocalDate.parse(jsonParser.getValueAsString(), DateTimeFormatter.ISO_DATE);
    }
}
