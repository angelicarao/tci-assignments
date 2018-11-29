import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    private UserDAO userDAO = mock(UserDAO.class);
    private SecurityService securityService = mock(SecurityService.class);
    private UserServiceImpl userService;
    private User user = mock(User.class);
    private static final String USER_PASS = "password";

    @Before
    public void setUp() {
        this.userService = new UserServiceImpl(userDAO, securityService);
    }

    @Test
    public void test_assignPassword() throws Exception {
        // arrange
        when(this.user.getPassword()).thenReturn(USER_PASS);
        when(this.securityService.md5(USER_PASS)).thenReturn(USER_PASS + "md5");

        // act
        this.userService.assignPassword(this.user);

        // assert
        verify(this.user).setPassword(USER_PASS + "md5");
        verify(this.userDAO).updateUser(this.user);
    }
}