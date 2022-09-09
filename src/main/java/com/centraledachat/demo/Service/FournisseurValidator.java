package com.centraledachat.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.centraledachat.demo.Model.Fournisseur;
import com.centraledachat.demo.Model.User;

@Component
public class FournisseurValidator implements Validator {
    @Autowired
    private FournisseurService fs;

    @Override
    public boolean supports(Class<?> aClass) {
        return Fournisseur.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Fournisseur user = (Fournisseur) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "societe", "NotEmpty");
        if (user.getSociete().length() < 6 || user.getSociete().length() > 32) {
            errors.rejectValue("societe", "Size.userForm.username");
        }
		/*
		 * if (fs.getFournisseur(user.getId_Fournisseur()) != null) {
		 * errors.rejectValue("societe", "Duplicate.userForm.username"); }
		 */

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
