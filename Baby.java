import java.util.Date;
import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;



public class Baby{
	private Date birthday;
	private String name;
	private char gender;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");





	public Baby(Date birthday, String name, char gender){
			this.birthday = birthday;
			this.name = name;
			this.gender = gender;
	}


	public Baby(String birthday, String name, char gender){
			this.name = name;
			this.gender = gender;

			try{
				this.birthday = dateFormat.parse(birthday);
			}
			catch(ParseException e){
			System.out.println(e);
		}
	}


	public Date getBirthday(){
		return this.birthday;
	}

	public void setBirthday(String birthday){
		try{
			this.birthday = dateFormat.parse(birthday);
		}
			catch(ParseException e){
			System.out.println(e);
		}
		 
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return this.gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String toString(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.birthday);

		return "Birthday: "+ dateFormat.format(this.birthday) + " "+calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE) + "\n" + "Name: " + this.name.toString() + "\n" + "Gender: " + this.gender;
	}


	public long howOld(){
		Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        Date birthday = new Date();
		birthday = getBirthday();
        long first = today.getTime() - birthday.getTime();
        long second = 1000 * 60 * 60 * 24;
        return first / second;
	}


	public boolean isOlder(Baby baby){
		return this.birthday.before(baby.getBirthday());
	}


	
	private ArrayList<Gift> gifts;


	public Baby(){
		gifts = new ArrayList<Gift>();
	}

	public void addGift(Gift p){
		gifts.add(p);
	}


	public ArrayList<Gift> getGifts(){
		return this.gifts;
	}

	public void setGifts(ArrayList<Gift> gifts){
		this.gifts = gifts;
	}

	
	public void printGifts(){
		for(Gift p: gifts){
			System.out.println(p+"\n"+ "-----------");
		}
	}
	




}