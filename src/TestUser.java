import java.util.ArrayList;

/**
 * Created by nikolaev on 25.04.2016.
 */
public class TestUser {
    private TestUser(){}

    public static ArrayList<User> someUsers(){
        ArrayList<User> users = new ArrayList<>();
        try {
            users.add(new User("Антон", "26", "true"));
            users.add(new User("Ира", "40", "false"));
            users.add(new User("Игор", "20", "false"));
            users.add(new User("Света", "22", "false"));
            users.add(new User("Катя", "27", "true"));
        }catch (ValidatorException ignor){
            //NOP
        }
        return users;
    }

}
