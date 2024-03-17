package com.Jpa.Service;

import java.nio.file.Files;
import java.nio.file.Path;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jpa.Entity.Person;
import com.Jpa.Repo.personRepo;


@Service
public class PersonService {
	
	@Autowired
	private personRepo pr;
	
	public void savePerson() {
		Person p=new Person();
		p.setName("sai");
		String resumePath="D:/Sai Resume.pdf";
		String photoPath="D:/saiPhoto1.jpg";

		try {
			Path resPath = Path.of(resumePath);
			byte[] resumeData = Files.readAllBytes(resPath);
			
			p.setResume(resumeData);
			
			Path phtPath = Path.of(photoPath);
			byte[] photoData = Files.readAllBytes(phtPath);
			
			p.setPhoto(photoData);
			
		}catch (Exception e) {
           e.printStackTrace();
		}
	      pr.save(p);
		
	}

}
