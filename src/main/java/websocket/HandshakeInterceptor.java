package websocket;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
/**
 * 创建握手（handshake）接口/拦截器
 * 作用：握手前做一些事，把所需要的东西放入到attributes里面
 * 可以在WebSocketHandler的session中， 取到相应的值
 * @author Administrator
 *
 */
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor{
	
	// 握手前
    @Override
    public boolean beforeHandshake(ServerHttpRequest request,
            ServerHttpResponse response, WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws Exception {
        String userId = ((ServletServerHttpRequest) request).getServletRequest().getParameter("userId");
        attributes.put("userId", userId);
        System.out.println("++++++++++++++++ HandshakeInterceptor: beforeHandshake  ++++++++++++++"+attributes);
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }
    
    // 握手后
    @Override
    public void afterHandshake(ServerHttpRequest request,
            ServerHttpResponse response, WebSocketHandler wsHandler,
            Exception ex) {

        System.out.println("++++++++++++++++ HandshakeInterceptor: afterHandshake  ++++++++++++++");
        super.afterHandshake(request, response, wsHandler, ex);
    }

}
