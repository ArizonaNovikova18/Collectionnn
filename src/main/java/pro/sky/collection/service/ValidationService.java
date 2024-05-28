package pro.sky.collection.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.collection.exception.ValidationFailedException;

import java.util.Locale;

@Service
public class ValidationService {
    public String checkName(String name){
        if (!StringUtils.isAlpha(name)){
            throw new ValidationFailedException();
        }
        return StringUtils.capitalize(name.toLowerCase());
    }
}
