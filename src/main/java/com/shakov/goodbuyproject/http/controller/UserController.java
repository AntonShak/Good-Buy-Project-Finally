package com.shakov.goodbuyproject.http.controller;

import com.shakov.goodbuyproject.dto.UserCreateEditDto;
import com.shakov.goodbuyproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @GetMapping
    public String findAll(Model model) {

        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {

        return userService.findById(id)
                .map(user -> {
                    model.addAttribute("user", userService.findById(id));
                    return "redirect:user/{id}";
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public String create(@ModelAttribute UserCreateEditDto userCreateEditDto) {

        return "redirect:users/" + userService.create(userCreateEditDto).getId();
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute UserCreateEditDto userCreateEditDto) {

        return userService.update(id, userCreateEditDto)
                .map(user -> "redirect:users/{id}")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }



    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        if(!userService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/users";
    }
}
