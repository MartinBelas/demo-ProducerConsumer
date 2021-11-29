package org.example.command;

import org.example.domain.User;
import org.example.repository.Repository;
import org.example.repository.UserJdbcRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class DeleteAllTest {

    final Repository<User> repo = Mockito.mock(UserJdbcRepository.class);

    @InjectMocks
    final Command command = new DeleteAll(repo);

    @Test
    void testExecute() {
        doNothing().when(repo).deleteAll();
        command.execute();
        verify(repo, times(1)).deleteAll();
    }
}