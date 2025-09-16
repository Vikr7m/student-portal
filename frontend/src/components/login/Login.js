// src/pages/Login.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import PasswordReset from './password reset/PasswordReset';
import axios from 'axios';
import styles from './Login.module.css'
import logo from './logo.png'

export default function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [showPassword, setShowPassword] = useState(
  <svg xmlns="http://www.w3.org/2000/svg" width={24} height={24} viewBox="0 0 24 24">
    <path fill="none" stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M3 10a13.4 13.4 0 0 0 3 2.685M21 10a13.4 13.4 0 0 1-3 2.685m-8 1.624L9.5 16.5m.5-2.19a10.6 10.6 0 0 0 4 0m-4 0a11.3 11.3 0 0 1-4-1.625m8 1.624l.5 2.191m-.5-2.19a11.3 11.3 0 0 0 4-1.625m0 0l1.5 1.815M6 12.685L4.5 14.5"></path>
  </svg>);
  const [error, setError] = useState('');

  const navigate = useNavigate();
  const forgotpassword = () => {
    navigate("/passwordreset");
  }

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const res = await axios.post('http://localhost:8081/student/login', {
        username: email,
        password
      });

      const token = res.data.token; // Adjust key as per your backend response
      localStorage.setItem('token', token); // Store in browser
      // Redirect or show success
      window.location.href = '/dashboard'; // example
    } catch (err) {
      console.error(err);
      setError('Invalid credentials or server error');
    }
  };

  return (
    <div className={styles.overallContainer}>
      <div className={styles.rightContainer}>
        <div className={styles.collegeDetails}>
          <div className={styles.logo}>
            <img src={logo} height="300" width="300"/>
          </div>
          <div className={styles.name}>
            <h1>Saranathan College of Engineering</h1>
            <p>Tiruchirapalli</p>
          </div>
        </div>
      </div>
      <div className={styles.leftContainer}>
        <div className={styles.loginContainer}>
          <h1>Login</h1>
          <br/>
          <form onSubmit={handleLogin}>
            <div className={styles.innerContainer}>
              <div className={styles.email}>
              <input
                type="email"
                placeholder="Email"
                value={email}
                onChange={e => setEmail(e.target.value)}
              />
            </div>
            <div className={styles.password}>
              <input
                type={showPassword ? "password" : "text"}
                placeholder="Password"
                value={password}
                onChange={e => setPassword(e.target.value)}
              />
              <span
                className={styles.togglePassword}
                onClick={() => setShowPassword(prev => !prev)}
              >
                {showPassword ? <svg xmlns="http://www.w3.org/2000/svg" width={24} height={24} viewBox="0 0 24 24">
                                  <path fill="none" stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M3 10a13.4 13.4 0 0 0 3 2.685M21 10a13.4 13.4 0 0 1-3 2.685m-8 1.624L9.5 16.5m.5-2.19a10.6 10.6 0 0 0 4 0m-4 0a11.3 11.3 0 0 1-4-1.625m8 1.624l.5 2.191m-.5-2.19a11.3 11.3 0 0 0 4-1.625m0 0l1.5 1.815M6 12.685L4.5 14.5"></path>
                                </svg> : 
                                <svg xmlns="http://www.w3.org/2000/svg" width={24} height={24} viewBox="0 0 24 24">
                                  <g fill="none" stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth={2}>
                                    <path d="M3 13c3.6-8 14.4-8 18 0"></path>
                                    <path fill="currentColor" d="M12 17a3 3 0 1 1 0-6a3 3 0 0 1 0 6"></path>
                                  </g>
                                </svg>}
              </span>
            </div>
            <p className={styles.forgotPassword} onClick={forgotpassword}>Forgot password?</p>
            <button type="submit">Login</button>
            <p style={{ color: 'red' }}>{error}</p>
            </div>
          </form>
          <p>use college email and password as saranathan123 for first time login</p>
        </div>
        
      </div>
    </div>
    
  );
}
