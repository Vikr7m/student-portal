
import styles from './Attendance.module.css';
import AttendancePerSubject from './AttendancePerSubject';



function Attendance(){
    const percentage = 75;
    const subList = [
        {
            subjectCode : "CS3245",
            totalHours : "12",
            totalPresent: "10", 
            totalAbsent : "2"
        },
        {
            subjectCode : "AD7842",
            totalHours : "8",
            totalPresent: "5", 
            totalAbsent : "3"
        },
        {
            subjectCode : "AI1243",
            totalHours : "12",
            totalPresent: "10", 
            totalAbsent : "2"
        },
        {
            subjectCode : "CS7545",
            totalHours : "12",
            totalPresent: "10", 
            totalAbsent : "2"
        },
    ]
    return(
        <div className={styles.attendance}>
            <h1>Attendance Section</h1>
            <p>Yet to be developed</p>
            <div className={styles.overallContainer}>
                        <h1>Subject - Wise Attendance</h1>
                        {subList?.map((sub, index) => (
                            <div className={syles.subContainer}>
                                <h2>{sub.subjectCode}</h2>
                                <h3>Total Hours : {sub.totalHours}</h3>
                                <h3>Hours Present: {sub.totalPresent}</h3>
                                <h3>Hours Absent: {sub.totalAbsent}</h3>
                                <div className={styles.progressBar}>
                                    <div
                                        className={styles.progress}
                                        style={{ width: `${percentage}%` }}
                                    ></div>
                                </div>
                            </div>)
                        )}
                    </div>
        </div>
    );
}

export default Attendance;