package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.branchdao;
import com.jbk.entity.Branch;

@Service
public class branchservice_impl implements branchservice {
	@Autowired
	private branchdao dao;

	@Override
	public Branch savestudent(Branch branch) {
		Branch branch1 = dao.savestudent(branch);
		return branch1;
	}

	@Override
	public Branch getstudent(String studentid) {
		Branch branch = dao.getstudent(studentid);
		return branch;
	}

}
