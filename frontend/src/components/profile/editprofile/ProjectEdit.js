import React, { useState } from "react";
import axios from "axios";
import styles from "./ProfieEdit.module.css";
import { useNavigate } from "react-router-dom";

const allTags = [
  "Figma", "UI/UX", "SpringBoot", "React", "Web", "Mobile App",
  "Machine Learning", "Data Science", "Java", "Python"
]; 

function ProjectEdit() {
  const navigate = useNavigate();
  const [error, setError] = useState("");
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [link, setLink] = useState("");
  const [technologies, setTechnologies] = useState("");
  const [coverImage, setCoverImage] = useState(null);
  const [preview, setPreview] = useState(null);
  const [success, setSuccess] = useState("");
  const [selectedTags, setSelectedTags] = useState([]);
  const [search, setSearch] = useState("");

  const token = localStorage.getItem("token");
  const batchno = localStorage.getItem("batchNo");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append("title", title);
    formData.append("description", description);
    formData.append("link", link);
    formData.append("technologies", selectedTags);
    if (coverImage) {
      formData.append("coverImage", coverImage);
    }

    try {
      await axios.post(`http://localhost:8081/student/${batchno}/edit-project`, formData, {
        headers: {
          Authorization: `Bearer ${token}`,
          "Content-Type": "multipart/form-data",
        },
      });
      setSuccess("Project uploaded successfully!");
      setCoverImage(null);
    } catch (err) {
      console.error(err);
      setError("Project uploading failed");
    }
  };

  const addTag = (tag) => {
    if (!selectedTags.includes(tag)) {
      setSelectedTags([...selectedTags, tag]);
    }
    setSearch("");
  };

  const removeTag = (tag) => {
    setSelectedTags(selectedTags.filter((t) => t !== tag));
  };

  const filteredTags = allTags.filter(
    (tag) => tag.toLowerCase().includes(search.toLowerCase()) && !selectedTags.includes(tag)
  );

  return (
    <div className={styles.editContainer}>
      <form onSubmit={handleSubmit} className={styles.form}>
        {/* Title */}
        <div className={styles.formGroup}>
          <label>Project Title</label>
          <input
            type="text"
            placeholder="Enter your Project Title"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
        </div>
        <div className={styles.formGroup}>
          <label>Project Tags</label>
          <div className={styles.tagList}>
          {selectedTags.map((tag) => (
            <span key={tag} className={styles.tags}>
              {tag} <button onClick={() => removeTag(tag)}>x</button>
            </span>
          ))}
        </div>
        <input
        type="text"
        placeholder="Search and add tags..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
        />

      {search && (
        <ul className={styles.searchList}>
          {filteredTags.map((tag) => (
            <li
              key={tag}
              onClick={() => addTag(tag)}
            >
              {tag}
            </li>
          ))}
        </ul>
      )}

        </div>
        

        {/* Description */}
        <div className={styles.formGroup}>
          <label>Description</label>
          <textarea
            placeholder="Add a description for your project"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
          />
        </div>

        {/* Project Link */}
        <div className={styles.formGroup}>
          <label>Project Link</label>
          <input
            type="text"
            placeholder="Github, website or any project links"
            value={link}
            onChange={(e) => setLink(e.target.value)}
          />
        </div>

        {/* Cover Image Upload Section */}
        {!preview && !success && (
          <div className={styles.formGroup}>
            <label>Cover image</label>
            <div className={styles.uploadBox}>
              <input
                type="file"
                id="fileUpload"
                style={{ display: "none" }}
                onChange={(e) => {
                  const file = e.target.files[0];
                  if (file) {
                    if (file.size > 5 * 1024 * 1024) {
                      setError("File size exceeds 5 MB");
                      setCoverImage(null);
                      setPreview(null);
                      return;
                    }
                    setError("");
                    setCoverImage(file);
                    setPreview(URL.createObjectURL(file));
                  }
                }}
              />
              <label htmlFor="fileUpload" className={styles.uploadBtn}>
                Upload
              </label>
              <p>file size of maximum 5 MB</p>
            </div>
          </div>
        )}

        {/* Preview after upload */}
        {preview && (
          <div className={styles.preview}>
            <img src={preview} alt="Preview" />
          </div>
        )}

        {success && <p className={styles.success}>{success}</p>}
        {error && <p className={styles.error}>{error}</p>}

        <button type="submit" className={styles.submitBtn}>
          Add the project
        </button>
      </form>
    </div>
  );
}

export default ProjectEdit;
