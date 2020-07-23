package VKI;

import java.text.DecimalFormat;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Vki extends JFrame implements ActionListener {
	
	private JTextField txtboy;
	private JTextField txtkilo;
	private JTextField txtyas;
	private JLabel lblboy;
	private JLabel lblbaslik;
	private JLabel lblkilo;
	private JLabel lblyas;
	private JLabel lblcinsiyet;
	private JLabel lbluyari;
    private JRadioButton cherkek;
    private JRadioButton chkadin;
    private ButtonGroup bg;
    private JButton btn1;
    private JButton btn2;
    private double boy;
    private double kilo;
    private double yas;
    private double sonuc=0;
    private JLabel lbldurum;
    private JLabel lblsonuc;
    private JLabel lblkitle;
    private JLabel lblkitle2;
    DecimalFormat df = new DecimalFormat("####0.00");
    
	public Vki(){
		
		txtboy=new JTextField(3);
		txtkilo=new JTextField(3);
		txtyas=new JTextField(2);
		lblbaslik=new JLabel("Vücut Kitle Endeksi Hesaplama");
		lblboy=new JLabel("Boyunuzu giriniz   :");
		lblkilo=new JLabel("Kilonuzu giriniz     :");
		lblyas=new JLabel("Yaşınızı giriniz       :");
		lblcinsiyet=new JLabel("Cinsiyet                   :");
		lbluyari=new JLabel("");
		lbldurum=new JLabel("");
		lblsonuc=new JLabel("");
		lblkitle=new JLabel("");
		lblkitle2=new JLabel("");
		cherkek=new JRadioButton("Erkek");
		chkadin=new JRadioButton("Kadın");
		btn1=new JButton("Temizle");
		btn2=new JButton("Hesapla");
		bg=new ButtonGroup();
		bg.add(cherkek);
		bg.add(chkadin);
		btn1.addActionListener(this);
	    btn2.addActionListener(this);
		cherkek.addActionListener(this);
	    chkadin.addActionListener(this);
		pack();
		setSize(400,400);
	    setLocationRelativeTo(null);
	    setResizable(false);
	    setTitle("VKI Hesaplama");
		pencereGoster();
	}
	
	public static void main(String[]args) {
		Vki vki = new Vki();
		vki.setVisible(true);
	}
		
	public void pencereGoster(){
		
		Container con=this.getContentPane();
		con.setLayout(null); 
		con.setBackground(Color.GRAY);
		txtboy.setBounds(185,50,150,25);
		txtboy.setHorizontalAlignment(JLabel.CENTER);
		txtboy.setBorder(null);
		txtboy.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txtboy.getText().length() >= 3 )
	                e.consume();
	        }
	    });
		txtkilo.setBounds(185,90,150,25);
		txtkilo.setHorizontalAlignment(JLabel.CENTER);
		txtkilo.setBorder(null);
		txtkilo.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txtkilo.getText().length() >= 3 )
	                e.consume();
	        }
	    });
		txtyas.setBounds(185,130,150,25);
		txtyas.setHorizontalAlignment(JLabel.CENTER);
		txtyas.setBorder(null);
		txtyas.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txtyas.getText().length() >= 3 )
	                e.consume();
	        }
	    });
		lblboy.setBounds(50,50,120,25);
		lblboy.setForeground(Color.WHITE);
		lblkilo.setBounds(50,90,120,25);
		lblkilo.setForeground(Color.WHITE);
		lblyas.setBounds(50,130,120,25);
		lblyas.setForeground(Color.WHITE);
		lblcinsiyet.setBounds(50,170,120,25);
		lblcinsiyet.setForeground(Color.WHITE);
		lblbaslik.setBounds(0,10,380,25);
		lblbaslik.setHorizontalAlignment(JLabel.CENTER);
		lblbaslik.setFont(new Font("Courier", Font.BOLD, 18));
		lblbaslik.setForeground(Color.WHITE);
		lbldurum.setBounds(10,260,180,25);
		lbldurum.setFont(new Font("Courier", Font.CENTER_BASELINE, 13));
		lbldurum.setForeground(Color.WHITE);
		lbluyari.setBounds(0,260,400,25);
		lbluyari.setHorizontalAlignment(JLabel.CENTER);
		lbluyari.setFont(new Font("Courier", Font.BOLD, 13));
		lbluyari.setForeground(Color.red);
		lblsonuc.setBounds(10,285,180,50);
		lblsonuc.setFont(new Font("Courier", Font.CENTER_BASELINE, 13));
		lblsonuc.setForeground(Color.WHITE);
		lblkitle.setBounds(195,260,180,25);
		lblkitle.setFont(new Font("Courier", Font.CENTER_BASELINE, 13));
		lblkitle.setForeground(Color.WHITE);
		lblkitle2.setBounds(195,285,180,50);
		lblkitle2.setFont(new Font("Courier", Font.CENTER_BASELINE, 13));
		lblkitle2.setForeground(Color.WHITE);
		cherkek.setBounds(195,170,60,25);
		cherkek.setForeground(Color.WHITE);
		cherkek.setBackground(Color.GRAY);
		chkadin.setBounds(255,170,60,25);
		chkadin.setBackground(Color.GRAY);
		chkadin.setForeground(Color.WHITE);
		btn1.setBounds(185,205,70,30);
		btn1.setBackground(Color.WHITE);
		btn1.setForeground(Color.black);
		btn1.setBorder(null);
		btn1.setFont(new Font("Courier", Font.CENTER_BASELINE, 10));
		btn2.setBounds(265,205,70,30);
		btn2.setBorder(null);
		btn2.setBackground(Color.white);
		btn2.setForeground(Color.black);
		btn2.setFont(new Font("Courier", Font.CENTER_BASELINE, 10));
	    con.add(txtboy);
		con.add(txtkilo);
		con.add(txtyas);
		con.add(lblbaslik);
		con.add(lblcinsiyet);
		con.add(cherkek);
		con.add(chkadin);
		con.add(lblboy);
		con.add(lblkilo);
		con.add(lbluyari);
		con.add(lblyas);
		con.add(btn1);
		con.add(btn2);
		con.add(lblsonuc);
		con.add(lbldurum);
	    con.add(lblkitle);
	    con.add(lblkitle2);
	    
	}
	
	public void actionPerformed(ActionEvent e){

        if (e.getSource() == btn1) {
        	
        	bg.clearSelection();
        	txtboy.setText("");
        	txtkilo.setText("");
        	txtyas.setText("");
        	lbldurum.setText("");
        	lbluyari.setText("");
        	lbldurum.setOpaque(false);
        	lblsonuc.setText("");
        	lblsonuc.setOpaque(false);
        	lblkitle.setText("");
        	lblkitle.setOpaque(false);
        	lblkitle2.setText("");
        	lblkitle2.setOpaque(false);
        
        } 
        
        if (e.getSource() == btn2) {

        	if(txtyas.getText().equals("") || txtboy.getText().equals("") || txtkilo.getText().equals("")) { 
        		lbluyari.setText("Boş alan bırakmayınız!!!"); 
        	}
     
        	else{
                try {
                	lbluyari.setText("");
   	            	boy=Integer.parseInt(txtboy.getText());
   	  	            kilo=Integer.parseInt(txtkilo.getText());
   	  	            yas=Integer.parseInt(txtyas.getText());
		   	  	   	sonuc=kilo/((boy/100)*(boy/100));
		        	
		        	if(sonuc>=0 && sonuc<=18.4){
		        		sonucPencere();
		        		lblkitle2.setText("Zayıf");
		        		lblkitle2.setHorizontalAlignment(JLabel.CENTER);
		                lblkitle2.setBackground(Color.LIGHT_GRAY);
		           		lblkitle2.setOpaque(true);
		        	}
		        	if(sonuc>18.4 && sonuc<=24.9){
		        		sonucPencere();
		           		lblkitle2.setText("Normal Kilolu");
		           		lblkitle2.setHorizontalAlignment(JLabel.CENTER);
		                lblkitle2.setBackground(Color.LIGHT_GRAY);
		           		lblkitle2.setOpaque(true);
		        	}
		        	if(sonuc>24.9 && sonuc<=29.9){
		        		sonucPencere();
		           		lblkitle2.setText("Fazla Kilolu");
		           		lblkitle2.setHorizontalAlignment(JLabel.CENTER);
		                lblkitle2.setBackground(Color.LIGHT_GRAY);
		           		lblkitle2.setOpaque(true);
		        	}
		        	if(sonuc>29.9 && sonuc<=34.9){
		        		sonucPencere();
		           		lblkitle2.setText("I.Derece Obez");
		           		lblkitle2.setHorizontalAlignment(JLabel.CENTER);
		                lblkitle2.setBackground(Color.LIGHT_GRAY);
		           		lblkitle2.setOpaque(true);
		        	}
		        	if(sonuc>34.9 && sonuc<=44.9){
		        		sonucPencere();
		           	    lblkitle2.setText("II.Derece Obez");
		           	    lblkitle2.setHorizontalAlignment(JLabel.CENTER);
		                lblkitle2.setBackground(Color.LIGHT_GRAY);
		        		lblkitle2.setOpaque(true);
		        	}
		        	if(sonuc>=45){
		        		sonucPencere();
		           		lblkitle2.setText("III.Derece Obez");
		           		lblkitle2.setHorizontalAlignment(JLabel.CENTER);
		                lblkitle2.setBackground(Color.LIGHT_GRAY);
		           		lblkitle2.setOpaque(true);		
		        	}
   			    }
                catch (NumberFormatException nfe) {
   			    	txtboy.setText("");
   			    	txtkilo.setText("");
   			    	txtyas.setText("");
   			    	lbluyari.setText("Lütfen sayı giriniz!!!");
   			    }
     
        	}
        }
	}
	
	public void sonucPencere() {
		
		lbldurum.setText("Vücut Kitle İndeksiniz");
		lbldurum.setHorizontalAlignment(JLabel.CENTER);
		lbldurum.setBackground(Color.DARK_GRAY);
		lbldurum.setOpaque(true);
        lblsonuc.setText(df.format(sonuc));
        lblsonuc.setHorizontalAlignment(JLabel.CENTER);
        lblsonuc.setBackground(Color.lightGray);
		lblsonuc.setOpaque(true);
		lblkitle.setText("Vücut Kitle Endeks Aralığı");
		lblkitle.setHorizontalAlignment(JLabel.CENTER);
        lblkitle.setBackground(Color.DARK_GRAY);
   		lblkitle.setOpaque(true);
   		
	}
}
