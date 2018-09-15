package pl.coderslab.martial_arts_event_creator_app.Model.User;

import pl.coderslab.martial_arts_event_creator_app.Model.Event.Federation;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AdminDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "federations_to_verify")
    private Set<Federation> federationsToVerify;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_to_verify")
    private Set<User> usersToVerify;

    public void addUserToVerify(User user) {
        this.usersToVerify.add(user);
    }

    private void addFederationToVerify(Federation federation) {
        this.federationsToVerify.add(federation);
    }

}
