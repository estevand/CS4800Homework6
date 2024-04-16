import java.util.Date;
import java.util.List;

public class Message
{
    private final String sender;
    private final List<String> reciever;
    private final String content;
    private final Date timeStamp;

    public Message(String sender, List<String> reciever, String content)
    {
        this.sender = sender;
        this.reciever = reciever;
        this.content = content;
        this.timeStamp = new Date();
    }

    public String getSender()
    {
        return sender;
    }

    public List<String> getReciever()
    {
        return reciever;
    }

    public String getContent()
    {
        return content;
    }

    public Date getTimeStamp()
    {
        return timeStamp;
    }



}
