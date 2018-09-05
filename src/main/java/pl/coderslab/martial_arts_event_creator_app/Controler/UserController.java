package pl.coderslab.martial_arts_event_creator_app.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.martial_arts_event_creator_app.Entity.User.*;
import pl.coderslab.martial_arts_event_creator_app.Repository.FighterRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.GuestRepository;
import pl.coderslab.martial_arts_event_creator_app.Repository.MenagerRepository;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    FighterRepository fighterRepository;

    @Autowired
    MenagerRepository menagerRepository;

//    Login page

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginPage(Model model){

        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String verifyLogin(@Valid User user, BindingResult result) {

        if(result.hasErrors()) {
            return "login";

        } else {
//          !!!!  TU WSTAWIC WALIDACJE URZYTKOWNIKOW !!!!

            switch(user.getRole()) {
                case ADMIN: return "redirect:adminIndex";

                case GUEST: return "redirect:guerstIndex";

                case FIGHTER: return "redirect:fighterIndex";

                case MENAGER: return "redirect:menagerIndex";

                default: return "login";
            }
        }
    }

//    User Registery

    @RequestMapping(value = "/registegues", method = RequestMethod.GET)
    public String  registerGuest(Model model) {

        model.addAttribute("guest", new Guest());
        return "registerGuest";
    }

    @RequestMapping(value = "/registerguerst", method = RequestMethod.POST)
    public String regGuest(@Valid Guest guest, BindingResult result) {

        if (result.hasErrors()) {
            return "registerGuest";

        } else {

            String email = guest.getEmail();
            guestRepository.save(guest);
            return "redirect:guestIndex/" + email;
        }
    }

//    Fighter Registery

    @RequestMapping(value = "/registerfighter", method = RequestMethod.GET)
    public String registerFighter(Model model) {

        model.addAttribute("fighter", new Fighter());
        return "registerFighter";
    }

    @RequestMapping(value = "/registerfighter", method = RequestMethod.POST)
    public String regFighter(@Valid Fighter fighter, BindingResult result ) {

        if(result.hasErrors()) {
            return "registerFighter";

        } else {

            String email = fighter.getEmail();
            fighterRepository.save(fighter);
            Admin.addUsertuVerify(fighterRepository.findByEmail(email));
            return "redirect:fighterIndex/" + email;
        }
    }


//    Menager Registery

    @RequestMapping(value = "/registermenager", method = RequestMethod.GET)
    public String registerMenager(Model model) {
        model.addAttribute("menager", new Menager());
        return "registermenager";
    }

    @RequestMapping(value = "/registermenager", method = RequestMethod.POST)
    public String regMenager(@Valid Menager menager, BindingResult result){

        if (result.hasErrors()) {
            return "registermenager";

        } else {

            String email = menager.getEmail();
            menagerRepository.save(menager);
            Admin.addUsertuVerify(menagerRepository.findByEmail(email));

            return "redirect:menagerIndex" + email;

        }
    }
}
