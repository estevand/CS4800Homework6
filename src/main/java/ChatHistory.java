import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistory implements IterableByUser
{
    private final List<Message> messages = new ArrayList<>();

    public void addMessage(Message message)
    {
        messages.add(message);
    }
    public MessageMemento getLastMessage()
    {
        Message lastMessage = messages.get(messages.size() - 1);
        return new MessageMemento(lastMessage.getContent(), lastMessage.getTimeStamp());
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith)
    {
        return new SearchMessagesByUserIterator(userToSearchWith, messages);
    }
}
