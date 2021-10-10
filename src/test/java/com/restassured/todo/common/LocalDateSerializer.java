package com.restassured.todo.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {
    public LocalDateSerializer(){

    }

    public void serialize(final LocalDate value, final JsonGenerator generator, final
                          SerializerProvider provider) throws IOException {
        generator.writeString(value.format(DateTimeFormatter.ISO_DATE));
    }
}
