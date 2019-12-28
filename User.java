import java.util.ArrayList;
import java.util.Scanner;

public class User
{
    String Name, DOB,Email,Password,Gender;
    UserRegister model = new UserRegister();
    Boolean hasAccount, loggedIn;
    Subscription sub;

    User()
    {

    }


    //_____________________________MAIN FUNCTIONS_________________________________

    public void signUp(String N,String D,String E,String P,String G)
    {
        while (true) {
            if (model.validate(E) == true)
            {
                model.Register(N,D,E,P,G);
                System.out.println("________Account Created Successfully________  \n\n");
                hasAccount=true;
                break;
            }
            else
            {
                System.out.println("The Email You Entered is already used, please reenter email: \n");
                Scanner in= new Scanner(System.in);
                String tempMail=in.nextLine();
                E=tempMail;
                continue;
            }
        }

    }

    public void logIn(String Email,String pass)
    {
        UserRegister u= new UserRegister();
        while (true) {
            if(model.validate(Email, pass, u)==true)
            {
                this.load(u);
                loggedIn=true;

                System.out.println("________Welcome " +this.Name+"________  \n\n");
                break;
            }
            else
            {
                Scanner in= new Scanner(System.in);
                Scanner in2= new Scanner(System.in);
                System.out.println("re-enter email: \n");
                Email=in.nextLine();
                System.out.println("re-enter Password: \n");
                pass=in2.nextLine();
                continue;

            }



        }
    }

    public void sendFriendRequest(String mail)
    {
        //check if loggedin

        if (loggedIn==true) {
            // search for friend
            User u = search(mail);
            //add a request to his requestlist

            model.addRequest(this, u);
            System.out.println("Request sent!");
        }
        else{
            System.out.println("please login first \n");
        }
    }

    public void acceptFriendRequest()
    {
        if (loggedIn==true) {


            User friend= new User();
            showRequests(friend);

            model.addFriend(this,friend);
        }
        else
        {
            System.out.println("please login first \n");
        }
    }

    public void Subscribe()
    {
        System.out.println("___To upgrade your registration subscription \n1-Advance \n2-Cancel \n");
        Scanner in=new Scanner(System.in);
        int choice=in.nextInt();
        if(choice==1) {
            if (sub.paymentIsDone() == true)
            {
                model.Upgrade(this);
                PremiumUser Pu=new PremiumUser(this);
            }
        }
        else if(choice==2)
        {
            System.out.println("Process terminated");
        }
        else
        {
            System.out.println("choice not found");
        }
    }

    //_____________________________________________________________________________


    public void showFriends()
    {
        ArrayList <User> friends= new ArrayList<>();
        friends=model.getFriends(this);
        int i=1;
        System.out.println("friends: ");
        for (User req : friends) {
            System.out.println(i + "-" +req.Name);
            i++;
        }

    }

    public void showRequests(User accepted)
    {
        ArrayList <User> requests= new ArrayList<>();
        requests=model.getRequests(this);
        int idx;

        if (requests.isEmpty()==false) {
            System.out.println("Requests: ");
            int i = 1;
            for (User req : requests) {
                System.out.println(i + "-" +req.Name);
                i++;
            }
            System.out.println("Choose the request you want to accept");
            Scanner in=new Scanner(System.in);

            idx=in.nextInt();
            accepted.equal(requests.get(idx-1));


        }
        else
        {
            System.out.println("___You have no friend requests___\n");
        }

    }

    public void load(UserRegister u)// =
    {
        Name=u.getName();
        DOB= u.getDOB();
        Email=u.getEmail();
        Password= u.getPassword();
        Gender= u.getGender();
    }

    public User search(String mail)
    {
        int idx=model.search(mail);

        User u=new User();
        u.load(model.getUserByIndex(idx));

        return u;
    }

    public void equal(User u)
    {
        Name=u.Name;
        DOB= u.DOB;
        Email=u.Email;
        Password= u.Password;
        Gender= u.Gender;
    }
}
