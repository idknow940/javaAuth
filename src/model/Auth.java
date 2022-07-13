package model;

import java.util.Arrays;
import java.util.Objects;

public class Auth {
    private int minimumUsrNameLength;
    private int minimumPassWordLength;
    String[][] usrMatrix = new String[100][3];

    public boolean register(String usrName, String passWord) {
        if (usrName.length() >= getMinimumUsrNameLength() && passWord.length() >= getMinimumUsrNameLength()) {
            addToUsrMatrix(usrName, passWord);
            return true;
        }
        return false;
    }

    public boolean login(String usrName, String passWord) {
        for (String[] matrix : usrMatrix) {
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
        for (int i = 0; i < usrMatrix.length; i++) {
            if (Arrays.equals(usrMatrix[i], new String[]{null, null, null}) || Objects.equals(usrMatrix[i][1], usrName)) {
                for (String ignored : usrMatrix[i]) {
                    usr.setId(i);
                    usr.setUsrName(usrName);
                    usr.setPassWord(passWord);
                    usrMatrix[i] = new String[]{"" + usr.getId() + "", usr.getUsrName(), usr.getPassWord()};
                }
                break;
            }
        }
    }

    public void printUserMatrix(){
        for (String[] strings : usrMatrix) {
            if (!Arrays.equals(strings, new String[]{null, null, null})){
                for (String string : strings) {
                    System.out.print(string + " ");
                }
                System.out.println();
            }
        }
    }

    public void reinitializeUserMatrix(){
        String[][] oldMatrix = usrMatrix;
        String[][] newUsrMatrix = new String[oldMatrix.length*2][oldMatrix[0].length];
        for (int i = 0; i < oldMatrix.length; i++) {
            newUsrMatrix[i] = oldMatrix[i];
        }
        usrMatrix = newUsrMatrix;
    }

    public int getMinimumUsrNameLength() {
        return minimumUsrNameLength;
    }

    public void setMinimumUsrNameLength(int minimumUsrNameLength) {
        this.minimumUsrNameLength = minimumUsrNameLength;
    }

    public int getMinimumPassWordLength() {
        return minimumPassWordLength;
    }

    public void setMinimumPassWordLength(int minimumPassWordLength) {
        this.minimumPassWordLength = minimumPassWordLength;
    }

    public void printUser(int id) {
        User n = new User();
        n.setId(id);
        n.setUsrName(usrMatrix[id][1]);
        n.setPassWord(usrMatrix[id][2]);
        System.out.println(n.info());
    }
}
