package net.viralpatel.contact.validator; 

import net.viralpatel.contact.form.UserAddress;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return UserAddress.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirm", "confirm.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street1", "street1.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street2", "street2.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "city.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "state.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "country.required");
		if(((UserAddress)(obj)).getName()==null)
		errors.rejectValue("name","can't be blank",new Object[]{"'name'"},"Name can't be null");
	}

}
