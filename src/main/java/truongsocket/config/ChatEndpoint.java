package truongsocket.config;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/chat-socket")
@Component
public class ChatEndpoint {

    private static final Set<Session> sessions = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
    	for (Session sessiong : sessions) {
            if (sessiong.isOpen()) {
                try {
                    sessiong.getBasicRemote().sendText("Connection "+session.getId()+" connected to room");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        sessions.add(session);
        
        System.out.println("New connection: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session senderSession) {
        for (Session session : sessions) {
            if (session.isOpen()) {
                try {
                    session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        System.out.println("Closed connection: " + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }
}
