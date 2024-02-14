package ocp.domaine;
//view

import ocp.controlleur.CtrlLoging;
import ocp.controlleur.DbDisplay;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DbView extends JFrame  {

    JButton chercher1,chercher2,saisir,supprimer1,supprimer2,modifier,afficher,logout,supprimer3,supprime4,afficherSrt;
    private ImageIcon exit;
    private JLabel dateLabel,headLabel,label,li;


    private ImageIcon img;
    public DbView(){
        this.setSize(920,600);
        this.setTitle("Menu principal");


        img=new ImageIcon("C://Users//aymane lahnin//Desktop//Gestion de pesage//pictures//test1.png");
        exit = new ImageIcon("C://Users//aymane lahnin//Desktop//Gestion de pesage//pictures//exit.png");
        label = new JLabel(img);
        li=new JLabel();
        li.setBounds(140,-5,800,600);
        label.setBounds(0,0,920,600);
        label.add(li);
        headLabel=new JLabel("Menu principal");
        headLabel.setFont(new Font("Arial", Font.BOLD, 20));


        chercher1=new JButton("chercher entree par numero de train");
        chercher2 = new JButton("chercher entree par date");

        chercher1.setBounds(40,80,250,50);
        chercher2.setBounds(380,80,250,50);
        chercher1.setFont(new Font("serif",Font.PLAIN,17));
        chercher2.setFont(new Font("serif",Font.PLAIN,18));
        chercher1.setBackground(new Color(199, 199, 199, 224));
        chercher1.setForeground(Color.black);
        chercher1.setBorder(BorderFactory.createRaisedBevelBorder());
        chercher2.setBackground(new Color(199, 199, 199, 224));
        chercher2.setBorder(BorderFactory.createRaisedBevelBorder());

        supprimer1=new JButton("Supprimer entree par date");
        supprimer1.setBounds(40,270,250,50);
        supprimer1.setFont(new Font("serif",Font.PLAIN,17));
        supprimer1.setBackground(new Color(199, 199, 199, 224));
        supprimer1.setBorder(BorderFactory.createRaisedBevelBorder());

        supprimer2=new JButton("Supprimer entree par num train");
        supprimer2.setBounds(380,270,250,50);
        supprimer2.setFont(new Font("serif",Font.PLAIN,17));
        supprimer2.setBackground(new Color(199, 199, 199, 224));
        supprimer2.setBorder(BorderFactory.createRaisedBevelBorder());

        modifier=new JButton("Ajouter une sortie");
        modifier.setBounds(40,170,250,50);
        modifier.setFont(new Font("serif",Font.PLAIN,18));
        modifier.setBackground(new Color(199, 199, 199, 224));
        modifier.setBorder(BorderFactory.createRaisedBevelBorder());

        saisir=new JButton("Ajouter une entree");
        saisir.setBounds(380,170,250,50);
        saisir.setBackground(new Color(199, 199, 199, 224));
        saisir.setBorder(BorderFactory.createRaisedBevelBorder());
        saisir.setFont(new Font("serif",Font.PLAIN,18));

        afficher=new JButton("Afficher toutes les entrees");
        afficher.setBounds(40,470,250,50);
        afficher.setBackground(new Color(199, 199, 199, 224));
        afficher.setBorder(BorderFactory.createRaisedBevelBorder());
        afficher.setFont(new Font("serif",Font.PLAIN,17));

        afficherSrt=new JButton("Afficher toutes les sorties");
        afficherSrt.setBounds(380,470,250,50);
        afficherSrt.setBackground(new Color(199, 199, 199, 224));
        afficherSrt.setBorder(BorderFactory.createRaisedBevelBorder());
        afficherSrt.setFont(new Font("serif",Font.PLAIN,17));


        supprimer3=new JButton("Supprimer sortie par date");
        supprimer3.setBounds(40,370,250,50);
        supprimer3.setFont(new Font("serif",Font.PLAIN,18));
        supprimer3.setBackground(new Color(199, 199, 199, 224));
        supprimer3.setBorder(BorderFactory.createRaisedBevelBorder());

        supprime4=new JButton("Supprimer sortie par num train");
        supprime4.setBounds(380,370,250,50);
        supprime4.setFont(new Font("serif",Font.PLAIN,18));
        supprime4.setBackground(new Color(199, 199, 199, 224));
        supprime4.setBorder(BorderFactory.createRaisedBevelBorder());




        logout=new JButton(exit);
        logout.setBounds(10,10,30,30);
        logout.setBackground(new Color(199, 199, 199, 224));
        logout.setBorder(BorderFactory.createRaisedBevelBorder());
        logout.setFont(new Font("serif",Font.PLAIN,18));

        label.add(logout);
        li.add(afficher);
        li.add(afficherSrt);
        li.add(modifier);
        li.add(saisir);
        li.add(supprimer1);
        li.add(supprimer2);
        li.add(supprimer3);
        li.add(supprime4);
        li.add(chercher1);
        li.add(chercher2);
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.BOLD, 20));
        dateLabel.setBounds(47,-20,300,90);
        dateLabel.setForeground(Color.BLACK);
        // Mettre à jour la date et l'heure
        updateDateTime();

        // Mettre en place une minuterie pour mettre à jour la date et l'heure toutes les secondes
        Timer timer = new Timer(1000, e -> updateDateTime());
        timer.start();

        add(dateLabel);

        this.add(label);
        this.setLayout(null);
        this.setLocation(300,40);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }

    public void displayData(TableModel tm,JTable table){
        table.setModel(tm);
    }

    private void updateDateTime() {
        // Obtenir la date et l'heure actuelles
        LocalDateTime now = LocalDateTime.now();

        // Formatter la date et l'heure
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        // Mettre à jour le label avec la date et l'heure formatées
        dateLabel.setText(formattedDateTime);
    }
    public JButton getChercher1(){
        return this.chercher1;
    }
    public JButton getChercher2() {
        return this.chercher2;
    }
    public JButton getSaisir(){
        return saisir;
    }

    public JButton getSupprimer1() {
        return supprimer1;
    }

    public JButton getSupprimer2() {
        return supprimer2;
    }

    public JButton getAfficher() {
        return afficher;
    }

    public JButton getModifier() {
        return modifier;
    }

    public JButton getLogout() {
        return logout;
    }


    public JButton getAfficherSrt() {
        return afficherSrt;
    }

    public JButton getSupprimer3() {
        return supprimer3;
    }

    public JButton getSupprime4() {
        return supprime4;
    }

    public void changeBGD(String path){
        ImageIcon imc=new ImageIcon(path);
        label.setIcon(imc);
        label.setBounds(0,0,1500,600);
    }

    public void updateHomeView(JScrollPane jsp, int x, int y,int width,int height){

        this.setLocation(-10,0);
        headLabel.setBounds(270,0,300,90);
        headLabel.setForeground(Color.white);
        li.add(headLabel);
        li.setBounds(0,0,1500,600);
        dateLabel.setBounds(1170,-10,300,90);
        jsp.setBorder(BorderFactory.createRaisedBevelBorder());
        jsp.setFont(new Font("serif",Font.PLAIN,18));
        jsp.setBounds(x,y,width,height);
        label.add(jsp);
    }



}