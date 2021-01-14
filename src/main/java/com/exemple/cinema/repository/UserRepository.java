package com.exemple.cinema.repository;

import com.exemple.cinema.entity.Order;
import com.exemple.cinema.entity.Ticket;
import com.exemple.cinema.entity.User;
import com.exemple.cinema.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList;

    public Long count;

    @PostConstruct
    private void initList() {
        userList = new ArrayList<>();
        count = 0L;
    }

    public List<User> getAll() {
        return userList;
    }

    public User save(User user) {
        ++count;
        user.setId(count);
        userList.add(user);

        return user;
    }

    public User getById(Long id) {
        User user = userList.stream()
                .filter((e -> e.getId().equals(id)))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "User not found", null));

        return user;
    }

    public User update(User user) {
        final User oldTicket = getById(user.getId());
        if (oldTicket==null){
            throw new ServiceException(400,"User not found", null);
        }
        userList.remove(oldTicket);
        userList.add(user);

        return user;
    }

    public  List<User> delete(final Long id){
        User user = getById(id);
        if(user==null){
            throw new ServiceException(400, "User not found", null);
        }
        userList.remove(user);
        return userList;
    }
}
