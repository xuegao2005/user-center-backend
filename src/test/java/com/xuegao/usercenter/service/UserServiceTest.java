package com.xuegao.usercenter.service;
import java.util.Date;

import com.xuegao.usercenter.model.domain.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void testAddUser() {

        User user = new User();
        user.setUsername("1234");
        user.setUserAccount("xuegao");
        user.setUserPassword("123456789");
        user.setAvatarUrl("123456");
        user.setGender(0);
        user.setPhone("123456789");
        user.setEmail("123456@qq.com");

        boolean result = userService.save(user);

        System.out.println(user.getId());
        // 断言
        Assertions.assertTrue(result);

    }

    @Test
    void userRegister() {

        // 1. 密码为空
        String userAccount = "xuegao1";
        String userPassword = "";
        String checkPassword = "123456";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        // 断言
        Assertions.assertEquals(-1, result);

        // 2. 账户<4 - 错误
        userAccount = "xue";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 3. 密码<8或校验码<8 - 错误
        userAccount = "xuegao1";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 4. 账户有特殊字符 - 错误
        userAccount = "xue gao";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 5. 密码和校验码不同 - 错误
        userAccount = "xuegao1";
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 6. 账户重复 - 错误
        userAccount = "xuegao";
        userPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 7. 成功
        userAccount = "xueegaoo";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
    }
}