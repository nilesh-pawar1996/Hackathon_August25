import axios from 'axios'
import {config} from './config'

export async function registerUser(

    firstName,
  lastName,
  email,
  password,
  role
) {
    try {
    const url = `${config.serverUrl}/users/signup`

    //create the body
    const body = {
         firstName,
        lastName,
        email,
        password,
        role,
    }

    const response = await axios.post(url, body)

    return response.data
}
catch (ex) {
    console.error('exception: ', ex)
}
}

export async function loginUser(email, password) {
    try {

        const url = `${config.serverUrl}/users/signin`

        const body = {
      email,
      password,
    }

    const response = await axios.post(url, body)

    return response.data
    } catch (ex) {
        console.error('exception: ', ex)
    }
}