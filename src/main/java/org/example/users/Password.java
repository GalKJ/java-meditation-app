package org.example.users;

public class Password {
    private String value;

    public Password(String value) {
        this.value = encrypt(value);
    }

    private String encrypt(String plain) {
        // Simple fake encryption for now
        return new StringBuilder(plain).reverse().toString();
    }

    public String getEncrypted() {
        return value;
    }
}
