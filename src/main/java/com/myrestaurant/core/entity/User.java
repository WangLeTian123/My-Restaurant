package com.myrestaurant.core.entity;


import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Data:   lombok插件
 *          1、@Data可以为类提供读写功能，从而不用写get、set方法。
 * 		    2、他还会为类提供 equals()、hashCode()、toString() 方法。
 * @ToString: lombok插件
 *          1、作用于类，覆盖默认的 toString() 方法，
 *                  输出格式：ClassName(fieldName=fieleValue, fieldName1=fieleValue)
 * @NoArgsConstructor:  lombok插件
 *          1、在类上使用，这个注解可以生成无参构造方法
 * @TableName("user"):
 *          1、在类上使用 用来将指定的数据库表和 JavaBean 进行映射
 *
 *      User实现UserDetails的作用是为了在Spring Security中使用该实体类作为用户信息的载体。通过实现UserDetails接口，User类
 *  可以提供用户的基本信息，如用户名、密码、权限等，供Spring Security进行认证和授权。在Spring Security中，我们可以通过实现
 *  UserDetailsService接口来自定义用户信息的获取方式，比如从数据库中获取用户信息。同时，我们还可以通过实现PasswordEncoder接口
 *  来自定义密码加密方式，以提高系统的安全性。在User类中，我们可以通过重写UserDetails接口中的方法来自定义用户的认证和授权逻辑
 */

@Data
@ToString
@TableName("user")
@NoArgsConstructor
public class User implements UserDetails {
    /**
     * 主键字段id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 密码
     */
    @JSONField(serialize = false)
    private String password;

    /**
     * 默认电话
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 验证码
     */
    private String code;

    /**
     * 店名
     */
    private String shopName;


    /**
     * 类型 0=管理员 1=厨师 2=服务员
     * EmployeeType
     */
    private Integer type;

    /**
     * 权限
     */
    @TableField(exist = false)
    private List<GrantedAuthority> authorities;


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
