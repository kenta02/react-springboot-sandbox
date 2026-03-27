import axios from 'axios'

type Todo = {
  id: number
  title: string
  done: boolean
}

const baseUrl = '/api/todos'

export const getTodos = () => axios.get<Todo[]>(baseUrl).then((res) => res.data)
export const createTodo = (title: string) =>
  axios.post<Todo>(baseUrl, { title }).then((res) => res.data)
export const updateTodo = (id: number, title: string) =>
  axios.put<Todo>(`${baseUrl}/${id}`, { title }).then((res) => res.data)
export const deleteTodo = (id: number) => axios.delete<void>(`${baseUrl}/${id}`)
