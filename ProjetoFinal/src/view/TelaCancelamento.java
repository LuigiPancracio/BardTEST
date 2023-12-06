package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Reserva;

public class TelaCancelamento extends JFrame implements ActionListener {

    public JTextField txtCodigoReserva;
    public JButton btnCancelar;

    public TelaCancelamento() {
        super("Cancelar Reserva");
        getContentPane().setLayout(new BorderLayout());

        JPanel panelDados = new JPanel();
        txtCodigoReserva = new JTextField();
        txtCodigoReserva.setBounds(123, 28, 77, 19);
        panelDados.setLayout(null);
        JLabel label = new JLabel("Código da Reserva:");
        label.setBounds(25, 31, 90, 13);
        panelDados.add(label);
        panelDados.add(txtCodigoReserva);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);

        getContentPane().add(panelDados, BorderLayout.CENTER);
        getContentPane().add(btnCancelar, BorderLayout.SOUTH);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancelar) {
            // Obter a reserva a ser cancelada

            int codigoReserva = Integer.parseInt(txtCodigoReserva.getText());
            Reserva reserva = Reserva.getReserva(codigoReserva);

            // Cancelar a reserva

            if (reserva == null) {
                JOptionPane.showMessageDialog(this, "Reserva não encontrada.");
                return;
            }

            reserva.setStatusReserva("Cancelado");
            reserva.save();

            this.dispose();
            new TelaPrincipal();
        }
    }
}