import React from "react";
import styles from "./ProjectSection.module.css";
import { Navigate, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

const ProjectSection = ({projects}) => {

  const navigate = useNavigate();
  const [menuOpenId, setMenuOpenId] = useState(null);
  

  const handleProjectEdit = () => {
        navigate('/project-edit');
    }

    const handleDelete = (id) => {
    const token = localStorage.getItem("token");
    fetch(`http://localhost:8081/student/delete-certificate/${id}`, {
      method: "DELETE",
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to delete certificate");
        // Optionally refetch or optimistically update UI:
        console.log("Deleted certificate:", id);
      })
      .catch((err) => console.error(err))
      .finally(() => setMenuOpenId(null));
  };

  return (
    <div className={styles.container}>
      <h2 className={styles.heading}>Projects</h2>
      <div className={styles.grid}>
        {projects?.map((project, index) => (
          <div key={index} className={styles.card}>
            
            <button onClick={() => handleDelete(project.id)}>Delete</button>
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
