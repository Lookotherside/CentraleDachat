package com.centraledachat.demo.Controller;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.centraledachat.demo.Model.Blog;
import com.centraledachat.demo.Service.BlogService;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog")
    public Iterable<Blog> index(){
        return blogService.getAllBlogs();
    }

    @GetMapping("/blog/{id}")
    public Optional<Blog> show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogService.getBlog((long) blogId);
    }

	

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        String content = body.get("content");
        return blogService.insertBlog(new Blog(title, content));
    }

	

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id){
        Long blogId = Long.parseLong(id);
        blogService.deleteBlog(blogId);
        return true;
    }

}
