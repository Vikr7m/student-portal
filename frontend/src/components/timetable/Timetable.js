import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import PeriodContainer from "./PeriodContainer";
import styles from './Timetable.module.css';
import DateSelector from "./DateSelector";

function Timetable() {
  const navigate = useNavigate();
  const today = new Date().toISOString().split("T")[0];

  const [date, setDate] = useState(today);
  const [timetableData, setTimetableData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // Fetch data whenever the selected date changes
  useEffect(() => {
    const token = localStorage.getItem("token");

    if (!token) {
      navigate('/login');
      return;
    }

    setLoading(true);
    fetch(`http://localhost:8081/student/timetable/${date}`, {
      method: "GET",
      headers: {
        "Authorization": `Bearer ${token}`
      }
    })
      .then(res => {
        if (!res.ok) {
          throw new Error("Failed to fetch timetable");
        }
        return res.json();
      })
      .then(data => {
        setTimetableData(data);
        setLoading(false);
      })
      .catch(err => {
        console.error("Failed to fetch timetable:", err);
        setError("Could not load timetable.");
        setLoading(false);
      });
  }, [date, navigate]);

  if (loading) {
    return <div className={styles.timetable}>Loading timetable...</div>;
  }

  if (error) {
    return <div className={styles.timetable}>{error}</div>;
  }

  if (!timetableData) {
    return null;
  }

  const dayOrder = timetableData?.dayOrder ?? 0;
  const timetable = timetableData?.dayOrderTimetable ?? [];
  const description = timetableData?.description ?? "";

  return (
    <div className={styles.timetable}>
      <DateSelector
        selectedDate={date}
        onDateSelect={(selectedDate) => setDate(selectedDate)}
      />

      <div className={styles.dayorder}>
        <h3>Schedule for {date}</h3>
        <h4>Day Order : {dayOrder}</h4>
      </div>

      <h3 className={styles.description}>{description}</h3>
      <div className={styles.periodContainers}>
        {timetable.length === 0 ? (
          <p>No periods scheduled.</p>
          ) : (
            timetable.map((period, index) => (
            <PeriodContainer
              key={index}
              periodNo={period.periodNo}
              subjectId={period.subjectId}
              subjectName={period.subjectName || "Free Period or Training and Placement"}
              startTime={period.startTime}
              endTime={period.endTime}
            />
          ))
        )}
      </div>
      
    </div>
  );
}

export default Timetable;
