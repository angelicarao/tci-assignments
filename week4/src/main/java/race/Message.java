package race;

import java.time.Instant;
import java.util.Date;

public class Message {
    public String getText() {
        return "";
    }

    public Date getTime() {
        return Date.from(Instant.now());
    }
}
