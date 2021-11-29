package org.example.command;

import org.example.domain.User;
import org.example.repository.Repository;
import org.example.repository.UserJdbcRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

class PrintAllTest {

    final Repository<User> repo = Mockito.mock(UserJdbcRepository.class);

    @InjectMocks
    final Command command = new PrintAll(repo);

    @Test
    void testExecute() {
        when(repo.getAll()).thenReturn(new ArrayList<>());
        command.execute();
        verify(repo, times(1)).getAll();
    }
}