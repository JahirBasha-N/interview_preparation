package MIsc;

import org.jetbrains.annotations.NotNull;

public class FieldsAndMethods {
    public FieldsAndMethods(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public FieldsAndMethods(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    private String firstName;
    private String lastName;
    private Integer age;
    private String fullName;
    public String getFullName() {
        return (fullName == null) ? ((firstName != null) ? (firstName + ((lastName != null) ? (" " + lastName) : "")) : "") : fullName;
    }

    private String getFirstName() {
        return firstName;
    }

    private String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    private void setLastName(String lastName) {
        this.lastName = lastName;
    }
    private void setFullName(@NotNull String firstName, @NotNull String lastName) {
        this.fullName = firstName + " " + lastName;
    }
}
