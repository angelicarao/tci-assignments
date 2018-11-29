package user.service;

public interface User {
    String getPassword();

    void setPassword(String passwordMd5);
}
