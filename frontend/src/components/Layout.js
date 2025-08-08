// Layout.js
import { Outlet } from "react-router-dom";
import Sidebar from '../sidebar/Sidebar'
import Header from "../header/Header";
import styles from './Layout.module.css'

function Layout() {
  return (
    <div className={styles.main}>
      <Header />
      <div className={styles.maincontainer}>
        <Sidebar />
        <div className={styles.maincontent}>
          <Outlet /> {/* This renders the current route component */}
        </div>
      </div>
    </div>
  );
}

export default Layout;
