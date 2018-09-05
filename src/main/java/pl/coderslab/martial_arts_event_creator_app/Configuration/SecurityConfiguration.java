package pl.coderslab.martial_arts_event_creator_app.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.coderslab.martial_arts_event_creator_app.Entity.User.Guest;
import pl.coderslab.martial_arts_event_creator_app.Entity.User.Menager;
import pl.coderslab.martial_arts_event_creator_app.Repository.AdminRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.FighterRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.GuestRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.MenagerRepository;

@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses =
        {AdminRepository.class, GuestRepository.class, FighterRepository.class, MenagerRepository.class})
@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .httpBasic();

        http.csrf().disable();
    }
}
