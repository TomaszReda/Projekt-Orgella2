package pl.orgella.apsect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.orgella.model.Product;
import pl.orgella.model.User;

import java.util.Collection;

@Aspect
@Component
public class UUwierzetylnianie {


    @After("execution(* pl.orgella.Controller.AddController.*(..)) && args(model)" )
    public void info1(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("user",name);
        Collection<? extends GrantedAuthority> all=auth.getAuthorities();
        GrantedAuthority admins=new SimpleGrantedAuthority("ADMIN_ROLE");
        GrantedAuthority employee=new SimpleGrantedAuthority("PRAC_ROLE");
        if(all.contains(admins))
        {
            model.addAttribute("admin","admin");
        }
        if(all.contains(employee)) {
        	model.addAttribute("employee","employee");
        }
        
        
        
    }


    @After("execution(* pl.orgella.Controller.AddController.*(..)) && args(product,bindingResult,model,filel)" )
    public void info2(Product product, BindingResult bindingResult, Model model,  MultipartFile[] filel)
    {
        info1(model);
    }


    @After("execution(* pl.orgella.Controller.AdminController.*(..)) && args(products,model)" )
    public void info3( long products,Model model)
    {
        info1(model);
    }

    @After("execution(* pl.orgella.Controller.AdminController.*(..)) && args(model)" )
    public void info4( Model model)
    {
        info1(model);
    }

    @After("execution(* pl.orgella.Controller.HomeController.*(..)) && args(model)" )
    public void info5( Model model)
    {
        info1(model);
    }

    @After("execution(* pl.orgella.Controller.MyAccountController.*(..)) && args(model)" )
    public void info6( Model model)
    {
        info1(model);
    }

    @After("execution(* pl.orgella.Controller.MyAccountController.*(..)) && args(model,oldPassword,newPassword1,newPassword2)" )
    public void info7( Model model, String oldPassword,String newPassword1,String newPassword2)
    {
        info1(model);
    }


    @After("execution(* pl.orgella.Controller.TermPrivacyController.*(..)) && args(model)" )
    public void info8( Model model)
    {
        info1(model);
    }

    @After("execution(* pl.orgella.Controller.SearchController.*(..)) && args(page,kategoria,model)" )
    public void info9( int page, String kategoria, Model model)
    {
        info1(model);
    }

    @After("execution(* pl.orgella.Controller.SearchController.*(..)) && args(model,page,word)" )
    public void info10( Model model,int page,String word)
    {
        info1(model);
    }

    @After("execution(* pl.orgella.Controller.SearchDetailsForm.*(..)) && args(model)" )
    public void info11( Model model)
    {
        info1(model);
    }

    @After("execution(* pl.orgella.Controller.SearchDetailsForm.*(..)) && args(model,ID)" )
    public void info12( Model model, Long ID)
    {
        info1(model);
    }



    @After("execution(* pl.orgella.Controller.MyAccountController.*(..)) && args(model,email,aktualne)" )
    public void info13( Model model, String email,String aktualne)
    {
        info1(model);
    }

    @After("execution(* pl.orgella.Controller.MyAccountController.*(..)) && args(model,login)" )
    public void info14( Model model, String login)
    {
        info1(model);
    }
    
    @After("execution(* pl.orgella.Controller.EmployeeController.*(..)) && args(products,model)" )
    public void info15( long products,Model model)
    {
        info1(model);
    }

    @After("execution(* pl.orgella.Controller.EmployeeController.*(..)) && args(model)" )
    public void info16( Model model)
    {
        info1(model);
    }















}
