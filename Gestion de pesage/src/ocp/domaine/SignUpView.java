package ocp.domaine;

import javax.swing.*;
import java.awt.*;

public class SignUpView extends LoginView {
    private JButton confirmer,annuler;
    public SignUpView(){
        super.getLogin().setBounds(0,0,0,0);
        super.getSignUp().setBounds(0,0,0,0);
        this.setTitle("Sign up");

        confirmer=new JButton("Valider");
        annuler=new JButton("Annuler");
        confirmer.setFont(new Font("Arial",Font.BOLD,17));
        confirmer.setBounds(350,280,90,40);
        confirmer.setBackground(new Color(199, 199, 199, 224));
        confirmer.setBorder(BorderFactory.createRaisedBevelBorder());

        annuler.setFont(new Font("Arial",Font.BOLD,17));
        annuler.setBounds(520,280,90,40);
        annuler.setBackground(new Color(199, 199, 199, 224));
        annuler.setBorder(BorderFactory.createRaisedBevelBorder());
        label.add(annuler);
        this.label.add(confirmer);

    }

    public JButton getConfirmer() {
        return confirmer;
    }

    public JButton getAnnuler() {
        return annuler;
    }


}
