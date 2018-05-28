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

import java.util.List;


@Controller
public class EmployeeController {



    private ProductRepository productRepository;


    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("/employeess")
    public String admins(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "EmployeePanelForm";
    }

    @PostMapping("/deleteProductss")
    public String deleteProduct(@RequestParam(required = false) Long products, Model model) {
        if (!productRepository.findAll().isEmpty()) {
            productRepository.deleteById(products);

        }

        return "redirect:employeess";

    }
  
    


}
