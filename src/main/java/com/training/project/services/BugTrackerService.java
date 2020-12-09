package com.training.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.training.project.entity.BugResource;
import com.training.project.ifaces.IBugResource;

@Service
public class BugTrackerService {

	@Autowired
	private IBugResource bugRepository;
	
	public List<BugResource> findAll(){
		
		return this.bugRepository.findAll();
	}
	
	public Optional<BugResource> findByID(int id) {
		
		return this.bugRepository.findById(id);
	}
	
	public List<BugResource> findByPagination(int pageSize, int pageNumber){
		
		Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
		
		return this.bugRepository.findAll(pageRequest).getContent();
	}
	
	public BugResource add(BugResource bug) {
		
		return this.bugRepository.save(bug);
	}
	
	public void delete(int id) {
		
		this.bugRepository.deleteById(id);
	}
}
