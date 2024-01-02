package learn.ch36_calculator.entity;

import java.util.List;

public class ResultList {
    private List<ShellResult> resultList;

    public ResultList(List<ShellResult> resultList) {
        this.resultList = resultList;
    }

    public ResultList(){

    }

    @Override
    public String toString() {
        return "Shell{" +
                "resultList=" + resultList +
                '}';
    }

    public List<ShellResult> getResultList() {
        return resultList;
    }

    public void setResultLists(List<ShellResult> resultList) {
        this.resultList = resultList;
    }
}
