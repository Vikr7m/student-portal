package com.saranathan.student.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saranathan.student.Model.Project;
import com.saranathan.student.Model.ProjectDTO;
import com.saranathan.student.Model.ProjectTags;
import com.saranathan.student.Model.Tags;
import com.saranathan.student.Repository.ProjectRepository;
import com.saranathan.student.Repository.ProjectTagsRepository;
import com.saranathan.student.Repository.TagRepository;


@Service
public class ProjectDTOService {
	
	@Autowired 
	ProjectRepository projectrepo;
	
	@Autowired
	TagRepository tagRepo;
	
	@Autowired
	ProjectTagsRepository ptagRepo;
	
	public void addProject(ProjectDTO project) {
		
		
		Project project1 = new Project();
		project1.setBatchNo(project.getBatchNo());
		project1.setTitle(project.getTitle());
		project1.setDescription(project.getDescription());
		project1.setTitle(project.getTitle());
		project1.setCoverImage(project.getCoverImage());
		projectrepo.save(project1);
		List<String> stringTags = project.getTags();
		for (String tag : stringTags) {
			System.out.println("Querying for :"+tag);
			int tagId = tagRepo.getIdByTagName(tag);
			System.out.println("The TagID : * * :" + tagId);
			ProjectTags ptags = new ProjectTags();
			System.out.println("Project ID :"+project1.getProjectid()+"\nTag ID :"+tagId);
			ptags.setProjectId(project1.getProjectid());			
			ptags.setTagId(tagId);
			ptagRepo.save(ptags);
		}
		
	
		
	}

}
