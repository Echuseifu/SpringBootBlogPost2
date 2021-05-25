package com.tts.TechTalentBlog.service;

import com.tts.TechTalentBlog.model.BlogPost;
import com.tts.TechTalentBlog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BlogPostServiceImpl implements BlogPostService {

    @Autowired
    BlogPostRepository blogPostRepository;

//    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
//        this.blogPostRepository = blogPostRepository;
//    }

    @Override
    public BlogPost addNewBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public Iterable<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    @Override
    public void deletePostById(Long id) {
        blogPostRepository.deleteById(id);
    }

    @Override
    public Optional<BlogPost> editBlogPostsById(Long id) {
        return blogPostRepository.findById(id);
    }

    @Override
    public Optional<BlogPost> updateBlogPostsById(Long id) {
        return blogPostRepository.findById(id);
    }


}

