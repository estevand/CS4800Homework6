public class ChatApplication
{
    public static void main(String[] args)
    {
        ChatServer chatServer = new ChatServer();
        User user1 = new User("Person1", chatServer);
        User user2 = new User("Person2", chatServer);
        User user3 = new User("Person3", chatServer);

        chatServer.registerUser(user1);
        chatServer.registerUser(user2);
        chatServer.registerUser(user3);

        user1.sendMessage("Person3", "Hello");
        user1.sendMessage("Person3", "Good Morning");
        user2.sendMessage("Person1", "Bye");
        user3.sendMessage("Person2", "Hi");


        user1.blockUser("Person2");
        user2.sendMessage("Person1", "The message is blocked");

        for (Message message : user1)
        {
            System.out.println(message.getSender() + " to " + message.getReciever().get(0) + " [" + message.getTimeStamp() + "]: " + message.getContent());
        }

        for (Message message : user2)
        {
            System.out.println(message.getSender() + " to " + message.getReciever().get(0) + " [" + message.getTimeStamp() + "]: " + message.getContent());
        }

        for (Message message : user3)
        {
            System.out.println(message.getSender() + " to " + message.getReciever().get(0) + " [" + message.getTimeStamp() + "]: " + message.getContent());
        }

    }
}
