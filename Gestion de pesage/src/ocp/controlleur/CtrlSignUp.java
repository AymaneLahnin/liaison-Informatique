package ocp.controlleur;


import ocp.domaine.DbAccess;
import ocp.domaine.SignUpView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CtrlSignUp implements ActionListener {
    private DbAccess dbAccess;
    private SignUpView signUpView;

    public CtrlSignUp(){
        dbAccess=new DbAccess();
        signUpView=new SignUpView();
        signUpView.getConfirmer().addActionListener(this);
        signUpView.getAnnuler().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == signUpView.getConfirmer()){
                String nusn=signUpView.getjTextField().getText();
                String npd=signUpView.getjPasswordField().getText();

                ResultSet s=dbAccess.executeQuery("select * from admins where username like '"+nusn+"' or passwrd like '"+npd+"'");
            try {
                if(dbAccess.linesCount(s) == 0){
                    String query= "insert into admins values('"+nusn+"','"+npd+"')";
                    dbAccess.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"la creation de votre compte a ete effectuee avec succee ","Notification",JOptionPane.INFORMATION_MESSAGE);
                    signUpView.setVisible(false);
                    new CtrlLoging();
                }else{
                    JOptionPane.showMessageDialog(null,"donnees incorrectes ou deja utilisees ","Avertissement",JOptionPane.WARNING_MESSAGE);

                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }





        }else{
            signUpView.setVisible(false);
            new CtrlLoging();
        }
    }
}
