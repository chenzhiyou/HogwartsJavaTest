package learn.ch36_calculator.entity;

public class ShellResult {
    private String caseName;
    private boolean result;

    public ShellResult(String caseName, boolean result) {
        this.caseName = caseName;
        this.result = result;
    }

    public ShellResult(){

    }

    @Override
    public String toString() {
        return "CaseAndResult{" +
                "caseName='" + caseName + '\'' +
                ", result=" + result +
                '}';
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
