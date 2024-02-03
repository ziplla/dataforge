package ru.ziplla.dataforge;

import ru.ziplla.dataforge.constraints.DoubleConstraint;
import ru.ziplla.dataforge.constraints.IntConstraint;
import ru.ziplla.dataforge.constraints.StringConstraint;
import ru.ziplla.dataforge.templates.EmailTemplate;
import ru.ziplla.dataforge.templates.Template;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class DataGeneratorTest {

    private DataGenerator dataGenerator;

    @Before
    public void setUp() {
        dataGenerator = new DataGenerator();
    }

    @Test
    public void testAddStringField() {
        StringConstraint constraints = new StringConstraint(5, 10);
        dataGenerator.addStringField("name", constraints);

        assertNotNull(dataGenerator.getStringConstraints().get("name"));
        assertEquals(constraints, dataGenerator.getStringConstraints().get("name"));
    }

    @Test
    public void testAddIntegerField() {
        IntConstraint constraints = new IntConstraint(1, 100);
        dataGenerator.addIntegerField("age", constraints);

        assertNotNull(dataGenerator.getIntConstraints().get("age"));
        assertEquals(constraints, dataGenerator.getIntConstraints().get("age"));
    }

    @Test
    public void testAddDoubleField() {
        DoubleConstraint constraints = new DoubleConstraint(0.5, 1.5, 2);
        dataGenerator.addDoubleField("weight", constraints);

        assertNotNull(dataGenerator.getDoubleConstraints().get("weight"));
        assertEquals(constraints, dataGenerator.getDoubleConstraints().get("weight"));
    }

    @Test
    public void testAddTemplate() {
        Template template = new EmailTemplate();
        dataGenerator.addTemplate("email", template);

        assertNotNull(dataGenerator.getTemplates().get("email"));
        assertEquals(template, dataGenerator.getTemplates().get("email"));
    }

    @Test
    public void testGenerate() {
        dataGenerator.addStringField("name", new StringConstraint(5, 10));
        dataGenerator.addIntegerField("age", new IntConstraint(1, 100));
        dataGenerator.addDoubleField("weight", new DoubleConstraint(0.5, 1.5, 2));
        dataGenerator.addTemplate("email", new EmailTemplate());

        Map<String, Object> generatedData = dataGenerator.generate();

        assertNotNull(generatedData.get("name"));
        assertTrue(generatedData.get("name") instanceof String);

        assertNotNull(generatedData.get("age"));
        assertTrue(generatedData.get("age") instanceof Integer);

        assertNotNull(generatedData.get("weight"));
        assertTrue(generatedData.get("weight") instanceof Double);

        assertNotNull(generatedData.get("email"));
        assertTrue(generatedData.get("email") instanceof String);
        assertTrue(((String) generatedData.get("email")).contains("@"));
    }
}

