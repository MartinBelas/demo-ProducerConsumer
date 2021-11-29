package org.example.command;

import org.example.domain.User;
import org.example.repository.Repository;
import org.example.repository.UserJdbcRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddTest {

    final Repository<User> repo = Mockito.mock(UserJdbcRepository.class);

    final int userId = 1;
    final String userGuid = UUID.randomUUID().toString();
    final String userName = "Adam";
    final User user = new User(userId, userGuid, userName);

    @InjectMocks
    final Command command = new Add(repo, user);

    @Test
    void testExecute() {
        doNothing().when(repo).add(user);
        command.execute();
        verify(repo, times(1)).add(user);
    }
}