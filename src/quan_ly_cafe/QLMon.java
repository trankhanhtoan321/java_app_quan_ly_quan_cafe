package quan_ly_cafe;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class QLMon extends JFrame implements ActionListener,MouseListener{
    private JButton btnback,btnthemmoi,btnxoa,btnsua;
    private JTextField txtma,txtten,txtgia,txtdvt;
    private JScrollPane sp;
    private JTable tb;
    private JLabel l1,l2,l3,l4;
    private GridBagConstraints c;
    private Vector tbRecords;
    private Vector tbTitle;
    private void khoitaobien(){
        this.btnback = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
        this.btnback.addActionListener(this);
        this.btnthemmoi = new JButton("Thêm Mới");
        this.btnthemmoi.addActionListener(this);
        this.txtma = new JTextField(15);
        this.txtten = new JTextField(15);
        this.txtgia = new JTextField(15);
        this.txtdvt = new JTextField(15);
        this.l1 = new JLabel("Mã:");
        this.l2 = new JLabel("Tên:");
        this.l3 = new JLabel("Đơn Giá:");
        this.l4 = new JLabel("ĐVT:");
        this.c = new GridBagConstraints();
        this.tbRecords = new Vector();
        this.tbTitle = new Vector();
        this.sp = new JScrollPane();
        this.tb = new JTable();
        this.btnxoa = new JButton("Xóa");
        this.btnxoa.addActionListener(this);
        this.btnsua = new JButton("Sửa");
        this.btnsua.addActionListener(this);
    }
    private void khoitaogiaodien(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
    }
    private void taomenu(){
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(btnback);
        this.c.gridx=0;
        this.c.gridy=0;
        this.c.gridwidth=2;
        this.add(p,c);
    }
    private void taoform(){
        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createTitledBorder("Thêm Mới"));
        p.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        
        c1.gridx=0;
        c1.gridy=0;
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(this.l1);
        p1.add(this.txtma);
        p.add(p1,c1);
        
        c1.gridx=0;
        c1.gridy=1;
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(this.l2);
        p2.add(this.txtten);
        p.add(p2,c1);
        
        c1.gridx=0;
        c1.gridy=2;
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.add(this.l3);
        p3.add(this.txtgia);
        p.add(p3,c1);
        
        c1.gridx=0;
        c1.gridy=3;
        JPanel p4 = new JPanel();
        p4.setLayout(new FlowLayout());
        p4.add(this.l4);
        p4.add(this.txtdvt);
        p.add(p4,c1);
        
        c1.gridx=0;
        c1.gridy=4;
        JPanel p5 = new JPanel();
        p5.setLayout(new FlowLayout());
        p5.add(this.btnthemmoi);
        p5.add(btnxoa);
        p.add(p5,c1);
        
        this.c.gridx=0;
        this.c.gridy=1;
        this.c.gridwidth=1;
        this.add(p,c);
    }
    private void taobang(){
        this.tb.addMouseListener(this);
        this.tb.setModel(new DefaultTableModel(tbRecords,tbTitle));
        this.tbTitle.add("Mã");
        this.tbTitle.add("Tên");
        this.tbTitle.add("Giá");
        this.tbTitle.add("ĐVT");
        this.tb.setModel(new DefaultTableModel(tbRecords,tbTitle));
        this.sp.setViewportView(this.tb);
        this.c.gridx=1;
        this.c.gridy=1;
        this.c.gridwidth = 1;
        this.add(sp,c);
    }
    public QLMon(){
        super("Quản Lý Món");
        this.khoitaobien();
        this.khoitaogiaodien();
        this.taomenu();
        this.taoform();
        this.taobang();
        this.setResizable(false);
        this.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btnback){
            this.dispose();
            TrangChu trangchu = new TrangChu();
            trangchu.setVisible(true);
        }
        if(ae.getSource()==btnthemmoi)
        {
            Vector record = new Vector();
            record.add(this.txtma.getText());
            record.add(this.txtten.getText());
            record.add(this.txtgia.getText());
            record.add(this.txtdvt.getText());
            this.tbRecords.add(record);
            this.tb.setModel(new DefaultTableModel(tbRecords,tbTitle));
            this.txtma.setText("");
            this.txtten.setText("");
            this.txtgia.setText("");
            this.txtdvt.setText("");
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==this.tb)
        {
            int dong = tb.getSelectedRow();
            if(dong != -1)
            {
                Vector vdong = (Vector) tbRecords.get(dong);
                txtma.setText(vdong.get(0).toString());
                txtten.setText(vdong.get(1).toString());
                txtgia.setText(vdong.get(2).toString());
                txtdvt.setText(vdong.get(3).toString());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
