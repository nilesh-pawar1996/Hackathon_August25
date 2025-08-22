
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import { registerUser } from '../services/user'

function Register() {
  const [info, setInfo] = useState({
    email: '',
    password: '',
    firstName: '',
    lastName: '',
    role: '',
  })

  const navigate = useNavigate()

  const onRegister = async () => {
    if (info.firstName.length === 0) {
      toast.warn('Please enter first name')
    } else if (info.lastName.length === 0) {
      toast.warn('Please enter last name')
    } else if (info.email.length === 0) {
      toast.warn('Please enter email')
    } else if (info.password.length === 0) {
      toast.warn('Please enter password')
    } else if (info.role.length === 0) {
      toast.warn('Please select a role')
    } else {
      const { firstName, lastName, email, password, role } = info
      const result = await registerUser(firstName, lastName, email, password, role)

      console.log('Register response:', result)

      if (result && result.status === 'success') {
        toast.success(result.message || 'Successfully registered a user')
        navigate('/login')
      } else {
        toast.error('Registration failed, please try again')
      }
    }
  }

  return (
    <div>
      <h1 className='page-header'>Register</h1>
      <div className='container'>
        <div className='mb-3'>
          <label>First Name</label>
          <input
            onChange={(e) => setInfo({ ...info, firstName: e.target.value })}
            type='text'
            className='form-control'
          />
        </div>

        <div className='mb-3'>
          <label>Last Name</label>
          <input
            onChange={(e) => setInfo({ ...info, lastName: e.target.value })}
            type='text'
            className='form-control'
          />
        </div>

        <div className='mb-3'>
          <label>Email</label>
          <input
            onChange={(e) => setInfo({ ...info, email: e.target.value })}
            type='text'
            className='form-control'
          />
        </div>

        <div className='mb-3'>
          <label>Password</label>
          <input
            onChange={(e) => setInfo({ ...info, password: e.target.value })}
            type='password'
            className='form-control'
          />
        </div>

       
        <div className='mb-3'>
          <label>Role</label>
          <select
            className='form-control'
            value={info.role}
            onChange={(e) => setInfo({ ...info, role: e.target.value })}
          >
            <option value=''>-- Select Role --</option>
            <option value='ROLE_STUDENT'>Student</option>
            <option value='ROLE_TEACHER'>Teacher</option>
            <option value='ROLE_ADMIN'>Admin</option>
          </select>
        </div>

        <div className='mb-3'>
          <div>
            Already have an account? Login <Link to='/login'>here</Link>
          </div>
          <button onClick={onRegister} className='btn btn-success mt-2'>
            Register
          </button>
        </div>
      </div>
    </div>
  )
}

export default Register

