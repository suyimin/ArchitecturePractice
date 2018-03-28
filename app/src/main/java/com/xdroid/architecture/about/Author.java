package com.xdroid.architecture.about;

public class Author {

    private String github = null;

    private String weibo = null;

    private String blog = null;

    private String mail = null;

    private String jianshu = null;

    Author() {
        github = "https://github.com/suyimin";
        weibo = "---";
        blog = "https://blog.csdn.net/suyimin2010";
        mail = "suyimin2001@163.com";
        jianshu = "---";
    }

    String getGithub() {
        return github;
    }

    String getWeibo() {
        return weibo;
    }

    String getBlog() {
        return blog;
    }

    String getMail() {
        return mail;
    }

    String getJianshu() {
        return jianshu;
    }
}
