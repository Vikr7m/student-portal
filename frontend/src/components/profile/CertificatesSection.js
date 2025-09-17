import React from "react";
import styles from "./CertfificateSection.module.css";
import { Navigate, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

const CertificatesSection = ({ certificates}) => {

    const navigate = useNavigate();
    const [menuOpenId, setMenuOpenId] = useState(null);
    const [confirmOpen, setConfirmOpen] = useState(false);
    const [pendingDeleteId, setPendingDeleteId] = useState(null);
  // Dummy handlers for now
  const handleView = (id) => {
    console.log("View certificate:", id);
  };

  const handleDownload = (id) => {
    console.log("Download certificate:", id);
  };

  const handleCertificateEdit = () => {
        navigate('/certificate-add');
  };

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
      <h2 className={styles.heading}>Certificates / Courses</h2>
      <div className={styles.grid}>
        {certificates?.map((cert, index) => (
          <div key={index} className={styles.card}>
            <div className={styles.header}>
              <h3 className={styles.title}>{cert.name}</h3>
              <button onClick={() => handleDelete(cert.id)}>⋮</button>
            </div>
            
            <img
              src={`data:image/jpeg;base64,${cert.certificateFile}`}
              alt={cert.title}
              className={styles.image}
            />
            <div className={styles.details}>
                <div className={styles.innerDetails}>
                    <p className={styles.org}>{cert.issuedOrganization}</p>
                    <p className={styles.date}>{cert.issueDate}</p>
                    <p className={styles.type}>{cert.type}</p>
                </div>
                <div className={styles.actions}>
                    <button onClick={() => handleView(cert.id)}>
                        <svg xmlns="http://www.w3.org/2000/svg" width={24} height={24} viewBox="0 0 24 24">
	                        <g fill="none">
		                        <circle cx={12} cy={12} r={4} fill="#0D4F45"></circle>
		                        <path stroke="#0D4F45" strokeWidth={2} d="M21 12s-1-8-9-8s-9 8-9 8"></path>
	                        </g>
                        </svg>
                    </button>
                    <button onClick={() => handleDownload(cert.id)}>
                        <svg xmlns="http://www.w3.org/2000/svg" width={24} height={24} viewBox="0 0 24 24">
	                        <path fill="#0D4F45" d="m12 16l-5-5l1.4-1.45l2.6 2.6V4h2v8.15l2.6-2.6L17 11zm-6 4q-.825 0-1.412-.587T4 18v-3h2v3h12v-3h2v3q0 .825-.587 1.413T18 20z" strokeWidth={0.5} stroke="#507537"></path>
                        </svg>
                    </button>
                </div>
            </div>
          </div>
        ))}

        {/* Add Certificate card */}
        <div
          className={styles.addCard}
          onClick={handleCertificateEdit}
        >
          <div className={styles.plus}>+</div>
          <p>Add a Certificate</p>
        </div>
      </div>
    </div>
  );
};

export default CertificatesSection;
