import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import styles from './UpdateImage.module.css';

function UpdateImage(){
    const navigate = useNavigate();
    const [preview, setPreview] = useState(null);
    const [coverImage, setCoverImage] = useState(null);
    const [success, setSuccess] = useState("");
    const [error, setError] = useState("");

    const token = localStorage.getItem("token");
    const batchno = localStorage.getItem("batchNo");

    const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    if (coverImage) {
      formData.append("coverImage", coverImage);
    }

    try {
      fetch(`http://localhost:8081/student/${batchno}/update-image`, {
        method: "POST",
        headers: {
            "Authorization": `Bearer ${token}`
        },
        body: formData
      });
      setSuccess("Image uploaded successfully!");
      setCoverImage(null);
    } catch (err) {
      console.error(err);
      setError("Project uploading failed");
    }
  };

  

    return(
        <div className={styles.editContainer}>
      <form onSubmit={handleSubmit} className={styles.form}>

        {/* Cover Image Upload Section */}
        {!preview && !success && (
          <div className={styles.formGroup}>
            <label>Student image</label>
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

export default UpdateImage;