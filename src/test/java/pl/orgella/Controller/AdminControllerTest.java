package pl.orgella.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.orgella.model.Product;
import pl.orgella.model.User;
import pl.orgella.repository.ProductRepository;
import pl.orgella.repository.UserRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdminControllerTest {

    @InjectMocks
    private AdminController adminController;

    private MockMvc mockMvc;

    @Mock
    private ProductRepository productRepository;
    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        mockMvc= MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    @WithMockUser(username = "Administrator")
    public void admins() throws Exception {
        User user=new User(10l,"tomek","redaaa","tomekreda@op.pl","Administrator","123456789a",null,true,true);
        Product product=new Product(10L,"headdderrrr","asadadadssadasda",30,"sklep",null);
        List<User> add=new LinkedList<>();
        List<Product> all=new LinkedList<>();
        add.add(user);
        all.add(product);

        Mockito.when(userRepository.findAll()).thenReturn(add);
        Mockito.when(productRepository.findAll()).thenReturn(all);

    mockMvc.perform(get("/admins"))
            .andExpect(status().isOk())
            .andExpect(view().name("AdminPanelForm"));

    }

    @Test
    @WithMockUser(username = "Administrator")
    public void deleteProduct() throws Exception {
        Product product=new Product(10L,"headdderrrr","asadadadssadasda",30,"sklep",null);
        List<Product> listt=new LinkedList<>();
        listt.add(product);
        Mockito.when(productRepository.findAll()).thenReturn(listt);
        Mockito.doNothing().when(productRepository).deleteById(product.getID());
        mockMvc.perform(post("/deleteProducts")
                .param("products", String.valueOf(10L))
        )

                .andExpect(view().name("redirect:admins"));


    }

    @Test
    public void deleteUsers() throws Exception {
        User user=new User(10l,"tomek","redaaa","tomekreda@op.pl","Administrator","123456789a",null,true,true);
        Optional<User> userOptional=Optional.ofNullable(user);

        Mockito.when(userRepository.findById(user.getID())).thenReturn(userOptional);
        Mockito.doNothing().when(userRepository).delete(user);
        mockMvc.perform(post("/deleteUsers")
                .param("user", String.valueOf(10l))
        )
                .andExpect(view().name("redirect:admins"));
    }
}