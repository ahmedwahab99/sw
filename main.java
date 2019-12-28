public class main
{
    public static void main (String args[])  //UNIT TEST CASES-------------------
    {
        //already existing accounts

        User user1=new User(); User user2=new User(); User user3=new User(); User user4=new User(); User user5=new User();

        System.out.println("\n_________________________________________________Signing Up___________________________________________________________\n");

        user1.signUp("Ahmed","5-5-1999","aadabdalwahab99.aa@gmail.com","123","male");

        // with same mail address---------->during runtime enter(mohamed@gmail.com)-----------
        user2.signUp("mohamed","4-4-1999","aadabdalwahab99.aa@gmail.com","456","male");

        user3.signUp("spongebob","3-3-1999","spongebob@gmail.com","789","male");
        user4.signUp("sandy","2-2-1999","sandy@gmail.com","1011","female");
        user5.signUp("patrick","1-1-1999","patrick@gmail.com","1213","male");

        System.out.println("\n__________________________________________________Signing In__________________________________________________________\n");

        user1.logIn("aadabdalwahab99.aa@gmail.com","123");
        user2.logIn("mohamed@gmail.com","456");

        //email address that does not exist-------->during runtime enter(spongebob@gmail.com)---------
        user3.logIn("yellow@gmail.com","789");

        //wrong password-------------during runtime enter(1011)-------
        user4.logIn("sandy@gmail.com","99999");

        user5.logIn("patrick@gmail.com","1213");


        System.out.println("\n__________________________________________________Sending friend requests__________________________________________________________\n");
        user1.sendFriendRequest("patrick@gmail.com");
        user2.sendFriendRequest("patrick@gmail.com");
        user3.sendFriendRequest("patrick@gmail.com");

        System.out.println("\n__________________________________________________Accepting friend requests__________________________________________________________\n");

        user5.acceptFriendRequest();
        user5.acceptFriendRequest();

        System.out.println("\n__________________________________________________viewing friends list__________________________________________________________\n");

        user5.showFriends();

    }
}
