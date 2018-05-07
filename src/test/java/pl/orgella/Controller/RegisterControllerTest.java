package pl.orgella.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.orgella.model.User;
import pl.orgella.repository.UserRepository;
import pl.orgella.service.UserService;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;



@RunWith(SpringJUnit4ClassRunner.class)
public class RegisterControllerTest {

    @InjectMocks
    private RegisterController registerController;

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() throws Exception {
        mockMvc= MockMvcBuilders.standaloneSetup(registerController).build();
    }


    @Test
    public void register() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("user"))
                .andExpect(view().name("zalozkonto"));
    }
    @Test
    public void succes() throws Exception {
        mockMvc.perform(get("/succes"))
                .andExpect(status().isOk())
                .andExpect(view().name("pomyslnieZalozonoKonto"));
    }



    @Test
    public void zalozkonto() throws Exception {
        User user=new User(10l,"tomek","redaaa","tomekreda@op.pl","redzik","123456789a",null,true,true);
        User user2=new User(102l,"tomek","redaaa","tomekredda@op.pl","resdzik","123456789a",null,true,true);

        List<User> users=new LinkedList<>();
        users.add(user2);
        Mockito.when(userRepository.findAll()).thenReturn(users);
        mockMvc.perform(post("/register")
                    .param("ID", String.valueOf(user.getID()))
                .param("firstname",user.getFirstname())
                .param("lastname",user.getLastname())
                .param("email",user.getEmail())
                .param("login",user.getLogin())
                .param("password",user.getPassword())
                .param("regulamin1", String.valueOf(user.isRegulamin1()))
                .param("regulamin2", String.valueOf(user.isRegulamin2()))
        )

                .andExpect(view().name("redirect:succes"));

    }



    @Test
    public void zalozBadLoginkonto() throws Exception {
        User user=new User(10l,"tomek","redaaa","tomekreda@op.pl","redzik","123456789a",null,true,true);
        User user2=new User(102l,"tomek","redaaa","tomekredda@op.pl","redzik","123456789a",null,true,true);

        List<User> users=new LinkedList<>();
        users.add(user2);
        Mockito.when(userRepository.findAll()).thenReturn(users);
        Mockito.doNothing().when(userService).addwithDefaultRole(user);
        mockMvc.perform(post("/register")
                .param("ID", String.valueOf(user.getID()))
                .param("firstname",user.getFirstname())
                .param("lastname",user.getLastname())
                .param("email",user.getEmail())
                .param("login",user.getLogin())
                .param("password",user.getPassword())
                .param("regulamin1", String.valueOf(user.isRegulamin1()))
                .param("regulamin2", String.valueOf(user.isRegulamin2()))
        )

                .andExpect(view().name("zalozkonto"));

    }
}