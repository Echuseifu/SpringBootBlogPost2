package com.tts.TechTalentBlog.service;


import com.tts.TechTalentBlog.model.BlogPost;

// this service is going to serve as a contract
// for our implementation
public interface BlogPostService {

    BlogPost addNewBlogPost(BlogPost blogPost);

    Iterable<BlogPost> getAllBlogPosts();

    void deletePostById(Long id);

    BlogPost findBlogPostById(Long id);

    BlogPost editBlogPostById(Long id, BlogPost blogPost);
//    List<BlogPost> getAllBlogPostsasList();

}
