package com.training.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.entity.BugResource;
import com.training.project.services.BugTrackerService;

@RestController
@CrossOrigin(origins = "*")
public class BugServiceRestController {
	
	@Autowired
	private BugTrackerService service;
	
	
	// Index Page
	@GetMapping(path = "/", produces = {MediaType.TEXT_HTML_VALUE})
	public String init() {
		
		 return "<html>\n"
		 		+ "<head>\n"
		 		+ "<meta charset=\"UTF-8\">\n"
		 		+ "<title>Home Page</title>\n"
		 		+ "</head>\n"
		 		+ "<body>\n"
		 		+ "\n"
		 		+ "	<h1 style=\"text-align: center\">CTL Bug Tracking Service Application</h1>\n"
		 		+ "\n"
		 		+ "	<a href=\"/issues\">Find All Issues</a>\n"
		 		+ "	<br>\n"
		 		+ "	<ul>\n"
		 		+ "		<li>\n"
		 		+ "			<a href=\"/issues/pages?page_size=4&page=1\">Page 1</a>\n"
		 		+ "		</li>\n"
		 		+ "		<li>\n"
		 		+ "			<a href=\"/issues/pages?page_size=3&page=2\">Page 2</a>\n"
		 		+ "		</li>\n"
		 		+ "		<li>\n"
		 		+ "			<a href=\"/issues/pages?page_size=3&page=3\">Page 3</a>\n"
		 		+ "		</li>\n"
		 		+ "	</ul>\n"
		 		+ "	\n"
		 		+ "\n"
		 		+ "</body>\n"
		 		+ "</html>";
	}
	
	@GetMapping(path = "/issues", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<BugResource> findAll(){
		
		return this.service.findAll();
	}
	
	@GetMapping(path = "/issues/{issueID}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Optional<BugResource> findByID(@PathVariable int issueID) {
		
		return this.service.findByID(issueID);
	}
	
	// URL format : localhost:8000/issues/pages?page_size=2&page=1
	@GetMapping(path = "/issues/pages", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<BugResource> findByPagination(@RequestParam("page_size") int page_size, @RequestParam("page") int page){
		
		return this.service.findByPagination(page_size, (page-1));
	}
	
	@PostMapping(path = "/issues")
	@ResponseStatus(code = HttpStatus.CREATED)
	public BugResource add(@RequestBody BugResource bug) {
		
		return this.service.add(bug);
	}
	
	@DeleteMapping(path = "/issues/{issueID}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int issueID) {
		
		this.service.delete(issueID);
	}
}
