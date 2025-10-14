package org.example.users;

public class Username {
    private String value;

    public Username(String value) {
        this.value = trimWhitespace(value);
        checkForIllegalCharacters();
    }

    private String trimWhitespace(String input) {
        return input.trim();
    }

    private void checkForIllegalCharacters() {
        if (value.contains(" ")) {
            throw new IllegalArgumentException("Username cannot contain spaces");
        }
    }

    public String getValue() {
        return value;
    }
}
