package ru.ziplla.dataforge;

import ru.ziplla.dataforge.constraints.Constraints;
import ru.ziplla.dataforge.templates.Templates;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        DataGenerator dataGenerator = new DataGenerator();

        dataGenerator.addIntegerField("age", Constraints.range(1, 3));
        dataGenerator.addDoubleField("salary", Constraints.rangeDouble(1, 1000));
        dataGenerator.addStringField("name", Constraints.length(2, 6));
        dataGenerator.addTemplate("email", Templates.email());
        dataGenerator.addTemplate("phone number", Templates.phoneNumber());

        Map<String, Object> generatedData = dataGenerator.generate();
        System.out.println(generatedData);
    }
}
