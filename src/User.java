import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private static int lastID;
    private int ID;
    private String name;
    private int age;
    private boolean statusBool;
    private Date dataUpdate;

    public User(String name, String age, String status) throws ValidatorException {
        setName(name);
        setAge(age);
        setStatus(status);
        setID();
        setDataUpdate(new Date());
    }

    public int getID() {
        return ID;
    }

    private void setID() {
        this.ID = lastID;
        lastID++;
    }

    public void setIDwithoutChange(int ID){
        this.ID = ID;
        lastID--;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ValidatorException {
        if (name.length()>25) throw new ValidatorException();
        this.name = name;
    }

    public int getAge() {return age;}

    public void setAge(String age) throws ValidatorException
    {
        if (age.length()>3) throw new ValidatorException();
        char[] chars = age.toCharArray();
        if (chars[0] == '-') throw new ValidatorException();
        for (char c : chars){
            if (!Character.isDigit(c)) throw new ValidatorException();
        }
        this.age = Integer.parseInt(age);
    }

    public boolean isStatus() {
        return statusBool;
    }

    public void setStatus(String status) throws ValidatorException
    {
        if (status.equals("true")) {
            this.statusBool = Boolean.parseBoolean(status);
        } else if (status.equals("false")){
            this.statusBool = Boolean.parseBoolean(status);
        } else {
            throw new ValidatorException();
        }
    }

    public Date getDataUpdate() {
        return dataUpdate;
    }

    public void setDataUpdate(Date dataUpdate) {
        this.dataUpdate = dataUpdate;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    @Override
    public String toString() {
        return "User" +
                "\t{name='" + name + '\'' +
                ",\t age=\t" + age +
                ",\t status=" + statusBool +
                ",\t\t dataUpdate=" + dateFormat.format(dataUpdate) +
                '}' + " ID "+ID;
    }
}
