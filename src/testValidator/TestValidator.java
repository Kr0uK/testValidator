package testValidator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class TestValidator<T> {
	private static T classe;

	public TestValidator(T classe) {
		super();
		if (validatorus(classe)){
			this.classe = classe;
			
		}
	}

	public static boolean validatorus(T test) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		classe = test;
		Set<ConstraintViolation<T>> violations = validator.validate(classe);

		for (ConstraintViolation<T> violation : violations) {
			System.out.println(violation.getMessage() + " " + violation.getPropertyPath());
		}
		return violations.isEmpty();
		
//		return false;
	}

	public T getClasse() {
		return classe;
	}

	public void setClasse(T classe) {
		this.classe = classe;
	}
	
	
	
	

}
