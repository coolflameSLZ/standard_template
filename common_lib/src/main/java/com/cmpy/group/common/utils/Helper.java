package com.cmpy.group.common.utils;

import cn.hutool.crypto.SecureUtil;

public class Helper {

    public static String generateGravatarUrl(String email) {
        String hash = SecureUtil.md5(email);
        return String.format("https://www.gravatar.com/avatar/%s.jpg?s=400&d=identicon", hash);
    }
}
