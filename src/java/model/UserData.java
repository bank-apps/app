package model;

public class UserData {
    
    private final String DNI;
    private String password;
    private String name;
    private String surnames;
    private String email;
    private String address;
    private String phoneNumber;

    public UserData(String DNI, String password, String name, String surnames, String email, String address, String phoneNumber) {
        this.DNI = DNI;
        this.password = password;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getDNI() {
        return DNI;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
}
