package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "userList";
    }

    @GetMapping("/create")
    public String createUserForm(@ModelAttribute User user) {
        return "/createUser";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String editUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/updateUser";
    }

    @PostMapping("/userUpdate")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
