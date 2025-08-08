import styles from './Header.module.css';
import logo from '../logo.png';
import { useNavigate } from 'react-router-dom';

function Header(){
    const navigate = useNavigate();

    const handleLogout = () => {
        const confirmLogout = window.confirm("Are you sure you want to logout?");
        if (confirmLogout) {
            // User clicked "Yes"
            localStorage.removeItem('token'); // Clear session
            navigate('/login');              // Redirect to login page
        }
    };

    return(
        <div className= {styles.header}>
            <div className={styles.collegeDetails}>
                <div className={styles.logo}>
                    <img src={logo} height="40" width="40"/>
                </div>
                <div className={styles.college}>
                    <h1>Sarnanathan college of engineering</h1>
                    <h3>Panjappur</h3>
                </div>
            </div>
            <div onClick={handleLogout}>
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
	                <path fill="currentColor" d="M5 21q-.825 0-1.412-.587T3 19V5q0-.825.588-1.412T5 3h7v2H5v14h7v2zm11-4l-1.375-1.45l2.55-2.55H9v-2h8.175l-2.55-2.55L16 7l5 5z" />
                </svg>
            </div>
            
        </div>
    );
}

export default Header;