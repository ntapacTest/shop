package com.example.shop.pojo;

import com.example.shop.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class UserResponce {
    @JsonProperty("users")
    public List<UserDetailPojo> users;

    @JsonIgnore
    @Autowired
    UserDetailPojo userDetailPojo;

    public UserResponce() {
        this.users = new LinkedList<>();
    }

    public void addUser(User users) {
        userDetailPojo = new UserDetailPojo();
        userDetailPojo.setId(users.getId());
        userDetailPojo.setFirstName(users.getFirstName());
        userDetailPojo.setLastName(users.getLastName());
        userDetailPojo.setEmail(users.getEmail());
        this.users.add(userDetailPojo);
    }

    public UserResponce(List<User> userList) {
        this.users = userList
                .stream()
                .map(o -> {
                    userDetailPojo = new UserDetailPojo();
                    userDetailPojo.setId(o.getId());
                    userDetailPojo.setFirstName(o.getFirstName());
                    userDetailPojo.setLastName(o.getLastName());
                    userDetailPojo.setEmail(o.getEmail());
                    return userDetailPojo;
                })
                .collect(Collectors.toList());
    }
}

