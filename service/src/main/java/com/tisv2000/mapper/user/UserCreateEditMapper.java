package com.tisv2000.mapper.user;

import com.tisv2000.database.entity.User;
import com.tisv2000.dto.user.UserCreateEditDto;
import com.tisv2000.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {

    @Override
    public User map(UserCreateEditDto fromObject, User toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    @Override
    public User map(UserCreateEditDto object) {
        var user = new User();
        copy(object, user);
        return user;
    }

    private void copy(UserCreateEditDto user, User entity) {
        entity.setRole(user.getRole());
        entity.setGender(user.getGender());
        entity.setBirthdate(user.getBirthdate());
        entity.setName(user.getUsername());


        entity.setPassword(user.getRawPassword());
        entity.setEmail(user.getEmail());
    }
}
