package datastruc;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class blackjack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = "", a = "", b = "", c = "";
		String card1 = "", card2 = "", card3 = "", card4 = "", card5 = "";
		String carda = "", cardb = "", cardc = "", cardd = "", carde = "";
		String[] temp;
		int first = 0, second = 0, third = 0, fourth = 0, fifth = 0;
		int one = 0, two = 0, three = 0, four = 0, five = 0;
		int sum, sum2;
		
		//the code below chooses randomly between a value of 1 and 11
		int twoints = new Random().nextBoolean() ? 1 : 11;
		
		String[] typeCards = new String[] //card rank
				{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] classCards = new String[] //card suit
				{"S", "D", "C", "H"};
		String[] deck = new String[52];
		int count = 0;
		//this code combines the suit and the rank
		for(int i = 0; i < classCards.length; i++)
		{
			for(int j = 0; j < typeCards.length; j++)
			{
				deck[count] = classCards[i] + "-" + typeCards[j];
				count++;
			}
		}
		//this code shuffles the cards
		Stack<String> theStack = new Stack<String>();
		for(int i = 0; i < deck.length; i++)
		{
			int j = (int)(Math.random() * deck.length);
			if(deck[j].equals(" "))
			{
				i--;
			}
			else
			{
				theStack.push(deck[j]);
				//System.out.print(deck[j] + " ");
				deck[j] = " ";
			}
		}
		
		//System.out.println();
		//deals 1st card to player
		card1 = theStack.pop();
		System.out.println("<player 1> " + card1);
		//if suit and rank are combined, length = 3
		if(card1.length() == 4) //if length = 4, it means the value is 10
		{
			card1 = "10";
		}
		else
		{
			temp = card1.split(""); //splits the string
			card1 = temp[2]; //takes the 3rd character (counts from 0-2)
		}
		try
		{
			first = Integer.parseInt(card1); //converts the third character into an integer
		}
		catch(Exception e)
		{
			switch(card1) //equivalent values of letters
			{
			case "A":
				System.out.print("pick a value (1 or 11): "); //lets player pick a value
				s = in.nextLine();
				first = Integer.parseInt(s); //converts string(answer) into integer
				break;
			case "J":
				first = 10;
				break;
			case "Q":
				first = 10;
				break;
			case "K":
				first = 10;
				break;
			}
		}
		//deals 1st card to computer
		System.out.println("\ndealing first card to player 2...");
		carda = theStack.pop();
		//same process as the one above
		if(carda.length() == 4)
		{
			carda = "10";
		}
		else
		{
			temp = carda.split("");
			carda = temp[2];
		}
		try
		{
			one = Integer.parseInt(carda);
		}
		catch(Exception e)
		{
			switch(carda)
			{
			case "A":
				one = twoints; //allows the computer to choose either 1 or 11
				break;
			case "J":
				one = 10;
				break;
			case "Q":
				one = 10;
				break;
			case "K":
				one = 10;
				break;
			}
		}
		//deals 2nd card to player
		card2 = theStack.pop();
		System.out.println("\n<player 1> " + card2);
		if(card2.length() == 4)
		{
			card2 = "10";
		}
		else
		{
			temp = card2.split("");
			card2 = temp[2];
		}
		try
		{
			second = Integer.parseInt(card2);
		}
		catch(Exception e)
		{
			switch(card2)
			{
			case "A":
				System.out.print("pick a value (1 or 11): ");
				s = in.nextLine();
				second = Integer.parseInt(s);
				break;
			case "J":
				second = 10;
				break;
			case "Q":
				second = 10;
				break;
			case "K":
				second = 10;
				break;
			}
		}
		sum = first + second; //gets the sum of first 2 cards
		//deals 2nd card to computer
		System.out.println("\ndealing second card to player 2...");
		cardb = theStack.pop();
		if(cardb.length() == 4)
		{
			cardb = "10";
		}
		else
		{
			temp = cardb.split("");
			cardb = temp[2];
		}
		try
		{
			two = Integer.parseInt(cardb);
		}
		catch(Exception e)
		{
			switch(cardb)
			{
			case "A":
				two = twoints;
				break;
			case "J":
				two = 10;
				break;
			case "Q":
				two = 10;
				break;
			case "K":
				two = 10;
				break;
			}
		}
		sum2 = one + two; //sum of computer's first 2 cards
		//asks if player wants to draw one more card
		System.out.print("\nhit or stand?: ");
		a = in.nextLine();
		//if player wants to draw one more card
		if(a.equalsIgnoreCase("hit"))
		{
			System.out.println("\nyou have chosen hit");
			System.out.print("\n<player 1> ");
			card3 = theStack.pop();
			System.out.print(card3);
			
			System.out.println();
			
			if(card3.length() == 4)
			{
				card3 = "10";
			}
			else
			{
				temp = card3.split("");
				card3 = temp[2];
			}
			try
			{
				third = Integer.parseInt(card3);
			}
			catch(Exception e)
			{
				switch(card3)
				{
				case "A":
					System.out.print("pick a value (1 or 11): ");
					s = in.nextLine();
					third = Integer.parseInt(s);
					break;
				case "J":
					third = 10;
					break;
				case "Q":
					third = 10;
					break;
				case "K":
					third = 10;
					break;
				}
			}
			sum = first + second + third;
			System.out.println("\nthe value of your cards is " + sum);
		}
		else if(a.equalsIgnoreCase("stand")) //if player is satisfied with first 2 cards
		{
			System.out.println("\nthe value of your cards is " + sum);
		}
		
		//if the computer's cards have a value less than 21 it will draw one more card
		if(sum2 < 21 && sum < 21)
		{
			System.out.println("\nplayer 2 has chosen hit");
			System.out.println("\ndealing additional card to player 2...");
			cardc = theStack.pop();
			if(cardc.length() == 4)
			{
				cardc = "10";
			}
			else
			{
				temp = cardc.split("");
				cardc = temp[2];
			}
			try
			{
				three = Integer.parseInt(cardc);
			}
			catch(Exception e)
			{
				switch(cardc)
				{
				case "A":
					three = twoints;
					break;
				case "J":
					three = 10;
					break;
				case "Q":
					three = 10;
					break;
				case "K":
					three = 10;
					break;
				}
			}
			sum2 = one + two + three;
			if(a.equalsIgnoreCase("stand") && sum2 >= 21)
			{
			System.out.println("\n<player 2> [" + carda + ", " + cardb + ", " + cardc + "] " + sum2);
			}
		}
		//if value of computer's cards is 21 or over, it will stand
		else if(a.equalsIgnoreCase("stand") && sum2 >= 21)
		{
			System.out.println("\n<player 2> [" + carda + ", " + cardb + ", " + cardc + "] " + sum2);
		}
		
		if(a.equalsIgnoreCase("hit") && sum < 21)
		{
			System.out.print("\nhit or stand?: ");
			b = in.nextLine();
		//if player wants to draw one more card
			if(b.equalsIgnoreCase("hit"))
			{
				System.out.println("\nyou have chosen hit");
				System.out.print("\n<player 1> ");
				card4 = theStack.pop();
				System.out.print(card4);
			
				System.out.println();
			
				if(card4.length() == 4)
				{
					card4 = "10";
				}
				else
				{
					temp = card4.split("");
					card4 = temp[2];
				}
				try
				{
					fourth = Integer.parseInt(card4);
				}
				catch(Exception e)
				{
					switch(card4)
					{
					case "A":
						System.out.print("pick a value (1 or 11): ");
						s = in.nextLine();
						fourth = Integer.parseInt(s);
						break;
					case "J":
						fourth = 10;
						break;
					case "Q":
						fourth = 10;
						break;
					case "K":
						fourth = 10;
						break;
					}
				}
			}
			sum = first + second + third + fourth;
			System.out.println("\nthe value of your cards is " + sum);
		}
		else if(b.equalsIgnoreCase("stand")) //if player is satisfied with first 2 cards
		{
			System.out.println("\nthe value of your cards is " + sum);
		}
		
		if(sum2 < 21 && sum < 21)
		{
			System.out.println("\nplayer 2 has chosen hit");
			System.out.println("\ndealing additional card to player 2...");
			cardd = theStack.pop();
			if(cardd.length() == 4)
			{
				cardd = "10";
			}
			else
			{
				temp = cardd.split("");
				cardd = temp[2];
			}
			try
			{
				four = Integer.parseInt(cardd);
			}
			catch(Exception e)
			{
				switch(cardd)
				{
				case "A":
					four = twoints;
					break;
				case "J":
					four = 10;
					break;
				case "Q":
					four = 10;
					break;
				case "K":
					four = 10;
					break;
				}
			}
			sum2 = one + two + three + four;
			if(b.equalsIgnoreCase("stand") && sum2 >= 21)
			{
				System.out.println("\n<player 2> [" + carda + ", " + cardb + ", " + cardc + ", " + cardd + "] " + sum2);
			}
		}
		//if value of computer's cards is 21 or over, it will stand
		else if(b.equalsIgnoreCase("stand") && sum2 >= 21)
		{
			System.out.println("\n<player 2> [" + carda + ", " + cardb + ", " + cardc + ", " + cardd + "] " + sum2);
		}
		
		if(b.equalsIgnoreCase("hit") && sum < 21)
		{
			System.out.print("\nhit or stand?: ");
			c = in.nextLine();
		//if player wants to draw one more card
			if(c.equalsIgnoreCase("hit"))
			{
				System.out.println("\nyou have chosen hit");
				System.out.print("\n<player 1> ");
				card5 = theStack.pop();
				System.out.print(card5);
			
				System.out.println();
			
				if(card5.length() == 4)
				{
					card5 = "10";
				}
				else
				{
					temp = card5.split("");
					card5 = temp[2];
				}
				try
				{
					fifth = Integer.parseInt(card5);
				}
				catch(Exception e)
				{
					switch(card5)
					{
					case "A":
						System.out.print("pick a value (1 or 11): ");
						s = in.nextLine();
						fifth = Integer.parseInt(s);
						break;
					case "J":
						fifth = 10;
						break;
					case "Q":
						fifth = 10;
						break;
					case "K":
						fifth = 10;
						break;
					}
				}
			}
			sum = first + second + third + fourth + fifth;
			System.out.println("\nthe value of your cards is " + sum);
		}
		else if(c.equalsIgnoreCase("stand")) //if player is satisfied with first 2 cards
		{
			System.out.println("\nthe value of your cards is " + sum);
		}
		
		if(sum2 < 21 && sum < 21)
		{
			System.out.println("\nplayer 2 has chosen hit");
			System.out.println("\ndealing additional card to player 2...");
			carde = theStack.pop();
			if(carde.length() == 4)
			{
				carde = "10";
			}
			else
			{
				temp = carde.split("");
				carde = temp[2];
			}
			try
			{
				five = Integer.parseInt(carde);
			}
			catch(Exception e)
			{
				switch(carde)
				{
				case "A":
					five = twoints;
					break;
				case "J":
					five = 10;
					break;
				case "Q":
					five = 10;
					break;
				case "K":
					five = 10;
					break;
				}
			}
			sum2 = one + two + three + four + five;
			if(c.equalsIgnoreCase("stand") && sum2 >= 21)
			{
				System.out.println("\n<player 2> [" + carda + ", " + cardb + ", " + cardc + ", " + cardd + ", " + carde + "] " + sum2);
			}
		}
		else if(c.equalsIgnoreCase("stand") && sum2 >= 21)
		{
			System.out.println("\n<player 2> [" + carda + ", " + cardb + ", " + cardc + ", " + cardd + ", " + carde + "] " + sum2);
		}
		
		//statements that determine the winner
		if(sum == 21 && sum2 != 21)
		{
			System.out.println("\n~PLAYER 1 WINS~");
		}
		else if(sum2 == 21 && sum != 21)
		{
			System.out.println("\n~PLAYER 2 WINS~");
		}
		else if(sum == sum2)
		{
			System.out.println("\n-PUSH-");
		}
		else if(sum > 21 && sum2 < 21)
		{
			System.out.println("\n<player 1> -BUST-");
			System.out.println("\n~PLAYER 2 WINS BY DEFAULT~");
		}
		else if(sum2 > 21 && sum < 21)
		{
			System.out.println("\n<player 2> -BUST-");
			System.out.println("\n~PLAYER 1 WINS BY DEFAULT~");
		}
		else if(sum > sum2 && sum <= 21 && sum2 != 21)
		{
			System.out.println("\n~PLAYER 1 WINS~");
		}
		else if(sum2 > sum && sum2 <= 21 && sum != 21)
		{
			System.out.println("\n~PLAYER 2 WINS~");
		}//I EDITED MY PROJECT BUT I FEEL LIKE I MESSED IT UP EVEN MORE

	}//I GIVE UP LOL

}
