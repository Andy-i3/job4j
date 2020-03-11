package ru.job4j.ex;

public class UserInvalidException extends UserNotFoundException {
    /**
     * @param message
     */
    public UserInvalidException(String message) {
        super(message);
    }
}
