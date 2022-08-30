package com.centraledachat.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centraledachat.demo.Model.Blog;
import com.centraledachat.demo.Model.BlogRepository;

import lombok.Data;

@Data
@Service
public class BlogService {
	
	@Autowired
	private BlogRepository br;
	
	public Optional<Blog> getBlog(final Long id){
		return br.findById(id);
	}
	
	public Iterable<Blog> getAllBlogs(){
		return br.findAll();
	}
	
	public void deleteBlog(final Long id) {
		br.deleteById(id);
	}
	
	public Blog insertBlog(Blog blog) {
		return br.save(blog);
	}
}
