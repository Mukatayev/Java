import java.util.Date;
import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;



public class Gift{
	private Date day;
	private String name;
	private String description;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");



	public Gift(){
		
	}


	public Gift(String name, String description, Date day){
			this.day = day;
			this.name = name;
			this.description = description;
	}


	public Gift(String name, String description, String day){
			this.name = name;
			this.description = description;

			try{
				this.day = dateFormat.parse(day);
			}
			catch(ParseException e){
			System.out.println(e);
		}
	}


	public Date getDay(){
		return this.day;
	}

	public void setDay(Date day){
			this.day = day; 
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public String toString(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.day);
		return "Name of the person who gave the gift: "+ this.name.toString() + "\n" + 
		"Description of the gift: " + this.description.toString() + "\n" + "Date from when the gift was given: " + 
		dateFormat.format(this.day) 
		+ " "+calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE);
	}

}