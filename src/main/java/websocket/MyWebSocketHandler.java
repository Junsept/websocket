package websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * websocket的处理类
 * @author Administrator
 *
 */
public class MyWebSocketHandler extends AbstractWebSocketHandler{
	private static final Logger log = LoggerFactory.getLogger(MyWebSocketHandler.class);
	// 保存所有的用户session
    private static final List<User> userList = new ArrayList<User>();
    // 连接就绪时 
    @Override
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {
        log.info("connect websocket success.......");
        Map<String, Object> attribute = session.getHandshakeAttributes();  
        User user = new User();
        user.setUserId(attribute.get("userId").toString());
        user.setSession(session);
        userList.add(user);
    }
    
    // 处理信息
    @Override
    public void handleMessage(WebSocketSession session,
            WebSocketMessage<?> message) throws Exception {

        Gson gson = new Gson();
        
        // 将消息JSON格式通过Gson转换成Map
        // message.getPayload().toString() 获取消息具体内容
        Map<String, Object> msg = gson.fromJson(message.getPayload().toString(), 
                new TypeToken<Map<String, Object>>(){}.getType());
        
        log.info("handleMessage......."+message.getPayload());
        
        // 处理消息 msgContent消息内容
        TextMessage textMessage = new TextMessage("sessionId为"+session.getId()+"的用户说："+msg.get("msgContent").toString(), true);
       
        if(msg.get("chatType").toString().equals("all")){
            // 调用方法（发送消息给所有人）
            sendMsgToAllsessionList(textMessage);
        }else{
        	String sessionId = msg.get("sessionId").toString();
        	sendMsgToOnesession(textMessage, sessionId);
        	sendMsgToOnesession(textMessage, session.getId());
        }
    }
    
    // 处理传输时异常
    @Override
    public void handleTransportError(WebSocketSession session,
            Throwable exception) throws Exception {
    	log.error(exception.getMessage());
    }
    
    // 关闭连接时
    @Override
    public void afterConnectionClosed(WebSocketSession session,
            CloseStatus closeStatus) throws Exception {
        log.info("connect websocket closed.......");
    
    }
    
    // 给所有用户发送信息
    public void sendMsgToAllsessionList(WebSocketMessage<?> message) throws Exception{    	
        for (User user : userList) {
           user.getSession().sendMessage(message);
        }
    }
    
    // 一对一发送信息
    public void sendMsgToOnesession(WebSocketMessage<?> message, String sessionId) throws IOException{
        for (User user : userList) {
            user.getSession().sendMessage(message);
         }
    }
    
}
