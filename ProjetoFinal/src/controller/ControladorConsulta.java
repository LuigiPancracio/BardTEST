package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Reserva;
import view.TelaConsulta;

public class ControladorConsulta implements ActionListener {

    private TelaConsulta telaConsulta;

    public ControladorConsulta(TelaConsulta telaConsulta) {
        this.telaConsulta = telaConsulta;

        telaConsulta.btnConsultar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaConsulta.btnConsultar) {
            // Listar as reservas

            telaConsulta.limparLista();

            for (Reserva reserva : Reserva.getReservas()) {
                telaConsulta.addReserva(reserva);
            }
        }
    }
}