package pl.coderslab.martial_arts_event_creator_app.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.martial_arts_event_creator_app.Model.User.AdminDetails;
import pl.coderslab.martial_arts_event_creator_app.Model.User.FighterDetails;
import pl.coderslab.martial_arts_event_creator_app.Model.User.MenagerDetails;
import pl.coderslab.martial_arts_event_creator_app.Model.User.User;
import pl.coderslab.martial_arts_event_creator_app.Repository.AdminDetailsRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.FighterDetailsRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.MenagerDetailsRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.UserRepository;

import javax.servlet.http.HttpSession;
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

        User userToVerify = userRepository.findByEmail(email);

            if (userToVerify.getFighterDetails() != null) {
                userToVerify.setRole("ROLE_FIGHTER");
            }
            if (userToVerify.getMenagerDetails() != null) {
                userToVerify.setRole("ROLE_MENAGER");
            }
            userRepository.save(userToVerify);
            admin.removeUserFromVerification(userToVerify);
            adminDetailsRepository.save(admin);

        return "redirect:/admin";
    }


//    CUSTOM USER EDITION

    @RequestMapping(value = "user/edit/{email}", method = RequestMethod.GET)
    public String customUser(Model model, @PathVariable String email) {

        User user = userRepository.findByEmail(email);
        model.addAttribute("user", user);

        return "customUserEdit";
    }

    @RequestMapping(value = "user/edit/{email}", method = RequestMethod.POST)
    public String customUserEdition(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "customUserEdit";
        }
        userRepository.save(user);

        return "redirect:/admin";
    }
// CUSTOM USER DETAILS EDITION

    @RequestMapping(value = "user/editfighterdetails/{email}", method = RequestMethod.GET)
    public String customFighterDetails(Model model, @PathVariable String email) {

        User user = userRepository.findByEmail(email);
        model.addAttribute("fighterDetails", fighterDetailsRepository.findByUser(user));
        return "customFighterEdit";
    }

    @RequestMapping(value = "user/editfighterdetails/{email}", method = RequestMethod.POST)
    public String customFighterEdition(@Valid FighterDetails fighterDetails, BindingResult result) {

        if (result.hasErrors()) {
            return "customFighterEdit";
        }
        fighterDetailsRepository.save(fighterDetails);
        return "redirect:/";
    }

    @RequestMapping(value = "user/editmenagerdetails/{email}", method = RequestMethod.GET)
    public String customMenagerDetails(Model model, @PathVariable String email) {

        User user = userRepository.findByEmail(email);
        model.addAttribute("menagerDetails", menagerDetailsRepository.findByMenager(user));
        return "customMenagerEdit";
    }

    @RequestMapping(value = "user/editmenagerdetails/{email}", method = RequestMethod.POST)
    public String customMenagerEdition(@Valid MenagerDetails menagerDetails, BindingResult result){
        if (result.hasErrors()) {
            return "customMenagerEdit";
        }
        menagerDetailsRepository.save(menagerDetails);
        return "redirect:/";
    }

//    VIEW USER INFO

    @RequestMapping(value = "user/{email}", method = RequestMethod.GET)
    public String viewUserDetails(Model model, @PathVariable String email){
        User user = userRepository.findByEmail(email);
        model.addAttribute("user", user);

        if (user.getFighterDetails() != null) {
            model.addAttribute("details", fighterDetailsRepository.findByUser(user));
        }

        if (user.getMenagerDetails() != null) {
            model.addAttribute("details", menagerDetailsRepository.findByMenager(user));
        }

        return "customUserDetails";
    }

}
