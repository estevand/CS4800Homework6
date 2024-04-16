import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
public class SearchMessagesByUserIterator implements Iterator<Message>
{
    private final User userToSearchWith;
    private final List<Message> messages;
    private int currentIndex = 0;

    public SearchMessagesByUserIterator(User userToSearchWith, List<Message> messages)
    {
        this.userToSearchWith = userToSearchWith;
        this.messages = messages;
    }

    @Override
    public boolean hasNext()
    {
        while (currentIndex < messages.size())
        {
            Message message = messages.get(currentIndex);
            if (message.getSender().equals(userToSearchWith.getUsername()) || message.getReciever().contains(userToSearchWith.getUsername()))
            {
                return true;
            }
            currentIndex++;
        }
        return false;
    }
    @Override
    public Message next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException();
        }
        return messages.get(currentIndex++);
    }

}
