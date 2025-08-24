import OverallContainer from "./OverallContainer";
import styles from './OverallContainerList.module.css'

function OverallContainerList({ cgpa, attendance, feesDue }){

    return(
        <div className={styles.overallList}>
            <OverallContainer name="CGPA" value="7.5612"/>
            <OverallContainer name="Attendance" value="75.43 %"/>
            <OverallContainer name="Fees due" value="34,500 Rs"/>
        </div>
    );
}

export default OverallContainerList;