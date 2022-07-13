import model.Auth;
public class Main {
    public static void main(String[] args) {
        Auth auth = new Auth();
        System.out.println("Registration Status: " + auth.register("Test00", "testpassword"));
        System.out.println("Registration Status: " + auth.register("Test01", "testpassword"));
        System.out.println("Login Status: " + auth.login("Test00", "testpassword"));
        System.out.println("Login Status: " + auth.login("Test01", "testpassword"));
        System.out.println("Login Status: " + auth.login("Test02", "testpassword"));
        System.out.println("Login Status: " + auth.login("Test00", "testpasswor"));
        auth.printUserMatrix();
        auth.printUser(0);
    }
}
