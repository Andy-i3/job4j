package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User u = null;
        for (User userItem : users) {
            if (userItem.getUsername().equals(login)) {
                u = userItem;
                break;
            }
        }
        if (u == null) {
            throw new UserNotFoundException("This user not found");
        }
        return u;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isValid())  {
            throw new UserInvalidException("This user <3 symbols");
        }

        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = null;
        try {
            validate(findUser(users, "Petr Arsentev"));
        } catch (UserInvalidException ev) {
            ev.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
