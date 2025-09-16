
import styles from './Marks.module.css';
import OverallMarks from './OverallMarks';
import SemWiseMarks from './SemWiseMarks';


function Marks(){
    return(
        <div className={styles.attendance}>
            <OverallMarks cgpa = {8.1234} />
            <SemWiseMarks/>
        </div>
    );
}

export default Marks;