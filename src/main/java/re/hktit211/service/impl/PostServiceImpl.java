package re.hktit211.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.hktit211.entity.Post;
import re.hktit211.repository.PostRepository;
import re.hktit211.service.PostService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post update(Long id, Post newPost) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setUsername(newPost.getUsername());
        post.setContent(newPost.getContent());
        post.setLikes(newPost.getLikes());
        post.setStatus(newPost.getStatus());
        post.setIs_delete(newPost.getIs_delete());

        return postRepository.save(post);
    }

    @Override
    public Post patch(Long id, Post patchPost) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        if (patchPost.getUsername() != null) {
            post.setUsername(patchPost.getUsername());
        }

        if (patchPost.getContent() != null) {
            post.setContent(patchPost.getContent());
        }

        if (patchPost.getStatus() != null) {
            post.setStatus(patchPost.getStatus());
        }

        if (patchPost.getIs_delete() != null) {
            post.setIs_delete(patchPost.getIs_delete());
        }

        return postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        postRepository.delete(post);
    }
}