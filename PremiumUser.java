import java.util.ArrayList;

public class PremiumUser extends User {
    ArrayList<User> pUsers =new ArrayList<>();
    PremiumUser(User u)
    {
        pUsers.add(u);
    }

    private void someExtraFunctionalities()
    {

    }
}
