package workcompass.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDaoService userDaoService;

    @GetMapping(value = "/listUsers")
    public List<String> getUserList(){
        return userDaoService.getAllUserNames();
    }

    @GetMapping(value = "/validateUser")
    public boolean isValidUser(@RequestParam String userName){
        return userDaoService.validateUserName(userName);
    }
}
