import { useState } from 'react'
import { Route, Routes } from 'react-router-dom'
import Register from './pages/Register'
import Login from './pages/Login'
import AdminDashboard from './pages/AdminDashboard'

function App() {

  return (
    
    <Routes>
              <Route path="/" element={<Register />}/>
              <Route path="/login" element={<Login />}/>
              <Route path="/admin" element={<AdminDashboard />}/>
    </Routes>
  )
}

export default App
