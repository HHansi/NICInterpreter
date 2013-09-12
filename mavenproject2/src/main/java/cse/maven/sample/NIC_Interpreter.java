package cse.maven.sample;

import cse.maven.sample.exception.InvalidNICPropException;
import java.util.*;

public class NIC_Interpreter {

	
	public NICProp createNICProp(String NIC) throws InvalidNICPropException {
		try {
			return new NICProp(NIC);
		} catch(Exception ex) {
			throw new InvalidNICPropException();
		}
	}
	
        //calculate outputs
        public String calculate(NICProp nicProp){
            String gender;          
            String bday=nicProp.getNIC();

            String year = bday.substring(0, 2);
            int year_i= Integer.parseInt(year);
            year_i=year_i+1900;
            String days = bday.substring(2,5);
            int days_i=Integer.parseInt(days);
            
            //find Gender
            if(days_i>500){
                gender="Female";
            }
            else{
                gender="Male"; 
            }
            
            //fing birthday (month & day)
            if(days_i>500){
                days_i= days_i-500;
            }

            Calendar c = Calendar.getInstance();
            c.set(c.DAY_OF_YEAR, days_i);

            int month= c.get(c.MONTH)+1;
            int day = c.get(c.DATE)-1;
            
            //calculate age
            Date now=new Date();
            int age;
            String isVote;
            
            int nowYear=now.getYear()+1900;
            int nowMonth=now.getMonth()+1;
            int nowDay=now.getDate();
            
            
            age=nowYear-year_i;
            if(month>nowMonth){
                age--;
            }
            else if(month==nowMonth){
                if(day>nowDay){
                    age--;
                }
            }
            if(age>18){   
               isVote="true";
            }
            else{
                isVote="false";
            }
                        
            String output="Birthday= " + year_i + "-" +month +"-" + day  +", Gender= " + gender +", isVote= " + isVote ;
            return output;
            }
        
        //check validity of input        
	public boolean validate(NICProp nicProp) {	
                 int n=nicProp.getNIC().length();
                 return (n==10 && (nicProp.getNIC().endsWith("V")|| nicProp.getNIC().endsWith("v") )) ? true:false;                
	}
	
        public String Output(NICProp nicProp) throws InvalidNICPropException{
            if(!validate(nicProp)){
                throw new InvalidNICPropException();
            }
            return this.calculate(nicProp);
        }
	
}
