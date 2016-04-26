import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by nikolaev on 25.04.2016.
 */
public class UserCreate {
    static ArrayList<User> users = new ArrayList<>();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        users.addAll(TestUser.someUsers());
        int commandNumber = 0;
        while (commandNumber != 6){
            System.out.println("Введите комманду:");
            System.out.println("1 - Ввести нового пользователя" +
                    "\t2 - Удалить" +
                    "\t3 - Именить" +
                    "\t4 - Список" +
                    "\t5 - Поиск по имени" +
                    "\t6 - Выйти");

            try {
                commandNumber = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                continue;
            }
            if (commandNumber<1 || commandNumber>5) {
                continue;
            }
            switch (commandNumber){
                case 1:
                    createUser();
                    break;
                case 2:
                    delateUser();
                    break;
                case 3:
                    changeUser();
                    break;
                case 4:
                    listUser();
                    break;
                case 5:
                    seacherUser();
                    break;
                case 6:
                    break;
            }

        }
    }

    private static void seacherUser() {
        System.out.println("--Поиск по имени--");
        String name = "";
        while (true) {
            try {
                System.out.print("Введите имя: ");
                name = reader.readLine();
            } catch (IOException ignor) {
                continue;
            }
            break;
        }
        ArrayList<User> indexName = new ArrayList<>();
        for(User user : users){
            String tempName = user.getName();
            if (tempName.equals(name)) {
                indexName.add(user);
            }
        }
        if (indexName.size() == 0){
            System.out.println("--Извините, пользователи с таким именем не обнаружены.--");
        } else {
            for(User user : indexName){
                System.out.println(user);
            }
        }

    }

    private static void changeUser() {
        if(users.size() == 0) {
            System.out.println("--Нет пользователей--");
            return;
        }
        System.out.println("--Изменение пользователя--");
        int index = seacher();
        User changed = users.get(index);
        System.out.println(changed);
        System.out.print("--Ввод данных--");
        User newUser = createData();
        newUser.setIDwithoutChange(changed.getID());
        users.set(index, newUser);
    }

    private static void delateUser() {
        System.out.println("--Удаление пользователя--");
        users.remove(seacher());
    }

    private static int seacher(){
        String temp = "";
        int index = -1;
        while (true) {
            try {
                System.out.print("Введите ID пользователя: ");
                temp = reader.readLine();
                index = seachID_returnIndex(temp);
            } catch (IOException ignor) {
                continue;
            } catch (ValidatorException ignor){
                continue;
            }
            return index;
        }
    }

    private static int seachID_returnIndex(String temp) throws ValidatorException {
        char[] chars = temp.toCharArray();
        for(char c : chars){
            if (!Character.isDigit(c)) throw new ValidatorException();
        }
        int valid = Integer.parseInt(temp);
        int[] arrayID = new int[users.size()];
        int arrIndex = 0;
        for (User user : users){
            arrayID[arrIndex++] = user.getID();
        }
        int validIndex = Arrays.binarySearch(arrayID,valid);
        if ( validIndex<0 ) throw new ValidatorException();
        return validIndex;
    }


    private static void listUser() {
        if(users.size() == 0) {
            System.out.println("--Нет пользователей--");
            return;
        }
        for(User user : users){
            System.out.println(user);
        }
    }


    private static void createUser() {
        User user = createData();
        users.add(user);
    }

    private static User createData() {
        String name;
        String age;
        String status;
        User user = null;
        while (true) {
            try {
                System.out.print("Имя: ");
                name = reader.readLine();
                System.out.print("Возраст: ");
                age = reader.readLine();
                System.out.print("Статус: ");
                status = reader.readLine();
            }catch (IOException e){
                continue;
            }
            try {
                user = new User(name,age,status);
            } catch (ValidatorException e) {
                continue;
            }
            break;
        }
        return user;
    }

}
