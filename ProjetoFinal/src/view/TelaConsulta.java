package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import model.Reserva;

public class TelaConsulta extends JFrame implements ActionListener {

    private JTable tabelaReservas;
    public JButton btnConsultar;

    public TelaConsulta() {
        super("Consultar Reservas");
        setLayout(new BorderLayout());

        JPanel panelDados = new JPanel(new FlowLayout());
        btnConsultar = new JButton("Consultar");
        btnConsultar.addActionListener(this);
        panelDados.add(btnConsultar);

        tabelaReservas = new JTable();
        // Use o modelo de tabela ReservaTableModel
        tabelaReservas.setModel(new ReservaTableModel());
        JScrollPane scrollPane = new JScrollPane(tabelaReservas);

        add(panelDados, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setSize(600, 400); // Ajuste o tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConsultar) {
            // Chame um método estático da classe Reserva para obter as reservas
            // (substitua "getReservas()" por seu método de obtenção de reservas)
            List<Reserva> reservas = Reserva.getReservas();
            // Atualize o modelo da tabela com as novas reservas
            tabelaReservas.setModel(new ReservaTableModel(reservas));
        }
    }

	public void limparLista() {
		// TODO Auto-generated method stub
		
	}

	public void addReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		
	}
}

class ReservaTableModel extends AbstractTableModel {

    private String[] colunas = {"Nome", "E-mail", "Telefone", "Data de Check-in", "Data de Check-out", "Número do Quarto", "Tipo do Quarto", "Número de Hóspedes", "Necessidades Especiais", "Método de Pagamento", "Total a Pagar", "Status da Reserva"};
    private List<Reserva> reservas; // Use a lista de reservas

    public ReservaTableModel() {
        // Inicialize a lista vazia
        this.reservas = new ArrayList<Reserva>();
    }

    public ReservaTableModel(List<Reserva> reservas) {
        // Use a lista de reservas fornecida
        this.reservas = reservas;
    }

    
    public int getRowCount() {
        return reservas.size();
    }

   
    public int getColumnCount() {
        return colunas.length;
    }

   
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reserva reserva = reservas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return reserva.getNome();
            case 1:
                return reserva.getEmail();
            case 2:
                return reserva.getTelefone();
            case 3:
                return reserva.getDataCheckIn();
            case 4:
                return reserva.getDataCheckOut();
            case 5:
                return reserva.getNumeroQuarto();
            case 6:
                return reserva.getTipoQuarto();
            case 7:
                return reserva.getNumeroHospedes();
            case 8:
                return reserva.getNecessidadesEspeciais();
            case 9:
                return reserva.getMetodoPagamento();
            case 10:
                return reserva.getTotalAPagar();
            case 11:
                return reserva.getStatusReserva();
            default:
                return null;
        }
    }

   
    public String getColumnName(int column) {
        return colunas[column];
    }
}