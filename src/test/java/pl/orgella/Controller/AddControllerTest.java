package pl.orgella.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;
import pl.orgella.model.Product;
import pl.orgella.model.Zdjecia;
import pl.orgella.repository.ProductRepository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;




import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;



@RunWith(SpringJUnit4ClassRunner.class)
public class AddControllerTest {


    @InjectMocks
    private AddController addController;

    @Mock
    private ProductRepository productRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc=MockMvcBuilders.standaloneSetup(addController).build();
    }

    @Test
    public void succes() throws Exception {
        mockMvc.perform(get("/successs"))
                .andExpect(status().isOk())
                .andExpect(view().name("succedAddForm"));
    }

    @Test
    public void add() throws Exception {
        mockMvc.perform(get("/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("addForm"));
    }

    @Test
    public void badValidation() throws Exception {
        List<Zdjecia> list=new LinkedList<>();
        //  Zdjecia zdjecia=new Zdjecia();
        //  zdjecia.setAdres("adres");
        //   list.add(zdjecia);
        Product product=new Product(10L,"hea","asadadadssadasda",30,"sklep",list);
        MultipartFile multipartFile=new MultipartFile() {
            @Override
            public String getName() {
                return "tomekk";
            }

            @Override
            public String getOriginalFilename() {
                return "tomekk";
            }

            @Override
            public String getContentType() {
                return "tomekk";
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public long getSize() {
                return 4;
            }

            @Override
            public byte[] getBytes() throws IOException {
                return new byte[0];
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public void transferTo(File file) throws IOException, IllegalStateException {

            }
        };
        MultipartFile[] file=new MultipartFile[1];
        file[0]=multipartFile;

        mockMvc.perform(post("/add")
                .param("ID", String.valueOf(product.getID()))
                .param("file", String.valueOf(file))
                .param("header",product.getHeader())
                .param("opis",product.getOpis())
                .param("cena", String.valueOf(product.getCena()))
                .param("kategoria",product.getKategoria())


        )
                .andExpect(status().isOk())
                .andExpect(view().name("addForm"));
    }




    @Test
    public void dodaj() throws Exception {
        List<Zdjecia> list=new LinkedList<>();
        //  Zdjecia zdjecia=new Zdjecia();
        //  zdjecia.setAdres("adres");
        //   list.add(zdjecia);
        Product product=new Product(10L,"headdderrrr","asadadadssadasda",30,"sklep",list);
        MultipartFile multipartFile=new MultipartFile() {
            @Override
            public String getName() {
                return "tomek";
            }

            @Override
            public String getOriginalFilename() {
                return "tomek";
            }

            @Override
            public String getContentType() {
                return "tomek";
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public long getSize() {
                return 4;
            }

            @Override
            public byte[] getBytes() throws IOException {
                return new byte[0];
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public void transferTo(File file) throws IOException, IllegalStateException {

            }
        };
        MultipartFile[] file=new MultipartFile[1];
        file[0]=multipartFile;

        mockMvc.perform(post("/add")
                .param("ID", String.valueOf(product.getID()))
                .param("file", String.valueOf(file))
                .param("header",product.getHeader())
                .param("opis",product.getOpis())
                .param("cena", String.valueOf(product.getCena()))
                .param("kategoria",product.getKategoria())


        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:successs"));
    }
}