package com.rifu.validators;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class SensitiveWordValidator extends FieldValidatorSupport{

	@Override
	public void validate(Object arg0) throws ValidationException {
		String fieldName=this.getFieldName();
		String value=this.getFieldValue(fieldName, arg0).toString();
		if(!check(value)){
			this.addFieldError(fieldName, arg0);
		}
	}
	
	public boolean check(String value){
		String sensitiveWords[]={"ÈÕ","ÄãÂè"};
		for(int i=0;i<sensitiveWords.length;i++){
			if(value.indexOf(sensitiveWords[i])>-1){
				return false;
			}
		}
		return true;
	}

}
