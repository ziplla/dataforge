# Data Forge

This is a Java library that helps generate test data


First, you add this to your `pom.xml`:

```xml
<dependency>
  <groupId>ru.ziplla</groupId>
  <artifactId>dataforge</artifactId>
  <version>1.0.0</version>
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
        dataGenerator.addDoubleField("salary", Constraints.rangeDouble(1, 1000, 2));
        dataGenerator.addStringField("string", Constraints.length(2, 6));
        dataGenerator.addTemplate("email", Templates.email());
        dataGenerator.addTemplate("phone number", Templates.phoneNumber());
        dataGenerator.addTemplate("name", Templates.name());

        Map<String, Object> generatedData = dataGenerator.generate();
    }
}
```
You can then assign this generated data to your entities.
Example:

```java
userService.createUser(generatedData);
```

#### A more detailed description of each method:

Method ```addIntegerField```:

If you want a number to be generated in the range you need, then you need to do this:

```java
dataGenerator.addIntegerField("Integer", Constraints.range(1, 3));
```

You can write the range in any order

If you want a number to be generated in any range, then you do not need to specify the range

```java
dataGenerator.addIntegerField("Integer");
```

Methods ```addLongField```, ```addByteField```, ```addShortField``` work the same as ```addIntegerField```:

```java
dataGenerator.addLongField("Long", Constraints.rangeLong(44L, 88L));
dataGenerator.addByteField("Byte", Constraints.rangeByte((byte) 2, (byte) 4));
dataGenerator.addShortField("Short", Constraints.rangeShort((short) 1, (short) 5));
```

Method ```addDoubleField```:
If you want a number to be generated in the range you need, then you need to do this:

```java
dataGenerator.addDoubleField("Double", Constraints.rangeDouble(3, 15));
```

You can also specify how many digits after the decimal point should be in the number

```java
dataGenerator.addDoubleField("Double", Constraints.rangeDouble(3, 15, 5));
```

Method ```addFloatField``` work as same as ```addDoubleField```:
```java
dataGenerator.addFloatField("Float", Constraints.rangeFloat(4, 75, 2));
```

Method ```addStringField``` generate a random string in a given range:

```java
dataGenerator.addStringField("String", Constraints.lengthString(2, 6));
```
You can also specify in which language to generate the string (Russian, English) (if you do not do this, the default string will be in English)

```java
dataGenerator.addStringField("string", Constraints.lengthString(6, 2, Language.ru));
dataGenerator.addStringField("string", Constraints.lengthString(6, 2, Language.en));
```

You can also generate phone numbers, emails, names

For this use method ```addTemplate```:
```java
dataGenerator.addTemplate("email", Templates.email());
dataGenerator.addTemplate("phone number", Templates.phoneNumber());
dataGenerator.addTemplate("name", Templates.name());
```

## How to Contribute

Fork repository, make changes, send us a
pull request.
We will review your changes and apply them to the `master` branch. To avoid frustration,
before sending us your pull request please run full Maven build
