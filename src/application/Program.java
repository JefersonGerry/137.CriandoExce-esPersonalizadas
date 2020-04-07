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
				// com o metodo ja criado dentro da classe executora
				// se chama ela para atualizar
				String error = reservation.updateDates(checkIn, checkOut);
				if (error != null) {
				System.out.println("Reservation: " + error);
				
				}else {
					System.out.println("Reservation: " + reservation);
				}
			}			
			
		 sc.close();
		}
		 
	}


