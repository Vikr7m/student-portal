import styles from './StudentDetailsMobile.module.css';
import { useEffect, useState } from "react";

function StudentDetailsMobile(props) {

    const [photoUrl, setPhotoUrl] = useState(null);
    const token = localStorage.getItem("token");
    const batchno = localStorage.getItem("batchNo") || props.batchNo;

    useEffect(() => {
                try {
                    fetch(`http://localhost:8081/student/${batchno}/image`, {
                    method: "GET",
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                    })
                    .then(res => res.blob())
                    .then(blob => {
                    setPhotoUrl(URL.createObjectURL(blob));
                    });
                } catch (err) {
                console.error(err);
                }
            }, []);
    

    return(
        <div className={styles.container}>
            <div className={styles.profile}>
                <div className={styles.photoName}>
                    {photoUrl && <img key={batchno} src={photoUrl} alt="Student"/>}
                    <div className={styles.name}>
                        <h2>{props.name}</h2>
                        <h3>{props.batchNo}</h3>
                        <h3>{props.department}</h3>
                    </div>
                </div>
                <div className={styles.sem}>
                    <h4>VII sem</h4>
                    <h4>IV year</h4>
                </div>
            </div>
            <div className={styles.studentValues}>
                <div className={styles.atendanse}>
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 576 512" fill="#ffffff">
                        <path d="M528 160v256c0 8.8-7.2 16-16 16H320c0-44.2-35.8-80-80-80h-64c-44.2 0-80 35.8-80 80H64c-8.8 0-16-7.2-16-16V160zM64 32C28.7 32 0 60.7 0 96v320c0 35.3 28.7 64 64 64h448c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64zm208 224a64 64 0 1 0-128 0a64 64 0 1 0 128 0m104-48c-13.3 0-24 10.7-24 24s10.7 24 24 24h80c13.3 0 24-10.7 24-24s-10.7-24-24-24zm0 96c-13.3 0-24 10.7-24 24s10.7 24 24 24h80c13.3 0 24-10.7 24-24s-10.7-24-24-24z"></path>
                    </svg>
                    <div className={styles.attendanceValue}>
                        <h4>86.26 %</h4>
                        <h5>Attendance</h5>
                    </div>
                </div>
                <div className={styles.atendanse}>
                    <svg xmlns="http://www.w3.org/2000/svg" width={24} height={24} viewBox="0 0 32 32"><path fill="currentColor" d="M14 23h8v2h-8zm-4 0h2v2h-2zm4-5h8v2h-8zm-4 0h2v2h-2zm4-5h8v2h-8zm-4 0h2v2h-2z"></path><path fill="currentColor" d="M25 5h-3V4a2 2 0 0 0-2-2h-8a2 2 0 0 0-2 2v1H7a2 2 0 0 0-2 2v21a2 2 0 0 0 2 2h18a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2M12 4h8v4h-8Zm13 24H7V7h3v3h12V7h3Z"></path>
                    </svg> 
                    <div className={styles.attendanceValue}>
                        <h4>8.1234</h4>
                        <h5>CGPA</h5>
                    </div>
                </div>
                <div className={styles.atendanse}>
                    <svg xmlns="http://www.w3.org/2000/svg" width={24} height={24} viewBox="0 0 24 24"><g fill="none" stroke="currentColor" strokeWidth={1.5}><path d="M17.414 10.414C18 9.828 18 8.886 18 7s0-2.828-.586-3.414m0 6.828C16.828 11 15.886 11 14 11h-4c-1.886 0-2.828 0-3.414-.586m10.828 0Zm0-6.828C16.828 3 15.886 3 14 3h-4c-1.886 0-2.828 0-3.414.586m10.828 0Zm-10.828 0C6 4.172 6 5.114 6 7s0 2.828.586 3.414m0-6.828Zm0 6.828ZM13 7a1 1 0 1 1-2 0a1 1 0 0 1 2 0Z"></path><path strokeLinecap="round" d="M18 6a3 3 0 0 1-3-3m3 5a3 3 0 0 0-3 3M6 6a3 3 0 0 0 3-3M6 8a3 3 0 0 1 3 3m-4 9.388h2.26c1.01 0 2.033.106 3.016.308a14.9 14.9 0 0 0 5.33.118c.868-.14 1.72-.355 2.492-.727c.696-.337 1.549-.81 2.122-1.341c.572-.53 1.168-1.397 1.59-2.075c.364-.582.188-1.295-.386-1.728a1.89 1.89 0 0 0-2.22 0l-1.807 1.365c-.7.53-1.465 1.017-2.376 1.162q-.165.026-.345.047m0 0l-.11.012m.11-.012a1 1 0 0 0 .427-.24a1.49 1.49 0 0 0 .126-2.134a1.9 1.9 0 0 0-.45-.367c-2.797-1.669-7.15-.398-9.779 1.467m9.676 1.274a.5.5 0 0 1-.11.012m0 0a9.3 9.3 0 0 1-1.814.004"></path><rect width={3} height={8} x={2} y={14} rx={1.5}></rect></g>
                    </svg>
                    <div className={styles.attendanceValue}>
                        <h4>35000 Rs</h4>
                        <h5>Fees due</h5>
                    </div>
                </div>
            </div>

        </div>

    );

}

export default StudentDetailsMobile;