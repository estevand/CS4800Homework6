import java.util.Date;
import java.util.*;

public class MessageMemento
{
    private final String content;
    private final Date timeStamp;

    public MessageMemento(String content, Date timeStamp)
    {
        this.content = content;
        this.timeStamp = timeStamp;
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
