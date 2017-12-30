package com.kshrd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.models.Publisher;
import com.kshrd.repositories.PublisherRepository;

@Service
public class PublisherServiceImp implements PublisherService{
	
	@Autowired
	private PublisherRepository PublisherRepository;

	@Override
	public List<Publisher> getAllPublishers() {
		// TODO Auto-generated method stub
		return PublisherRepository.findAll();
	}

}
