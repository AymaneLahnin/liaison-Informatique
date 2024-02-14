package ocp.domaine;

import ocp.controlleur.CtrlLoging;
import ocp.controlleur.DbDisplay;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    protected JLabel label;
    protected ImageIcon imageIcon;
    protected JTextField jTextField;
    protected JPasswordField jPasswordField;
    private JButton login,signUp;
    public LoginView(){
        this.setSize(900,540);
        this.setTitle("Se connecter");
        ImageIcon logo=new ImageIcon("C://Users//aymane lahnin//Desktop//Gestion de pesage//pictures//ocpLOGO.png");
        this.setIconImage(logo.getImage());
        imageIcon=new ImageIcon("C://Users//aymane lahnin//Desktop//Gestion de pesage//pictures//loginImg.png");
        label =new JLabel(imageIcon);
        label.setBounds(0,0,900,540);

        //zone de saisi
        jTextField =new JTextField();
        jTextField.setBounds(400,150,200,30);
        jTextField.setBackground(new Color(199, 199, 199, 224));
        jTextField.setFont(new Font("serif", Font.PLAIN, 18));
        jTextField.setBorder(BorderFactory.createRaisedBevelBorder());

        jPasswordField=new JPasswordField();
        jPasswordField.setBounds(400,210,200,30);
        jPasswordField.setFont(new Font("serif", Font.PLAIN, 18));
        jPasswordField.setBackground(new Color(199, 199, 199, 224));
        jPasswordField.setBorder(BorderFactory.createRaisedBevelBorder());

        label.add(jPasswordField);
        label.add(jTextField);


        //titre des  zones
        JLabel usnLab = new JLabel("nom d'utilisateur");
        usnLab.setBounds(240,140,200,50);
        usnLab.setFont(new Font("Arial", Font.BOLD, 18));
        usnLab.setForeground(Color.white);
        label.add(usnLab);

        JLabel pwdLab= new JLabel("mot de passe");
        pwdLab.setBounds(245,200,200,50);
        pwdLab.setFont(new Font("Arial", Font.BOLD, 18));
        pwdLab.setForeground(Color.white);
        label.add(pwdLab);

        //Bouttons
        login=new JButton("Login");
        login.setFont(new Font("Arial",Font.BOLD,17));
        login.setBounds(350,280,90,40);
        login.setBackground(new Color(199, 199, 199, 224));
        login.setBorder(BorderFactory.createRaisedBevelBorder());
        label.add(login);

        signUp=new JButton("Sign up");
        signUp.setFont(new Font("Arial",Font.BOLD,17));
        signUp.setBounds(520,280,90,40);
        signUp.setBackground(new Color(199, 199, 199, 224));
        signUp.setBorder(BorderFactory.createRaisedBevelBorder());
        label.add(signUp);
        
        this.add(label);
        this.setLayout(null);
        this.setLocation(50,10);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }

    public JButton getLogin() {
        return login;
    }

    public JButton getSignUp() {
        return signUp;
    }

    public JTextField getjTextField() {
        return jTextField;
    }

    public JPasswordField getjPasswordField() {
        return jPasswordField;
    }

}
