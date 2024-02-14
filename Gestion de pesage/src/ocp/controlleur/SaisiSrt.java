package ocp.controlleur;

import net.proteanit.sql.DbUtils;
import ocp.domaine.DbAccess;
import ocp.domaine.SaisiView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SaisiSrt implements ActionListener {
    private DbAccess dbAccess;
    private SaisiView saisiView;

    public SaisiSrt() {
        dbAccess = new DbAccess();
        saisiView = new SaisiView();
        saisiView.getEnregistrer().addActionListener(this);
        saisiView.getAnnuler().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saisiView.getEnregistrer()) {
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDate localDate = localDateTime.toLocalDate();
            int h = localDateTime.getHour();
            int m = localDateTime.getMinute();
            int s = localDateTime.getSecond();

            String numT = saisiView.fnumTrain.getText();
            String numV = saisiView.fnumVoiture.getText();
            String pB = saisiView.fpoidsBrute.getText();
            String pT = saisiView.fpoidsTarage.getText();
            String ido = saisiView.fidOperation.getText();
            Double pn = Double.parseDouble(pB) - Double.parseDouble(pT);
            String itp = h + ":" + m + ":" + s;
            String dtp = String.valueOf(localDate);

            String req = "insert into sortie values(" + Integer.parseInt(numT) + "," + Integer.parseInt(numV) + ",'" + dtp + "','" + itp + "'," + Double.parseDouble(pT) + "," + Double.parseDouble(pB) + "," + pn + ",'" + ido + "')";
            dbAccess.executeUpdate(req);
            JOptionPane.showMessageDialog(null, "L'enregistrement a été ajouté avec succès !");
            String req2 = "select * from sortie where idOperation like '" + ido + "'";
            ResultSet rs = dbAccess.executeQuery(req2);
            saisiView.updateTable(DbUtils.resultSetToTableModel(rs));
        }else{
            saisiView.setVisible(false);
            new DbDisplay();
        }
    }






}