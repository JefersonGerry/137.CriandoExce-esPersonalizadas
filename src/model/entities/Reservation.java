package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptions;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainExceptions {
		if(!checkOut.after(checkIn)) {// definindo que a data de check-out tem que ser posterior a data de check-in
			throw new DomainExceptions( "Check-out date must be after check-in dates.");
		}	
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
	public void updateDates(Date checkIn, Date checkOut) throws DomainExceptions {
		// throws DomainExceptions para se propagar a excessão dentro sem precisar se criar try/catch
		//para criar uma data com o horario de agora
		Date now = new Date();
		// problema 1 muito ruim
		// se a data de check-in for antes de agora ou a data de check-out for antes de agora
		// esse if define que a data não pode ser nem anterior e nem depois da data inicial definida
		if(checkIn.before(now)|| checkOut.after(now)) {
			 throw new DomainExceptions( " Reservation dates for update must be future dates.");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		//return null; para indicar ao compilador que não obtivemos nenhum erro
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
