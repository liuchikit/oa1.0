package com.zhumian.realm;

import com.zhumian.entity.sys.User;
import com.zhumian.service.sys.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author zhumian
 * @Description
 * @date 2017/12/10 10:10
 */
public class LoginRealm extends AuthorizingRealm {

    private static final String ACCOUNT = "zhumian";
    private static final String PASSWORD = "123456";

    @Resource
    private UserService userService;

    /**
     * 为当前登录用户授予角色和权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       /* String account = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();


        QueryRolesOrRightsRequest request = new QueryRolesOrRightsRequest();
        request.setAccount(account);
        //赋予角色
        BaseResponse<List<RoleResponse>> roleResponse = userService.queryRolesByUser(request);
        if(roleResponse.isSuccess()){
            List<RoleResponse> roles = roleResponse.getData();
            Set<String> roleSet = new TreeSet<>();
            for(RoleResponse role : roles){
                roleSet.add(role.getRoleCode());
            }
            simpleAuthorizationInfo.setRoles(roleSet);
        }
        //赋予权限
        BaseResponse<List<RightResponse>> rightReponse = userService.queryRightsByUser(request);
        if(rightReponse.isSuccess()){
            List<RightResponse> rights = rightReponse.getData();
            Set<String> rightSet = new TreeSet<>();
            for(RightResponse right : rights){
                rightSet.add(right.getRightCode());
            }
            simpleAuthorizationInfo.setRoles(rightSet);
        }
        return simpleAuthorizationInfo;*/

       Set<String> roles = new HashSet<>();
       Set<String> rights = new HashSet<>();
       roles.add("系统管理员");
       rights.add("登录");
       SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
       simpleAuthorizationInfo.setStringPermissions(rights);
       return simpleAuthorizationInfo;
    }

    /**
     * 登录验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String account = (String)token.getPrincipal();
        String password =  new String((char[])token.getCredentials());
        User userSearcher = new User();
        userSearcher.setAccount(account);
        User user = userService.getOne(userSearcher);
        if(user == null){
            throw new UnknownAccountException();
        }
        if(!Objects.equals(password,user.getPassword())){
            throw new IncorrectCredentialsException();
        }

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("user",user);

        return new SimpleAuthenticationInfo(account, password, getName());

    }
}
