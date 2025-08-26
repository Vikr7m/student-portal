import React from "react";
import styles from "./ProjectSection.module.css";
import { Navigate, useNavigate } from "react-router-dom";

const ProjectSection = ({projects}) => {

  const navigate = useNavigate();
  

  const handleProjectEdit = () => {
        navigate('/project-edit');
    }

  return (
    <div className={styles.container}>
      <h2 className={styles.heading}>Projects</h2>
      <div className={styles.grid}>
        {projects?.map((project, index) => (
          <div key={index} className={styles.card}>
            
            <img
              src={`data:image/jpeg;base64,${project.coverImage}`}
              alt={project.title}
              className={styles.image}
            />

            <div className={styles.projectContent}>
                <div className={styles.tags}>
                    {project.projectTags?.map((tag,index) => (
                        <div key={index} className={styles.tagContainer}>
                            <h5>{tag}</h5>
                        </div>
                    ))}
                </div>
                <h1 className={styles.title}>{project.title}</h1>
                <h3>{project.description}</h3>
                
                <p className={styles.link}>{project.link}</p>
            </div>
          </div>
        ))}

        {/* Add Certificate card */}
        <div
          className={styles.addCard}
          onClick={handleProjectEdit}
        >
          <div className={styles.plus}>+</div>
          <p>Add a Project</p>
        </div>
      </div>
    </div>
  );
};

export default ProjectSection;
