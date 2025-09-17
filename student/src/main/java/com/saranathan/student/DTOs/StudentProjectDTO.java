package com.saranathan.student.DTOs;

import java.util.List;

public class StudentProjectDTO {
	
	private String title;
	private String description;
	private String link;
	private List<String> projectTags;
	private byte[] coverImage;
	
	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<String> getProjectTags() {
		return projectTags;
	}

	public void setProjectTags(List<String> projectTags) {
		this.projectTags = projectTags;
	}

	public byte[] getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(byte[] coverImage) {
		this.coverImage = coverImage;
	}

}

	


