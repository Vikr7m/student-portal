import React, { useState } from "react";
import './App.css';
// src/App.js
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from './components/login/Login';
import Dashboard from './components/dashboard/Dashboard';
import Attendance from "./components/attendance/Attendance";
import Marks from "./components/marks/Marks";
import Payments from "./components/payments/Payments";
import Campus from "./components/campus/Campus";
import Profile from "./components/profile/Profile";
import PrivateRoute from './privateroute';
import Layout from "./components/Layout";

function App() {

  const [selectedPage, setSelectedPage] = useState("dashboard");
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login />} />

        <Route
          path="/"
          element={
            <PrivateRoute>
              <Layout />
            </PrivateRoute>
          }
        >
          <Route path="dashboard" element={<Dashboard />} />
          <Route path="attendance" element={<Attendance />} />
          <Route path="marks" element={<Marks />} />
          <Route path="payments" element={<Payments />} />
          <Route path="campus" element={<Campus />} />
          <Route path="profile" element={<Profile />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;

