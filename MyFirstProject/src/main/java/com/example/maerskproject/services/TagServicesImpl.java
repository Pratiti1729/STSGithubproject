package com.example.maerskproject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.maerskproject.entities.Tag;
@Service
public class TagServicesImpl implements TagService {
	List<Tag> list;
	public TagServicesImpl() {
		list = new ArrayList<>();
		list.add(new Tag(132,"Java Core"));
		list.add(new Tag(12,"JavaScript"));
	}

	@Override
	public List<Tag> getTags() {
		return list;
	}

	@Override
	public Tag addTag(Tag tag) {
		list.add(tag);
		return tag;
	}
	public void deleteTag(long parseLong) {
		list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
				
	}

}
