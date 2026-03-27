import axios from "axios";

export type Todo = {
  id: number;
  title: string;
  done: boolean;
};

const baseUrl = "/api/todos";

// Todo一覧取得
export const getTodos = () =>
  axios.get<Todo[]>(baseUrl).then((res) => res.data);

// Todo新規作成
export const createTodo = (title: string) =>
  axios.post<Todo>(baseUrl, { title }).then((res) => res.data);

// Todo更新
export const updateTodo = (id: number, title: string) =>
  axios.put<Todo>(`${baseUrl}/${id}`, { title }).then((res) => res.data);

// Todo削除
export const deleteTodo = (id: number) =>
  axios.delete<void>(`${baseUrl}/${id}`);
