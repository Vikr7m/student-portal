import styles from './subjectStaffContainer.module.css';

function SubjectStaffContainer(props){
    return(
        <div className = {styles.subjectstaffcontainer}>
            <div className={styles.Subjectstaff}>
                <div className={styles.subject}>
                    <h1>{props.subjectId}</h1>
                    <h3>{props.subjectName}</h3>
                </div>
                <p>{props.staffName}</p>
            </div>
            <div className={styles.expandIcon}>
                <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 16 16">
	                <path fill="#fff" d="M4.28 5.22a.75.75 0 0 1 0 1.06L3.56 7h2.69a.75.75 0 0 1 0 1.5H3.56l.72.72a.75.75 0 1 1-1.06 1.06l-2-2a.75.75 0 0 1 0-1.06l2-2a.75.75 0 0 1 1.06 0m7.44 0a.75.75 0 0 1 1.06 0l2 2a.75.75 0 0 1 0 1.06l-2 2a.75.75 0 1 1-1.06-1.06l.72-.72H9.75a.75.75 0 0 1 0-1.5h2.69l-.72-.72a.75.75 0 0 1 0-1.06" />
                </svg>
            </div>
        </div>
    );
}

export default SubjectStaffContainer;