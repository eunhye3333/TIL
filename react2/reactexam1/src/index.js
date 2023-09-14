import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";

// import MyFooter from "./MyFooter";

const root = ReactDOM.createRoot(document.getElementById("root")); // App 함수가 리턴하는 값(<App />)을 ID가 root인 요소 아래로 넣겠다
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
