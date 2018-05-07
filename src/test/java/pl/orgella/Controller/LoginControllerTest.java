package pl.orgella.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringJUnit4ClassRunner.class
)
public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc= MockMvcBuilders.standaloneSetup(loginController).build();
    }
    @Test
    public void failuser() throws Exception {
        mockMvc.perform(get("/failLogin"))
                .andExpect(status().isOk())
                .andExpect(view().name("failLoginForm"));
    }

    @Test
    public void login() throws Exception {
        mockMvc.perform(get("/loginForm"))
                .andExpect(status().isOk())
                .andExpect(view().name("loginForms"));
    }
}