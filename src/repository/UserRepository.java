package repository;

import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public boolean addUser(User user){
        if(getUserByEmail(user.getEmail()) != null) return false;
        users.add(user);
        return true;
    }

    public User getUserByEmail(String email){
        for(User u : users){
            if(u.getEmail().equalsIgnoreCase(email)) return u;
        }
        return null;
    }

    public List<User> getAllUsers(){ return users; }
}
