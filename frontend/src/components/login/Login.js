// src/pages/Login.js
import React, { useState } from 'react';
import axios from 'axios';
import styles from './Login.module.css'
import logo from './logo.png'

export default function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

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
                type="password"
                placeholder="Password"
                value={password}
                onChange={e => setPassword(e.target.value)}
              />
            </div>
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
