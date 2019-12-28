import java.util.Scanner;

public class Subscription {
    UserRegister model = new UserRegister();

    public boolean paymentIsDone() {
        while (true) {
            System.out.println("___via: \n1-credit card \n2- PayPal\nAny key- cancel");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            if (choice == 1 || choice == 2) {
                System.out.println("___payment done successfully___\n");
                return true;
            } else {
                break;
            }

        }return false;
    }
}
