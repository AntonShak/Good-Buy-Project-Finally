package com.shakov.goodbuyproject.http.controller;


import com.shakov.goodbuyproject.database.entity.Role;
import com.shakov.goodbuyproject.dto.UserCreateEditDto;
import com.shakov.goodbuyproject.service.UserService;
import com.shakov.goodbuyproject.validation.groups.CreateAction;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        return userService.findById(id)
                .map(user -> {
                    model.addAttribute("user", user);
                    model.addAttribute("roles", Role.values());
                    return "user/user";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }


    @GetMapping("/registration")
    public String registration(Model model, @ModelAttribute("user") UserCreateEditDto user) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user/registration";
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public String create(@ModelAttribute @Validated({Default.class, CreateAction.class})UserCreateEditDto userCreateEditDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("user", userCreateEditDto);
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/users/registration";
        }
        userService.create(userCreateEditDto);
        return "redirect:/login";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute @Validated UserCreateEditDto user) {

        return userService.update(id, user)
                .map(it -> "redirect:/users/{id}")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }



    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        if (!userService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/users";
    }
}
