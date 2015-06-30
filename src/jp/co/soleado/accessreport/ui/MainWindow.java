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

    // �ʏ�\��
    JRadioButton    rdoNormalReport   = null;
    // �O���t�\��
    JRadioButton    rdoGraphRepot     = null;
    // �\���{�^��
    JButton         btnShow           = null;

    private static final long serialVersionUID = -1934765542749638344L;

    public MainWindow(ApplicationContext context) {
        this.context = context;
        setup();
    }

    public void setup() {
        setTitle("�A�N�Z�X���|�[�g");
        setBounds(100, 100, 300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ��ʃ��C�A�E�g�̍쐬
        JPanel p = new JPanel();
        p.setLayout(null);

        {
            ButtonGroup group = new ButtonGroup();
            rdoNormalReport = new JRadioButton("�ʏ�", true);
            rdoNormalReport.setBounds(30, 50, 70, 50);

            rdoGraphRepot = new JRadioButton("�O���t");
            rdoGraphRepot.setBounds(100, 50, 70, 50);

            group.add(rdoNormalReport);
            group.add(rdoGraphRepot);
            p.add(rdoNormalReport);
            p.add(rdoGraphRepot);
        }
        {
            // �\���{�^��
            btnShow = new JButton();
            btnShow.setText("�\��");
            btnShow.setBounds(30, 150, 100, 45);
            btnShow.addActionListener(this);
            p.add(btnShow);
        }

        getContentPane().add(p, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // �T���v���T�[�r�X�̌Ăяo��
        SampleService sampleService = (SampleService) this.context.getBean("SampleService");
        sampleService.run();


        if (e.getSource() == btnShow) {
            // �\���{�^��������

            // �I������Ă��郉�W�I�{�^���̏�Ԃ��擾
            String selectedRadio = null;
            if (rdoNormalReport.isSelected()) {
                selectedRadio = Constant.VIEW_TYPE_NORMAL;
            } else if(rdoGraphRepot.isSelected()) {
                selectedRadio = Constant.VIEW_TYPE_GRAPH;
            }

            ReportWindow reportWindow = new ReportWindow(this);

            // �\���p��Model�𐶐����AReportWindow�ŕ\�����s������

            reportWindow.setVisible(true);
        }

    }
}
