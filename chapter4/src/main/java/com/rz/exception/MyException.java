package com.rz.exception;

/**
 * 自定义异常类
 * @author 18217
 * 
 * spring boot 默认情况下会映射到 /error 进行异常处理，但是提示并不十分友好，下面自定义异常处理，提供友好展示。
 * 注：spring 对于 RuntimeException 异常才会进行事务回滚。
 *
 */
public class MyException extends RuntimeException {
	
	private static final long serialVersionUID = 5448319488411026616L;

	private String code;
	
	private String msg;

	public MyException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	

}
