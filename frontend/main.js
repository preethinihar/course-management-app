import React, { useEffect, useState } from 'https://esm.sh/react';
import ReactDOM from 'https://esm.sh/react-dom/client';

function App(){
  const [courses,setCourses]=useState([]);
  const [title,setTitle]=useState('');
  const [instructor,setInstructor]=useState('');

  async function load(){
    const r=await fetch('http://localhost:8080/api/courses');
    setCourses(await r.json());
  }
  async function add(){
    await fetch('http://localhost:8080/api/courses',{method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify({title,instructor})});
    setTitle('');setInstructor('');load();
  }
  useEffect(()=>{load();},[]);
  return (<div>
    <h1>Courses</h1>
    <input placeholder="Title" value={title} onChange={e=>setTitle(e.target.value)} />
    <input placeholder="Instructor" value={instructor} onChange={e=>setInstructor(e.target.value)} />
    <button onClick={add}>Add</button>
    <ul>{courses.map(c=><li key={c.id}>{c.title} — {c.instructor}</li>)}</ul>
  </div>);
}

ReactDOM.createRoot(document.getElementById('app')).render(<App/>);
