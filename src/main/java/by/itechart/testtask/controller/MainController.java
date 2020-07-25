package by.itechart.testtask.controller;

import by.itechart.testtask.dto.UserDto;
import by.itechart.testtask.mapper.UserMapper;
import by.itechart.testtask.repository.UserRepository;
import by.itechart.testtask.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private /*final*/ UserService userService;
    @Autowired
    private UserRepository userRepository;

    /*@GetMapping
    public String greeting(Map<String, Object> model) {
        model.put("some", "Greeting!!!");
        return "greeting";
    }*/

    @GetMapping({/*"/",*/ "/welcome"}/*, method = RequestMethod.GET*/)
    public ModelAndView /*String*/ welcome(/*Model model,*/ Principal principal) {
        /*String login =principal.getName();
        User user = userMapper.toEntity(userService.findByLogin(login));*/
        /*model.addAttribute("username", "Welcome to this page!");*/
        /*User user = userRepository.findByLogin(principal.getName()).orElseThrow();
        List<Role> roles = new ArrayList<>();
        for (Role role : user.getRoles()) {
            roles.add(role);
        }*/
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.getModelMap().addAttribute("greeting", "Welcome to this page!");
        /*modelAndView.getModelMap().addAttribute("username", principal.getName());
        modelAndView.getModelMap().addAttribute("role", roles.get(0).getName());*/
        return modelAndView;
        //return "welcome";
    }

    // login using web form
    @GetMapping("/login")
    public /*ModelAndView*/Model login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }
        /*ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;*/
        return model;
    }

    // login using rest
    /*@GetMapping("/loginRest")
    public UserDto login(@RequestBody @Valid UserDto userDto) {
        logger.info("invoked method login.");
        System.out.println("rest");
        return userService.findByLogin(userDto.getLogin());
    }*/

    @GetMapping("/registration")
    public ModelAndView /*String*/ registration() {
        ModelAndView modelAndView = new ModelAndView("registration");
        return modelAndView;
    }

    @GetMapping("/admin")
    public Model admin(Model model) {
        model.addAttribute("admin", "Admin right here.");
        /*ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;*/
        return model;/*"/login"*/
    }

    /*@PostMapping("/registration")
    public String registration(*//*@ModelAttribute("newUser")*//*@RequestBody @Valid UserDto userDto*//*, Model model*//*) {

        userService.add(userDto);

        return "redirect:/welcome";
    }*/

    /*@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Client userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.add(userForm);

        //securityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }*/
}
