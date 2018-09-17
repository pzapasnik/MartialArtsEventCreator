package pl.coderslab.martial_arts_event_creator_app.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.martial_arts_event_creator_app.Model.User.*;
import pl.coderslab.martial_arts_event_creator_app.Repository.UserRepository;
import pl.coderslab.martial_arts_event_creator_app.Service.CustomUserDetailService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.Authenticator;


@Controller
@SessionAttributes("fighterId")
public class HomeController {

    @Autowired
    UserRepository userRepository;


//    Login page

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPageform() {
        return"redirect:/main";
    }


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return"main";
    }
//    User Registery

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String  registery(Model model) {

        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registery(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "/register";

        } else {
            UserPrincipal.create(user);
            userRepository.save(user);
            return "";
        }
    }

//    Fighter Registery

    @RequestMapping(value = "/registerfighter", method = RequestMethod.GET)
    public String registerFighter(Model model) {

        model.addAttribute("user", new User());
        return "registerFighter";
    }

    @RequestMapping(value = "/registerfighter", method = RequestMethod.POST)
    public String regFighter(@Valid User user, BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "registerFighter";

        } else {
            userRepository.save(user);
            model.addAttribute("fighterId", user.getId());
            return "redirect:/fighterdts";
        }
    }

    @RequestMapping(value = "/fighterdts", method = RequestMethod.GET)
    public String fighterDTS(Model model) {

        model.addAttribute("fighterDetails", new FighterDetails());

        return "fighterdts";
    }

    @RequestMapping(value = "fighterdts", method = RequestMethod.POST)
    public String regFighterDTE (@Valid FighterDetails fighterDetails, BindingResult result, HttpSession session){

        if(result.hasErrors()) {
            return "fighterdts";
        } else {
            Long id = (Long) session.getAttribute("fighterId");
            User user = userRepository.getOne(id);
            user.setFighterDetails(fighterDetails);
            userRepository.save(user);
            return "";
    }


//    Menager Registery

//    @RequestMapping(value = "/registermenager", method = RequestMethod.GET)
//    public String registerMenager(Model model) {
//        model.addAttribute("menager", new Menager());
//        return "registermenager";
//    }
//
//    @RequestMapping(value = "/registermenager", method = RequestMethod.POST)
//    public String regMenager(@Valid Menager menager, BindingResult result){
//
//        if (result.hasErrors()) {
//            return "registermenager";
//
//        } else {
//
//            String email = menager.getEmail();
//            menagerRepository.save(menager);
//            AdminDetails.addUsertuVerify(menagerRepository.findByEmail(email));
//
//            return "redirect:menagerIndex" + email;
//
//        }
//    }
}
}
