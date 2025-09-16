import styles from './LeaveRequest.module.css';
import React, { useState } from "react";

function LeaveRequest(){
    const [date, setDate] = useState("");
    return(
        <div className={styles.container}>
            <h2>Leave / OD Request</h2>
            <div className={styles.datePick}>
                <div className={styles.formGroup}>
                    <label>From :</label>
                    <input
                        type="date"
                        placeholder="Enter the Issued Date"
                        value={date}
                        onChange={(e) => setDate(e.target.value)}
                    />
                </div>
                <div className={styles.formGroup}>
                    <label>To :</label>
                    <input
                        type="date"
                        placeholder="Enter the Issued Date"
                        value={date}
                        onChange={(e) => setDate(e.target.value)}
                    />
                </div>
            </div>
            <h3>Class Coordinator : Mrs A Subashri</h3>
            <div className={styles.button}>
                <h4>Draft Mail</h4>
            </div>
        </div>
    );
}

export default LeaveRequest;