import java.util.ArrayList;

public class UserRegister
{
    private static int userNumber=0;
    private static ArrayList <UserRegister> users=new ArrayList<>();

    private String Name, DOB,Email,Password,Gender;
    public static ArrayList <User> friends=new ArrayList<>();
    public static ArrayList <User> requests=new ArrayList<>();

    boolean isPremium=false;

    UserRegister()
    {

    }

    public Boolean validate(String E)
    {

        for (UserRegister u: users)
        {
            if(E.equals(u.Email))
            {
                return false;
            }
        }
        return true;
    }

    public Boolean validate(String E, String p,UserRegister thisUser)
    {

        for (UserRegister u: users)
        {
            if(E.equals(u.Email))
            {
                if(p.equals(u.Password))
                {
                    thisUser.equal(u);
                    return true;
                }
                else
                {
                    System.out.println("________WRONG PASSWORD!________");
                    return false;
                }
            }
        }
        System.out.println("________Mail you entered is not found!________");
        return false;
    }

    public void Register(String N,String D,String E,String P,String G)
    {
        Name=N;
        DOB=D;
        Email=E;
        Password=P;
        Gender=G;
        users.add(this);
        userNumber++;

    }

    public void Upgrade(User toUpgrade)
    {
        int idx=search(toUpgrade.Email);
        users.get(idx).isPremium=true;
    }

    public void addRequest(User sender,User receiver)
    {
        for (UserRegister u:users)
        {
            if(u.Email==receiver.Email)
            {

                u.requests.add(sender);

            }
        }
    }

    public void addFriend(User user, User toAdd)
    {
        for (UserRegister u:users)
        {
            if(u.Email==user.Email)
            {
                //add to friends
                u.friends.add(toAdd);

                //remove from requests
                for (int i=0;i<requests.size();i++)
                {
                    if (requests.get(i).Email==toAdd.Email) { requests.remove(i); }
                }

            }
        }
    }


    public UserRegister getUserByIndex(int idx)
    {
        return users.get(idx);
    }


    public void equal(UserRegister u)
    {
        Name=u.Name;
        DOB= u.DOB;
        Email=u.Email;
        Password= u.Password;
        Gender= u.Gender;
    }

    public int search(String mail)
    {

        int i=0;
        for (UserRegister u: users)
        {
            if(mail.equals(u.Email))
            {
                return i;
            }
            i++;
        }

        return -1;
    }

    public ArrayList<User> getRequests(User user)
    {
        ArrayList<User> names= new ArrayList<>();
        int idx=search(user.Email);

        for (User u:users.get(idx).requests)
        {
            names.add(u);
        }

        return names;
    }

    public ArrayList<User> getFriends(User user)
    {
        ArrayList<User> names= new ArrayList<>();
        int idx=search(user.Email);

        for (User u:users.get(idx).friends)
        {
            names.add(u);
        }

        return names;
    }

    public String getName() {
        return Name;
    }

    public String getDOB() {
        return DOB;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getGender() {
        return Gender;
    }
}
