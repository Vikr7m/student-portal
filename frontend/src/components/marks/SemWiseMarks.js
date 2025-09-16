import styles from './SemWiseMarks.module.css';

function SemWiseMarks(){
    return(
        <div className={styles.overallContainer}>
            <div className={styles.semesters}>
                <ul>
                    <li>1</li>
                    <li>2</li>
                    <li>3</li>
                    <li>4</li>
                    <li>5</li>
                    <li>6</li>
                    <li>7</li>
                    <li>8</li>
                    <div className={styles.semDenotar}>
                    <div className={styles.semDenotarBar}></div>
                </div>
                </ul>
                
            </div>
        </div>
    );

}

export default SemWiseMarks;