package pl.coderslab.martial_arts_event_creator_app.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.martial_arts_event_creator_app.Enum.Discipline;
import pl.coderslab.martial_arts_event_creator_app.Model.User.*;
import pl.coderslab.martial_arts_event_creator_app.Repository.UserRepository;
import pl.coderslab.martial_arts_event_creator_app.Service.CustomUserDetailService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.Authenticator;
import java.util.*;


@Controller
@SessionAttributes("userEmail")
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @ModelAttribute("disciplines")
    public Collection<Discipline> populateDisciplines() {
        List<Discipline> disciplines = new ArrayList<>();
        disciplines.add(Discipline.MIXED_MARCIAL_ARTS);
        disciplines.add(Discipline.KICKBOXING);
        return disciplines;
    }


//    Login page

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

//     Main Page

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
    public String registery(@RequestParam(required = false) Boolean fighter, Model model,
                            @Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "register";

        }
            user.setRole("ROLE_USER");
            userRepository.save(user);

            if(fighter != null){
                model.addAttribute("userEmail", user.getEmail());
                return"redirect:/registerFighter";
            }

            Authentication auth = new UsernamePasswordAuthenticationToken(user,
                    user.getPassword(), user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(auth);
            return "redirect:/main";
        }

    @RequestMapping(value = "/registerFighter", method = RequestMethod.GET)
    public String fighter(Model model) {
        model.addAttribute("fighterDetails", new FighterDetails());
        return "registerFighter";
    }


    @RequestMapping(value = "/registerFighter", method = RequestMethod.POST)
    public String fighterReg(@Valid FighterDetails fighterDetails, BindingResult result, HttpSession ses){

        if (result.hasErrors()) {
            return"registerFighter";
        }
        System.out.print(ses.getAttribute("userEmail"));
        Optional<User> user = userRepository.findByEmail((String) ses.getAttribute("userEmail"));

        user.ifPresent(u -> {
            u.setFighterDetails(fighterDetails);
            userRepository.save(u);

            Authentication auth = new UsernamePasswordAuthenticationToken(user,
                    u.getPassword(), u.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        });
        return"redirect:/main";
    }
//    Fighter Registery

//    @RequestMapping(value = "/registerfighter", method = RequestMethod.GET)
//    public String registerFighter(Model model) {
//
//        model.addAttribute("user", new User());
//        return "registerFighter";
//    }
//
//    @RequestMapping(value = "/registerfighter", method = RequestMethod.POST)
//    public String regFighter(@Valid User user, BindingResult result, Model model) {
//
//        if(result.hasErrors()) {
//            return "registerFighter";
//
//        } else {
//            userRepository.save(user);
//            model.addAttribute("fighterId", user.getId());
//            return "redirect:/fighterdts";
//        }
//    }
//
//    @RequestMapping(value = "/fighterdts", method = RequestMethod.GET)
//    public String fighterDTS(Model model) {
//
//        model.addAttribute("fighterDetails", new FighterDetails());
//
//        return "fighterdts";
//    }
//
//    @RequestMapping(value = "fighterdts", method = RequestMethod.POST)
//    public String regFighterDTE (@Valid FighterDetails fighterDetails, BindingResult result, HttpSession session){
//
//        if(result.hasErrors()) {
//            return "fighterdts";
//        } else {
//            Long id = (Long) session.getAttribute("fighterId");
//            User user = userRepository.getOne(id);
//            user.setFighterDetails(fighterDetails);
//            userRepository.save(user);
//            return "";
//    }


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

