package com.reco.cn.util;

import java.util.Random;
import java.util.UUID;

/**
 * Created by cpf on 2018/4/18.
 */
public class RandomUtil {
    public static final String VERIFY_CODES = "123456789ABCDEFGHJKLMNPQRSTUVWXYZ";

    public static String generateVerifyCode(int verifySize, String sources) {
        if (sources == null || sources.length() == 0) {
            sources = VERIFY_CODES;
        }
        int codesLen = sources.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for (int i = 0; i < verifySize; i++) {
            verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
        }
        return verifyCode.toString();
    }

    public static synchronized String createId() {
        UUID uuid = UUID.randomUUID();
        return UUID.randomUUID().toString();
    }

}
