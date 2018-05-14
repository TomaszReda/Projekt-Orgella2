package pl.orgella.Controller;



import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.orgella.model.User;
import pl.orgella.repository.UserRepository;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class MyAccountControllerTest {

    @InjectMocks
    private MyAccountController myAccountController;

    private MockMvc mockMvc;



    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        mockMvc= MockMvcBuilders.standaloneSetup(myAccountController).build();
    }

    @Test
    public void myAcount() throws Exception {
        mockMvc.perform(get("/account"))
                .andExpect(status().isOk())
                .andExpect(view().name("MyAccountForm"));
    }

    @Test
    @WithMockUser(username = "Redzikesxd2")
    public void change() throws Exception {
        User user=new User(10l,"tomek","redaaa","tomekreda@op.pl","Redzikesxd2","$2a$10$z4Eb7ZtQtqP3OiNCZ.Z50OyFaI3HaMWi8GyMwZo7IG.5JmvirSDPS",null,true,true);
        Mockito.when(userRepository.findFirstByLogin(user.getLogin())).thenReturn(user);
        Mockito.when(userRepository.save(user)).thenReturn(user);

    }


    @Test
    @WithMockUser(username = "Redzikesxd3",password = "123456789")
    public void zmienLogin() throws Exception {
        User user=new User(10l,"tomek","redaaa","tomekreda@op.pl","Redzikesxd3","123456789",null,true,true);
        Mockito.when(userRepository.findFirstByLogin("Redzikesxd2")).thenReturn(null);
        Mockito.when(userRepository.findFirstByLogin("Redzikesxd3")).thenReturn(user);
        user.setLogin("Redzikesxd2");
        Mockito.when(userRepository.save(user)).thenReturn(user);
        mockMvc.perform(post("/zmienLogin")
        .param("login","Redzikexd2")
        )
                .andExpect(status().isOk())
                .andExpect(view().name("MyAccountForm"));
    }



    @Test
    @WithMockUser(username = "Redzikesxd2",password = "123456789")
    public void badLogin() throws Exception {
        User user=new User(10l,"tomek","redaaa","tomekreda@op.pl","Redzikesxd2","123456789",null,true,true);
        Mockito.when(userRepository.findFirstByLogin("Redzikesxd2")).thenReturn(user);

        mockMvc.perform(post("/zmienLogin")
                .param("login","Redzikexd2")
        )
                .andExpect(status().isOk())
                .andExpect(view().name("MyAccountForm"));
    }




    @Test
    @WithMockUser(username = "Redzikesxd2",password = "123456789")
    public void email() throws Exception {
        User user=new User(10l,"tomek","redaaa","tomekreda@op.pl","Redzikesxd2","123456789",null,true,true);
        Mockito.when(userRepository.findFirstByLogin("Redzikesxd2")).thenReturn(user);


    }
}