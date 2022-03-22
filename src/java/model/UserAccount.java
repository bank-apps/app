package model;

public class UserAccount {
    
    private UserData userData;

    public UserAccount(UserData userData) {
        this.userData = userData;
    }

    public UserData getData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
    
}
