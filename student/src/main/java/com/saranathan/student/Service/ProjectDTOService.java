package com.saranathan.student.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saranathan.student.DTOs.StudentProjectDTO;
import com.saranathan.student.Model.Project;
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
	
	public void addProject(StudentProjectDTO project, Integer batchNo) {
		Project project1 = new Project();
		project1.setBatchNo(batchNo);
		project1.setTitle(project.getTitle());
		project1.setDescription(project.getDescription());
		project1.setProjectLink(project.getLink());
		project1.setCoverImage(project.getCoverImage());
		projectrepo.save(project1);
		List<String> stringTags = project.getProjectTags();
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
	
	public List<StudentProjectDTO> getProjectDTODetails(Integer batchNo) {
		List<StudentProjectDTO> result = new ArrayList<>();
		List<Project> projects = projectrepo.getProjectByBatchNo(batchNo);
		System.out.println(projects);
		
		
		for (Project project : projects) {
			System.out.println("_______Project :"+project);
			StudentProjectDTO projectDTO = new StudentProjectDTO();
			int projectId = project.getProjectid();
			projectDTO.setTitle(project.getTitle());
			projectDTO.setDescription(project.getDescription());
			projectDTO.setLink(project.getProjectLink());
			projectDTO.setCoverImage(project.getCoverImage());
			
			List<String> tagNames = new ArrayList<>();
			
			List<Integer> tagIds = ptagRepo.getTagdIdsByProjectId(projectId);
			for (Integer tagId :tagIds ) {
				
				String tagName = tagRepo.getTagNameById(tagId);
				tagNames.add(tagName);
			}
			System.out.println(tagNames);
			projectDTO.setProjectTags(tagNames);
			result.add(projectDTO);
			
		}
		
		
		return result;
	}

}
