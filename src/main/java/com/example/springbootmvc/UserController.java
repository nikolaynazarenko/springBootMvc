package com.example.springbootmvc;

import com.example.springbootmvc.model.User;
import com.example.springbootmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showUsers (Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users",users);
        return "userlist";
    }

    @GetMapping("/new")
    public String newUser (Model model){
        model.addAttribute("user",new User());
        return "new";
    }

    @PostMapping()
    public String create (@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String update (@PathVariable long id, Model model){
        model.addAttribute("user",userService.findById(id));
        return "updateuser";
    }

    @PostMapping("/{id}")
    public String updateUser (@ModelAttribute ("user") User user,@PathVariable long id){
        userService.update(user);
        return "redirect:/";
    }

    @PostMapping ("/delete/{id}")
    public String delete (@PathVariable long id){
        userService.delete(userService.findById(id));
        return "redirect:/";
    }
}
