package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Reserva;
import view.TelaCancelamento;
import view.TelaPrincipal;

public class ControladorCancelamento implements ActionListener {

    private TelaCancelamento telaCancelamento;

    public ControladorCancelamento(TelaCancelamento telaCancelamento) {
        this.telaCancelamento = telaCancelamento;

        telaCancelamento.btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCancelamento.btnCancelar) {
            // Obter a reserva a ser cancelada

            int codigoReserva = Integer.parseInt(telaCancelamento.txtCodigoReserva.getText());
            Reserva reserva = Reserva.getReserva(codigoReserva);

            // Cancelar a reserva

            reserva.setStatusReserva("Cancelado");
            reserva.save();

            telaCancelamento.dispose();
            new TelaPrincipal();
        }
    }
}