package ocp.domaine;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;

public class SaisiView extends JFrame {
    private JLabel label,lnT,lnV,lPB,lidOP,lPT;
    private JTable table;
    private JScrollPane jScrollPane;
    private ImageIcon img;
    public JTextField fnumTrain,fnumVoiture,fpoidsBrute,fpoidsTarage,fidOperation;

    private JButton annuler,enregistrer;

    public SaisiView(){
        this.setSize(910,540);
        this.setTitle("verification des poids");
        img=new ImageIcon("C://Users//aymane lahnin//Desktop//Gestion de pesage//pictures//bgAdd.png");
        label = new JLabel(img);
        label.setBounds(0,0,910,540);
        //composants
        fnumTrain=new JTextField();
        fnumTrain.setBounds(210,100,150,30);
        fnumTrain.setFont(new Font("Arial", Font.BOLD, 18));
        fnumTrain.setBorder(BorderFactory.createRaisedBevelBorder());
        fnumTrain.setBackground(new Color(199, 199, 199, 224));
        label.add(fnumTrain);

        fnumVoiture=new JTextField();
        fnumVoiture.setBounds(210,170,150,30);
        fnumVoiture.setFont(new Font("Arial", Font.BOLD, 18));
        fnumVoiture.setBorder(BorderFactory.createRaisedBevelBorder());
        fnumVoiture.setBackground(new Color(199, 199, 199, 224));
        label.add(fnumVoiture);

        fpoidsBrute=new JTextField();
        fpoidsBrute.setBounds(680,170,150,30);
        fpoidsBrute.setFont(new Font("Arial", Font.BOLD, 18));
        fpoidsBrute.setBorder(BorderFactory.createRaisedBevelBorder());
        fpoidsBrute.setBackground(new Color(199, 199, 199, 224));
        label.add(fpoidsBrute);


        fpoidsTarage=new JTextField();
        fpoidsTarage.setBounds(680,100,150,30);
        fpoidsTarage.setFont(new Font("Arial", Font.BOLD, 18));
        fpoidsTarage.setBorder(BorderFactory.createRaisedBevelBorder());
        fpoidsTarage.setBackground(new Color(199, 199, 199, 224));
        label.add(fpoidsTarage);

        fidOperation=new JTextField();
        fidOperation.setBounds(450,30,150,30);
        fidOperation.setFont(new Font("Arial", Font.BOLD, 18));
        fidOperation.setBorder(BorderFactory.createRaisedBevelBorder());
        fidOperation.setBackground(new Color(199, 199, 199, 224));
        label.add(fidOperation);


        //titre des composants
        lnT=new JLabel("numero de train");
        lnT.setBounds(73,80,120,60);
        lnT.setFont(new Font("Arial", Font.BOLD, 16));
        lnT.setForeground(Color.white);
        label.add(lnT);

        lnV=new JLabel("numero de wagon");
        lnV.setBounds(53,150,150,60);
        lnV.setFont(new Font("Arial", Font.BOLD, 16));
        lnV.setForeground(Color.white);
        label.add(lnV);

        lPB=new JLabel("poids brute");
        lPB.setBounds(510,150,120,60);
        lPB.setFont(new Font("Arial", Font.BOLD, 16));
        lPB.setForeground(Color.white);
        label.add(lPB);


        lPT=new JLabel("poids de tarage");
        lPT.setBounds(510,80,120,60);
        lPT.setFont(new Font("Arial", Font.BOLD, 16));
        lPT.setForeground(Color.WHITE);
        label.add(lPT);

        lidOP=new JLabel("Id operation");
        lidOP.setBounds(350,10,120,70);
        lidOP.setFont(new Font("Arial", Font.BOLD, 16));
        lidOP.setForeground(Color.WHITE);
        label.add(lidOP);


        //Bouttons
        annuler=new JButton("Annuler");
        enregistrer=new JButton("Enregistrer");
        annuler.setBounds(520,230,100,40);
        annuler.setFont(new Font("Serif",Font.PLAIN,18));
        annuler.setBackground(new Color(250, 229, 211));
        annuler.setBorder(BorderFactory.createRaisedBevelBorder());
        label.add(annuler);

        enregistrer.setBounds(350,230,100,40);
        enregistrer.setFont(new Font("Serif",Font.PLAIN,18));
        enregistrer.setBackground(new Color(250, 229, 211));
        enregistrer.setBorder(BorderFactory.createRaisedBevelBorder());
        label.add(enregistrer);

        this.add(label);
        this.setLayout(null);
        this.setLocation(200, 50);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }

    public JButton getAnnuler() {
        return annuler;
    }

    public JButton getEnregistrer() {
        return enregistrer;
    }

    public void updateTable(TableModel tableModel){
        table=new JTable();
        jScrollPane=new JScrollPane(table);
        table.setModel(tableModel);
        jScrollPane.setBounds(0, 300, 900, table.getPreferredSize().height + 20);
        label.add(jScrollPane);
    }

}
