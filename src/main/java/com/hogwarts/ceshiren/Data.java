package com.hogwarts.ceshiren;

import java.util.List;

public class Data {
    private List<CalculatorYamlEntity> datas;


    public List<CalculatorYamlEntity> getDatas() {
        return datas;
    }

    public void setDatas(List<CalculatorYamlEntity> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Data{" +
                "datas=" + datas +
                '}';
    }
}
