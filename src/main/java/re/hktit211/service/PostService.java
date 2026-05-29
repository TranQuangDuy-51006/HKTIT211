package re.hktit211.service;

import re.hktit211.entity.Post;

import java.util.List;

public interface PostService {

    Post create(Post post);

    List<Post> findAll();

    Post update(Long id, Post post);

    Post patch(Long id, Post post);

    void delete(Long id);
}