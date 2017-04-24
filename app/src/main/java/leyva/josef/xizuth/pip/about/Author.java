package leyva.josef.xizuth.pip.about;

/**
 * Created by josef on 4/24/17.
 */

public class Author {

    private final String name;
    private final String email;
    private final String description;

    public Author(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }
}
