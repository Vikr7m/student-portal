import styles from './Studentdetails.module.css';
import profile from './profile.jpg';
import banner from './banner.jpg'
import { useEffect, useState } from "react";

function StudentDetails(props){

    const [photoUrl, setPhotoUrl] = useState(null);
    const token = localStorage.getItem("token");
    const batchno = localStorage.getItem("batchNo") || props.batchNo;


    

    useEffect(() => {
            try {
                fetch(`http://localhost:8081/student/${batchno}/image`, {
                method: "GET",
                headers: {
                    "Authorization": `Bearer ${token}`
                }
                })
                .then(res => res.blob())
                .then(blob => {
                setPhotoUrl(URL.createObjectURL(blob));
                });
            } catch (err) {
            console.error(err);
            }
        }, [batchno, token]);


        return(
        <div className={styles.container}>
            <div className={styles.studentdetails}>
                {photoUrl && <img key={batchno} src={photoUrl} alt="Student"/>}
                <div className={styles.name}>
                    <h1>{props.name}</h1>
                    <div className={styles.batchdepartment}>
                        <h3>{props.batchNo}</h3>
                        <h3>{props.department}</h3>
                        <h3>VII sem  /  IV year</h3>
                    </div>
                </div>
            </div>
            <div className={styles.motivation}>
                <h2><d>Be</d>live In</h2>
                <h3><d>You</d>rself</h3>
            </div>
        </div>
    );
       
}
export default StudentDetails;