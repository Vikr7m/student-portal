import styles from './AttendancePerSubject.module.css';
import { CircularProgressbar, buildStyles } from "react-circular-progressbar";
import "react-circular-progressbar/dist/styles.css";

function AttendancePerSubject({subList}) {
    const percentage = 5;
    
    const calculatePercentage = (totalPresent, totalHours) => {
        return ((totalPresent/totalHours) * 100).toFixed(2);
    };
    return(
        <div className={styles.attendancePerSubject}>
            <h1>Subject - Wise Attendance</h1>
            <div className={styles.overallContainer}>
                        {subList?.map((sub, index) => (
                            <div className={styles.subContainer}>
                                <div className={styles.subDetails}>
                                    <div className={styles.codeName}>
                                        <h2>{sub.subjectId}</h2>
                                        <h2>{sub.subjectName}</h2>
                                    </div>
                                    <div className={styles.hoursPresentAbsent}>
                                        <h3>Total Hours : {sub.totalPeriods}</h3>
                                        <h3>Hours Present: {sub.totalPresent}</h3>
                                        <h3>Hours Absent: {sub.totalAbsent}</h3>
                                    </div>

                                </div>
                                <div className={styles.progressBar}>
                                    <CircularProgressbar
                                    value={calculatePercentage(sub.totalPresent, sub.totalPeriods)}
                                    text={`${calculatePercentage(sub.totalPresent, sub.totalPeriods)}%`}
                                    styles={buildStyles({
                                    textColor: "#F8F9FA",
                                    pathColor: "#F4A261",
                                    trailColor: "#F8F9FA"
                                    })}
                                    />
                                </div>
                            </div>)
                        )}
                    </div>
        </div>
    );
}

export default AttendancePerSubject;