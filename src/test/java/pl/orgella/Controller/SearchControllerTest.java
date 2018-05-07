package pl.orgella.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.orgella.model.Product;
import pl.orgella.repository.ProductRepository;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class SearchControllerTest {
    @InjectMocks
    private SearchController searchController;

    @Mock
    private ProductRepository productRepository;

    private MockMvc mockMvc;
        @Before
    public void setUp() throws Exception {
            mockMvc= MockMvcBuilders.standaloneSetup(searchController).build();
    }

    @Test
    public void search() throws Exception {
        Product product=new Product(10L,"headdderrrr","asadadadssadasda",30,"sklep",null);
        Product product1=new Product(11L,"headdderrrr","asadadadssadasda",30,"sklep",null);
        Set<Product> list=new HashSet<>();
        list.add(product);
        Mockito.when(productRepository.findAllByKategoria(product.getKategoria())).thenReturn(list);

        mockMvc.perform(get("/search")
                .param("kategoria","sklep")
        )
                .andExpect(status().isOk())
                .andExpect(view().name("searchForm"));


    }

    @Test
    public void searchh() throws Exception {
        Product product=new Product(10L,"asda ad sad s slowo sad ","asadadadssadasda",30,"sklep",null);
        List<Product> list=new LinkedList<>();
        list.add(product);

        Mockito.when(productRepository.findAll()).thenReturn(list);
        mockMvc.perform(get("/searchh")
                    .param("word","slowo")


            )
                    .andExpect(status().isOk())
                    .andExpect(view().name("searchByWordForm"));
    }
}