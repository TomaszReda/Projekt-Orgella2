package pl.orgella.Controller;
import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
import pl.orgella.model.Zdjecia;
import pl.orgella.repository.ProductRepository;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class SearchDetailsFormTest {

    @InjectMocks
    private SearchDetailsForm searchDetailsForm;

    private MockMvc mockMvc;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        mockMvc= MockMvcBuilders.standaloneSetup(searchDetailsForm).build();
    }

    @Test
    public void details() throws Exception {


        Product product=new Product(10L,"headdderrrr","asadadadssadasda",30,"sklep",null);
        List<Zdjecia> zdjeciaSet=new LinkedList<>();
        zdjeciaSet.add(new Zdjecia(10l,"ASSADADADASDADA"));
        product.setZdjeciaSet(zdjeciaSet);
        Mockito.when(productRepository.getOne(product.getID())).thenReturn(product);
        mockMvc.perform(get("/detailsSearch")
                .param("ID", String.valueOf(product.getID()))
                        )

                .andExpect(status().isOk())
                .andExpect(view().name("searchDetailsForm"));
    }

    @Test
    public void buy() throws Exception {
        Product product=new Product(10L,"headdderrrr","asadadadssadasda",30,"sklep",null);
        Mockito.doNothing().when(productRepository).deleteById(product.getID());
        mockMvc.perform(get("/buy")
                .param("ID", String.valueOf(10L))
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:succesBought"));
    }

    @Test
    public void succes() throws Exception {
        mockMvc.perform(get("/succesBought"))
                .andExpect(status().isOk())
                .andExpect(view().name("succesBoughtForm"));
    }
}