package com.example.express.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.express.domain.ResponseResult;
import com.example.express.domain.bean.SysUser;
import com.example.express.domain.enums.SexEnum;
import com.example.express.domain.enums.ThirdLoginTypeEnum;
import com.example.express.domain.vo.BootstrapTableVO;
import com.example.express.domain.vo.admin.AdminUserInfoVO;
import com.example.express.domain.vo.user.UserInfoVO;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface SysUserService extends IService<SysUser> {
    /**
     * 根据用户名查找用户
     */
    SysUser getByName(String username);
    /**
     * 根据手机号查找用户
     */
    SysUser getByTel(String tel);
    /**
     * 根据三方登陆查找用户
     */
    SysUser getByThirdLogin(String thirdLoginId, ThirdLoginTypeEnum thirdLoginTypeEnum);
    /**
     * 获取用户信息
     */
    UserInfoVO getUserInfo(String userId);
    /**
     * 根据用户名判断用户是否存在
     */
    boolean checkExistByUsername(String username);
    /**
     * 根据手机号判断用户是否存在
     */
    boolean checkExistByTel(String mobile);
    /**
     * 根据身份证号判断用户是否存在
     */
    boolean checkExistByIdCard(String idCard);
    /**
     * 是否实名认证
     */
    boolean checkApplyRealName(SysUser user);
    /**
     * 能否切换角色
     */
    boolean canChangeRole(SysUser user);
    /**
     * 校验密码
     */
    boolean checkPassword(String userId, String password);
    /**
     * 三方登陆逻辑
     */
    ResponseResult thirdLogin(String thirdLoginId, ThirdLoginTypeEnum thirdLoginTypeEnum);
    /**
     * 根据用户名注册
     * @author jitwxs
     * @date 2019/4/22 0:39
     */
    ResponseResult registryByUsername(String username, String password);
    /**
     * 根据手机号注册
     * @author jitwxs
     * @date 2019/4/22 0:39
     */
    ResponseResult registryByTel(String tel, String code, HttpSession session);
    /**
     * 人脸注册
     * @author jitwxs
     * @date 2019/5/3 0:34
     * @param gender male:男性 female:女性
     */
    ResponseResult registryByFace(String faceToken, String gender);
    /**
     * 修改密码
     */
    ResponseResult resetPassword(String userId, String oldPassword, String newPassword);
    /**
     * 设置用户名密码
     */
    ResponseResult setUsernameAndPassword(SysUser user, String username, String password);
    /**
     * 设置实名信息
     */
    ResponseResult setRealName(SysUser user, String realName, String idCard);
    /**
     * 设置/修改手机号码
     */
    ResponseResult setTel(SysUser user, String tel, String code, HttpSession session);
    /**
     * 设置/修改性别
     */
    ResponseResult setSex(SysUser sysUser, SexEnum sexEnum);
    /**
     * 设置/修改高校信息
     * @param schoolId 学校ID
     * @param studentIdCard 学号
     */
    ResponseResult setSchoolInfo(SysUser user, Integer schoolId, String studentIdCard);
    /**
     * 切换角色
     * user -> courier
     */
    ResponseResult changeRole(String userId);
    /**
     * 获取 frontName
     */
    String getFrontName(String userId);
    /**
     * 获取 frontName
     */
    String getFrontName(SysUser user);
    /**
     * 获取 AdminUserInfoVO 列表
     */
    BootstrapTableVO<AdminUserInfoVO> pageAdminUserInfoVO(Page<SysUser> sysUserPage, QueryWrapper<SysUser> wrapper);
    /**
     * 绑定或更新人脸数据
     */
    ResponseResult bindOrUpdateFace(String faceToken, String userId);
    /**
     * 管理员仪表盘展示数据
     */
    Map<String, Integer> getAdminDashboardData();

    String encode(String password);
}
