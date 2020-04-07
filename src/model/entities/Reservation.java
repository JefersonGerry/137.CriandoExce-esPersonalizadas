package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		// covertendo milisegundos para dias
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	// quando se deseja atualizar alguma variavel dentro do programa
	// se passa ela como paramentro dentro da função
	public String updateDates(Date checkIn, Date checkOut) {
		
		//para criar uma data com o horario de agora
		Date now = new Date();
		// problema 1 muito ruim
		// se a data de check-in for antes de agora ou a data de check-out for antes de agora
		// esse if define que a data não pode ser nem anterior e nem depois da data inicial definida
		if(checkIn.before(now)|| checkOut.after(now)) {
			 return "Error in reservation: Reservation dates for update must be future dates.";
		}
		// problema 2 muito ruim
		if(!checkOut.after(checkIn)) {// definindo que a data de check-out tem que ser posterior a data de check-in
			return "Check-out date must be after check-in dates.";
		}	
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null; // para indicar ao compilador que não obtivemos nenhum erro
	}	
	@Override
	public String toString() {
		return "Room " 
	+roomNumber 
	+ ", check-in: " 
	+ sdf.format(checkIn) 
	+", check- Out: " 
	+ sdf.format(checkOut)  
	+ ", " 
	+ duration()
	+ " nights";
	}

}
