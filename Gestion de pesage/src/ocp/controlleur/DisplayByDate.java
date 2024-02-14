package ocp.controlleur;

import net.proteanit.sql.DbUtils;
import ocp.domaine.ChercherView;
import ocp.domaine.DbAccess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayByDate implements ActionListener{
    private ChercherView chercherDate;
    private DbAccess dbAccess;
    public DisplayByDate(){
        chercherDate=new ChercherView();
        dbAccess=new DbAccess();
        chercherDate.getValider().addActionListener(this);
        chercherDate.getBack().addActionListener(this);
    }






    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chercherDate.getValider()){
            String query = "select * from verifierPoids where date_pesage = '"+this.chercherDate.getTfInput().getText()+"'";

            ResultSet rs = dbAccess.executeQuery(query);
            try {
                if(dbAccess.linesCount(rs)==0){
                    JOptionPane.showMessageDialog(null, "Aucun enregistrement trouvé pour la date : " + chercherDate.getTfInput().getText(), "Avertissement", JOptionPane.WARNING_MESSAGE);
                }else{
                    rs= dbAccess.executeQuery(query);
                    chercherDate.showData(DbUtils.resultSetToTableModel(rs));
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
        else{
            chercherDate.setVisible(false);
            new DbDisplay();
        }


    }



}
