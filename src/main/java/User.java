import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;


public class User implements Iterable<Message>
{
    private final String username;
    private final ChatServer chatServer;
    private final ChatHistory chatHistory = new ChatHistory();
    private MessageMemento lastMessageMemento;

    public User(String username, ChatServer chatServer)
    {
        this.username = username;
        this.chatServer = chatServer;
    }

    public String getUsername()
    {
        return username;
    }
    public void sendMessage(String reciever, String content)
    {
        Message message = new Message(username, Collections.singletonList(reciever), content);
        chatServer.sendMessage(this, message);
        lastMessageMemento = new MessageMemento(content, message.getTimeStamp());
    }

    public void undoLastMessage()
    {
        if (lastMessageMemento != null) {
            chatServer.sendMessage(this, new Message(username, Collections.emptyList(), lastMessageMemento.getContent()));
            lastMessageMemento = null;
        }
    }

    public void blockUser(String usernameToBlock)
    {
        chatServer.blockUser(this, usernameToBlock);
    }

    public void recieveMessage(Message message)
    {
        chatHistory.addMessage(message);
        lastMessageMemento = new MessageMemento(message.getContent(), message.getTimeStamp());
    }

    public ChatHistory getChatHistory()
    {
        return chatHistory;
    }

    @Override
    public Iterator<Message> iterator()
    {
        return chatHistory.iterator(this);
    }
}
