package pl.coderslab.martial_arts_event_creator_app.Model.User;

import pl.coderslab.martial_arts_event_creator_app.Model.Event.Federation;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class AdminDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "federations_to_verify")
    private Set<Federation> federationsToVerify;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_to_verify")
    private Set<User> usersToVerify;

    public AdminDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Federation> getFederationsToVerify() {
        return federationsToVerify;
    }

    public void setFederationsToVerify(Set<Federation> federationsToVerify) {
        this.federationsToVerify = federationsToVerify;
    }

    public Set<User> getUsersToVerify() {
        return usersToVerify;
    }

    public void setUsersToVerify(Set<User> usersToVerify) {
        this.usersToVerify = usersToVerify;
    }

    public void addUserToVerify(User user) {
        Set<User> users = this.getUsersToVerify();
        users.add(user);
        this.setUsersToVerify(users);
    }

    public void removeUserFromVerification(User user) {
        Set<User> users = this.getUsersToVerify();
        users.remove(user);
        this.setUsersToVerify(users);
    }

    public void addFederationToVerify(Federation federation) {
        Set<Federation> federations = this.getFederationsToVerify();
        federations.add(federation);
        this.setFederationsToVerify(federations);
    }

    public void removeFederationFromVerification(Federation federation) {
        Set<Federation> federations = this.getFederationsToVerify();
        federations.remove(federation);
        this.setFederationsToVerify(federations);
    }



}
