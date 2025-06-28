package dao;

import entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserDaoTest {

    @Mock
    private UserDao userDao;

    @Test
    void shouldGetUserById() {
        User expectedUser = new User(1,"1","1","1");

        Mockito.doReturn(Optional.of(expectedUser)).when(userDao).get(expectedUser.getId());
        User actualUser = userDao.get(1).get();

        Assertions.assertThat(actualUser).isEqualTo(expectedUser);
    }


}
