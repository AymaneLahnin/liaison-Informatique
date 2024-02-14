package ocp.domaine;




import ocp.controlleur.DbDisplay;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChercherView extends JFrame{

    private JTextField tfInput;
    private JLabel label;

    private JButton back;
    private JButton valider;
    private JTable dateTable;
    private JScrollPane dateJsp;
    private ImageIcon img;

    public ChercherView() {
        this.setSize(800, 500);
        this.setTitle("verification des poids");


        dateTable = new JTable();

        dateJsp = new JScrollPane(dateTable);


        img = new ImageIcon("C://Users//aymane lahnin//Desktop//Gestion de pesage//pictures//cpesage.png");
        label = new JLabel(img);
        label.setBounds(0, 0, 800, 500);


        back = new JButton("Annuler");
        back.setBounds(470, 90, 100, 40);
        back.setBorder(BorderFactory.createRaisedBevelBorder());
        back.setBackground(new Color(250, 229, 211));
        back.setFont(new Font("serif", Font.PLAIN, 18));

        label.add(back);

        tfInput = new JTextField();
        tfInput.setBorder(BorderFactory.createRaisedBevelBorder());
        tfInput.setBackground(new Color(199, 199, 199, 224));
        tfInput.setFont(new Font("serif", Font.PLAIN, 18));
        tfInput.setBounds(280, 50, 300, 30);
        JLabel search = new JLabel("Saisir votre choix");
        search.setForeground(Color.BLACK);
        search.setBounds(280, -5, 180, 80);
        search.setFont(new Font("serif", Font.PLAIN, 20));
        label.add(tfInput);
        label.add(search);


        valider = new JButton("Chercher");
        valider.setBounds(290, 90, 100, 40);
        valider.setBorder(BorderFactory.createRaisedBevelBorder());
        valider.setBackground(new Color(250, 229, 211));
        valider.setFont(new Font("serif", Font.PLAIN, 18));

        label.add(valider);


        this.add(label);
        this.setLayout(null);
        this.setLocation(200, 50);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }


    public JTextField getTfInput() {
        return this.tfInput;
    }

    public JButton getValider() {
        return this.valider;
    }

    public JButton getBack() {
        return this.back;
    }

    public void showData(TableModel tableModel) {
        dateTable.setModel(tableModel);
        dateJsp.setBounds(0, 150, 785, dateTable.getPreferredSize().height + 20);
        label.add(dateJsp);
    }

}
