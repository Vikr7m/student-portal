
import React, { useState } from 'react';
import { useEffect} from "react";
import { Navigate, useNavigate } from "react-router-dom";
import styles from './Attendance.module.css';
import AttendancePerSubject from './AttendancePerSubject';
import LeaveRequest from './LeaveRequest';
import OverallAttendance from './OverallAttendance';




function Attendance(){
    const navigate = useNavigate();
    const [attendanceData, setAttendanceData] = useState(null);

    

    useEffect(() => {
            const token = localStorage.getItem("token");
            const batchNo = localStorage.getItem("batchNo");
        
            if (!token) {
              navigate('/login'); // redirect if token is missing
              return;
            }
        
            fetch(`http://localhost:8081/student/attendance/${batchNo}`, {
              method: "GET",
              headers: {
                "Authorization": `Bearer ${token}`
              }
            })
            .then(res => res.json())
            .then(data => {
            setAttendanceData(data); // update UI state
            });
          }, []);
    
    return(
        <div className={styles.attendance}>
            <div className={styles.overall}>
                <OverallAttendance subList = {attendanceData} />
                <LeaveRequest/>
            </div>
            <AttendancePerSubject subList = {attendanceData} />
        </div>
    );
}

export default Attendance;