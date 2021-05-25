package com.tts.TechTalentBlog.controller;

import com.tts.TechTalentBlog.model.BlogPost;
import com.tts.TechTalentBlog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.awt.print.Book;
import java.util.Optional;

@Controller
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;


//    public BlogPostController(BlogPostService blogPostService) {
//        this.blogPostService = blogPostService;
//    }

    @GetMapping("/")
    public String index(BlogPost blogPost, Model model) {
        model.addAttribute("posts", blogPostService.getAllBlogPosts());
        // this return value is a reference to a template
        // it will not literally return a string value
        return "blogpost/index";
    }

    @GetMapping("/blogposts/new")
    public String newBlog(BlogPost blogPost) {
        return "blogpost/new";
    }

    @PostMapping("/blogposts")
    public String addNewBlogPost(BlogPost blogPost, Model model) {
        blogPostService.addNewBlogPost(blogPost);
        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        return "blogpost/result";
    }

    // method to check orderby methods
//    @GetMapping("/json")
//    @ResponseBody
//    public Iterable<Book> getAllDesc() {
//        return blogPostRepository.findByOrderByTitleAsc();
//    }

    @DeleteMapping("/blogposts/{id}")
    public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {
        blogPostService.deletePostById(id);
        return "redirect:/";
    }



    @RequestMapping(value = "/blogposts/{id}", method = RequestMethod.GET)
    public String editPostWithId(@PathVariable Long id, BlogPost blogPost, Model model) {
        Optional<BlogPost> post = blogPostService.editBlogPostsById(id);
        if (post.isPresent()) {
            BlogPost actualPost = post.get();
            model.addAttribute("blogPost", actualPost);
        }
        return "blogpost/edit";
    }


    @RequestMapping(value = "/blogposts/update/{id}")
    public String updateExistingPost(@PathVariable Long id, BlogPost blogPost, Model model) {
        Optional<BlogPost> post = blogPostService.updateBlogPostsById(id);
        if (post.isPresent()) {
            BlogPost actualPost = post.get();
            actualPost.setTitle(blogPost.getTitle());
            actualPost.setAuthor(blogPost.getAuthor());
            actualPost.setBlogEntry(blogPost.getBlogEntry());

            blogPostService.addNewBlogPost(actualPost);
            model.addAttribute("blogPost", actualPost);
        }

        return "blogpost/result";
    }






}