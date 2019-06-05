package com.katsubo.validation;

public abstract class ValidationFactory {
    public static Validation getValidation(ValidationType validationType){
        Validation validation = null;
        switch (validationType){
            case TOY:
                validation = new ValidationToy();
                break;
        }

        return validation;
    }

}
