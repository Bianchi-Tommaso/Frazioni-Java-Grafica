
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class GraficaFrazioni extends JFrame implements ActionListener
{
        private Container c = new Container();
        private JPanel p1 = new JPanel();
        private JLabel numeratore = new JLabel ("Inserire Numeratore:");
        private JLabel denominatore = new JLabel("Inserire Denominatore:");
        private JLabel risultato = new JLabel("");
        private JTextField N = new JTextField();
        private JTextField D = new JTextField();
        private JTextField N1 = new JTextField();
        private JTextField D1 = new JTextField();
        private JButton bottoneReciproco = new JButton("Reciproco");
        private JButton bottoneSomma = new JButton("Somma");
        private JButton bottoneSottrazione = new JButton("Sottrazione");
        private JButton bottoneProdotto = new JButton("Prodotto");
        private JButton bottoneQuoziente = new JButton("Quoziente");
        
    public GraficaFrazioni() 
    {
        c = this.getContentPane();
        p1.setLayout(null);
        this.setTitle("Frazioni");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(250, 300);
        this.setResizable(false); 
        p1.setBackground(Color.orange);
        
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
        
        bottoneReciproco.addActionListener(this);
        bottoneSomma.addActionListener(this);
        bottoneSottrazione.addActionListener(this);
        bottoneProdotto.addActionListener(this);
        bottoneQuoziente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String evento = e.getActionCommand();
        String letturaNumeratore;
        String letturaDenominatore;
        String letturaNumeratore1;
        String letturaDenominatore1;
        String outputRisultato = null;
        Razionale stampa;

        switch(evento)
        {
            case "Reciproco":
                letturaNumeratore = N.getText();
                letturaDenominatore = D.getText();
                letturaNumeratore1 = N1.getText();
                letturaDenominatore1 = D1.getText();
                Razionale frazione = new Razionale(Integer.valueOf(letturaNumeratore), Integer.valueOf(letturaDenominatore));
                Razionale frazione1 = new Razionale(Integer.valueOf(letturaNumeratore1), Integer.valueOf(letturaDenominatore1));
                stampa = frazione.reciproco();
                outputRisultato = stampa.toString();
                stampa = frazione1.reciproco();
                outputRisultato += "|";
                outputRisultato += stampa.toString();
                risultato.setText(outputRisultato);
                break;
                
            case "Somma":
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
