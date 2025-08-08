import { useEffect, useState } from "react";
import { motion, AnimatePresence } from "framer-motion";
import styles from './DateSelector.module.css';

function DateSelector({ selectedDate, onDateSelect }) {
  const [dates, setDates] = useState([]);
  const [baseDate, setBaseDate] = useState(new Date(selectedDate));

  // Generate 5 dates around base date
  const getFiveDates = (centerDate) => {
    const result = [];
    for (let i = -2; i <= 2; i++) {
      const temp = new Date(centerDate);
      temp.setDate(centerDate.getDate() + i);
      result.push({
        label: temp.toDateString(),
        value: temp.toISOString().split("T")[0],
        day: temp.getDate().toString().padStart(2, '0'),
        weekday: temp.toLocaleDateString('en-US', { weekday: 'short' }),
        fullDate: temp,
      });
    }
    return result;
  };

  useEffect(() => {
    const center = new Date(selectedDate);
    setBaseDate(center);
    setDates(getFiveDates(center));
  }, [selectedDate]);

  const handleClick = (dateStr) => {
    if (dateStr !== selectedDate) {
      onDateSelect(dateStr);
    }
  };

  const handlePrev = () => {
    const newBase = new Date(baseDate);
    newBase.setDate(baseDate.getDate() - 1);
    onDateSelect(newBase.toISOString().split("T")[0]);
  };

  const handleNext = () => {
    const newBase = new Date(baseDate);
    newBase.setDate(baseDate.getDate() + 1);
    onDateSelect(newBase.toISOString().split("T")[0]);
  };

  // Month and Year display
  const displayMonthYear = baseDate.toLocaleDateString("en-US", {
    month: "long",
    year: "numeric",
  });

  return (
    <div className={styles.container}>
      <div className={styles.dateHeader}>
        <div onClick={handlePrev} className={styles.arrow1}>
          <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1.5em" viewBox="0 0 12 24">
	          <path fill="#0D4F45" fill-rule="evenodd" d="M10.157 12.711L4.5 18.368l-1.414-1.414l4.95-4.95l-4.95-4.95L4.5 5.64l5.657 5.657a1 1 0 0 1 0 1.414" />
          </svg>
        </div>
        <h2 className={styles.monthYear}>{displayMonthYear}</h2>
        <div onClick={handleNext} className={styles.arrow2}>
          <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1.5em" viewBox="0 0 12 24">
	          <path fill="#0D4F45" fill-rule="evenodd" d="M10.157 12.711L4.5 18.368l-1.414-1.414l4.95-4.95l-4.95-4.95L4.5 5.64l5.657 5.657a1 1 0 0 1 0 1.414" />
          </svg>
        </div>
      </div>

      <div className={styles.dateList}>
        <AnimatePresence mode="popLayout">
          {dates.map((dateObj) => (
            <motion.div
              key={dateObj.value}
              className={dateObj.value === selectedDate ? styles.selected : styles.notSelected}
              onClick={() => handleClick(dateObj.value)}
              layout
              initial={{ opacity: 0, x: -30 }}
              animate={{ opacity: 1, x: 0 }}
              exit={{ opacity: 0, x: 30 }}
              transition={{ duration: 0.05, ease: "easeInOut" }}
            >
              <h3>{dateObj.weekday}</h3>
              <p>{dateObj.day}</p>
            </motion.div>
          ))}
        </AnimatePresence>
      </div>
    </div>
  );
}

export default DateSelector;
