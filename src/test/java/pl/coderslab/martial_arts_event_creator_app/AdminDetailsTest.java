package pl.coderslab.martial_arts_event_creator_app;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import pl.coderslab.martial_arts_event_creator_app.Model.User.MenagerDetails;
import pl.coderslab.martial_arts_event_creator_app.Model.User.AdminDetails;
import pl.coderslab.martial_arts_event_creator_app.Model.User.User;

import java.util.HashSet;

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
        adminDetails.setUsersToVerify(new HashSet<>());

        adminDetails.addUserToVerify(user);

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
        user.setPhoneNumber("0000");

        AdminDetails adminDetails = new AdminDetails();
        adminDetails.setId(1L);
        adminDetails.setUsersToVerify(new HashSet<>());

        adminDetails.addUserToVerify(user);
        assertThat(adminDetails.getUsersToVerify(), hasItem(user));

        adminDetails.removeUserFromVerification(user);
        assertThat(adminDetails.getUsersToVerify(), not(hasItem(user)));
    }
}
