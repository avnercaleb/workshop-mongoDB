package com.workshopmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workshopmongo.controller.util.URL;
import com.workshopmongo.entities.Post;
import com.workshopmongo.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findPostById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping("/titlesearch")
	public ResponseEntity<List<Post>> findByPost(@RequestParam(value = "text", defaultValue = "") String text){
		text = URL.decodeParam(text);
		List<Post> list = service.findByTittle(text);
		return ResponseEntity.ok().body(list);
	}
}
