package com.saranathan.student.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "project_tags")
public class ProjectTags {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@Column(name="projectid")
	private Integer projectId;
	
	@ManyToOne
	@Column(name="tagid")
	private int tagId;
	
	
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

}
