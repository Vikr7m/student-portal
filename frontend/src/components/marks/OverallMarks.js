import { useState } from 'react';
import { useEffect} from "react";
import { Navigate, useNavigate } from "react-router-dom";
import styles from './OverallMarks.module.css';
import { CircularProgressbar, buildStyles } from "react-circular-progressbar";
import "react-circular-progressbar/dist/styles.css";

function OverallMarks({cgpa}){

    const cgpaPercent = cgpa * 10;

    const[overallMarksData, setOverallMarksData] = useState(null);

    
    const navigate = useNavigate();
    

    useEffect(() => {
                const token = localStorage.getItem("token");
                const batchNo = localStorage.getItem("batchNo");
            
                if (!token) {
                  navigate('/login'); // redirect if token is missing
                  return;
                }
            
                fetch(`http://localhost:8081/student/overall-marks/${batchNo}`, {
                  method: "GET",
                  headers: {
                    "Authorization": `Bearer ${token}`
                  }
                })
                .then(res => res.json())
                .then(data => {
                setOverallMarksData(data); // update UI state
        });
    }, []);

    return (
        <div className={styles.overall}>
            <h1>Overall Marks</h1>
        <div className={styles.container}>
            <div className={styles.progressBar}>
                <CircularProgressbar
                    value={cgpaPercent}
                    text={`${cgpa}`}
                    styles={buildStyles({
                    textColor: "#0D4F45",
                    textSize: "32px bold",
                    pathColor: "#0D4F45",
                    trailColor: "#F8F9FA"
                    })}
                    
                />
                <h1 className={styles.cgpaValue}>CGPA</h1>
            </div>
            <div className={styles.totalHours}>
                <h1>{overallMarksData?.subjectsPassed ?? '--'}/<label>{overallMarksData?.totalSubjects ?? '--'}</label></h1>
                <h2>Subjects Passed</h2>
            </div>
            <div className={styles.presentAbsent}>
                <h2 className={styles.preAbs}><label>Current Arrears :</label> {overallMarksData?.currentArrears ?? '--'}</h2>
                <h2 className={styles.preAbs}><label>History Of Arrears :</label>{overallMarksData?.historyOfArrears ?? '--'}</h2>
            </div>

        </div>
         </div>
    );

}

export default OverallMarks;