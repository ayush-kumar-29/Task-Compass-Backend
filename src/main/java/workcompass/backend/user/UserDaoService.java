package workcompass.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoService {

    @Autowired
    private UserRepository userRepository;

//    private static List<User> users;
//    private static int userId;

//    static{
//        userId=1;
//        users = new ArrayList<>();
////        users.add(new User(getNewUserId(), "user1",
////                null, null));
////        users.add(new User(getNewUserId(), "user2",
////                null, null));
////        users.add(new User(getNewUserId(), "user3",
////                null, null));
//    }

//    private static int getNewUserId(){
//        return userId++;
//    }

    public List<String> getAllUserNames(){
        return userRepository.findDistinctUserName();
//        List<String> userNames=new ArrayList<>();
//        for(User user:users)
//            userNames.add(user.getUserName());
//        return userNames;
    }

    public String getUserIdFromName(String userName){
        return userRepository.findUserIdByUserName(userName);
    }

    public boolean validateUserName(String userName){
        User user = userRepository.findByUserName(userName);
        return user!=null;
//        for(User user:users){
//            if(user.getUserName().equals(userName))
//                return true;
//        }
//        return false;
    }

    public void addNewUser(User newUser){
        userRepository.save(newUser);
    }

    public String getUniqueUserId(){
        return "U-"+(userRepository.getRowCount()+1);
    }

    public User createNewUser(String userName, String password, String email){
        return new User(getUniqueUserId(), userName, email, password);
    }
}
