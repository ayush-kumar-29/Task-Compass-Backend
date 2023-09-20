package workcompass.backend.todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
✔ Show todos
✔ Adding a new todo
✔ Show open todos
✔ Show completed todos
✔ Delete a todo
Mark todo as done
Edit a todo
*/

@RestController
public class TodoController {
    @Autowired
    private TodoDaoService todoDaoService;

    TodoController(TodoDaoService todoDaoService){
        this.todoDaoService=todoDaoService;
    }

    @GetMapping(value = "/ping")
    public String ping(){
        return "API is working fine!";
    }

    @GetMapping(value = "/todos")
    public List<Todo> getTodosList(@RequestParam String userName, @RequestParam boolean open,
                                   @RequestParam boolean completed){
        return todoDaoService.getTodosForFilter(userName, open, completed);
    }

    @GetMapping(value = "/todos/{todoId}")
    public Todo getTodo(@RequestParam String userName, @PathVariable int todoId){
        return todoDaoService.getTodoForId(userName, todoId);
    }

    @GetMapping(value = "/todos/countByType")
    public long countTodos(@RequestParam String userName, @RequestParam String status){
        return todoDaoService.countTodos(userName, status.equals("COMPLETED"));
    }

    @PostMapping(value = "/todos/addTodo")
    public void addTodo(@RequestParam String userName, @RequestBody Todo newTodo){
        System.out.println(newTodo);
        todoDaoService.addTodo(newTodo, userName);
    }

    @DeleteMapping(value = "todos/deleteTodo/{todoId}")
    public void deleteTodo(@RequestParam String userName, @PathVariable int todoId){
        todoDaoService.deleteTodo(userName, todoId);
    }

    @PatchMapping(value = "todos/updateTodo/{todoId}")
    public void updateTodo(@RequestParam String userName, @RequestParam String updateType,
                                 @PathVariable int todoId, @RequestBody Todo todoPatch){
        if(updateType.equals("status"))
            todoDaoService.updateTodo(userName, todoId);
        else if(updateType.equals("content"))
            todoDaoService.updateTodo(userName, todoId, todoPatch);
    }
//
//    @PatchMapping(value = "/{userId}/updateTodoContent")
//    public void updateTodoContent(@PathVariable String userId, @RequestBody Todo todoPatch){
//        todoDaoService.updateTodoContent(todoPatch);
//    }

}
