package com.jack;

import com.jack.utils.BiHuUrlUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Jack
 */
public class StartApplication {

    public static void main(String[] args) {
        BiHuUrlUtils biHuUrlUtils = BiHuUrlUtils.newInstance();
        biHuUrlUtils.login();
    }
}


