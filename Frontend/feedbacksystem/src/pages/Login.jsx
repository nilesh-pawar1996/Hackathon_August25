
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { loginUser } from "../services/user";

function Login() {
  const [info, setInfo] = useState({
    email: "",
    password: "",
  });

  const navigate = useNavigate();

  const onLogin = async () => {
    if (info.email.length === 0) {
      toast.warn("Please enter email");
    } else if (info.password.length === 0) {
      toast.warn("Please enter password");
    } else {
      const { email, password } = info;
      try {
        const result = await loginUser(email, password);

        
        if (result.jwt) {
          const { jwt, role, email: userEmail } = result;

          // save token and user info
          localStorage.setItem("token", jwt);
          localStorage.setItem(
            "user",
            JSON.stringify({ role, email: userEmail })
          );

          toast.success("Login successful!");

          
          if (role === "ROLE_ADMIN") {
            navigate("/admin");
          } else if (role === "ROLE_TEACHER" ) {
            navigate("/teacher");
          } else if (role === "ROLE_STUDENT") {
            navigate("/feedback");
          } else {
            navigate("/"); 
          }
        } else {
          toast.error("Invalid email or password!");
        }
      } catch (err) {
        console.error(err);
        toast.error("Something went wrong. Try again!");
      }
    }
  };

  return (
    <div>
      <h1 className="page-header">Login</h1>
      <div className="container">
        <div className="mb-3">
          <label>Email</label>
          <input
            onChange={(e) => setInfo({ ...info, email: e.target.value })}
            type="text"
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <label>Password</label>
          <input
            onChange={(e) => setInfo({ ...info, password: e.target.value })}
            type="password"
            className="form-control"
          />
        </div>

        <div className="mb-3">
          <div>
            Don’t have an account yet? Register <Link to="/">here</Link>
          </div>
          <button onClick={onLogin} className="btn btn-success mt-2">
            Login
          </button>
        </div>
      </div>
    </div>
  );
}

export default Login;

