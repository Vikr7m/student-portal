import styles from './PeriodContainer.module.css';

function PeriodContainer(props){
    return(

        <div className={styles.overallContainer}>
            <div className={styles.insideContainer}>
                <h1>0{props.periodNo}</h1>
                <div className={styles.subject}>
                    <h2>{props.subjectId}</h2>
                    <h3>{props.subjectName}</h3>
                </div>
            </div>
            <div className={styles.timing}>
                <p>{props.startTime}</p>
                |
                <p>{props.endTime}</p>
            </div>
        </div>

    );
}

export default PeriodContainer;