package truongsocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import truongsocket.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
