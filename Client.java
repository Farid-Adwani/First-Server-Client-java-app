import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.JFormattedTextField;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;

import java.awt.Color;
public class Client extends JFrame implements ActionListener {
    IBank stub;
    public int select;
    public JButton solde;
    public JButton etat;
    public JButton ajouter;
    public JButton retirer;
    public JButton transfert;
    public JButton creer;
    public JButton ok;
    public JLabel hello;
    public JLabel label;
    public JLabel id;
    public JLabel id2;
    public JLabel Mdp;
    public JLabel Mdp2;
    public JLabel Nom;
    public JLabel Prenom;
    public JLabel montant;
    public JFormattedTextField wid;
    public JFormattedTextField wid2;
    public JFormattedTextField wmdp;
    public JFormattedTextField wmdp2;
    public JFormattedTextField wnom;
    public JFormattedTextField wPrenom;
    public JFormattedTextField wmontant;
     

    
    

    public Client(IBank stub) {
        this.stub=stub;
        this.setSize(610,500);
        this.setTitle("Banque");
        this.setLayout(null);
        this.setLocation(510,150);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        Image icon = Toolkit.getDefaultToolkit().getImage("billet-de-banque.png"); 
        this.setIconImage(icon);     
        try {
          this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("moneydt.jpg")))));
      } catch (IOException e) {
          e.printStackTrace();
      }
        
    
        solde = new JButton("Voir Solde");
       solde.setBounds(0,50,150,50); 
       this.add(solde);

        
         etat = new JButton("Etat Compte");
        etat.setBounds(150,50,150,50); 
        this.add(etat);
          ajouter = new JButton("Ajouter au Compte");
        ajouter.setBounds(300,50,150,50); 
        this.add(ajouter);
          retirer = new JButton("Retirer de Compte");
        retirer.setBounds(450,50,150,50); 
        this.add(retirer);
          transfert = new JButton("Transfert");
        transfert.setBounds(150,100,150,50); 
        this.add(transfert);
          creer= new JButton("Creer un Compte");
        creer.setBounds(300,100,150,50); 
        this.add(creer);

          label =new JLabel("Bienvenue, Veuillez choisisser une option et ecrire les donnees.");
        label.setForeground(Color.BLUE);
        label.setHorizontalAlignment(0);             
        label.setBounds(0,0,610,60);
        this.add(label);

          id =new JLabel("ID :");
        id.setForeground(Color.BLACK);
        id.setHorizontalAlignment(2);               
        id.setBounds(50,170,100,30);
        this.add(id);

        wid=new JFormattedTextField();
        wid.setBounds(150,170,150,30);
        this.add(wid);

        montant =new JLabel("Montant en DT :");
        montant.setForeground(Color.BLACK);
        montant.setHorizontalAlignment(2);               
        montant.setBounds(310,170,120,30);
        this.add(montant);

        wmontant=new JFormattedTextField();
        wmontant.setBounds(430,170,150,30);
        this.add(wmontant);

         

          Mdp =new JLabel("Mot De Passe :");
        Mdp.setForeground(Color.BLACK);
        Mdp.setHorizontalAlignment(2);               
        Mdp.setBounds(50,200,100,30);
        this.add(Mdp);

          wmdp=new JFormattedTextField();
        wmdp.setBounds(150,200,150,30);
        this.add(wmdp);

          Mdp2 =new JLabel("Confirmer votre Mdp:");
        Mdp2.setForeground(Color.BLACK);
        Mdp2.setHorizontalAlignment(2);               
        Mdp2.setBounds(310,200,120,30);
        this.add(Mdp2);
        
          wmdp2=new JFormattedTextField();
        wmdp2.setBounds(430,200,150,30);
        this.add(wmdp2);

          id2 =new JLabel("ID de Recepteur :");
        id2.setForeground(Color.BLACK);
        id2.setHorizontalAlignment(2);               
        id2.setBounds(50,230,100,30);
        this.add(id2);

          wid2=new JFormattedTextField();
        wid2.setBounds(150,230,150,30);
        this.add(wid2);

          Prenom =new JLabel("Prenom :");
        Prenom.setForeground(Color.BLACK);
        Prenom.setHorizontalAlignment(2);               
        Prenom.setBounds(50,260,100,30);
        this.add(Prenom);

         wPrenom=new JFormattedTextField();
        wPrenom.setBounds(150,260,150,30);
        this.add(wPrenom);

          Nom =new JLabel("Nom :");
        Nom.setForeground(Color.BLACK);
        Nom.setHorizontalAlignment(2);               
        Nom.setBounds(50,290,100,30);
        this.add(Nom);

          wnom=new JFormattedTextField();
        wnom.setBounds(150,290,150,30);
        this.add(wnom);

          ok= new JButton("OK");
       ok.setBounds(250,325,70,50); 
       this.add(ok);

          hello=new JLabel(".......................................");
        hello.setHorizontalAlignment(0);
        hello.setBounds(0,375, 610, 50);
        hello.setForeground(Color.RED);
        this.add(hello);

        id.setVisible(false);
        wid.setVisible(false);
        montant.setVisible(false);
        wmontant.setVisible(false);
        id2.setVisible(false);
        wid2.setVisible(false);
        Nom.setVisible(false);
        wnom.setVisible(false);
        Prenom.setVisible(false);
        wPrenom.setVisible(false);
        Mdp.setVisible(false);
        wmdp.setVisible(false);
        Mdp2.setVisible(false);
        wmdp2.setVisible(false);
        
        this.setVisible(true);
        solde.addActionListener(this);
        etat.addActionListener(this);
        transfert.addActionListener(this);
        ajouter.addActionListener(this);
        retirer.addActionListener(this);
        creer.addActionListener(this);
        ok.addActionListener(this);
              
    }
    public void actionPerformed(ActionEvent e){
        try{
        if (e.getSource()== solde) {
            this.select=1;
        id.setVisible(true);
        wid.setVisible(true);
        montant.setVisible(false);
        wmontant.setVisible(false);
        id2.setVisible(false);
        wid2.setVisible(false);
        Nom.setVisible(false);
        wnom.setVisible(false);
        Prenom.setVisible(false);
        wPrenom.setVisible(false);
        Mdp.setVisible(true);
        wmdp.setVisible(true);
        Mdp2.setVisible(false);
        wmdp2.setVisible(false);
        hello.setText("Accees au Solde...");
        // System.out.println("solde");
    }
    if (e.getSource()== creer) {
        this.select=6;
        id.setVisible(false);
        wid.setVisible(false);
        montant.setVisible(false);
        wmontant.setVisible(false);
        id2.setVisible(false);
        wid2.setVisible(false);
        Nom.setVisible(true);
        wnom.setVisible(true);
        Prenom.setVisible(true);
        wPrenom.setVisible(true);
        Mdp.setVisible(true);
        wmdp.setVisible(true);
        Mdp2.setVisible(true);
        wmdp2.setVisible(true);
        hello.setText("Creation de Compte...");
        // System.out.println("creer");
    }
    if (e.getSource()== transfert) {
        this.select=5;        
        id.setVisible(true);
        wid.setVisible(true);
        montant.setVisible(true);
        wmontant.setVisible(true);
        id2.setVisible(true);
        wid2.setVisible(true);
        Nom.setVisible(false);
        wnom.setVisible(false);
        Prenom.setVisible(false);
        wPrenom.setVisible(false);
        Mdp.setVisible(true);
        wmdp.setVisible(true);
        Mdp2.setVisible(false);
        wmdp2.setVisible(false);
        hello.setText("Transfert...");
        // System.out.println("transfer");
    }
    if (e.getSource()== retirer) {
        this.select=4;
        id.setVisible(true);
        wid.setVisible(true);
        montant.setVisible(true);
        wmontant.setVisible(true);
        id2.setVisible(false);
        wid2.setVisible(false);
        Nom.setVisible(false);
        wnom.setVisible(false);
        Prenom.setVisible(false);
        wPrenom.setVisible(false);
        Mdp.setVisible(true);
        wmdp.setVisible(true);
        Mdp2.setVisible(false);
        wmdp2.setVisible(false);
        hello.setText("Retirement...");
        // System.out.println("retirer");
    }
    if (e.getSource()== ajouter) {
        this.select=3;
        id.setVisible(true);
        wid.setVisible(true);
        montant.setVisible(true);
        wmontant.setVisible(true);
        id2.setVisible(false);
        wid2.setVisible(false);
        Nom.setVisible(false);
        wnom.setVisible(false);
        Prenom.setVisible(false);
        wPrenom.setVisible(false);
        Mdp.setVisible(true);
        wmdp.setVisible(true);
        Mdp2.setVisible(false);
        wmdp2.setVisible(false);
        hello.setText("Ajout d'argent...");
        // System.out.println("ajouter");
    }
    if (e.getSource()==etat) {
        this.select=2;
        id.setVisible(true);
        wid.setVisible(true);
        montant.setVisible(false);
        wmontant.setVisible(false);
        id2.setVisible(false);
        wid2.setVisible(false);
        Nom.setVisible(false);
        wnom.setVisible(false);
        Prenom.setVisible(false);
        wPrenom.setVisible(false);
        Mdp.setVisible(true);
        wmdp.setVisible(true);
        Mdp2.setVisible(false);
        wmdp2.setVisible(false);
        hello.setText("Accees a l'etat du Compte...");
        // System.out.println("etat");
    }
    if (e.getSource()==ok) {
      
        //hello.setText("Operation en cours....."); 
        if(select==6){
          if(wmdp.getText().equals("") || wmdp2.getText().equals("") || wnom.getText().equals("") || wPrenom.getText().equals("")){
            hello.setText("Attention, il faut remplir tput les champs .");
          }else{
            if(!(wmdp.getText()).equals(wmdp2.getText())|| (wmdp.getText()).equals("") ){
              hello.setText("les 2 mots de passe ne sont pas identiques.");
          }else{
              hello.setText("Operation en cours....");
              hello.setText(stub.creerCompte(wmdp.getText(),wnom.getText(),wPrenom.getText()));
          }
          }
            

        }else if(select==1){
          if(wmdp.getText().equals("") || wid.getText().equals("")){
            hello.setText("Attention, il faut remplir tput les champs .");
          }else{
            if((Integer.parseInt(wid.getText()))>stub.getnum()  || (Integer.parseInt(wid.getText()))<0){
              hello.setText("ID introuvable, veuillez ressayer..."); 
              }else{   
                  hello.setText(stub.getValeur(Integer.parseInt(wid.getText()),wmdp.getText()));
              }
          }
            

        }else if(select==2){
          if(wmdp.getText().equals("") || wid.getText().equals("")){
            hello.setText("Attention, il faut remplir tput les champs .");
          }else{
            if((Integer.parseInt(wid.getText()))>stub.getnum()  || (Integer.parseInt(wid.getText()))<0){
              hello.setText("ID introuvable, veuillez ressayer..."); 
          }else{
              hello.setText(stub.etatCompte(Integer.parseInt(wid.getText()),wmdp.getText()));
          }
          }
            
            
        }else if(select==3){
          if(wmdp.getText().equals("") || wid.getText().equals("") || wmontant.getText().equals("")){
            hello.setText("Attention, il faut remplir tput les champs .");
          }else{
            if((Integer.parseInt(wid.getText()))>stub.getnum()  || (Integer.parseInt(wid.getText()))<0){
              hello.setText("ID introuvable, veuillez ressayer..."); 
          }else{
              hello.setText(stub.ajouterSurCompte(Integer.parseInt(wid.getText()),wmdp.getText(),Float.parseFloat(wmontant.getText())));
          }
          }
           
        }else if(select==4){
          if(wmdp.getText().equals("") || wid.getText().equals("") || wmontant.getText().equals("")){
            hello.setText("Attention, il faut remplir tput les champs .");
          }else{
            if((Integer.parseInt(wid.getText()))>stub.getnum()  || (Integer.parseInt(wid.getText()))<0){
              hello.setText("ID introuvable, veuillez ressayer..."); 
          }else{
              hello.setText(stub.enleverSurCompte(Integer.parseInt(wid.getText()),wmdp.getText(),Float.parseFloat(wmontant.getText())));
          }
          }
            
        }else if(select==5){
          if(wmdp.getText().equals("") || wid.getText().equals("") || wid2.getText().equals("") || wmontant.getText().equals("")){
            hello.setText("Attention, il faut remplir tput les champs .");
          }else{
            if((Integer.parseInt(wid.getText()))>stub.getnum()  || (Integer.parseInt(wid.getText()))<0){
              hello.setText("ID introuvable, veuillez ressayer..."); 
          }else{
              hello.setText(stub.transfertEntreComptes(Integer.parseInt(wid.getText()),wmdp.getText(),Integer.parseInt(wid2.getText()),Float.parseFloat(wmontant.getText())));
          }
          }
            
        }

        wPrenom.setText("");
        wid.setText("");
        wid2.setText("");
        wmdp.setText("");
        wmdp2.setText("");
        wmontant.setText("");
        wnom.setText("");
    }
   }   catch (Exception ex) {
    System.err.println("Client exception: " + ex.toString());
    ex.printStackTrace(); }
    }

    public static void main(String[] args) {
        

        try {
            System.out.println("Lancement...");
            Registry reg = LocateRegistry.getRegistry();
            
            
            IBank stub = (IBank) reg.lookup("bankServeurClient");
            Client fr=new Client(stub);
             
            } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace(); }
        }
        }

        


    