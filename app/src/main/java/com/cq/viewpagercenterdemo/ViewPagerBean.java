package com.cq.viewpagercenterdemo;

/**
 * Created by ${YangJunJin}
 * on 2019/9/2
 */
public class ViewPagerBean {
    private String name;
    private boolean show;

    public ViewPagerBean(String name, boolean show) {
        this.name = name;
        this.show = show;
    }

    public String getName() {
        return name;
    }

    public ViewPagerBean setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isShow() {
        return show;
    }

    public ViewPagerBean setShow(boolean show) {
        this.show = show;
        return this;
    }
}
