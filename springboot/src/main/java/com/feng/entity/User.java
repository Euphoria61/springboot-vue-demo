package com.feng.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName("user")
public class User extends Model<User> {
    @TableId(type = IdType.AUTO)
    //ID
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //昵称
    private String nickName;
    //年龄
    private Integer age;
    //性别
    private String sex;
    //地址
    private String address;


}

