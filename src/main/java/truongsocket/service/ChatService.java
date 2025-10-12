package truongsocket.service;

import java.util.List;

import truongsocket.entity.Message;

public interface ChatService {
    Message saveMessage(Message message);
    List<Message> getAllMessages();
}
