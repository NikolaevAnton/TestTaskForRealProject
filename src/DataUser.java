import java.util.ArrayList;

/**
 * Created by nikolaev on 26.04.2016.
 */
public class DataUser {
    private static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addUser(int index, User user) {
        users.add(index,user);
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static User getUser(int index){
        return users.get(index);
    }

    public static void removeUserThrowIndex(int index){
        users.remove(index);
    }

    public static void removeUser(User user){
        users.remove(user);
    }

    public static void addAll(ArrayList<User> usersForAddAll){
        users.addAll(usersForAddAll);
    }

    public static int getSize(){
        return users.size();
    }
}
