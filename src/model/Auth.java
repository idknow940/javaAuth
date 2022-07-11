package model;

import java.util.Arrays;
import java.util.Objects;

public class Auth {
    int minimumUsrNameLength = 6;
    int minimumPassWordLength = 8;
    String[][] usrMatrix__ = new String[100][3];

    public boolean register(String usrName, String passWord) {
        if (usrName.length() >= minimumUsrNameLength && passWord.length() >= minimumPassWordLength) {
            addToUsrMatrix(usrName, passWord);
            return true;
        }
        return false;
    }

    public boolean login(String usrName, String passWord) {
        for (String[] matrix : usrMatrix__) {
            for (int j = 0; j < matrix.length; j++) {
                if (Objects.equals(matrix[1], usrName) && Objects.equals(matrix[2], passWord)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addToUsrMatrix(String usrName, String passWord) {
        User usr = new User();
        for (int i = 0; i < usrMatrix__.length; i++) {
            if (Arrays.equals(usrMatrix__[i], new String[]{null, null, null}) || Objects.equals(usrMatrix__[i][1], usrName)) {
                for (String ignored : usrMatrix__[i]) {
                    usr.setId(i);
                    usr.setUsrName(usrName);
                    usr.setPassWord(passWord);
                    usrMatrix__[i] = new String[]{"" + usr.getId() + "", usr.getUsrName(), usr.getPassWord()};
                }
                break;
            }
        }
    }

    public void printUserMatrix(){
        for (String[] strings : usrMatrix__) {
            if (!Arrays.equals(strings, new String[]{null, null, null})){
                for (String string : strings) {
                    System.out.print(string + " ");
                }
                System.out.println();
            }
        }
    }
}
