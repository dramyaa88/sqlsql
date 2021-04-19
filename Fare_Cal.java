package JourneyDetails;
import UserDetails.User_ip;
import java.sql.*;
import UserDetails.User_Validation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Fare_Cal {
	  public static void main (String[] args) throws Exception
      {BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      Scanner p = new Scanner (System.in);
      System.out.print("1- for userDetails  "+ "  2-  Ticket booking  ---> ");
      int ss = p.nextInt();
      switch(ss) {
      case 2 :
      {      User_ip details = new User_ip();
             User_Validation uv = new User_Validation();
             System.out.print("Enter your Name: ");
             String k = br.readLine();
             details.setName(k);
        System.out.print("Enter your email: ");
        String e = br.readLine();
        details.setEmail(e);
        System.out.print("Enter the Phone Number: ");
        long ph = p.nextLong();
        details.set_phoNo(ph);
        try
	    {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busTicket","root","0608");
            PreparedStatement pstmt = con.prepareStatement("insert into userip(passengername,phn_number,email) values('"+k+"','"+ph+"','"+e+"');");
	        pstmt.executeUpdate();
	    }
	    catch (SQLException ex)
	    {	
	    } 
        double rand = (int)Math.floor(Math.random()*(9999-1111+1)+1111);
        uv.setOtp(rand);
        System.out.println(uv.getOtp());
        Scanner c = new Scanner (System.in);
        System.out.println("Enter the Otp: ");
        int check = c.nextInt();
        if (check==rand) {
        System.out.println("Enter the total number of seats would you like to book");
        int n=c.nextInt();
        List<Integer> seat=new ArrayList<>(10);
        System.out.println("enter your seat number total number of seats is 30");
        Integer[] totset = new Integer[]{1, 2, 3, 4, 5,6,7,8,9,10};
        List<Integer> Lists = new ArrayList<>(Arrays.asList(totset));
        System.out.println("Enter seat number between 1 to 30");
        for(int i=0;i<n;i++){
            seat.add(c.nextInt());
        }
        Start_End se = new Start_End();
        System.out.print("Enter the source:");
        String start = br.readLine();
        se.setSource(start);
        System.out.print("Enter the destination:");
        String end = br.readLine();
        se.setDestination(end);
        int kms=0;
        switch(start) {
        case "abc":
        	if (end.equals("bcd")) {
        		kms = 100;
        		break;
        	}
        	else if(end.equals("cde")) {
        		kms=200;
        		break;
        	}
        	else {
        		System.out.print("Invalid");
        		break;
        	}
        case "bcd":
        	if (end.equals("abc")) {
        		kms = 100;
        		break;
        	}
        	else if(end.equals("cde")) {
        		kms=100;
        		break;
        	}
        	else {
        		System.out.print("Invalid");
        		break;
        	}
        case "cde":
        	if (end.equals("abc")) {
        		kms = 200;
        		break;
        	}
        	else if(end.equals("bcd")) {
        		kms=100;
        		break;
        	}
        	else {
        		System.out.print("Invalid");
        		break;
        	}
        }
        if (kms<=0) {
        	System.out.print("Invalid");
        }
        else {
        	System.out.println(start+" to "+end+" distances is : "+kms);
        	int fair = kms*2*n;
        	System.out.println("Cost is : "+fair);
        }
        System.out.println("Enter the payment (yes/no) : ");
        String payment = br.readLine();
        if (payment.equals("yes")) {
        	//System.out.println("your name  is "+details.getName());
            //System.out.println("Your email is "+details.getEmail());
            System.out.println("Your ticket is from "+start+" to "+end);
            System.out.println("number of Tickets "+n);
        	System.out.println("Ticket Booked");
        }
        else {
        	System.out.println("Payment Failed");
        }
       }
        else {
        System.out.println("wrong otp please try again");
      }
      }
      case 1 :
    	  System.out.print("Enter the Phone Number: ");
          long ph = p.nextLong();
        //  details.set_phoNo(ph);
    	  try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busTicket","root","0608");
    			Statement stmt=con.createStatement();
    			ResultSet rs = stmt.executeQuery("select * from userip where phn_number="+ph);  
    			while(rs.next())  
    			System.out.println(rs.getString(1)+"  "+rs.getLong(2)+"  "+rs.getString(3));  
    			con.close();  
    			}
    			catch(Exception e){ 
    				System.out.println(e);}
	  }}
}