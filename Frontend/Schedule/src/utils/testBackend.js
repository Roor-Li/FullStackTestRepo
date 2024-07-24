const fakeData = [
  {
    date: "2024-07-01",
    todoList: ["070101", "070102", "1111111"]
  },
  {
    date: "2024-07-02",
    todoList: ["070201", "070202", "77777777"]
  },
  {
    date: "2024-07-04",
    todoList: ["070401", "070402"]
  },
  {
    date: "2024-07-05",
    todoList: ["070501", "070502", "666666"]
  },
  {
    date: "2024-07-07",
    todoList: ["070701", "070702", "75451654"]
  },
  {
    date: "2024-07-08",
    todoList: ["070801", "070802"]
  },
  {
    date: "2024-07-09",
    todoList: ["070901", "070902", "3333333"]
  }
]

export const getTodoList = (date) => {
  const formattedDate = date.toISOString().split('T')[0]; // 只取日期部分
  const data = fakeData.find(element => element.date === formattedDate)
  return data ? data.todoList : [];
}