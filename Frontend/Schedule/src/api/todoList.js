import request from '@/utils/request'

// 根据日期获取todolist
export const getTodoList = async (date) => {
  return request.get('/todo/' + date)
  .then(result => {
    if (result.data) {
      return JSON.parse(result.data.todoList)
    } else return []
  })
  .catch(err => {
    console.log(err);
    return []
  })
}

//根据日期更新todolist
export const updateTodoList = async (date, todoList) => {
  return request.post('/update', {
    // 这里是请求参数
    date: date,
    todoList: JSON.stringify(todoList)
  })
  .then(result => {
    console.log(result);
  })
  .catch(err => {
    console.log(err);
  })
}