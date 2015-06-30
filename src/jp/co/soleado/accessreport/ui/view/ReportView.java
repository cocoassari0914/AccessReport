package jp.co.soleado.accessreport.ui.view;

import java.util.List;

import javax.swing.JTable;

import jp.co.soleado.accessreport.service.dto.ReportDto;

public abstract class ReportView {
    // 表示データ
    private List<ReportDto> datas;

    public void setup(List<ReportDto> datas) {
        this.datas = datas;
    }

    public abstract void showReport(JTable table);
}
