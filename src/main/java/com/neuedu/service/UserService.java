package com.neuedu.service;

import com.neuedu.dao.UserRepository;
import com.neuedu.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    @Autowired
    UserRepository repository;
  @Transactional
    public  void  add(){
        UserInfo user=new UserInfo();
        user.setUsername("zhangsan11111111");
        UserInfo user2=new UserInfo();
        user2.setUsername("zhangsan22222222");
        try{
            repository.save(user);
            int a= 2/0;
            repository.save(user2);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
    }

}
