package pl.coderslab.martial_arts_event_creator_app.Entity.User;

import pl.coderslab.martial_arts_event_creator_app.Enum.Role;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Admin extends User {

    private static Set<User> usersToVerify;

    public Admin() {
        this.setRole(Role.ADMIN);
    }

    public static void addUsertuVerify(User user) {
        usersToVerify.add(user);
    }

    private void verifyFighter(Fighter fighter) {
        fighter.setRole(Role.FIGHTER);
    }

    private void verifyMenager(Menager menager) {

    }
}
