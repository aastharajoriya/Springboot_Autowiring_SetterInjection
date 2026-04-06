package com.aastha.service;


import com.aastha.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private  PwdService pwdService;

    private UserDao userDao;


    @Autowired
    public void setPwdService(PwdService pwdService) {
        this.pwdService = pwdService;
    }
@Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
@Autowired
    public void setEmailService(emailService emailService) {
        this.emailService = emailService;
    }

    private  emailService emailService;

    public void registerUser(String name, String email, String pwd){
        //encrypt pwd
        String encyptPwd=pwdService.encryptPwd(pwd);

        // save user in db
       boolean isSaved= userDao.saveUser(name,email,encyptPwd);

        // , send email
        if (isSaved){
          boolean isSent=  emailService.sendEmail(email,"Test Subject","Test body");
       if (isSent){
           System.out.println("User registration completed...");
       }

        }
    }
}
