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

	//��֤ʱ����Ҫʵ�ֵķ���(Ҳ����������˵�ĵ�¼)
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1. �� AuthenticationToken ת��Ϊ UsernamePasswordToken 
		UsernamePasswordToken upToken=(UsernamePasswordToken)token;
		//2. �� UsernamePasswordToken ������ȡ username
		String username=upToken.getUsername();
		System.out.println(upToken);
		//3. �������ݿ�ķ���, �����ݿ��в�ѯ username ��Ӧ���û���¼
		
		//4. ���û�������, ������׳� UnknownAccountException �쳣
		if("noExsist".equals(username)){
			throw new UnknownAccountException();
		}
		//5. �����û���Ϣ�����, �����Ƿ���Ҫ�׳������� AuthenticationException �쳣. 
		
		//6. �����û������, ������ AuthenticationInfo ���󲢷���. ͨ��ʹ�õ�ʵ����Ϊ: SimpleAuthenticationInfo
		//������Ϣ�Ǵ����ݿ��л�ȡ��.
		//1). principal: ��֤��ʵ����Ϣ. ������ username, Ҳ���������ݱ��Ӧ���û���ʵ�������. 
		Object principal = username;
		//2). credentials: ����. 
		Object credentials = null; 
		if("user".equals(username)){
			credentials = "629fcb32a81113c2ee3dbad0432d692a";	//��Ӧ������528428,�˺���user
		}else if("admin".equals(username)){
			credentials = "ca4f725eaa20a19260e1b94e1b8028f5";	//��Ӧ������528428,�˺���admin
		}
		//3). realmName: ��ǰ realm ����� name. ���ø���� getName() ��������
		String realmName = getName();
		//4). ��ֵ. 
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);
		return info;
	}
	
	public static void main(String [] args){
		//ȡ�þ���1024�μ���֮���MD5����
		String hashAlgorithmName = "MD5";
		Object credentials = "528428";
		Object salt = ByteSource.Util.bytes("admin");		//����ӵ���ֵ��ʹmd5���Ӳ�����,�൱���������md5��������������Ӧ���ַ���
		int hashIterations = 1024;
		
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println(result);
	}

	//��Ȩ��Ҫʵ�ֵķ���
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		System.out.println("doGetAuthorizationInfo....");
		//1.��PrincipalCollection �л�ȡ�û���¼����Ϣ
		Object  principal=arg0.getPrimaryPrincipal();
		
		//2.���õ�¼���û���Ϣ����ȡ��ǰ�û��Ľ�ɫ��Ȩ��
		Set<String> roles=new HashSet<>();
		roles.add("user");
		if("admin".equals(principal)){
			roles.add("admin");
		}
		
		//3.����SimpleAuthorizationInfo ,��������reles����
		SimpleAuthorizationInfo sai=new SimpleAuthorizationInfo(roles);
		//4.���� SimpleAuthorizationInfo ����
		return sai;
	}

}
