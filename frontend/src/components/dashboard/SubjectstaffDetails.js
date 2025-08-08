import SubjectStaffContainer from './SubjectStaffContainer';
import styles from './SubjectstaffDetails.module.css'



function SubjectStaffDetails({ sublist }) {
  
  if (!sublist || sublist.length === 0) {
    return <p>No subject staff data available</p>; // safe fallback
  }


  return (
    <>
    <h1>Subjects</h1>
    <div className={styles.subjectstaffcontainers}>
      {sublist.map((details, index) => (
        <SubjectStaffContainer 
          key={index}
          subjectId={details.subjectId} 
          subjectName={details.subjectName} 
          staffName={details.staffName} 
        />
      ))}
    </div>
    </>
  );
}


export default SubjectStaffDetails;