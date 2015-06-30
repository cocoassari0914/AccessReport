package jp.co.soleado.accessreport.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jp.co.soleado.accessreport.ui.view.ReportView;

public class ReportWindow extends JDialog  {
    private static final long serialVersionUID = 5497773132408701833L;

    private JTable spredList;
    private DefaultTableModel tableModel;

    public ReportWindow(Frame owner) {
        super(owner, true);     // モーダル化
        setup();
    }

    public void setup() {
        setTitle("レポート結果");
        setBounds(100, 100, 420, 260);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // 画面レイアウトの作成
        JPanel p = new JPanel();
        p.setLayout(null);

        {
            tableModel = new DefaultTableModel(new String[] {"サイト名", "件数"}, 0);
            spredList = new JTable(tableModel);

            // 暫定でダミーを設定
            for(int i = 0 ; i < 4 ; i++){
                tableModel.addRow(new String[] {"xxx", "10"} );
            }

            JScrollPane sp = new JScrollPane(spredList);
            sp.setBounds(10, 10, 380, 200);
            p.add(sp);
        }

        getContentPane().add(p, BorderLayout.CENTER);
    }

    // 画面起動時に設定すること
    public void setModel(ReportView model) {

    }
}
