package com.tts.TechTalentBlog.service;


import com.tts.TechTalentBlog.model.BlogPost;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

// this service is going to serve as a contract
// for our implementation
public interface BlogPostService {

    BlogPost addNewBlogPost(BlogPost blogPost);

    Iterable<BlogPost> getAllBlogPosts();

    void deletePostById(Long id);

//    List<BlogPost> getAllBlogPostsasList();

    Optional<BlogPost> editBlogPostsById( Long id);

    Optional<BlogPost> updateBlogPostsById( Long id);

}
