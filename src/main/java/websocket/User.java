package websocket;

import org.springframework.web.socket.WebSocketSession;

public class User {
	private String userId;
	private WebSocketSession session;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setSession(WebSocketSession session) {
		this.session = session;
	}
	public WebSocketSession getSession() {
		return session;
	}
}
