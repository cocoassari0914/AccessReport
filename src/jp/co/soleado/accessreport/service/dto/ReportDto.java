package jp.co.soleado.accessreport.service.dto;

public class ReportDto {
    // 名称
    private String name;
    // カウント
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
