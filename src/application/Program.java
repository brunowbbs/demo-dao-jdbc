package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Seller obj = new Seller(1, "Wesley Bruno", "wbbs@gmail.com", sdf.parse("30/10/1992"), 8000.0, new Department(2, "Eletronics"));
		
		System.out.println(obj);
		

	}

}
