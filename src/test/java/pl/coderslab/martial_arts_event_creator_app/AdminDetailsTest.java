package pl.coderslab.martial_arts_event_creator_app;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import pl.coderslab.martial_arts_event_creator_app.Model.User.AdminDetails;
import pl.coderslab.martial_arts_event_creator_app.Model.User.User;

import java.util.HashSet;
import java.util.Set;

public class AdminDetailsTest {

    @Test
    public void addUserToVerifyTest() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@test.pl");
        user.setPassword("test");
        user.setFirstName("test");
        user.setLastName("test");
        user.setRole("ROLE_USER");
        user.setAddress("test");

        AdminDetails adminDetails = new AdminDetails();
        adminDetails.setId(1L);

        Set<User> usersToVerify = new HashSet<>();
        usersToVerify.add(user);
        adminDetails.setUsersToVerify(usersToVerify);

        assertThat(adminDetails.getUsersToVerify(), hasItem(user));
    }

    @Test
    public void removeUserFromVerificationTest() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@test.pl");
        user.setPassword("test");
        user.setFirstName("test");
        user.setLastName("test");
        user.setRole("ROLE_USER");
        user.setAddress("test");

        AdminDetails adminDetails = new AdminDetails();
        adminDetails.setId(1L);

        Set<User> usersToVerify = new HashSet<>();
        usersToVerify.add(user);
        adminDetails.setUsersToVerify(usersToVerify);
        usersToVerify.remove(user);
        adminDetails.setUsersToVerify(usersToVerify);

        assertThat(adminDetails.getUsersToVerify(), not(hasItem(user)));
    }
}
