package com.example.cachewithredis.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@RedisHash("user")
public class User {

    private String id;
    private Gender gender;
    private String firstName;
    private String lastName;
    private String NationalCode;

    @CreatedDate // TODO: createdAt & updatedAt are not working
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;

    @LastModifiedDate // TODO: createdAt & updatedAt are not working
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updatedAt;

    public enum Gender {
        MALE, FEMALE
    }
}
