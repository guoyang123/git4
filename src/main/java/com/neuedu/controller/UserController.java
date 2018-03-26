package com.neuedu.controller;
import com.neuedu.config.Boot02Properties;
import com.neuedu.dao.UserRepository;
import com.neuedu.entity.UserInfo;
import com.neuedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Value("${projecturl}")
  private String  projecturl;


      @Autowired
      Boot02Properties boot02Properties;

      @Autowired
      UserRepository repository;

      /**
       * 查询所有用户
       * */
      @GetMapping(value ={"/find","/hello"} )
     public   List<UserInfo>   find(){

         List<UserInfo> infos= repository.findAll();
       return  infos;
     }
  /**
   * 添加用户
   * */
  @RequestMapping(value = "/add/{username}",method = RequestMethod.POST)
   public  UserInfo add(@PathVariable("username") String name){
      UserInfo info=new UserInfo();
      info.setUsername(name);
      return repository.save(info);
   }

/***
 * 查询某位用户
 *
 * */
@RequestMapping(value = "/find/{userid}",method = RequestMethod.GET)
  public Optional<UserInfo> findOne(@PathVariable("userid") Integer userid){

     return repository.findById(userid);
  }

   /**
    * 按照用户名查询
    *
    * */
   @RequestMapping(value = "/finduser/{username}")
   public List<UserInfo> findByUsername(@PathVariable("username") String username){
        return  repository.findByUsername(username);
   }

   /**
    * 修改用户
    * */
 @RequestMapping(value = "/updateuser/{userid}/{username}")
   public UserInfo updateUser(@PathVariable("userid") Integer userid,@PathVariable("username") String username){
      UserInfo info=new UserInfo();
      info.setId(userid);
      info.setUsername(username);
      return repository.save(info);
   }
 /**
  * 删除用户
  * */

 @RequestMapping(value = "/delete/{userid}")
 public void  delete(@PathVariable("userid") Integer userid){

     repository.deleteById(userid);
 }

 @Autowired
 UserService userService;
 /**
  * 测试事物
  * */
  @RequestMapping(value = "/trans")
  public  void  testTransactional(){
    userService.add();
  }
     @RequestMapping(value = "/findUser",method = RequestMethod.GET)
     public  String  getUser(@RequestParam("username") String username,@RequestParam("password") String password ){

          return username+"  "+password;
     }
     //rest风格  restful
   @RequestMapping(value ="/{id}/update/{username}")
    public   String  update(@PathVariable("id") String userid,@PathVariable("username") String name){

          return userid+" "+name;
    }







}
