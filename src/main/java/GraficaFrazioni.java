
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class GraficaFrazioni extends JFrame implements ActionListener  
{
        private Container c = new Container();    //Container, conterrà tutta l'interfaccia.
        private JPanel p1 = new JPanel();         //JPanel, conterrà tutti i JButton, JTextField e JLabel.
        private JLabel numeratore = new JLabel ("Inserire Numeratore:");     //JLabel con scritto "Inserire Numeratore".
        private JLabel denominatore = new JLabel("Inserire Denominatore:");  //JLabel con scritto "Inserire Denominatore". 
        private JLabel risultato = new JLabel("");                           //JLabel vuoto che ha la funzione di stampare il risultato delle Frazioni.
        private JTextField N = new JTextField();                             //JTextField serve come input per inserire il Numeratore o Denominatore
        private JTextField D = new JTextField();
        private JTextField N1 = new JTextField();
        private JTextField D1 = new JTextField();
        private JButton bottoneReciproco = new JButton("Reciproco");         //JButton ha la funzione di generare un evento, in questo caso l'evento del Reciproco.
        private JButton bottoneSomma = new JButton("Somma");                 //JButton genera l'evento della somma
        private JButton bottoneSottrazione = new JButton("Sottrazione");     //JButton genera l'evento della sottrazione
        private JButton bottoneProdotto = new JButton("Prodotto");           //JButton genera l'evento del prodotto
        private JButton bottoneQuoziente = new JButton("Quoziente");         //JButton genera l'evento del quoziente.
        
    public GraficaFrazioni()          //Questo è il costruttore dove impostiamo tutti i parametri necessari per creare la nostra grafica
    {
        c = this.getContentPane();      
        p1.setLayout(null);          //Il layout viene impostato a NULL, in modo da poter gestire liberamente dove collocare ogni componente.
        this.setTitle("Frazioni");                              //Imposta il titolo alla finestra.
        this.setVisible(true);                                  //Imposta la finestra visibile.
        this.setLocationRelativeTo(null);                       //Imposta la finestra al centro dello schermo
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //Imposta la chiusura della finestra
        this.setSize(250, 300);                                 //Imposta la grandezza del Frame(la finestra)
        this.setResizable(false);                               //Imposta in modo che la finestra non si possa ridimensionare
        p1.setBackground(Color.orange);                         //Imposta lo sfondo del JPanel.
        
        
        //Qui vengono inserite tutte le cordinate e dimensioni di ogni singolo elemento. setBounds(x, y, lunghezza, larghezza)
        
        numeratore.setBounds(60, 5, 140, 50);
        denominatore.setBounds(60, 65, 140, 50);
        risultato.setBounds(105, 110, 160, 50);
        N.setBounds(120, 45, 20, 20);
        N1.setBounds(90, 45, 20, 20);
        D1.setBounds(90, 105, 20, 20);
        D.setBounds(120, 105, 20, 20);
        bottoneReciproco.setBounds(20, 155, 90, 20);
        bottoneSomma.setBounds(130, 155, 90, 20);
        bottoneSottrazione.setBounds(20, 180, 90, 20);
        bottoneProdotto.setBounds(130, 180, 90, 20);
        bottoneQuoziente.setBounds(75, 205, 90, 20);
        
        
        //Qui viene impostato il font ad ogni singolo bottone
        
        bottoneReciproco.setFont(new Font("Arial", Font.PLAIN, 11));
        bottoneSomma.setFont(new Font("Arial", Font.PLAIN, 11));
        bottoneSottrazione.setFont(new Font("Arial", Font.PLAIN, 11));
        bottoneProdotto.setFont(new Font("Arial", Font.PLAIN, 11));   
        bottoneQuoziente.setFont(new Font("Arial", Font.PLAIN, 11));
        bottoneReciproco.setFont(new Font("Arial", Font.PLAIN, 11));
              
        //Viene aggiunto al JPanel ogni singolo componente e infine il JPanle viene aggiunto al Container
        
        p1.add(numeratore);
        p1.add(denominatore);
        p1.add(risultato);
        p1.add(N);
        p1.add(D);
        p1.add(N1);
        p1.add(D1);
        p1.add(bottoneReciproco);
        p1.add(bottoneSomma);
        p1.add(bottoneSottrazione);
        p1.add(bottoneProdotto);
        p1.add(bottoneQuoziente);
        c.add(p1);
        
        //Qui viene impostato l'ascoltatore dell'evento che viene generato.
        
        bottoneReciproco.addActionListener(this);
        bottoneSomma.addActionListener(this);
        bottoneSottrazione.addActionListener(this);
        bottoneProdotto.addActionListener(this);
        bottoneQuoziente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) //Questo metodo ci permette di gestire gli eventi generati.
    {
        String evento = e.getActionCommand();   //Questa Stringa cattura l'evento generato, così facendo possiamo gestirlo
        String letturaNumeratore;               //Legge il JTextField del Numeratore, ovvero il dato che viene inserito dall'utente.
        String letturaDenominatore;
        String letturaNumeratore1;
        String letturaDenominatore1;
        String outputRisultato = null;          
        Razionale stampa;                       //Oggetto per poter stampare il risultato

        switch(evento)                          //Switch per gestire l'evento e capire quale evento è stato generato
        {
            case "Reciproco":                   
                letturaNumeratore = N.getText();      //Legge il Numeratore nel JTextField di N
                letturaDenominatore = D.getText();    //Legge il Denominatore nel JTextField di D
                letturaNumeratore1 = N1.getText();     
                letturaDenominatore1 = D1.getText(); 
                
                //Instanza dell'oggetto per poter inserire i dati e calcolarli. Viene usato Integer.valueOf per poter convertire una stringa in un numero
                
                Razionale frazione = new Razionale(Integer.valueOf(letturaNumeratore), Integer.valueOf(letturaDenominatore));   
                Razionale frazione1 = new Razionale(Integer.valueOf(letturaNumeratore1), Integer.valueOf(letturaDenominatore1));
                
                stampa = frazione.reciproco();              //Chiamo il metodo reciproco per la prima frazione
                outputRisultato = stampa.toString();        //Lo salvo in outputRisultato
                stampa = frazione1.reciproco();             //Chiamo il metodo reciproco per la seconda frazione
                outputRisultato += " | ";                   //Concateno al risultato " | " per poter dividere le due frazioni.
                outputRisultato += stampa.toString();       //concateno il risultato della seconda frazione
                risultato.setText(outputRisultato);         //Infine stampo il risultato nel JLabel risultato
                break;
                
            case "Somma":                       //Il Procedimento è lo stesso per tutti gli altri casi, cambia soltanto il richiamo di alcuni metodi.
                letturaNumeratore = N.getText();
                letturaDenominatore = D.getText();
                letturaNumeratore1 = N1.getText();
                letturaDenominatore1 = D1.getText();
                Razionale fraziones1 = new Razionale(Integer.valueOf(letturaNumeratore), Integer.valueOf(letturaDenominatore));
                Razionale fraziones2 = new Razionale(Integer.valueOf(letturaNumeratore1), Integer.valueOf(letturaDenominatore1));
                stampa = fraziones1.somma(fraziones2);
                risultato.setText(stampa.toString());
                break;
            
            case "Sottrazione":
                letturaNumeratore = N.getText();
                letturaDenominatore = D.getText();
                letturaNumeratore1 = N1.getText();
                letturaDenominatore1 = D1.getText();
                Razionale frazionesot1 = new Razionale(Integer.valueOf(letturaNumeratore), Integer.valueOf(letturaDenominatore));
                Razionale frazionesot2 = new Razionale(Integer.valueOf(letturaNumeratore1), Integer.valueOf(letturaDenominatore1));
                stampa = frazionesot1.sottrazione(frazionesot2);
                risultato.setText(stampa.toString());
                break;
                
            case "Prodotto":
                letturaNumeratore = N.getText();
                letturaDenominatore = D.getText();
                letturaNumeratore1 = N1.getText();
                letturaDenominatore1 = D1.getText();
                Razionale frazionepr1 = new Razionale(Integer.valueOf(letturaNumeratore), Integer.valueOf(letturaDenominatore));
                Razionale frazionepr2 = new Razionale(Integer.valueOf(letturaNumeratore1), Integer.valueOf(letturaDenominatore1));
                stampa = frazionepr1.prodotto(frazionepr2);
                risultato.setText(stampa.toString());
                break;
                
            case "Quoziente":
                letturaNumeratore = N.getText();
                letturaDenominatore = D.getText();
                letturaNumeratore1 = N1.getText();
                letturaDenominatore1 = D1.getText();
                Razionale frazioneq1 = new Razionale(Integer.valueOf(letturaNumeratore), Integer.valueOf(letturaDenominatore));
                Razionale frazioneq2 = new Razionale(Integer.valueOf(letturaNumeratore1), Integer.valueOf(letturaDenominatore1));
                stampa = frazioneq1.quoziente(frazioneq2);
                risultato.setText(stampa.toString());
                break;
        }
    }
}
