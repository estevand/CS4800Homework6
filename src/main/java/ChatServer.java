import java.util.*;

public class ChatServer
{
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, List<String>> blockedUsers = new HashMap<>();

    public void registerUser(User user)
    {
        users.put(user.getUsername(), user);
    }

    public void unregisterUser(User user)
    {
        users.remove(user.getUsername());
    }
    public void sendMessage(User sender, String reciever, String content)
    {
        List<String> recievers = new ArrayList<>();
        recievers.add(reciever);
        sendMessage(sender, new Message(sender.getUsername(), recievers, content));
    }
    public void sendMessage(User sender, Message message)
    {
        List<String> recievers  = message.getReciever();
        for(String reciever: recievers)
        {
            if(!isBlocked(sender.getUsername(), reciever))
            {
                User recieve = users.get(reciever);
                if (recieve != null)
                {
                    recieve.recieveMessage(message);
                }
            }
        }
    }
    public void blockUser(User user, String usernameToBlock)
    {
        blockedUsers.computeIfAbsent(user.getUsername(), i -> new ArrayList<>()).add(usernameToBlock);
    }

    private boolean isBlocked(String sender, String reciever)
    {
        List<String> blocked = blockedUsers.get(sender);
        return blocked != null && blocked.contains(reciever);
    }
}