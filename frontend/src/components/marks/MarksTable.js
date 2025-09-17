import React, { useEffect, useState } from "react";
import styles from "./MarksTable.module.css";
import { Navigate, useNavigate } from "react-router-dom";

export default function MarksTable() {
  const [semester, setSemester] = useState(1);
  const [marksData, setMarksData] = useState([]);
  
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);

  const navigate = useNavigate(); 
  useEffect(() => {
                const token = localStorage.getItem("token");
                const batchNo = localStorage.getItem("batchNo");
            
                if (!token) {
                  navigate('/login'); // redirect if token is missing
                  return;
                }
            
                fetch(`http://localhost:8081/student/marks/${batchNo}/${semester}`, {
                  method: "GET",
                  headers: {
                    "Authorization": `Bearer ${token}`
                  }
                })
                .then(res => res.json())
                .then(data => {
                setMarksData(data); // update UI state
        });
    }, [semester]);


  if (error) return <p style={{ color: "red" }}>{error}</p>;
  if (!marksData || !marksData.marksPerSem) return <p>Loading…</p>;  

  const { marksPerSem, gpa } = marksData;

  // Compute column totals
  const totalIA1 = marksPerSem.reduce((acc, s) => acc + s.ia1Marks, 0);
  const totalIA2 = marksPerSem.reduce((acc, s) => acc + s.ia2Marks, 0);
  const totalIA3 = marksPerSem.reduce((acc, s) => acc + s.ia3Marks, 0);
  const totalAvg = marksPerSem.reduce(
    (acc, s) => acc + (s.ia1Marks + s.ia2Marks + s.ia3Marks) / 3,
    0
  );

  return (
    
    <div className={styles.marksContainer}>
         <div className={styles.wrapper}>
      {/* semester selector */}
      <div className={styles.semesters}>
        {[1,2,3,4,5,6,7,8].map((num) => (
          <button
            key={num}
            className={`${styles.semBtn} ${num === semester ? styles.active : ""}`}
            onClick={() => setSemester(num)}
          >
            {num}
          </button>
        ))}
      </div>
      </div>
      <div className={styles.underline} style={{ left: `${(semester-1)*12.5}%` }} ></div>
      <table className={styles.marksTable}>
        <thead>
          <tr>
            <th>Subjects</th>
            <th>IA1</th>
            <th>IA2</th>
            <th>IA3</th>
            <th>Avg</th>
            <th>SEM</th>
          </tr>
        </thead>
        <tbody>
          {marksPerSem.map((s) => {
            const avg = ((s.ia1Marks + s.ia2Marks + s.ia3Marks) / 3).toFixed(1);
            return (
              <tr key={s.subjectId}>
                <td>
                  <div className={styles.subjectCell}>
                    <div className={styles.subjectCode}>{s.subjectId}</div>
                    <div className={styles.subjectName}>{s.subjectName}</div>
                  </div>
                </td>
                <td>{s.ia1Marks}</td>
                <td className={s.ia2Marks < 50 ? "lowMark" : ""}>{s.ia2Marks}</td>
                <td>{s.ia3Marks}</td>
                <td>{avg}</td>
                <td>{s.semGrade || "-"}</td>
              </tr>
            );
          })}
        </tbody>
        <tfoot>
          <tr>
            <td>Total</td>
            <td>{totalIA1}</td>
            <td>{totalIA2}</td>
            <td>{totalIA3}</td>
            <td>{totalAvg.toFixed(1)}</td>
            <td>{gpa.toFixed(2)}</td>
          </tr>
        </tfoot>
      </table>
      
    </div>
  );
}