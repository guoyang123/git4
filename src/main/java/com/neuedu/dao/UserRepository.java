package com.neuedu.dao;

import com.neuedu.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<UserInfo,Integer> {
     List<UserInfo>  findByUsername(String username);


}
