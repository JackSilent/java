package com.jack;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jack.utils.http.BiHuUrlUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Jack
 */
public class StartApplication {

    public static void main(String[] args) throws IOException {
        BiHuUrlUtils biHuUrlUtils = BiHuUrlUtils.newInstance();
        biHuUrlUtils.login();
        Map<String, Object> result = biHuUrlUtils.getResult();
        String loginResponseJson = result.get("loginResponseJson").toString();
        System.err.println(loginResponseJson);
        Map loginHeader = (Map) result.get("loginHeader");
        Set keys = loginHeader.keySet();
        Iterator keyIter = keys.iterator();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(loginResponseJson).get("data");
        String securityCode = "";
        if (jsonNode.isObject()) {
            jsonNode.get("accessToken");
            System.out.println( jsonNode.get("accessToken").toString());
            securityCode = jsonNode.get("accessToken").toString();
        }

        biHuUrlUtils.getPersonalInfo(securityCode.split("\"")[1].toString());

        String personalData = (String) result.get("PersonalInfoResponseJson");
        System.err.println(personalData);
    }
}


