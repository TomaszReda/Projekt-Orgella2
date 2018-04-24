package pl.orgella.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.orgella.model.Product;
import pl.orgella.model.User;
import pl.orgella.repository.ProductRepository;
import pl.orgella.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {


    private ProductRepository productRepository;


    private UserRepository userRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/admins")
    public String admins(Model model) {


        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "AdminPanelForm";
    }

    @PostMapping("/deleteProducts")
    public String deleteProduct(@RequestParam(required = false) Long products, Model model) {
        if (!productRepository.findAll().isEmpty()) {
            productRepository.deleteById(products);

        }
        return "redirect:admins";

    }


    @PostMapping("/deleteUsers")

    public String deleteUsers(@RequestParam(required = false) Long user, Model model) {
        Optional<User> users = userRepository.findById(user);
        User a = users.get();
        if (!"Admin".equals(a.getLogin())) {
            userRepository.delete(a);

        }


        return "redirect:admins";
    }
}
