
import { useEffect, useState } from "react";
import { Navigate, useNavigate } from "react-router-dom";
import styles from './Profile.module.css'


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
        <div className={styles.attendance}>
            <center>
                <h1>{profileData.name}</h1>
                <p>Yet to be developed</p>
                <button onClick={handleProjectEdit}>Project</button>
                <button onClick={handleCertificateEdit}>Certificate</button>
                <button onClick={handleImageUpadte}>Image</button>
                <h1>{batchno}</h1>
            </center>
        </div>
    );
}

export default Profile;