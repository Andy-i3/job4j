package ru.job4j.ex;

public class UserNotFoundException extends Throwable {
    /**
     * @param message
     */
    public UserNotFoundException(String message) {
        System.out.println( message );
    }
}
