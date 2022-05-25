package com.jbk.branchcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Branch;
import com.jbk.service.branchservice;

@RestController
@RequestMapping("/branch")
public class branchcontroller {
@Autowired
private branchservice service;


@PostMapping(value = "/savebranch")
public ResponseEntity<Branch> savestudent(@RequestBody Branch branch){
	Branch branch1= service.savestudent(branch);
	if(branch1!=null) {
		return new ResponseEntity<Branch>(branch1,HttpStatus.CREATED);
		
	}else {
		return new ResponseEntity<Branch>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
@GetMapping(value = "/getbranchbyid/{branchid}")
public ResponseEntity<Branch> getstudent(@PathVariable String branchid) {
	Branch branch = service.getstudent(branchid);
	if (branch != null) {
		return new ResponseEntity<>(branch, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
}
