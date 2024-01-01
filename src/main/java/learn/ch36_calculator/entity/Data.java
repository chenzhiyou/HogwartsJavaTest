package learn.ch36_calculator.entity;

import java.util.List;

public class Data {
    private List<dataEntity> datas;

    public List<dataEntity> getDatas() {
        return datas;
    }

    public void setDatas(List<dataEntity> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Data{" +
                "datas=" + datas +
                '}';
    }
}
