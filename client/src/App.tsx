import { useEffect, useState } from "react";
import {
  getTodos,
  createTodo,
  updateTodo,
  deleteTodo,
  Todo,
} from "./api/todos";
import "./App.css";

function App() {
  const [todos, setTodos] = useState<Todo[]>([]);
  const [title, setTitle] = useState("");
  const [error, setError] = useState<string | null>(null);

  const load = async () => {
    try {
      const result = await getTodos();
      if (!Array.isArray(result)) {
        console.warn("getTodos returned non-array", result);
        setTodos([]);
        setError("Unexpected API response format");
        return;
      }
      setTodos(result);
      setError(null);
    } catch {
      setTodos([]);
      setError("Failed to load todos");
    }
  };

  useEffect(() => {
    load();
  }, []);

  // フォーム送信: 新規Todoを追加
  const onSubmit: React.FormEventHandler<HTMLFormElement> = async (e) => {
    e.preventDefault();
    if (!title.trim()) return; // 空文字は無視
    try {
      await createTodo(title);
      setTitle("");
      load(); // 一覧再取得
      setError(null);
    } catch {
      setError("Create failed");
    }
  };

  // Todo完了状態をトグル（今回セットではなくAPI想定）
  const onToggle = async (todo: Todo) => {
    try {
      await updateTodo(todo.id, todo.title);
      load();
      setError(null);
    } catch {
      setError("Update failed");
    }
  };

  // Todo削除
  const onDelete = async (id: number) => {
    try {
      await deleteTodo(id);
      load();
      setError(null);
    } catch {
      setError("Delete failed");
    }
  };

  return (
    <div className="container">
      <h1>Todo List</h1>
      {error && <p style={{ color: "red" }}>{error}</p>}
      <form onSubmit={onSubmit}>
        <input
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          placeholder="New todo"
        />
        <button type="submit">Add</button>
      </form>
      <ul>
        {(Array.isArray(todos) ? todos : []).map((todo) => (
          <li key={todo.id}>
            <span>{todo.title}</span>
            <button onClick={() => onToggle(todo)}>
              {todo.done ? "Undo" : "Done"}
            </button>
            <button onClick={() => onDelete(todo.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
