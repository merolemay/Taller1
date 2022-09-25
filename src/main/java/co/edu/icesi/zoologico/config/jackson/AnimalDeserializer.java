package co.edu.icesi.zoologico.config.jackson;

import co.edu.icesi.zoologico.model.Animal;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class AnimalDeserializer extends StdDeserializer<Animal> {

    public AnimalDeserializer(){
        super(Animal.class);
    }

    @Override
    public Animal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        return null;
    }
}