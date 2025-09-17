
import styles from './Marks.module.css';
import OverallMarks from './OverallMarks';
import SemWiseMarks from './SemWiseMarks';
import MarksTable from './MarksTable';


function Marks(){
    const batchNo = localStorage.getItem("batchNo");
    return(
        <div className={styles.attendance}>
            <OverallMarks cgpa = {8.1234} />
            <MarksTable/>
        </div>
    );
}

export default Marks;