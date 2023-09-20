package workcompass.backend.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workcompass.backend.user.UserDaoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoDaoService {

    @Autowired
    private UserDaoService userDaoService;
    private static List<Todo> todos=new ArrayList<>();
    private static int todoCount=1001;

    static{
        todos.add(new Todo(getCount(), 1, "Dummy Description-1",
                LocalDate.now().plusDays(1),false, null));
        todos.add(new Todo(getCount(), 1, "Dummy Description-2",
                LocalDate.now().plusDays(2),false, null));
        todos.add(new Todo(getCount(), 2, "Dummy Description-3",
                LocalDate.now().plusDays(3),false, null));
    }

    public static int getCount(){
        return todoCount++;
    }

    public List<Todo> getTodosForFilter(String userName, boolean openFilter, boolean completedFilter){
        int userId = userDaoService.getUserIdFromName(userName);
        List<Todo> filteredTodoList = new ArrayList<>();
        if(openFilter)
            filteredTodoList.addAll(todos.stream().filter(todo->todo.getUserId()==userId && !todo.getIsDone()).toList());
        if(completedFilter)
            filteredTodoList.addAll(todos.stream().filter(todo->todo.getUserId()==userId && todo.getIsDone()).toList());
        return filteredTodoList;
    }

    public Todo getTodoForId(String userName, int todoId){
        int userId = userDaoService.getUserIdFromName(userName);
        return todos.stream().filter(todo -> todo.getUserId()==userId && todo.getTodoId()==todoId)
                .findAny().get();
    }

    public void addTodo(Todo newTodo, String userName){
        int userId = userDaoService.getUserIdFromName(userName);
        newTodo.setUserId(userId);
        newTodo.setTodoId(getCount());
        newTodo.setIsDone(false);
        todos.add(newTodo);
    }

    public void addTodo(Todo newTodo){
        todos.add(newTodo);
    }

    public void deleteTodo(String userName, int todoId){
        int userId = userDaoService.getUserIdFromName(userName);
        todos.removeIf(todo->(todo.getUserId()==userId && todo.getTodoId()==todoId));
    }

    public void deleteTodo(int userId, int todoId){
        todos.removeIf(todo->(todo.getUserId()==userId && todo.getTodoId()==todoId));
    }

    public void updateTodo(String userName, int todoId, Todo todoPatch){
        int userId = userDaoService.getUserIdFromName(userName);
        Todo todoToUpdate = todos.stream().filter(todo -> (todo.getTodoId()==todoId &&todo.getUserId()==userId))
                .findAny().get();
        deleteTodo(userName, todoToUpdate.getTodoId());
        todoToUpdate.setTodoDescription(todoPatch.getTodoDescription());
        todoToUpdate.setDueDate(todoPatch.getDueDate());
        addTodo(todoToUpdate);
    }

    public void updateTodo(String userName, int todoId){
        int userId = userDaoService.getUserIdFromName(userName);
        Todo todoToUpdate = todos.stream().filter(
                        todo -> (todo.getTodoId().equals(todoId) &&
                                todo.getUserId()==userId)
                )
                .findAny().get();
        deleteTodo(userId, todoId);
        todoToUpdate.setIsDone(!todoToUpdate.getIsDone());
        addTodo(todoToUpdate);
    }

    public long countTodos(String userName, boolean statusFlag){
        return todos.stream()
                .filter(
                        todo -> todo.getUserId()==userDaoService.getUserIdFromName(userName) &&
                                todo.getIsDone() == statusFlag
                ).count();
    }
}
