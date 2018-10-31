package com.rifu.realms;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class ShiroRealm extends AuthorizingRealm{

	//认证时候需要实现的方法(也就是我们所说的登录)
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1. 把 AuthenticationToken 转换为 UsernamePasswordToken 
		UsernamePasswordToken upToken=(UsernamePasswordToken)token;
		//2. 从 UsernamePasswordToken 中来获取 username
		String username=upToken.getUsername();
		System.out.println(upToken);
		//3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
		
		//4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
		if("noExsist".equals(username)){
			throw new UnknownAccountException();
		}
		//5. 根据用户信息的情况, 决定是否需要抛出其他的 AuthenticationException 异常. 
		
		//6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
		//以下信息是从数据库中获取的.
		//1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象. 
		Object principal = username;
		//2). credentials: 密码. 
		Object credentials = null; 
		if("user".equals(username)){
			credentials = "629fcb32a81113c2ee3dbad0432d692a";	//对应密码是528428,账号是user
		}else if("admin".equals(username)){
			credentials = "ca4f725eaa20a19260e1b94e1b8028f5";	//对应密码是528428,账号是admin
		}
		//3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
		String realmName = getName();
		//4). 盐值. 
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);
		return info;
	}
	
	public static void main(String [] args){
		//取得经过1024次加密之后的MD5密码
		String hashAlgorithmName = "MD5";
		Object credentials = "528428";
		Object salt = ByteSource.Util.bytes("admin");		//待添加的盐值，使md5更加不可逆,相当于在密码的md5序列中随机插入对应的字符串
		int hashIterations = 1024;
		
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println(result);
	}

	//授权需要实现的方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		System.out.println("doGetAuthorizationInfo....");
		//1.从PrincipalCollection 中获取用户登录的信息
		Object  principal=arg0.getPrimaryPrincipal();
		
		//2.利用登录的用户信息来获取当前用户的角色或权限
		Set<String> roles=new HashSet<>();
		roles.add("user");
		if("admin".equals(principal)){
			roles.add("admin");
		}
		
		//3.创建SimpleAuthorizationInfo ,并设置其reles属性
		SimpleAuthorizationInfo sai=new SimpleAuthorizationInfo(roles);
		//4.返回 SimpleAuthorizationInfo 对象
		return sai;
	}

}
