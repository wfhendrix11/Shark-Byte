package main;

public class UserAccount {
    private String username;
    private String password;

    UserAccount() {

    }

    UserAccount(String newUsername, String newPassword) {
        username = newUsername;
        password = newPassword;
    }

    void changeUsername(String newUsername) {
        if (newUsername == null) {
            return;
        }

        username = newUsername;
    }

    void changePassword(String newPassword) {
        if (newPassword == null) {
            return;
        }

        password = newPassword;
    }
}
