package util;

public class ResultCodeUtil {
	
	/**
	 * 205	验证出错
	 */
	public final static int VERIFY_FAIL = 205;
	
	/**
	 * 200 已注册 201 注册成功 202 注册失败
	 */
	public final static int REGISTER_ALREADY = 200;
	public final static int REGISTER_SUCCESS = 201;
	public final static int REGISTER_FAIL = 202;

	/**
	 * 200 未注册 201 登录成功 202 登录失败
	 */
	public final static int NO_REGISTER = 200;
	public final static int LOGIN_SUCCESS = 201;
	public final static int LOGIN_FAIL = 202;

	/**
	 * 201 修改成功 202 修改失败
	 */
	public final static int UPDATE_SUCCESS = 201;
	public final static int UPDATE_FAIL = 202;
	
	/**
	 * 201 回复成功 202 回复失败
	 */
	public final static int REPLY_SUCCESS = 201;
	public final static int REPLY_FAIL = 202;

	/**
	 * 204 查询为空，没有更多内容
	 */
	public final static int HAS_NOTHING = 204;

	/**
	 * 202 查询失败 	202 查询成功
	 */
	public final static int SUCCESS = 201;
	public final static int FAIL = 202;
	
}
