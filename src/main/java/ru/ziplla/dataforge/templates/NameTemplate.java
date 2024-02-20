package ru.ziplla.dataforge.templates;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class NameTemplate implements Template {

    public static String generateRandomName() {
        Random random = new Random();

        Yaml yaml = new Yaml();

        try (InputStream inputStream = NameTemplate.class.getClassLoader().getResourceAsStream("name.yml")) {
            Map<String, List<String>> data = yaml.load(inputStream);

            List<String> maleNameList = data.get("male_first_name");
            List<String> femaleNameList = data.get("female_first_name");
            List<String> lastNameList = data.get("last_name");

            String maleName = maleNameList.get(random.nextInt(maleNameList.size()));
            String femaleName = femaleNameList.get(random.nextInt(femaleNameList.size()));
            String lastName = lastNameList.get(random.nextInt(lastNameList.size()));

            if ((1 + random.nextInt(2)) == 1) {
                return maleName + " " + lastName;
            } else {
                return femaleName + " " + lastName;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Exception";
        }
    }

    @Override
    public Object generate() {
        return generateRandomName();
    }
}

