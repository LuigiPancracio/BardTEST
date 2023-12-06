package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.UUID;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Reserva;

import java.awt.Color;
import java.awt.GridLayout;

public class TelaReserva extends JFrame implements ActionListener {

    public JTextField txtNome;
    public JTextField txtEmail;
    public JTextField txtTelefone;
    public JTextField txtDataCheckIn;
    public JTextField txtDataCheckOut;
    public JTextField txtNumeroQuarto;
    public JTextField txtTipoQuarto;
    public JTextField txtNumeroHospedes;
    public JTextField txtNecessidadesEspeciais;
    public JTextField txtMetodoPagamento;
    public JTextField txtTotalAPagar;
    public JButton btnConfirmar;

    public TelaReserva() {
        super("Reservar Quarto");

        JPanel panelDados = new JPanel();
        
        txtNome = new JTextField();
        txtNome.setBounds(88, 29, 140, 19);
        panelDados.setLayout(null);
        JLabel label = new JLabel("Nome:");
        label.setBounds(35, 32, 51, 13);
        panelDados.add(label);
        panelDados.add(txtNome);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(88, 58, 140, 19);
        JLabel label_1 = new JLabel("E-mail:");
        label_1.setBounds(35, 61, 51, 13);
        panelDados.add(label_1);
        panelDados.add(txtEmail);
        txtTelefone = new JTextField();
        txtTelefone.setBounds(88, 87, 140, 19);
        
        JLabel label_2 = new JLabel("Telefone:");
        label_2.setForeground(new Color(0, 0, 0));
        label_2.setBounds(18, 90, 68, 13);
        panelDados.add(label_2);
        panelDados.add(txtTelefone);
        txtDataCheckIn = new JTextField();
        txtDataCheckIn.setBounds(267, 58, 88, 19);
        
        JLabel label_3 = new JLabel("Data de Check-in:");
        label_3.setBounds(267, 32, 121, 13);
        panelDados.add(label_3);
        panelDados.add(txtDataCheckIn);
        txtDataCheckOut = new JTextField();
        
        JLabel label_4 = new JLabel("Data de Check-out:");
        label_4.setBounds(398, 32, 122, 13);
        panelDados.add(label_4);
        txtNumeroQuarto = new JTextField();
        txtNumeroQuarto.setBounds(398, 87, 96, 19);
        
        JLabel label_5 = new JLabel("Número do quarto:");
        label_5.setBounds(264, 96, 121, 13);
        panelDados.add(label_5);
        panelDados.add(txtNumeroQuarto);

        txtTipoQuarto = new JTextField();
        txtTipoQuarto.setBounds(398, 116, 96, 19);
        JLabel label_6 = new JLabel("Tipo de quarto:");
        label_6.setBounds(263, 119, 96, 13);
        panelDados.add(label_6);
        panelDados.add(txtTipoQuarto);

        txtNumeroHospedes = new JTextField();
        txtNumeroHospedes.setBounds(398, 145, 96, 19);
        JLabel label_7 = new JLabel("Número de hóspedes:");
        label_7.setBounds(270, 148, 136, 13);
        panelDados.add(label_7);
        panelDados.add(txtNumeroHospedes);

        txtNecessidadesEspeciais = new JTextField();
        txtNecessidadesEspeciais.setBounds(156, 190, 309, 19);
        JLabel label_8 = new JLabel("Necessidades especiais:");
        label_8.setBounds(18, 193, 122, 13);
        panelDados.add(label_8);
        panelDados.add(txtNecessidadesEspeciais);

        txtMetodoPagamento = new JTextField();
        txtMetodoPagamento.setBounds(258, 243, 110, 19);
        JLabel label_9 = new JLabel("Método de pagamento:");
        label_9.setBounds(107, 246, 182, 13);
        panelDados.add(label_9);
        panelDados.add(txtMetodoPagamento);
        
        txtDataCheckOut = new JTextField();
        txtDataCheckOut.setBounds(398, 58, 96, 19);
        panelDados.add(txtDataCheckOut);
        txtDataCheckOut.setColumns(10);
        
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(206, 318, 200, 20);
        panelDados.add(btnConfirmar);
        btnConfirmar.addActionListener(this);
        getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
        
        getContentPane().add(panelDados);
        
        setSize(600, 400); // Ajuste o tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        panelDados.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == btnConfirmar) {
            // Obtém os valores dos campos de texto
            String nome = txtNome.getText();
            String email = txtEmail.getText();
            String telefone = txtTelefone.getText();
            LocalDate dataCheckIn = LocalDate.parse(txtDataCheckIn.getText());
            LocalDate dataCheckOut = LocalDate.parse(txtDataCheckOut.getText());
            int numeroQuarto = Integer.parseInt(txtNumeroQuarto.getText());
            int numeroHospedes = Integer.parseInt(txtNumeroHospedes.getText());
            double totalAPagar = Double.parseDouble(txtTotalAPagar.getText());

            // Cria uma nova reserva
            Reserva reserva = new Reserva(
                txtNome.getText(),
                txtEmail.getText(),
                txtTelefone.getText(),
                dataCheckIn,
                dataCheckOut,
                numeroQuarto,
                txtTipoQuarto.getText(),
                numeroHospedes,
                txtNecessidadesEspeciais.getText(),
                txtMetodoPagamento.getText(),
                totalAPagar,

                "Pendente",
                "",

                UUID.randomUUID().toString()
            );

            try {
                // Create a file to store the reservations
                File file = new File("reservas.txt");

                // Create a writer to write to the file
                FileWriter writer = new FileWriter(file);

                // Write the reservation to the file
                writer.write(reserva.getNome() + "\n");
                writer.write(reserva.getEmail() + "\n");
                writer.write(reserva.getTelefone() + "\n");
                writer.write(reserva.getDataCheckIn() + "\n");
                writer.write(reserva.getDataCheckOut() + "\n");
                writer.write(reserva.getNumeroQuarto() + "\n");
                writer.write(reserva.getTipoQuarto() + "\n");
                writer.write(reserva.getNumeroHospedes() + "\n");
                writer.write(reserva.getNecessidadesEspeciais() + "\n");
                writer.write(reserva.getMetodoPagamento() + "\n");
                writer.write(reserva.getTotalAPagar() + "\n");
                writer.write(reserva.getStatusReserva() + "\n");
                writer.write(reserva.getComentarios() + "\n");

               
                writer.close();

                // Exibe mensagem de confirmação
                JOptionPane.showMessageDialog(this, "Reserva realizada com sucesso!");
            } catch (IOException e) {
                // Handle the exception
                System.out.println("Erro ao salvar a reserva: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Erro ao salvar a reserva. Tente novamente mais tarde.");
            }
        }
    }
}
