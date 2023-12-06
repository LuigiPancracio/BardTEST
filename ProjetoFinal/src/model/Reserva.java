package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Reserva implements Serializable {

    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private Integer numeroQuarto;
    private String tipoQuarto;
    private Integer numeroHospedes;
    private String necessidadesEspeciais;
    private String metodoPagamento;
    private Double totalAPagar;
    private String statusReserva;
    private String comentarios;
    private String codigoReserva;

    public Reserva() {
    }

    public Reserva(String nome, String email, String telefone,
    		LocalDate dataCheckIn, LocalDate dataCheckOut,
    		Integer numeroQuarto, String tipoQuarto, Integer numeroHospedes,
    		String necessidadesEspeciais, String metodoPagamento, Double totalAPagar,
    		String statusReserva, String comentarios, String codigoReserva) {

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroQuarto = numeroQuarto;
        this.tipoQuarto = tipoQuarto;
        this.numeroHospedes = numeroHospedes;
        this.necessidadesEspeciais = necessidadesEspeciais;
        this.metodoPagamento = metodoPagamento;
        this.totalAPagar = totalAPagar;
        this.statusReserva = statusReserva;
        this.comentarios = comentarios;
        this.codigoReserva = codigoReserva;
    }

    public String getNome() {
        return nome;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataCheckIn() {
		return dataCheckIn;
	}

	public void setDataCheckIn(LocalDate dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}

	public LocalDate getDataCheckOut() {
		return dataCheckOut;
	}

	public void setDataCheckOut(LocalDate dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public String getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public Integer getNumeroHospedes() {
		return numeroHospedes;
	}

	public void setNumeroHospedes(Integer numeroHospedes) {
		this.numeroHospedes = numeroHospedes;
	}

	public String getNecessidadesEspeciais() {
		return necessidadesEspeciais;
	}

	public void setNecessidadesEspeciais(String necessidadesEspeciais) {
		this.necessidadesEspeciais = necessidadesEspeciais;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public Double getTotalAPagar() {
		return totalAPagar;
	}

	public void setTotalAPagar(Double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}

	public String getStatusReserva() {
		return statusReserva;
	}

	public void setStatusReserva(String statusReserva) {
		this.statusReserva = statusReserva;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getCodigoReserva() {
		return codigoReserva;
	}

	public static List<Reserva> getReservas() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Reserva getReserva(int codigoReserva2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save() {
		// TODO Auto-generated method stub
		
	}

	public void setNome(String text) {
		// TODO Auto-generated method stub
		
	}
	
}
