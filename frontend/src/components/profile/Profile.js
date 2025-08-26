
import { useEffect, useState } from "react";
import { Navigate, useNavigate } from "react-router-dom";
import styles from './Profile.module.css'
import CertificatesSection from "./CertificatesSection";
import ProjectSection from "./ProjectSection";


function Profile(){

    const navigate = useNavigate();
    const [profileData, setProfileData] = useState([]);
    const batchno = localStorage.getItem("batchNo");

    useEffect(() => {
        const token = localStorage.getItem("token");
    
        if (!token) {
          navigate('/login'); // redirect if token is missing
          return;
        }
    
        fetch("http://localhost:8081/student/profile", {
          method: "GET",
          headers: {
            "Authorization": `Bearer ${token}`
          }
        })
        .then(res => res.json())
        .then(data => {
          setProfileData(data); // update UI state
        });
      }, []);

    const handleProjectEdit = () => {
        navigate('/project-edit');
    }
    const handleCertificateEdit = () => {
        navigate('/certificate-add');
    }
    const handleImageUpadte = () => {
        navigate('/image-upadte');
    }


    return(
      <div className={styles.profileContent}>
        <div className={styles.profilecard}>
          {/* Top Section - Profile Pic + Basic Info */}
          <div className={styles.topSection}>
            <div className={styles.top}>
              <img src={`data:image/jpeg;base64,${profileData.image}`} alt="profile" className={styles.profilePic} />
              <div className={styles.basicInfo}>
                <h2>{profileData.name}</h2>
                <p>{profileData.batchNo}</p>
                <p>{profileData.dept}</p>
                <p>{profileData.academicYear}</p>
              </div>
            </div>
      
            <div className={styles.academicInfo}>
              <p>
                <span>Year :</span> {profileData.year}
                <span className={styles.semester}>Semester :</span> {profileData.semester}
              </p>
              <p>
                <span>Current SGPA :</span> {profileData.sgpa}
              </p>
              <p>
                <span>CGPA :</span> {profileData.cgpa}
              </p>
              <p>
                <span>Backlogs :</span> {profileData.backlogs}
              </p>
            </div>
          </div>

    

          {/* Right Side - Personal Info */}
          <div className={styles.personalInfo}>
            <p><span>Mobile No :</span> {profileData.mobileNo}</p>
            <p><span>Email :</span> {profileData.email}</p>
            <p><span>Date of Birth :</span> {profileData.dob}</p>
            <p><span>Blood Group :</span> {profileData.bloodGroup}</p>
            <p><span>Father’s Name :</span> {profileData.fatherName}</p>
            <p><span>Mother’s Name :</span> {profileData.motherName}</p>
            <p><span>Address :</span> {profileData.address}</p>
            <p><span>Emergency Contact :</span> {profileData.emergencyContact}</p>
          </div>
        </div>

        <CertificatesSection certificates={profileData.certificates} />
        <ProjectSection projects={profileData.projects} />
        
    
    </div>
);

}

export default Profile;