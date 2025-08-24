package com.saranathan.student.Model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagid;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    //@ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    //private Set<Project> projects = new HashSet<>();
    
    //private int projectId;

    // -------- Getters & Setters ----------
    
    public Tags(String name ) {
    	this.name = name;
    }
    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	} */
}