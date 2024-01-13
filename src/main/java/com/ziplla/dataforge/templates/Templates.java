package com.ziplla.dataforge.templates;

public class Templates {

    public static Template email() {
        return new EmailTemplate();
    }

    public static Template phoneNumber() {
        return new PhoneNumberTemplate();
    }
}
