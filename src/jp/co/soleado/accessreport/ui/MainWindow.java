package jp.co.soleado.accessreport.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import jp.co.soleado.accessreport.Constant;
import jp.co.soleado.accessreport.service.SampleService;

import org.springframework.context.ApplicationContext;

public class MainWindow extends JFrame implements ActionListener {
    private ApplicationContext context = null;

    // 通常表示
    JRadioButton    rdoNormalReport   = null;
    // グラフ表示
    JRadioButton    rdoGraphRepot     = null;
    // 表示ボタン
    JButton         btnShow           = null;

    private static final long serialVersionUID = -1934765542749638344L;

    public MainWindow(ApplicationContext context) {
        this.context = context;
        setup();
    }

    public void setup() {
        setTitle("アクセスレポート");
        setBounds(100, 100, 300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 画面レイアウトの作成
        JPanel p = new JPanel();
        p.setLayout(null);

        {
            ButtonGroup group = new ButtonGroup();
            rdoNormalReport = new JRadioButton("通常", true);
            rdoNormalReport.setBounds(30, 50, 70, 50);

            rdoGraphRepot = new JRadioButton("グラフ");
            rdoGraphRepot.setBounds(100, 50, 70, 50);

            group.add(rdoNormalReport);
            group.add(rdoGraphRepot);
            p.add(rdoNormalReport);
            p.add(rdoGraphRepot);
        }
        {
            // 表示ボタン
            btnShow = new JButton();
            btnShow.setText("表示");
            btnShow.setBounds(30, 150, 100, 45);
            btnShow.addActionListener(this);
            p.add(btnShow);
        }

        getContentPane().add(p, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // サンプルサービスの呼び出し
        SampleService sampleService = (SampleService) this.context.getBean("SampleService");
        sampleService.run();


        if (e.getSource() == btnShow) {
            // 表示ボタンを押下

            // 選択されているラジオボタンの状態を取得
            String selectedRadio = null;
            if (rdoNormalReport.isSelected()) {
                selectedRadio = Constant.VIEW_TYPE_NORMAL;
            } else if(rdoGraphRepot.isSelected()) {
                selectedRadio = Constant.VIEW_TYPE_GRAPH;
            }

            ReportWindow reportWindow = new ReportWindow(this);

            // 表示用のModelを生成し、ReportWindowで表示を行うこと

            reportWindow.setVisible(true);
        }

    }
}
