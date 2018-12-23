package com.jack.fall_back;

import com.jack.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @author Jack
 */
@Component
public class SchedualServiceUserLoginHystricImpl implements UserService {

    @Override
    public String userLogin(String name) {
        return new String("sorry "+name);
    }
}
