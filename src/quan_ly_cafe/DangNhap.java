package quan_ly_cafe;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DangNhap extends JFrame implements ActionListener{
    private JLabel lbUsername,lbPassword;
    private JButton btnLogin;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    public DangNhap(){
        super("Đăng Nhập");
        this.setSize(300,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        lbUsername = new JLabel("Username:");
        lbPassword = new JLabel("Password:");
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);
        txtUsername = new JTextField(15);
        txtPassword = new JPasswordField(15);
//        txtPassword.addKeyListener((KeyListener) this);
        
        gbc.gridx=0;
        gbc.gridy=0;
        this.add(lbUsername,gbc);
        
        gbc.gridx=1;
        gbc.gridy=0;
        this.add(txtUsername,gbc);
        
        gbc.gridx=0;
        gbc.gridy=1;
        this.add(lbPassword,gbc);
        
        gbc.gridx=1;
        gbc.gridy=1;
        this.add(txtPassword,gbc);
        
        gbc.gridx=1;
        gbc.gridy=2;
        this.add(btnLogin,gbc);
        
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btnLogin){
            String username,password;
            try{
                username=txtUsername.getText();
                password=txtPassword.getText();
                if(username.compareTo("")==0 || password.compareTo("")==0){
                    JOptionPane.showMessageDialog(this,"Thiếu thông tin!");
                    return;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"thiếu thông tin!");
                return;
            }
            if(username.compareTo("admin")==0 && password.compareTo("admin")==0){
                JOptionPane.showMessageDialog(this, "Login Successed!");
                this.dispose();
                TrangChu trangchu = new TrangChu();
                trangchu.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Login Failled!");
            }
        }
    }
//    public void keyReleased(KeyEvent ke)
//    {
//        int key = ke.getKeyCode();
//        if(ke.getSource()==txtPassword)
//        {
//            if(key==KeyEvent.VK_ENTER)
//            {
//                JOptionPane.showMessageDialog(this,"ok");
//            }
//        }
//    }
}