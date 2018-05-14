package pl.orgella.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.orgella.model.User;
import pl.orgella.repository.UserRepository;

@Controller
public class MyAccountController {

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/account")
    public String myAcount(Model model) {


        return "MyAccountForm";
    }

    @PostMapping("/changePassword")
    public String change(Model model, @RequestParam String oldPassword, @RequestParam String newPassword1, @RequestParam String newPassword2) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findFirstByLogin(name);


        System.out.println(oldPassword);
        if (!BCrypt.hashpw(oldPassword, user.getPassword()).equals(user.getPassword())) {
            model.addAttribute("badOld", "Złe hasło");
            return "MyAccountForm";
        }

        if (!newPassword1.equals(newPassword2)) {
            model.addAttribute("NotTheSame", "Hasła musza byc takie samo");
            return "MyAccountForm";
        }

        if (newPassword1.length() < 9) {
            model.addAttribute("badLength", "Hasło musi byc dłuzszse niz 9 znaków");
            return "MyAccountForm";
        }

        user.setPassword(passwordEncoder.encode(newPassword1));
        userRepository.save(user);
        model.addAttribute("succes", "Pomyslnie zmieniono hasło");
        return "MyAccountForm";
    }







    @PostMapping("/zmienLogin")
    public String zmien( Model model,@RequestParam String login) {

        System.err.println("cccccccc");
        User users = userRepository.findFirstByLogin(login);
        if (users != null) {
            model.addAttribute("badLogin", "Login jest juz zajety");
            return "MyAccountForm";
        }

        if (login.length() >= 5 && login.length() <= 15 && users == null ) {
            System.err.println("cccccccc");
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName();
            User user=userRepository.findFirstByLogin(name);
            user.setLogin(login);
            userRepository.save(user);
            model.addAttribute("successs","Pomyslnie zmieniono login wyloguj i zaloguj sie ponownie");
            return "MyAccountForm";

        }

        else {

            model.addAttribute("logins", "Login powinien mieć od od 5 do 12 znaków");
            return "MyAccountForm";
        }


    }






    @PostMapping("/zmienEmail")
    public String haslo(Model model,@RequestParam String email,@RequestParam String aktualne){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username


        User user=userRepository.findFirstByLogin(name);

        if(!BCrypt.hashpw(aktualne, user.getPassword()).equals(user.getPassword())) {

            model.addAttribute("badPassowrd","Złe hasło");

        }
        User emaill = userRepository.findFirstByEmail(email);
        if(emaill!=null)
        {
            model.addAttribute("badEmail","Email juz w uzyciu jest");


        }
        if(BCrypt.hashpw(aktualne, user.getPassword()).equals(user.getPassword()) && emaill==null)
        {
            model.addAttribute("succcces","Pomyslnie zmieniono email");
            user.setEmail(email);
            userRepository.save(user);
        }




        return "MyAccountForm";
    }

}
