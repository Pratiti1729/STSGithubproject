package com.example.maerskproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.maerskproject.entities.Tag;
import com.example.maerskproject.services.TagService;

@RestController
public class MyMaerskController{
	@Autowired
	private TagService tagService;
	/*public String Tag() {
		return "You and I in this beautiful world";
	}*/
	@GetMapping("/Tags")
	public List<Tag> getTags()
	{
		return this.tagService.getTags();
	}
	@PostMapping("/Tags")
	public Tag addTag(@RequestBody Tag tag) {
		return this.tagService.addTag(tag);
	}
	@DeleteMapping("/Tags/{TagId}")
	public ResponseEntity<HttpStatus> deleteTag(@PathVariable String TagId){
		try {
			this.tagService.deleteTag(Long.parseLong(TagId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
