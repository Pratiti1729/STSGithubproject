package com.example.maerskproject.services;

import java.util.List;

import com.example.maerskproject.entities.Tag;

public interface TagService {
	public List<Tag> getTags();
	public Tag addTag(Tag tag);
	public void deleteTag(long parseLong);

}
