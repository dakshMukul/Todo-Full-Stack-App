package com.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.antlr.v4.runtime.atn.SemanticContext.Predicate;
import org.aspectj.apache.bcel.classfile.Module.Uses;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    static int userCount = 0;
    static {
        users.add(new User(++userCount, "Mukul Singh", LocalDate.now().minusYears(24)));
        users.add(new User(++userCount, "Shyam Singh", LocalDate.now().minusYears(23)));
        users.add(new User(++userCount, "Prashant Singh", LocalDate.now().minusYears(22)));
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User findById(int id) {
        java.util.function.Predicate<? super User> userPredicate = user -> user.getId() == id;
        return users.stream().filter(userPredicate).findFirst().orElse(null);
    }
       

    public User saveUser(User user ){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void DeleteUserById(int id){
        users.removeIf(user -> user.getId() == id);
    }
}
