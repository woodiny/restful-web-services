package dev.woodiny.restfulwebservices.controller;

import dev.woodiny.restfulwebservices.model.post.Post;
import dev.woodiny.restfulwebservices.model.user.User;
import dev.woodiny.restfulwebservices.service.UserDaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @PostMapping("")
    public void createUser(@RequestBody User user) {
        userDaoService.save(user);
    }

    @GetMapping("/{id}")
    public User retrieveUser(@PathVariable Long id) {
        return userDaoService.findOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@RequestParam Long id) {

    }

    @GetMapping("/{id}/posts")
    public List<Post> retrieveAllPostsOfUser(@RequestParam Long id) {
        return null;
    }

    @PostMapping("/{id}/posts")
    public void createPost(@RequestParam Long id) {

    }

    @GetMapping("/{id}/posts/{post_id}")
    public Post retrievePost(@RequestParam Long id, @RequestParam("post_id") Long postId) {
        return null;
    }
}
