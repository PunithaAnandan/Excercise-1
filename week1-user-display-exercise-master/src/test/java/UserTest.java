import edu.matc.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Punitha Anandan on 1/26/2017.
 */
public class UserTest {

    User user;

    @Before
    public void setUp() {
        user = new User();
        user.setDateOfBirth("1985-05-14");

    }
    @Test
    public void calculateAge() throws Exception {
        assertEquals("Age was not correct", 31, user.getAge());
        assertNotNull(user);

    }
}