package com.hogwarts.ceshiren;

import java.util.List;

public class SumData {
    private boolean flag;
    private List<Integer> add;
    private int re;

    public SumData(boolean flag, List<Integer> add, int re) {
        this.flag = flag;
        this.add = add;
        this.re = re;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<Integer> getAdd() {
        return add;
    }

    public void setAdd(List<Integer> add) {
        this.add = add;
    }

    public int getRe() {
        return re;
    }

    public void setRe(int re) {
        this.re = re;
    }
}
