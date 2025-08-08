import styles from './Studentdetails.module.css';
import profile from './profile.jpg';
import banner from './banner.jpg'

function StudentDetails(props){

        return(
        <div className={styles.container}>
            <div className={styles.studentdetails}>
                <img src={profile} height="100" width="100"/>
                <div className={styles.name}>
                    <h1>{props.name}</h1>
                    <div className={styles.batchdepartment}>
                        <h3>{props.batchNo}</h3>
                        <h3>{props.department}</h3>
                        <h3>VII sem  /  IV year</h3>
                    </div>
                </div>
            </div>
            <div className={styles.motivation}>
                <h2><d>Be</d>live In</h2>
                <h3><d>You</d>rself</h3>
            </div>
        </div>
    );
       
}
export default StudentDetails;