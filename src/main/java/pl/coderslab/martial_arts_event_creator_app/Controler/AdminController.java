package pl.coderslab.martial_arts_event_creator_app.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.martial_arts_event_creator_app.Model.User.AdminDetails;
import pl.coderslab.martial_arts_event_creator_app.Model.User.FighterDetails;
import pl.coderslab.martial_arts_event_creator_app.Model.User.User;
import pl.coderslab.martial_arts_event_creator_app.Repository.AdminDetailsRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.FighterDetailsRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.UserRepository;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FighterDetailsRepository fighterDetailsRepository;

    @Autowired
    AdminDetailsRepository adminDetailsRepository;

    @ModelAttribute("usersToVerify")
    public Collection<User> usersToVerify() {
        return userRepository.findAllUsersToVerify();
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String admin() {
        return "adminPanel";
    }



//    FIGHTERS VERIFICATION

    @RequestMapping(value = "/fighters", method = RequestMethod.GET)
    public String fighters() {


        return "verifyfighters";
    }

    @RequestMapping(value = "/fighters", method = RequestMethod.POST)
    public String verifyFighters() {

        return "";
    }

//    FEDERATION VERIFICATION

    @RequestMapping(value = "/federation", method = RequestMethod.GET)
    public String federation() {

        return "verifyfederation";
    }

    @RequestMapping(value = "/federation", method = RequestMethod.POST)
    public String verifyFederation() {

        return "";
    }

//    CUSTOM USER EDITION

    @RequestMapping(value = "user/{email}", method = RequestMethod.GET)
    public String customUser(Model model, @PathVariable String email) {
        Optional<User> u = userRepository.findByEmail(email);
        u.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        User user = u.map(user1 -> new User()).get();
        FighterDetails fighterDetails = fighterDetailsRepository.findByUser(user);
        model.addAttribute("user", user);
        model.addAttribute("fighter", fighterDetails);
        return "customfighter";
    }

    @RequestMapping(value = "user/{email}", method = RequestMethod.POST)
    public String customUserDetails(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "customfighter";
        }

//        REMOVING USER FROM VERIFICATION LIST
        Optional<AdminDetails> admin = adminDetailsRepository.findById(1L);
        admin.orElseThrow(() -> new NullPointerException("No AdminDetails"));

        admin.ifPresent( a -> {
            a.removeUserFromVerification(user);
            adminDetailsRepository.save(a);
                }
        );
        userRepository.save(user);

        return "redirect:/admin";

    }

}
