package bean;

/**
 * Created by Lifu on 2017/9/20.
 */

public class Session {
    private int session_id;
    private String session_senderId;
    private String session_senderName;
    private String session_senderIcon;
    private String session_receiverId;
    private int session_tag;
    private String session_lastContent;
    private String session_lastTime;

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }

    public String getSession_senderId() {
        return session_senderId;
    }

    public void setSession_senderId(String session_senderId) {
        this.session_senderId = session_senderId;
    }

    public String getSession_senderName() {
        return session_senderName;
    }

    public void setSession_senderName(String session_senderName) {
        this.session_senderName = session_senderName;
    }

    public String getSession_senderIcon() {
        return session_senderIcon;
    }

    public void setSession_senderIcon(String session_senderIcon) {
        this.session_senderIcon = session_senderIcon;
    }

    public String getSession_reciverId() {
        return session_receiverId;
    }

    public void setSession_reciverId(String session_reciverId) {
        this.session_receiverId = session_reciverId;
    }

    public int getSession_tag() {
        return session_tag;
    }

    public void setSession_tag(int session_tag) {
        this.session_tag = session_tag;
    }

    public String getSession_lastContent() {
        return session_lastContent;
    }

    public void setSession_lastContent(String session_lastContent) {
        this.session_lastContent = session_lastContent;
    }

    public String getSession_lastTime() {
        return session_lastTime;
    }

    public void setSession_lastTime(String session_lastTime) {
        this.session_lastTime = session_lastTime;
    }
}
