

function AttendancePerSubject({subList}) {
    const percentage = 75;
    return(
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
    );
}

export default AttendancePerSubject;