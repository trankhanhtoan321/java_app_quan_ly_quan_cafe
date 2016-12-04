package quan_ly_cafe;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TrangChu extends JFrame implements ActionListener{
    private JButton btnmon,btnorder,btnnv;
    public TrangChu(){
        super("Trang Chủ");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        btnmon = new JButton();
        btnmon.addActionListener(this);
        btnmon.setIcon(new ImageIcon(getClass().getResource("/images/mon.png")));
        btnmon.setBackground(Color.WHITE);
        gbc.gridx=0;
        gbc.gridy=0;
        this.add(btnmon,gbc);
        
        btnorder = new JButton();
        btnorder.addActionListener(this);
        btnorder.setIcon(new ImageIcon(getClass().getResource("/images/order.png")));
        btnorder.setBackground(Color.WHITE);
        gbc.gridx=1;
        gbc.gridy=0;
        this.add(btnorder,gbc);
        
        btnnv = new JButton();
        btnnv.addActionListener(this);
        btnnv.setIcon(new ImageIcon(getClass().getResource("/images/nhanvien.png")));
        btnnv.setBackground(Color.WHITE);
        gbc.gridx=2;
        gbc.gridy=0;
        this.add(btnnv,gbc);
        
        this.setResizable(false);
        this.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btnmon){
            this.dispose();
            QLMon qlmon = new QLMon();
            qlmon.setVisible(true);
        }
    }
    
}
