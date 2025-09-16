import OverallContainer from "./OverallContainer";
import styles from './OverallContainerList.module.css'

function OverallContainerList({ cgpa, attendance, feesDue }){

    const cgpaRounded = Math.round((cgpa * 1000.0)) / 1000.0;

    return(
        <div className={styles.overallList}>
            <OverallContainer name="CGPA" value={cgpaRounded}/>
            <OverallContainer name="Attendance" value="75.43 %"/>
            <OverallContainer name="Fees due" value="34,500 Rs"/>
        </div>
    );
}

export default OverallContainerList;