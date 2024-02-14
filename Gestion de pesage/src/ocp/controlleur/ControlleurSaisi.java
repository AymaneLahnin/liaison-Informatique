package ocp.controlleur;

import net.proteanit.sql.DbUtils;
import ocp.controlleur.DbDisplay;
import ocp.domaine.DbAccess;
import ocp.domaine.SaisiView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ControlleurSaisi implements ActionListener {
    private DbAccess dbAccess;
    private SaisiView saisiView;

    public ControlleurSaisi(){
        dbAccess=new DbAccess();
        saisiView=new SaisiView();
        saisiView.getEnregistrer().addActionListener(this);
        saisiView.getAnnuler().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == saisiView.getEnregistrer()){
            LocalDateTime localDateTime= LocalDateTime.now();
            LocalDate localDate = localDateTime.toLocalDate();
            int h=localDateTime.getHour();
            int m=localDateTime.getMinute();
            int s=localDateTime.getSecond();

            String numT=saisiView.fnumTrain.getText();
            String numV=saisiView.fnumVoiture.getText();
            String pB=saisiView.fpoidsBrute.getText();
            String pT=saisiView.fpoidsTarage.getText();
            String ido=saisiView.fidOperation.getText();
            //String
            Double pn= Double.parseDouble(pB)-Double.parseDouble(pT);
            String itp=h+":"+m+":"+s;
            String dtp= String.valueOf(localDate);

            try {
                ResultSet resultSet = dbAccess.executeQuery("select * from approvisionnement where idOperation like '"+ido+"'");

                if(resultSet.next()){
                    Double pns=resultSet.getDouble("poids_net");
                    String fnsId=resultSet.getString("idFournisseur");

                    if(Math.abs(pns-pn)>0.02*pns){
                        JOptionPane.showMessageDialog(null,"Avertissement concernant l'approvisionnement du fournisseur avec l'ID : " + fnsId
                                + "\nvaleur de Décalage  : " + ((Math.abs(pns-pn))/pns )*100+ " %","Avertissement d'approvisionnement",JOptionPane.WARNING_MESSAGE);
                        String q1="insert into operationNV values('"+fnsId+"',"+Double.parseDouble(numT)+","+Math.abs(pns-pn)+",'"+dtp+" "+itp+"',"+Integer.parseInt(numV)+")";
                        dbAccess.executeUpdate(q1);
                    }else{
                        String query= "insert into verifierPoids values ("+Integer.parseInt(numT)+","+ Integer.parseInt(numV)+","+ "'"+localDate+"','"+h+":"+m+":"+s+"',"+ Double.parseDouble(pT)+","+Double.parseDouble(pB)+","+(Double.parseDouble(pB)-Double.parseDouble(pT))+",'"+ido+"')";
                        dbAccess.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"L'enregistrement a été ajouté avec succès !");

                        String query2="select * from verifierPoids where idOperation like '"+ido+"'";

                        saisiView.updateTable(DbUtils.resultSetToTableModel(dbAccess.executeQuery(query2)));

                    }
                }else{

                    JOptionPane.showMessageDialog(null,"l'identifiant saisi ne correspond a aucune operation d'approvisionnement");
                    String idF = JOptionPane.showInputDialog(null,"Saisir l'id du fournisseur");
                    Double pt=Double.parseDouble(JOptionPane.showInputDialog(null,"Saisir le poids de tarage:"));
                    Double pb=Double.parseDouble(JOptionPane.showInputDialog(null,"Saisir le poids brute:"));
                    int nv=Integer.parseInt(JOptionPane.showInputDialog(null,"Saisir le numero de wagon:"));
                    String q= "insert into approvisionnement values('"+idF+"',"+Integer.parseInt(numT)+","+pt+","+pb+","+(pb-pt)+",'"+ido+"'"+","+nv+")";
                    dbAccess.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"approvisionnement a été ajouté avec succès !");

                    String query2="select * from approvisionnement where idOperation like '"+ido+"'";
                    dbAccess.executeQuery(query2);
                    saisiView.updateTable(DbUtils.resultSetToTableModel(dbAccess.executeQuery(query2)));

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }else{
            saisiView.setVisible(false);
            new DbDisplay();
        }
    }



}
