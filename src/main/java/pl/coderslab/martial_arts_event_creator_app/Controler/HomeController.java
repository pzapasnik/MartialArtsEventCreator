package pl.coderslab.martial_arts_event_creator_app.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.martial_arts_event_creator_app.Enum.Discipline;
import pl.coderslab.martial_arts_event_creator_app.Model.User.MenagerDetails;
import pl.coderslab.martial_arts_event_creator_app.Model.User.*;
import pl.coderslab.martial_arts_event_creator_app.Repository.AdminDetailsRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.FederationRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;


@Controller
@SessionAttributes(value = {"userEmail", "singUpValidation"})
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdminDetailsRepository adminDetailsRepository;

    @Autowired
    FederationRepository federationRepository;

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
    public String registery(@RequestParam String account, Model model,
                            @Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "register";

        }
            user.setRole("ROLE_USER");
            userRepository.save(user);

            if(account.equals("fighter")){
                model.addAttribute("userEmail", user.getEmail());
                model.addAttribute("singUpValidation", "fighter");
                return"redirect:/registerfighter";
            }

            if(account.equals("menager")){
                model.addAttribute("userEmail", user.getEmail());
                model.addAttribute("singUpValidation", "menager");
                return"redirect:/registermenager";
            }

            Authentication auth = new UsernamePasswordAuthenticationToken(user,
                    user.getPassword(), user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(auth);
            return "redirect:/main";
        }


//  Fighter Registery

    @RequestMapping(value = "/registerfighter", method = RequestMethod.GET)
    public String fighter(Model model, HttpSession ses) {

        try {
            String validURL = (String) ses.getAttribute("singUpValidation");

            if (validURL.equals("fighter")) {
                model.addAttribute("fighterDetails", new FighterDetails());
                return "registerFighter";

            } else {
                return "redirect:/register";
            }

        } catch (NullPointerException e) {
            return "redirect:/register";
        }
    }


    @RequestMapping(value = "/registerfighter", method = RequestMethod.POST)
    public String fighterReg(@Valid FighterDetails fighterDetails, BindingResult result, HttpSession ses){

        if (result.hasErrors()) {
            return"registerFighter";
        }
        ses.removeAttribute("singUpValidation");
        Optional<User> user = userRepository.findByEmail((String) ses.getAttribute("userEmail"));

        user.ifPresent(u -> {
            u.setFighterDetails(fighterDetails);
            fighterDetails.setUser(u);
            userRepository.save(u);

//            Adding Fighter to be verified by admin
            Optional <AdminDetails> adminDetails = adminDetailsRepository.findById(1L);
            adminDetails.ifPresent(a -> {
                a.addUserToVerify(u);
                adminDetailsRepository.save(a);
            });

            Authentication auth = new UsernamePasswordAuthenticationToken(user,
                    u.getPassword(), u.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        });
        return"redirect:/main";
    }


    @RequestMapping(value = "/registermenager", method = RequestMethod.GET)
    public String registerFederation(Model model, HttpSession ses) {
        try {
            String validURL = (String) ses.getAttribute("singUpValidation");

            if (validURL.equals("menager")) {
                model.addAttribute("menagerDetails", new MenagerDetails());
                return "registerMenager";

            } else {
                return "redirect:/register";
            }

        } catch (NullPointerException e) {
            return "redirect:/register";
        }
    }

    @RequestMapping(value = "/registermenager", method = RequestMethod.POST)
    public String regFederation(@Valid MenagerDetails menagerDetails,
                                BindingResult result, HttpSession ses){

        if (result.hasErrors()) {
            return "registerMenager";
        }
        ses.removeAttribute("singUpValidation");
        Optional<User> user = userRepository.findByEmail((String) ses.getAttribute("userEmail"));

        user.ifPresent(u -> {
                    u.setMenagerDetails(menagerDetails);
                    menagerDetails.setMenager(u);
                    userRepository.save(u);

//            Adding MenagerDetails to be verified by admin
                    Optional <AdminDetails> adminDetails = adminDetailsRepository.findById(1L);
                    adminDetails.ifPresent(a -> {
                        a.addUserToVerify(u);
                        adminDetailsRepository.save(a);
                    });

                    Authentication auth = new UsernamePasswordAuthenticationToken(user,
                            u.getPassword(), u.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(auth);
        });
        return"redirect:/main";
    }
}

