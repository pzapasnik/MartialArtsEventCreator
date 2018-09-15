package pl.coderslab.martial_arts_event_creator_app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.martial_arts_event_creator_app.Model.User.UserPrincipal;
import pl.coderslab.martial_arts_event_creator_app.Model.User.User;
import pl.coderslab.martial_arts_event_creator_app.Repository.UserRepository;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(Email)
                .orElseThrow(() -> new UsernameNotFoundException("Wrong Username of Email, user not found"));

        return UserPrincipal.create(user);
    }
}
