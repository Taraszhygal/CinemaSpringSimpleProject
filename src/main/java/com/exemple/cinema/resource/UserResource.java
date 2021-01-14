package com.exemple.cinema.resource;

import com.exemple.cinema.dto.TicketDto;
import com.exemple.cinema.dto.UserDto;
import com.exemple.cinema.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/")
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/{id}")
    public List<UserDto> deleteUserById(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
