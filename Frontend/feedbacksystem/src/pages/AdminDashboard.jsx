import React, { useState } from "react";
import axios from "axios";
import { toast } from "react-toastify";

function AdminDashboard() {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [questions, setQuestions] = useState([""]);

  const token = localStorage.getItem("token");

  const handleAddQuestion = () => {
    setQuestions([...questions, ""]);
  };

  const handleQuestionChange = (index, value) => {
    const newQuestions = [...questions];
    newQuestions[index] = value;
    setQuestions(newQuestions);
  };

  const handleSubmit = async () => {
    if (!title || !description || questions.some((q) => !q)) {
      toast.warn("Please fill all fields");
      return;
    }

    try {
      const payload = {
        title,
        description,
        questions: questions.map((q) => ({ questionText: q })),
      };

      const response = await axios.post(
        "http://localhost:8080/templates",
        payload,
        { headers: { Authorization: `Bearer ${token}` } }
      );

      toast.success("Template created successfully!");
      console.log("Created:", response.data);

      
      setTitle("");
      setDescription("");
      setQuestions([""]);
    } catch (err) {
      console.error(err);
      toast.error("Error creating template");
    }
  };

  return (
    <div className="container mt-5">
      <h2>Admin Dashboard</h2>
      <h4>Create Feedback Template</h4>

      <div className="mb-3">
        <label>Title</label>
        <input
          className="form-control"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
      </div>

      <div className="mb-3">
        <label>Description</label>
        <input
          className="form-control"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
      </div>

      <h5>Questions</h5>
      {questions.map((q, index) => (
        <div key={index} className="mb-2">
          <input
            className="form-control"
            placeholder={`Question ${index + 1}`}
            value={q}
            onChange={(e) => handleQuestionChange(index, e.target.value)}
          />
        </div>
      ))}
      <button className="btn btn-secondary me-2" onClick={handleAddQuestion}>
        Add Question
      </button>

      <button className="btn btn-primary" onClick={handleSubmit}>
        Save Template
      </button>
    </div>
  );
}

export default AdminDashboard;
