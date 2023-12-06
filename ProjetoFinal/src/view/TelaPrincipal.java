package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TelaPrincipal extends JFrame implements ActionListener { 
	
	public JButton btnReservar;
	public JButton btnConsultar;
	public JButton btnCancelar;

    public TelaPrincipal() {
        super("Tela Principal");
        setLayout(new BorderLayout());

        JPanel panelBotoes = new JPanel(new FlowLayout());
        btnReservar = new JButton("Reservar");
        btnReservar.addActionListener(this);
        panelBotoes.add(btnReservar);
        
        btnConsultar = new JButton("Consultar");
        btnConsultar.addActionListener(this);
        panelBotoes.add(btnConsultar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        panelBotoes.add(btnCancelar);

        add(panelBotoes, BorderLayout.CENTER);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Instancia a tela principal
        TelaPrincipal telaPrincipal = new TelaPrincipal();

        // Define a visibilidade para true para exibir a janela
        telaPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReservar) {
            new TelaReserva();
        } else if (e.getSource() == btnConsultar) {
            new TelaConsulta();
        } else if (e.getSource() == btnCancelar) {
            new TelaCancelamento();
        }
    }   
}