package ocp.controlleur;

import net.proteanit.sql.DbUtils;
import ocp.domaine.ChercherView;
import ocp.domaine.DbAccess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DisplayByNum implements ActionListener {
    private ChercherView chercherView;
    private DbAccess dbAccess;
    public DisplayByNum(){
        chercherView =new ChercherView();
        dbAccess = new DbAccess();
        chercherView.getValider().addActionListener(this);
        chercherView.getBack().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chercherView.getValider()){
        String query = "select * from verifierPoids where num_train = "+Integer.parseInt(this.chercherView.getTfInput().getText());
        ResultSet rs = dbAccess.executeQuery(query);
        try{
            if(dbAccess.linesCount(rs)==0){
                JOptionPane.showMessageDialog(null, "Aucun enregistrement trouvé pour le train numero : " + chercherView.getTfInput().getText(), "Avertissement", JOptionPane.WARNING_MESSAGE);

            }else{
                rs = dbAccess.executeQuery(query);
                this.chercherView.showData(DbUtils.resultSetToTableModel(rs));
            }

        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erreur lors de l'exécution de la requête : " + ex.getMessage());
        }
    }else{
            chercherView.setVisible(false);
            new DbDisplay();
        }
}
}

