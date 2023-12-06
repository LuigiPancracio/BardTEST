package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaCancelamento;
import view.TelaConsulta;
import view.TelaPrincipal;
import view.TelaReserva;

public class ControladorPrincipal implements ActionListener {

    private TelaPrincipal telaPrincipal;

    public ControladorPrincipal(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;

        telaPrincipal.btnReservar.addActionListener(this);
        telaPrincipal.btnConsultar.addActionListener(this);
        telaPrincipal.btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.btnReservar) {
            new TelaReserva();
        } else if (e.getSource() == telaPrincipal.btnConsultar) {
            new TelaConsulta();
        } else if (e.getSource() == telaPrincipal.btnCancelar) {
            new TelaCancelamento();
        }
    }
}