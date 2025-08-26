import React, { useState } from "react";
import axios from "axios";
import styles from "./CertificateEdit.module.css";
import { useNavigate } from "react-router-dom";

function CertificateEdit() {
  const navigate = useNavigate();
  const [error, setError] = useState("");
  const [name, setName] = useState("");
  const [issuedOrganiziation, setIssuedOrganiziation] = useState("");
  const [date, setDate] = useState("");
  const [type, setType] = useState("");
  const [coverImage, setCoverImage] = useState(null);
  const [preview, setPreview] = useState(null);
  const [success, setSuccess] = useState("");
  

  const token = localStorage.getItem("token");
  const batchno = localStorage.getItem("batchNo");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append("name", name);
    formData.append("issuedOrganiziation", issuedOrganiziation);
    formData.append("date", date);
    formData.append("type", type);
    if (coverImage) {
      formData.append("coverImage", coverImage);
    }

    try {
      await axios.post(`http://localhost:8081/student/${batchno}/add-certificate`, formData, {
        headers: {
          Authorization: `Bearer ${token}`,
          "Content-Type": "multipart/form-data",
        },
      });
      setSuccess("Certificate uploaded successfully!");
      setCoverImage(null);
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
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>

        {/* Technologies */}
        <div className={styles.formGroup}>
          <label>Issued By</label>
          <input
            type="text"
            placeholder="Issued Organization eg: Google"
            value={issuedOrganiziation}
            onChange={(e) => setIssuedOrganiziation(e.target.value)}
          />
        </div>

        {/* Project Link */}
        <div className={styles.formGroup}>
          <label>Completed Date</label>
          <input
            type="date"
            placeholder="Enter the Issued Date"
            value={date}
            onChange={(e) => setDate(e.target.value)}
          />
        </div>

        <div className={styles.formGroup}>
          <label>Type of Your Certificate</label>
          <div className={styles.certificateTypes}>
            <div className={styles.type}>
              <input
                type="checkbox"
                checked={type === "course"}
                onChange={() => setType(type === "course" ? "" : "course")}
              />
              <h2>Course</h2>
            </div>

            <div className={styles.type}>
              <input
                type="checkbox"
                checked={type === "achievement"}
                onChange={() => setType(type === "achievement" ? "" : "achievement")}
              />
              <h2>Achievement</h2>
            </div>

            <div className={styles.type}>
              <input
                type="checkbox"
                checked={type === "others"}
                onChange={() => setType(type === "others" ? "" : "others")}
              />
              <h2>Others</h2>
            </div>
          </div>
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
