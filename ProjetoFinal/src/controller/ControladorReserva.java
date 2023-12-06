package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import DAO.ReservaDAO;
import model.Reserva;
import view.TelaPrincipal;
import view.TelaReserva;

public class ControladorReserva implements ActionListener {

    private TelaReserva telaReserva;
    private ReservaDAO reservaDAO;

    public ControladorReserva(TelaReserva telaReserva, ReservaDAO reservaDAO) {
        this.telaReserva = telaReserva;
        this.reservaDAO = reservaDAO;

        telaReserva.btnConfirmar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaReserva.btnConfirmar) {
            Reserva reserva = new Reserva();

            reserva.setNome(telaReserva.txtNome.getText());
            reserva.setEmail(telaReserva.txtEmail.getText());
            reserva.setTelefone(telaReserva.txtTelefone.getText());
            reserva.setDataCheckIn(LocalDate.parse(telaReserva.txtDataCheckIn.getText()));
            reserva.setDataCheckOut(LocalDate.parse(telaReserva.txtDataCheckOut.getText()));
            reserva.setNumeroQuarto(Integer.parseInt(telaReserva.txtNumeroQuarto.getText()));
            reserva.setTipoQuarto(telaReserva.txtTipoQuarto.getText());
            reserva.setNumeroHospedes(Integer.parseInt(telaReserva.txtNumeroHospedes.getText()));
            reserva.setNecessidadesEspeciais(telaReserva.txtNecessidadesEspeciais.getText());
            reserva.setMetodoPagamento(telaReserva.txtMetodoPagamento.getText());
            reserva.setTotalAPagar(Double.parseDouble(telaReserva.txtTotalAPagar.getText()));

            // Validar os dados da reserva

            if (reserva.getNome().isEmpty()) {
                JOptionPane.showMessageDialog(telaReserva, "O campo 'Nome' é obrigatório.");
                return;
            }

            if (reserva.getEmail().isEmpty()) {
                JOptionPane.showMessageDialog(telaReserva, "O campo 'E-mail' é obrigatório.");
                return;
            }

            if (reserva.getDataCheckIn().isBefore(LocalDate.now())) {
                JOptionPane.showMessageDialog(telaReserva, "A data de check-in deve ser posterior à data atual.");
                return;
            }

            if (reserva.getDataCheckOut().isBefore(reserva.getDataCheckIn())) {
                JOptionPane.showMessageDialog(telaReserva, "A data de check-out deve ser posterior à data de check-in.");
                return;
            }

            // Salvar a reserva

            try {
                reservaDAO.salvarReserva(reserva);
                telaReserva.dispose();
                new TelaPrincipal();
            } catch (Exception ei) {
                System.out.println("Erro ao salvar a reserva: " + ei.getMessage());
                JOptionPane.showMessageDialog(telaReserva, "Erro ao salvar a reserva. Tente novamente mais tarde.");
            }
        }
    }
}