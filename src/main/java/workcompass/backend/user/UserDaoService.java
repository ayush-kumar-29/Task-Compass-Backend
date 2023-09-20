package workcompass.backend.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoService {

    private static List<User> users;
    private static int userId;

    static{
        userId=1;
        users = new ArrayList<>();
        users.add(new User(getNewUserId(), "user1",
                null, null, null));
        users.add(new User(getNewUserId(), "user2",
                null, null, null));
        users.add(new User(getNewUserId(), "user3",
                null, null, null));
    }

    private static int getNewUserId(){
        return userId++;
    }

    public List<String> getAllUserNames(){
        List<String> userNames=new ArrayList<>();
        for(User user:users)
            userNames.add(user.getUserName());
        return userNames;
    }

    public int getUserIdFromName(String userName){
        return users.stream().filter(user -> user.getUserName().equals(userName))
                .findAny().get().getUserId();
    }

    public boolean validateUserName(String userName){
        for(User user:users){
            if(user.getUserName().equals(userName))
                return true;
        }
        return false;
    }
}
