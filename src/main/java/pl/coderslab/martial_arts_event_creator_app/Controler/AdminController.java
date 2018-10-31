package pl.coderslab.martial_arts_event_creator_app.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.martial_arts_event_creator_app.Model.User.AdminDetails;
import pl.coderslab.martial_arts_event_creator_app.Model.User.FighterDetails;
import pl.coderslab.martial_arts_event_creator_app.Model.User.User;
import pl.coderslab.martial_arts_event_creator_app.Repository.AdminDetailsRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.FighterDetailsRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.MenagerDetailsRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.UserRepository;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("/admin")
@Controller
@SessionAttributes(value = {"userDetails"})
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FighterDetailsRepository fighterDetailsRepository;

    @Autowired
    MenagerDetailsRepository menagerDetailsRepository;

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



//    USER VERIFICATION

    @RequestMapping(value = "/verify/{email}", method = RequestMethod.GET)
    public String fighters(@PathVariable String email) {

        AdminDetails admin = adminDetailsRepository.getOne(1L);

        Optional<User> userToVerify = userRepository.findByEmail(email);
        userToVerify.ifPresent(u -> {
            if (u.getFighterDetails() != null) {
                u.setRole("ROLE_FIGHTER");
            }
            if (u.getMenagerDetails() != null) {
                u.setRole("ROLE_MENAGER");
            }
            userRepository.save(u);
            admin.removeUserFromVerification(u);
            adminDetailsRepository.save(admin);
        });

        return "redirect:/admin";
    }


//    CUSTOM USER EDITION

    @RequestMapping(value = "user/{email}", method = RequestMethod.GET)
    public String customUser(Model model, @PathVariable String email) {

        Optional<User> user = userRepository.findByEmail(email);
        user.ifPresent(u -> {
            if (u.getFighterDetails() != null) {
                model.addAttribute("userDetails", fighterDetailsRepository.findByUser(u));
            }
            if (u.getMenagerDetails() != null) {
                model.addAttribute("userDetails", menagerDetailsRepository.findByMenager(u));
            }

            model.addAttribute("user", u);
        });

        return "customUserEdit";
    }

    @RequestMapping(value = "user/{email}", method = RequestMethod.POST)
    public String customUserDetails(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "customUserEdit";
        }

        return "redirect:/admin";

    }

}
