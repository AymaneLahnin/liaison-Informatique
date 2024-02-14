package ocp.controlleur;
//controlleur
import net.proteanit.sql.DbUtils;
import ocp.domaine.DbAccess;
import ocp.domaine.DbView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbDisplay implements ActionListener {
    private DbView dbView  = new DbView();
    private DbAccess dbAccess = new DbAccess();
    public DbDisplay(){

        dbView.getChercher1().addActionListener(this);
        dbView.getChercher2().addActionListener(this);
        dbView.getSaisir().addActionListener(this);
        dbView.getAfficher().addActionListener(this);
        dbView.getSupprimer1().addActionListener(this);
        dbView.getSupprimer2().addActionListener(this);
        dbView.getLogout().addActionListener(this);
        dbView.getModifier().addActionListener(this);
        dbView.getSupprimer3().addActionListener(this);
        dbView.getSupprime4().addActionListener(this);
        dbView.getAfficherSrt().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == dbView.getChercher1()){
            dbView.setVisible(false);
            new DisplayByNum();
        }else if(e.getSource() == dbView.getChercher2()){
            dbView.setVisible(false);
            new DisplayByDate();
        }else if(e.getSource()==dbView.getSaisir()){
            dbView.setVisible(false);
            new ControlleurSaisi();
        } else if (e.getSource() == dbView.getSupprimer1()) {
            String date = JOptionPane.showInputDialog(null,"Veuillez saisir la date","date d'enregistrement");
            String heure = JOptionPane.showInputDialog(null,"Veuillez saisir l'horaire d'enregistrement","Horaire d'enregistrement");

            String q1= "delete from verifierPoids where date_pesage like '"+date+"' and instant_pesage like '"+heure+"'";
            String q2= "select * from verifierPoids where date_pesage like '"+date+"' and instant_pesage like '"+heure+"'";
            try {
                if(dbAccess.linesCount(dbAccess.executeQuery(q2))==0){
                    JOptionPane.showMessageDialog(null,"Aucun enregistrement pour la date" + date , "Suppression échouée", JOptionPane.INFORMATION_MESSAGE);

                }else{
                    dbAccess.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null,"La suppression de l'enregistrement de la date " + date +"a l'instant "+heure+ " a été effectuée avec succès.", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource()==dbView.getSupprimer2()) {
            String numTrain = JOptionPane.showInputDialog(null,"Veuillez saisir le numero de train a supprimer","numero de train");
            String q1= "delete from verifierPoids where num_train ="+Integer.parseInt(numTrain);
            String q2= "select * from verifierPoids where num_train = "+Integer.parseInt(numTrain);
            try {
                if(dbAccess.linesCount(dbAccess.executeQuery(q2))==0){
                    JOptionPane.showMessageDialog(null,"Aucun enregistrement correspond au train numero" + Integer.parseInt(numTrain) , "Suppression échouée", JOptionPane.INFORMATION_MESSAGE);

                }else{
                    dbAccess.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null,"La suppression de l'enregistrement correspondant au train numéro " + Integer.parseInt(numTrain) + " a été effectuée avec succès.", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } else if (e.getSource()==dbView.getAfficher()){
            String[] options={ "entrees validees","entree non validee"};
            int  userChoice=JOptionPane.showOptionDialog(null,"Veuillez choisir une option :","Choix de l'utilisateur",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options,options[0]);
            dbView.setSize(1500,600);
            dbView.changeBGD("C://Users//aymane lahnin//Desktop//Gestion de pesage//pictures//cpesage1.png");
            JTable jTable=new JTable();
            JScrollPane jScrollPane=new JScrollPane(jTable);
            if(userChoice==0){
                try{
                    String query = "select * from verifierPoids";
                    ResultSet rs = dbAccess.executeQuery(query);

                    dbView.displayData(DbUtils.resultSetToTableModel(rs),jTable);
                    dbView.updateHomeView(jScrollPane,640,90,720,90);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }else{
                try{

                    String query = "select * from operationNV";
                    ResultSet rs = dbAccess.executeQuery(query);
                    dbView.displayData(DbUtils.resultSetToTableModel(rs),jTable);
                    dbView.updateHomeView(jScrollPane,715,200,650,90);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }

        }else if(e.getSource() == dbView.getLogout()){
            dbView.setVisible(false);
            new CtrlLoging();
        } else if (e.getSource()==dbView.getModifier()) {
            dbView.setVisible(false);
            new SaisiSrt();
        } else if (e.getSource()==dbView.getSupprimer3()) {
            String dt=JOptionPane.showInputDialog(null,"Saisir la date");
            String tmp=JOptionPane.showInputDialog(null,"Saisir l'heure");
            String req="delete from sortie where date_pesage like '"+dt+"' and instant_pesage like '"+tmp+"'";
            String sel="select * from sortie where date_pesage like '"+dt+"' and instant_pesage like '"+tmp+"'";

            try {
                if(dbAccess.linesCount(dbAccess.executeQuery(sel))==0){
                    JOptionPane.showMessageDialog(null,"Aucun enregistrement pour la date" + dt , "Suppression échouée", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    dbAccess.executeUpdate(req);
                    JOptionPane.showMessageDialog(null,"La suppression de l'enregistrement de la date " + dt +"a l'instant "+tmp+ " a été effectuée avec succès.", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource()==dbView.getSupprime4()) {
            int nt=Integer.parseInt(JOptionPane.showInputDialog(null,"Saisir le numero de train"));
            String r1="delete from sortie where numTrain = "+nt;
            String r2="select * from sortie where numTrain = "+nt;
            try {
                if(dbAccess.linesCount(dbAccess.executeQuery(r2))==0){
                    JOptionPane.showMessageDialog(null,"Aucun enregistrement correspond au train numero " + nt, "Suppression échouée", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    dbAccess.executeUpdate(r1);
                    JOptionPane.showMessageDialog(null,"La suppression de l'enregistrement correspondant au train numéro " + nt + " a été effectuée avec succès.", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }else{
            String r="select * from sortie";
            ResultSet rs= dbAccess.executeQuery(r);
            JTable jTable=new JTable();
            JScrollPane jScrollPane=new JScrollPane(jTable);
            try {
                if(rs.next()){
                    dbView.setSize(1500,600);
                    dbView.changeBGD("C://Users//aymane lahnin//Desktop//Gestion de pesage//pictures//cpesage1.png");
                    dbView.displayData(DbUtils.resultSetToTableModel(rs),jTable);
                    dbView.updateHomeView(jScrollPane,640,300,720,90);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}