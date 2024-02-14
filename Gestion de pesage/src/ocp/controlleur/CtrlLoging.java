package ocp.controlleur;

import ocp.domaine.DbAccess;
import ocp.domaine.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class CtrlLoging implements ActionListener {
    private DbAccess dbAccess;
    private LoginView loginView;
    public CtrlLoging(){
        dbAccess=new DbAccess();
        loginView=new LoginView();
        loginView.getLogin().addActionListener(this);
        loginView.getSignUp().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginView.getLogin()){
            String nu = loginView.getjTextField().getText();
            String mdp= loginView.getjPasswordField().getText();
            String query1= "select * from admins where username like'"+nu+"' and passwrd like '"+mdp+"'";
            ResultSet rs =dbAccess.executeQuery(query1);
            try {
                if(rs.next()){
                    loginView.setVisible(false);
                    new DbDisplay();
                }else{
                    JOptionPane.showMessageDialog(null,"nom d'utilisateur ou mot de passe incorrect","Échec de la connexion.",JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }else{
            loginView.setVisible(false);
            new CtrlSignUp();
        }
    }
}
