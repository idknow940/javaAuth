package model;

public class User {
    private int id;
    private String usrName;
    private String passWord;
    private Auth auth = new Auth();

    public String info() {
        return "User{" +
                "id=" + id +
                ", usrName='" + usrName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        if (usrName.length() >= auth.getMinimumUsrNameLength())
            this.usrName = usrName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
