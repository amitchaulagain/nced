package com.cms.api;

import com.cms.dto.EmailDTO;
import com.cms.dto.UserDTO;
import com.cms.model.*;
import com.cms.repository.IRoleDAO;
import com.cms.repository.IUserDAO;
import com.cms.repository.IUserInfoDAO;
import com.cms.service.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by amit on 6/16/16.
 */

@Service

public class UserApi implements IUserApi {

    @Autowired
    IUserDAO userDao;
    @Autowired
    IRoleDAO roleDao;
    @Autowired
    IUserInfoDAO userInfoDao;
    @Autowired
    PasswordEncoder encoder;


    @Override
    public User createOrEditAppUser(UserDTO dto) {
        if (dto.getId() != 0) {
            return editUser(dto);
        } else {
            return createUser(dto);
        }


    }

    private User editUser(UserDTO dto) {
      /*  try {
            mailService.sendMail(new EmailDTO());
        } catch (MessagingException e) {
            e.printStackTrace();
        }*/
        User user = userDao.findOne(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(getEncodedPassword(dto.getPassword()));
        user.getUserInfo().setFirstName(dto.getFirstName());
        user.getUserInfo().setLastName(dto.getLastName());
        user.getUserInfo().setMiddleName(dto.getMiddleName() + "");
        user.getUserInfo().setLandlineNumber(dto.getLandlineNumber());
        user.getUserInfo().setMobileNumber(dto.getMobileNumber());
        user.getUserInfo().setStreetAddress(dto.getStreetAddress());
        user.getUserInfo().setVdc(dto.getVdcOrMunicipality());
        user.getUserInfo().setZone(dto.getZone());
        user.getUserInfo().setDistrict(dto.getDistrict());
        user.getUserInfo().setCountry(dto.getCountry());
        user.getUserInfo().setMale(dto.isMale());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");


//        Date date = null;
//        try {
//            date = formatter.parse(dto.getDob());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


        user.getUserInfo().setDob(dto.getDob());
        user.getUserInfo().setUser(user);
        userInfoDao.save(user.getUserInfo());
        userDao.save(user);
        Set<String> roleSet = new HashSet<String>();
        ;
        Set<String> databaseRoleSet = new HashSet<String>();
        ;
        Set<String> allRoleSet = new HashSet<String>();
        ;


        for (Role hh : userDao.findOne(dto.getId()).getRoles()) {
            databaseRoleSet.add(hh.getRole());
            allRoleSet.add(hh.getRole());
        }

        for (String rr : dto.getRoless()) {
            roleSet.add(rr);
            allRoleSet.add(rr);
        }
        for (String role : allRoleSet) {
            if (role != null) {

                if (!databaseRoleSet.contains(role)) {
                    Role ttt = new Role(role);
                    ttt.setUser(userDao.findOne(dto.getId()));

                    roleDao.save(ttt);
                }

                if (!roleSet.contains(role)) {
                    Role rr = roleDao.findRoleByUserIdAndValue(role, dto.getId());

                    roleDao.delete(rr.getId());
                }
            }

        }


        return user;
    }
    @Autowired
    MailServiceImpl mailService;
    private User createUser(UserDTO dto) {


        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(getEncodedPassword(dto.getPassword()));
        user.setStatus(Status.APPROVED);
        UserInfo userInfo= new UserInfo();
        userInfo.setFirstName(dto.getFirstName());
        userInfo.setLastName(dto.getLastName());
        userInfo.setMiddleName(dto.getMiddleName() + "");
        userInfo.setLandlineNumber(dto.getLandlineNumber());
        userInfo.setMobileNumber(dto.getMobileNumber());
        userInfo.setStreetAddress(dto.getStreetAddress());
        userInfo.setVdc(dto.getVdcOrMunicipality());
        userInfo.setZone(dto.getZone());
        userInfo.setDistrict(dto.getDistrict());
        userInfo.setCountry(dto.getCountry());
        userInfo.setMale(dto.isMale());
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");


//        Date date = null;
//        try {
//            date =(Date) formatter.parse(dto.getDob());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(date);
//        System.out.println(formatter.format(date));

        userInfo.setDob(dto.getDob());
        user.setUserInfo(userInfo);


        //user.setRoles(roles);
        User x = userDao.save(user);
        user.getUserInfo().setUser(x);
        userInfoDao.save(user.getUserInfo());
        Set<Role> roles = new HashSet<Role>();
        for (String role : dto.getRoless()) {
            if (role != null) {
                Role r = new Role(role);

                r.setUser(x);
                roles.add(r);
            }
        }
        roleDao.save(roles);

        return x;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public String deleteUser(Integer userId) {
//        UserInfo ui = userInfoDao.getUserInfoByUserId(userId);
//        userInfoDao.delete(ui.getId());
//        List<Role> roless = roleDao.findRolesByUserId(userId);
//        roleDao.delete(roless);
        userDao.delete(userId);

        return "User with ID :" + userId + "  deleted";
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.findOne(id);
    }

    public String getEncodedPassword(String password) {
        return encoder.encode(password);
    }
}
