import { useEffect, useState } from "react";
import { Navigate, useNavigate } from "react-router-dom";
import StudentDetails from "./Studentdetails";
import SubjectStaffDetails from "./SubjectstaffDetails";
import styles from './Dashboard.module.css';
import OverallContainerList from "./OverallContainerList";
import Timetable from "../timetable/Timetable";
import StudentDetailsMobile from "./StudentDetailsMobile";


function Dashboard() {
  const navigate = useNavigate();
  const [screenWidth, setScreenWidth] = useState(window.innerWidth);
  const token = localStorage.getItem("token");

  useEffect(() => {
    function handleResize() {
      setScreenWidth(window.innerWidth);
    }

    window.addEventListener("resize", handleResize);
    
    // cleanup on unmount
    return () => window.removeEventListener("resize", handleResize);
  }, []);


  const [dashboardData, setDashboardData] = useState([]);

  useEffect(() => {
    

    if (!token) {
      navigate('/login'); // redirect if token is missing
      return;
    }

    fetch("http://localhost:8081/student/dashboard", {
      method: "GET",
      headers: {
        "Authorization": `Bearer ${token}`
      }
    })
    .then(res => res.json())
    .then(data => {
      setDashboardData(data); // update UI state
    });
  }, []);
  
  localStorage.setItem("batchNo", dashboardData.batchNo);


  if (screenWidth>480){
    return (
    <div className = {styles.dashboardcontainer}>
      <div className={styles.studentDetails}>
        <StudentDetails name={dashboardData.name} 
          batchNo={dashboardData.batchNo} 
          department={dashboardData.department}/>
        <OverallContainerList
          cgpa={dashboardData.cgpa}
          attendance={dashboardData.attendance}
          feesDue={dashboardData.feesDue}
          />
        <SubjectStaffDetails sublist={dashboardData.subjectStaffs}/>
      </div>
      <Timetable/>    
    </div>
  );
  }
  else{
    return (
    <div className = {styles.dashboardcontainer}>
      <div className={styles.studentDetails}>
        <StudentDetailsMobile name={dashboardData.name} 
          batchNo={dashboardData.batchNo} 
          department={dashboardData.department}/>
        <SubjectStaffDetails sublist={dashboardData.subjectStaffs}/>
      </div>
      <Timetable/>
    </div>
  );
  }
  
}


export default Dashboard;