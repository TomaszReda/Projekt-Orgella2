package pl.orgella.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.orgella.model.Product;
import pl.orgella.model.User;
import pl.orgella.model.UserRole;
import pl.orgella.repository.ProductRepository;
import pl.orgella.repository.UserRepository;
import pl.orgella.repository.UserRoleRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {


    private ProductRepository productRepository;


    private UserRepository userRepository;
    
    private UserRoleRepository userRoleRepository;

  
    
	
    @Autowired
	public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
		this.userRoleRepository = userRoleRepository;
	}

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
        GrantedAuthority us=new SimpleGrantedAuthority("DEFAULT_USER");
        UserRole usersRole=new UserRole(1L,"DEFAULT_USER","Domyslna rola przy rejestracji");
        List<User> users2=new LinkedList<>();
        for(int i=0;i<users.size();i++) {
        	

        	if(users.get(i).getUserRole().toString().equals("[DEFAULT_USER]")) {
        		users2.add(users.get(i));
        		
        	}
        }
        model.addAttribute("users2", users2);
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
    
    
    @PostMapping("/addPrac")
    public String addPracownik(@RequestParam(required = false) Long user, Model model) {
        Optional<User> users = userRepository.findById(user);
        User a = users.get();
        Optional<UserRole> USS=userRoleRepository.findById(3L);
        UserRole asad=USS.get();
        a.getUserRole().add(asad);
        userRepository.save(a);

        return "redirect:admins";
    }
    
    
    
    
    
    
}
