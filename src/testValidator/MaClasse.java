package testValidator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.internal.metadata.raw.ConstrainedField;

public class MaClasse {

	public MaClasse(String numAfpa, String email) {
		this.numAfpa = numAfpa;
		this.email = email;
	}

	@Pattern(regexp = "^[0-9]{2}$", message = "Entrer un nombre de deux chiffres")
	private String numAfpa;

	@Pattern(regexp = "^[a-z]{2}$", message = "Entrer un nombre de deux lettres")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		// validatorus();
	}

	public MaClasse() {
	}
/*
	public MaClasse(String numAfpa, String mail) {
		MaClasse maClasse = new MaClasse();
		maClasse.numAfpa = numAfpa;
		maClasse.email = mail;
		if (validatorus(maClasse)) {
			this.numAfpa = numAfpa;
			this.email = mail;
		}
		maClasse = null;

	}
	*/

	public String getNumAfpa() {
		return numAfpa;
	}

	public void setNumAfpa(String numAfpa) {
		MaClasse maClasse = new MaClasse();
		maClasse.numAfpa = numAfpa;
		if (validatorus(maClasse, "numAfpa"))
			this.numAfpa = numAfpa;
		maClasse = null;
	}

	private boolean validatorus(MaClasse maClasse) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<MaClasse>> violations = validator.validate(maClasse);

		for (ConstraintViolation<MaClasse> violation : violations) {
			System.out.println(violation.getMessage() + " " + violation.getPropertyPath());
		}
		return violations.isEmpty();

	}

	private boolean validatorus(MaClasse maClasse, String attribut) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<MaClasse>> violations = validator.validateProperty(maClasse, attribut);

		for (ConstraintViolation<MaClasse> violation : violations) {
			System.out.println(violation.getMessage() + " " + violation.getPropertyPath());
		}
		return violations.isEmpty();

	}

}
