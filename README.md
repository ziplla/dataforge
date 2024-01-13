# DataForge

This is a Java library that helps generate test data


First, you add this to your `pom.xml`:

```xml
<dependency>
  <groupId>ru.ziplla</groupId>
  <artifactId>dataforge</artifactId>
  <version>0.0.1</version>
</dependency>
```

Then, you use it like this:

```java
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
    }
}
```
You can then assign this generated data to your entities.
Example:

```java
userService.createUser(generatedData);
```

## How to Contribute

Fork repository, make changes, send us a
pull request.
We will review your changes and apply them to the `master` branch shortly,
provided they don't violate our quality standards. To avoid frustration,
before sending us your pull request please run full Maven build:
