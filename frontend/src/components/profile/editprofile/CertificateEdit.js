import React, { useState } from "react";
import axios from "axios";
import styles from "./CertificateEdit.module.css";
import { useNavigate } from "react-router-dom";

function CertificateEdit() {
  const navigate = useNavigate();
  const [error, setError] = useState("");
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [link, setLink] = useState("");
  const [technologies, setTechnologies] = useState("");
  const [coverImage, setCoverImage] = useState(null);
  const [preview, setPreview] = useState(null);
  const [success, setSuccess] = useState("");

  const token = localStorage.getItem("token");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append("title", title);
    formData.append("description", description);
    formData.append("link", link);
    formData.append("technologies", technologies);
    if (coverImage) {
      formData.append("coverImage", coverImage);
    }

    try {
      await axios.post("http://localhost:8081/student/edit-project", formData, {
        headers: {
          Authorization: `Bearer ${token}`,
          "Content-Type": "multipart/form-data",
        },
      });
      setSuccess("Certificate uploaded successfully!");
      setCoverImage(null);
      navigate('/profile');
    } catch (err) {
      console.error(err);
      setError("Project uploading failed");
    }
  };

  return (
    <div className={styles.editContainer}>
      <form onSubmit={handleSubmit} className={styles.form}>
        {/* Title */}
        <div className={styles.formGroup}>
          <label>Certificate Name</label>
          <input
            type="text"
            placeholder="Eg: Java Programming"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
        </div>

        {/* Technologies */}
        <div className={styles.formGroup}>
          <label>Technologies</label>
          <input
            type="text"
            placeholder="Choose the tags"
            value={technologies}
            onChange={(e) => setTechnologies(e.target.value)}
          />
        </div>

        {/* Project Link */}
        <div className={styles.formGroup}>
          <label>Completed Date</label>
          <input
            type="date"
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

export default CertificateEdit;
