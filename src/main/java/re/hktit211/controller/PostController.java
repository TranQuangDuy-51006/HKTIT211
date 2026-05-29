package re.hktit211.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import re.hktit211.entity.Post;
import re.hktit211.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @GetMapping
    public List<Post> getAll() {
        return postService.findAll();
    }

    @PutMapping("/{id}")
    public Post update(
            @PathVariable Long id,
            @RequestBody Post post) {
        return postService.update(id, post);
    }
    @PatchMapping("/{id}")
    public Post patch(
            @PathVariable Long id,
            @RequestBody Post post) {
        return postService.patch(id, post);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        postService.delete(id);
        return "Delete success";
    }
}