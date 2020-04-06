package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			// dentro do if chamando checkOut da para se comparar se ele esta vindo 
			// depois do checkIn
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation reservation = new Reservation(number,checkIn,checkOut);
			// para se mostrar o dados da reserva basta jogar o objeto dentro da println
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			//para criar uma data com o horario de agora
			Date now = new Date();
			// problema 1 muito ruim
			// se a data de check-in for antes de agora ou a data de check-out for antes de agora
			// esse if define que a data não pode ser nem anterior e nem depois da data inicial definida
			if(checkIn.before(now)|| checkOut.after(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates.");
			}
			// problema 2 muito ruim
			else if(!checkOut.after(checkIn)) {// definindo que a data de check-out tem que ser posterior a data de check-in
				System.out.println("Error in reservation: Reservation dates for update must be future dates.");
			}
			// problema 3 muito ruim
			else {
				// com o metodo ja criado dentro da classe executora
				// se chama ela para atualizar
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}			
			
		}
		
		
        sc.close();
	}

}
