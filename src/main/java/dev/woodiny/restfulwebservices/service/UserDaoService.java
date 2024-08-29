package dev.woodiny.restfulwebservices.service;

import dev.woodiny.restfulwebservices.model.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDaoService {
    private static Long usersCount = 3L;
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1L,"Henry", LocalDate.now().minusYears(18)));
        users.add(new User(2L,"Jane",LocalDate.now().minusYears(54)));
        users.add(new User(3L,"Tom",LocalDate.now().minusYears(26)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findOne(Long id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }
}
