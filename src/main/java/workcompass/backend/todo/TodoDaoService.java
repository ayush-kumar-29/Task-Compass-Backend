package workcompass.backend.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import workcompass.backend.user.UserDaoService;
import workcompass.backend.user.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoDaoService {

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private TodoRepository todoRepository;

//    @Autowired
//    private UserRepository userRepository;
//    private static List<Todo> todos=new ArrayList<>();
//    private static int todoCount=1001;

//    static{
//        todos.add(new Todo(getCount(), 1, "Dummy Description-1",
//                LocalDate.now().plusDays(1),false, null));
//        todos.add(new Todo(getCount(), 1, "Dummy Description-2",
//                LocalDate.now().plusDays(2),false, null));
//        todos.add(new Todo(getCount(), 2, "Dummy Description-3",
//                LocalDate.now().plusDays(3),false, null));
//    }

//    public static int getCount(){
//        return todoCount++;
//    }

    public List<Todo> getTodosForFilter(String userName, boolean openFilter,
                                        boolean completedFilter){
        long userId = userDaoService.getUserIdFromName(userName);
        List<Todo> filteredTodoList = new ArrayList<>();
        if(openFilter)
            filteredTodoList.addAll(todoRepository.findByUserIdAndIsDoneAndIsDeleted(userId, false, false));
//            filteredTodoList.addAll(todos.stream().filter(todo->todo.getUserId()==userId && !todo.getIsDone()).toList());
        if(completedFilter)
            filteredTodoList.addAll(todoRepository.findByUserIdAndIsDoneAndIsDeleted(userId, true, false));
//            filteredTodoList.addAll(todos.stream().filter(todo->todo.getUserId()==userId && todo.getIsDone()).toList());
        return filteredTodoList;
    }

    public Todo getTodoForId(String userName, String todoId){
        long userId = userDaoService.getUserIdFromName(userName);
        return todoRepository.findByUserIdAndTodoId(userId, todoId);
//        todos.stream().filter(todo -> todo.getUserId()==userId && todo.getTodoId()==todoId)
//                .findAny().get();
    }

    public void addTodo(Todo newTodo, String userName){
        long userId = userDaoService.getUserIdFromName(userName);
        newTodo.setUserId(userId);
        newTodo.setTodoId(getUniqueTodoId());
        newTodo.setIsDone(false);
        newTodo.setIsDeleted(false);
//        todos.add(newTodo);
        todoRepository.save(newTodo);
    }

    public void addTodo(Todo newTodo){
        todoRepository.save(newTodo);
    }

    public void deleteTodo(String userName, String todoId){
        long userId = userDaoService.getUserIdFromName(userName);
        Todo todoToDelete = todoRepository.findByUserIdAndTodoId(userId, todoId);
        todoToDelete.setIsDeleted(true);
        todoRepository.save(todoToDelete);
//        todoRepository.deleteById(todoToDelete.getId());
//        todos.removeIf(todo->(todo.getUserId()==userId && todo.getTodoId()==todoId));
    }

    @Transactional
    public void deleteTodo(long userId, String todoId){
        Todo todoToDelete = todoRepository.findByUserIdAndTodoId(userId, todoId);
        todoToDelete.setIsDeleted(true);
        todoRepository.save(todoToDelete);
//        todoRepository.deleteById(todoToDelete.getId());
//        todos.removeIf(todo->(todo.getUserId()==userId && todo.getTodoId()==todoId));
    }

    public void updateTodo(String userName, String todoId, Todo todoPatch){
        long userId = userDaoService.getUserIdFromName(userName);
//        Todo todoToUpdate = todos.stream().filter(todo -> (todo.getTodoId()==todoId &&todo.getUserId()==userId))
//                .findAny().get();
        Todo todoToUpdate = todoRepository.findByUserIdAndTodoId(userId, todoId);
        todoToUpdate.setTodoDescription(todoPatch.getTodoDescription());
        todoToUpdate.setDueDate(todoPatch.getDueDate());
        addTodo(todoToUpdate);
    }

    public void updateTodo(String userName, String todoId){
        long userId = userDaoService.getUserIdFromName(userName);
//        Todo todoToUpdate = todos.stream().filter(
//                        todo -> (todo.getTodoId().equals(todoId) &&
//                                todo.getUserId()==userId)
//                )
//                .findAny().get();
        Todo todoToUpdate = todoRepository.findByUserIdAndTodoId(userId, todoId);
        todoToUpdate.setIsDone(!todoToUpdate.getIsDone());
        if(todoToUpdate.getCompletionDate()==null)
            todoToUpdate.setCompletionDate(LocalDate.now());
        else
            todoToUpdate.setCompletionDate(null);
        addTodo(todoToUpdate);
    }

    public long countTodos(String userName, boolean statusFlag){
        long userId = userDaoService.getUserIdFromName(userName);
        return todoRepository.countByUserIdAndIsDoneAndIsDeleted(userId, statusFlag, false);
//        return todos.stream()
//                .filter(
//                        todo -> todo.getUserId()==userDaoService.getUserIdFromName(userName) &&
//                                todo.getIsDone() == statusFlag
//                ).count();
    }

    public String getUniqueTodoId(){
        return "T-"+(todoRepository.getRowCount()+1);
    }
}
