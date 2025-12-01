package Biblioteca;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
    
    @Override
    public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
        try {
            return new JsonPrimitive(date.format(formatter));
        } catch (Exception e) {
            throw new JsonParseException("Error serializando LocalDate: " + date, e);
        }
    }
    
    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            String dateString = json.getAsString();
            return LocalDate.parse(dateString, formatter);
        } catch (Exception e) {
            throw new JsonParseException("Error deserializando LocalDate: " + json.getAsString(), e);
        }
    }
}
