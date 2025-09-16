import styles from './OverallAttendance.module.css';
import { CircularProgressbar, buildStyles } from "react-circular-progressbar";
import "react-circular-progressbar/dist/styles.css";

function OverallAttendance({subList}){

    const { tHours, tPresent, tAbsent } = subList?.reduce(
    (acc, sub) => {
      acc.tHours += sub.totalPeriods;
      acc.tPresent += sub.totalPresent;
      acc.tAbsent += sub.totalAbsent;
      return acc;
    },
    { tHours: 0, tPresent: 0, tAbsent: 0 }
  ) || { tHours: 0, tPresent: 0, tAbsent: 0 };
    const calculatePercentage = (totalPresent, totalHours) => {
        return ((totalPresent/totalHours) * 100).toFixed(2);
    };

    return (
        <div className={styles.overall}>
            <h1>Overall Attendance</h1>
        <div className={styles.container}>
            <div className={styles.progressBar}>
                <CircularProgressbar
                    value={calculatePercentage(tPresent, tHours)}
                    text={`${calculatePercentage(tPresent, tHours)}%`}
                    styles={buildStyles({
                    textColor: "#0D4F45",
                    textSize: "32px bold",
                    pathColor: "#0D4F45",
                    trailColor: "#F8F9FA"
                    })}
                    
                />
            </div>
            <div className={styles.totalHours}>
                <h1>{tHours}</h1>
                <h2>Total Hours</h2>
            </div>
            <div className={styles.presentAbsent}>
                <h2 className={styles.preAbs}><label>Total Present :</label> {tPresent}</h2>
                <h2 className={styles.preAbs}><label>Total Absent :</label>{tAbsent}</h2>
            </div>

        </div>
         </div>
    );

}

export default OverallAttendance;