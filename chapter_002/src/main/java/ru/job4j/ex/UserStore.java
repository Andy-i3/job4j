package ru.job4j.ex;

public class UserStore {



    public static User findUser(User[] users, String login) throws UserNotFoundException {

        User u = null;
        for (User User_item : users) { if (User_item.getUsername().equals( login )) {
            u = User_item;
            break;
        }  else {
           throw new UserNotFoundException("This user not found");
        }
        }
        return u;
    }

    public static boolean validate(User user) throws UserInvalidException {
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User( "Petr Arsentev", true )
        };
        User user = null;
        try {
            user = findUser( users, "Petr Arsentev" );
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (validate( user )) {
                System.out.println( "This user has an access" );
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        }
    }
}