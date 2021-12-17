package telegrambotdemo;
import classes.room2;
import classes.courseera_result;
import classes.instructor2;
import classes.DayOfWeek;
import classes.Schedule;

import java.time.LocalDate;
import java.util.List;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TBot extends TelegramLongPollingBot {
	public void onUpdateReceived(Update update) {
		// if there is a message that has text
		courseera_result result = new courseera_result();
		SendMessage message = new SendMessage();
		message.setChatId(update.getMessage().getChatId().toString());
		
		if (update.hasMessage() && update.getMessage().hasText()) {
			// get the text of the message
			String receivedText = update.getMessage().getText();
			String[] inputList = receivedText.split(" ");
			
			if(inputList[0].equals("/byroom")) {
				room2 room = new room2() ;
				room.building = inputList[1].toUpperCase();
				room.roomnumber = inputList[2];
				String lst = result.roomSchedule(room).toString();
				message.setText(lst);
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			
			else if(inputList[0].equals("/byroomdate")) {
				room2 room = new room2() ;
				room.building = inputList[1].toUpperCase();
				room.roomnumber = inputList[2];
				int Day = Integer.parseInt(inputList[3]);
				int Month = Integer.parseInt(inputList[4]);
				int Year = Integer.parseInt(inputList[5]);
				String lst = result.roomSchedule(room, LocalDate.of(Year, Month, Day)).toString();
				message.setText(lst);
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			
			else if(inputList[0].equals("/byroomday")) {
				room2 room = new room2() ;
				room.building = inputList[1].toUpperCase();
				room.roomnumber = inputList[2];
				String Day = inputList[3];
				String lst = "";
				switch(Day) {
				case"Monday":
					lst = result.roomSchedule(room, DayOfWeek.Monday).toString();
					break;
				case"Tuesday":
					lst = result.roomSchedule(room, DayOfWeek.Tuesday).toString();
					break;
				case"Wednesday":
					lst = result.roomSchedule(room, DayOfWeek.Wednesday).toString();
					break;
				case"Thursday":
					lst = result.roomSchedule(room, DayOfWeek.Thursday).toString();
					break;
				case"Friday":
					lst = result.roomSchedule(room, DayOfWeek.Friday).toString();
					break;
				case"Saturday":
					lst = result.roomSchedule(room, DayOfWeek.Saturday).toString();
					break;
				}
				message.setText(lst);
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			
			else if(inputList[0].equals("/whowastherelast")) {
				room2 room = new room2() ;
				room.building = inputList[1].toUpperCase();
				room.roomnumber = inputList[2];
				String lst = result.whoWasThereLast(room).toString();
				message.setText(lst);
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			
			else if(inputList[0].equals("/whoistherenow")) {
				room2 room = new room2() ;
				room.building = inputList[1].toUpperCase();
				room.roomnumber = inputList[2];
				String lst = result.whoIsThereNow(room).toString();
				message.setText(lst);
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			
			else if(inputList[0].equals("/profschedule")) {
				instructor2 instructor = new instructor2();
				instructor.firstName = inputList[1];
				instructor.lastName = inputList[2];
				String lst = result.profSchedule(instructor).toString();
				message.setText(lst);
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			
			else if(inputList[0].equals("/wherewillprofbe")) {
				instructor2 instructor = new instructor2();
				instructor.firstName = inputList[1];
				instructor.lastName = inputList[2];
				String lst = result.whereWillProfBe(instructor).toString();
				message.setText(lst);
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

		}	
			
	}

	public String getBotUsername() {
		return "roomschdulebot";
	}

	@Override
	public String getBotToken() {
		return "2146288248:AAGWFUFVQaqC4jCzeO05XiTSWkH8lNPeawE";
	}
}