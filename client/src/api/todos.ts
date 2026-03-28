export type Todo = {
  id: number;
  title: string;
  done: boolean;
};

const baseUrl = "/api/todos";

const checkStatus = async (response: Response) => {
  if (!response.ok) {
    const body = await response.text();
    throw new Error(`HTTP ${response.status}: ${body}`);
  }
  return response;
};

// Todo一覧取得
export const getTodos = async (): Promise<Todo[]> => {
  const response = await fetch(baseUrl);
  await checkStatus(response);
  return response.json();
};

// Todo新規作成
export const createTodo = async (title: string): Promise<Todo> => {
  const response = await fetch(baseUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title }),
  });
  await checkStatus(response);
  return response.json();
};

// Todo更新
export const updateTodo = async (id: number, title: string): Promise<Todo> => {
  const response = await fetch(`${baseUrl}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title }),
  });
  await checkStatus(response);
  return response.json();
};

// Todo削除
export const deleteTodo = async (id: number): Promise<void> => {
  const response = await fetch(`${baseUrl}/${id}`, { method: "DELETE" });
  await checkStatus(response);
};
