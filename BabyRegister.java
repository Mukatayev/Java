import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;



public class BabyRegister{



	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		String userCommand;

		Baby baby = new Baby();
		

		ArrayList<Baby> babies = new ArrayList<Baby>();

		Baby a = new Baby("21/11/1995", "Nuraly", 'M');
		babies.add(a);
		Baby b = new Baby("26/04/1994", "Zingo", 'F');
		babies.add(b);
		Baby c = new Baby("06/03/1995", "Kaisar", 'M');
		babies.add(c);

		Gift a1 = new Gift("Kaban", "100$", "25/11/1995");
		Gift b1 = new Gift("Attila", "200$", "27/04/1994");
		Gift c1 = new Gift("Bacho", "300$", "08/03/1995");
		
		baby.addGift(a1);
		baby.addGift(b1);
		baby.addGift(c1);



		do{
			System.out.println("*************"+"\n" + "Menu: "+"\n" +
			"Enter '1': Add new baby" +"\n" + "Enter '2': List Babies by age" +"\n" + "Enter '3': List Babies by name" + "\n" +
			"Enter '4': Add gift" +"\n" +"Enter '5': List gifts" +"\n" + "exit"+"\n" + "*************");
			userCommand = scanner.next();

			switch(userCommand){
				case "1":

					System.out.println("The name of the Baby:");
					String name = scanner.next();

					System.out.println("The birthday of the Baby(dd/MM/yyyy)");
					Date day = new Date();

					
					boolean validDate = false;
					while(!validDate){
						try{
							day = myFormat.parse(scanner.next());
							validDate = true;
						}catch(ParseException e){
							System.out.println("Invalid date, type it again");
							validDate = false;
						}
					}

					System.out.println("The gender of the Baby(M or F)");
					char gender = scanner.next().charAt(0);


					Baby pq = new Baby(day, name, gender);
					babies.add(pq);
					
					break;
				case "2":
					

					for(int i=0; i<babies.size()-1; i++){
						for(int j=i+1; j<babies.size(); j++){
							Baby s1 = babies.get(i);
							Baby s2 = babies.get(j);
					if(s1.getBirthday().compareTo(s2.getBirthday())>0){
						Baby aux = s1;
						babies.set(j,aux);
						babies.set(i, s2);
							}
						}
					}

					for(Baby p: babies){
							System.out.println(p+"\n"+"Age in a days: "+p.howOld()+"\n"+ "-----------");
					}
			

			
					break;

					case "3":

					for(int i=0; i<babies.size()-1; i++){
						for(int j=i+1; j<babies.size(); j++){
							Baby s1 = babies.get(i);
							Baby s2 = babies.get(j);
					if(s1.getName().compareTo(s2.getName())>0){
						Baby aux = s1;
						babies.set(j,aux);
						babies.set(i, s2);
							}
						}
					}

					for(Baby p: babies){
							System.out.println(p+"\n"+"Age in a days: "+p.howOld()+"\n"+ "-----------");
					}


					break;

					case "4":

					System.out.println("Name of the person who gave the gift:");
					name = scanner.next();

					System.out.println("Description of the gift:");
					String description = scanner.next();

					System.out.println("Date from when the gift was given(dd/MM/yyyy): ");
					day = new Date();

					
					validDate = false;
					while(!validDate){
						try{
							day = myFormat.parse(scanner.next());
							validDate = true;
						}catch(ParseException e){
							System.out.println("Invalid date, type it again");
							validDate = false;
						}
					}

					


					Gift g = new Gift(name, description, day);
					baby.addGift(g);


					break;
					case "5":
					baby.printGifts();
					break;

			}
			
		}while(!userCommand.equals("exit"));

	}

}