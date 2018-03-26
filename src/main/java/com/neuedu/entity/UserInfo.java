package com.neuedu.entity;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class UserInfo {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;

}
