package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CustomerManager {

    private boolean isLoginSuccess=false;
    private static JSONArray customerList;
    private JSONParser jsonParser;

    public CustomerManager() {
        customerList = new JSONArray();
        jsonParser = new JSONParser();
    }
    public  void start(){
        Customer customer1 = new Customer("12312312312", 12, 12, 1995, "yas", 1200, 100, 1000, 100);
        writeJson(customer1);
        Customer customer2 = new Customer("10110111110",5,5,1995,"468ya",5000,1000,5000,0);
        writeJson(customer2);
    }
    public static void newUser () {
        customerList.add(new Customer("null",0,0,0,"null",0,0,0,0));
        int a=customerList.size()-1;
        String tcNo = "";
        int tcNoControl = 1;
        int birthdDay = 0;
        int birthDayControl=1;
        int birthMonth = 0;
        int birthMonthControl=1;
        int birthYear = 0;
        int birthYearControl=1;
        int passwordControl=1;
        String password="";
        double balance;
        double cardDept;
        double creditDept;
        double limitCreditCard;
        Scanner inp = new Scanner(System.in);
        while (tcNoControl == 1) {
            System.out.println("Tc Kimlik Numaranızı Giriniz");
            tcNo = inp.nextLine();
            
            int numberOfCharactersTcNo=tcNo.length();
            if(numberOfCharactersTcNo==11){
                int count =0;
                for(int i=0;i<10;i++){
                    if(tcNo.charAt(i)==i){
                        count++;
                    }
                }
                if(count==11){
                    customerList.get(a).setTcNo
                    tcNoControl++;

                }
            }else {
                System.out.println("Tekrar deneyiniz");
            }


                

        }
        while (birthDayControl==1){
            System.out.println("Doğum Gününüzü Giriniz");
            birthdDay= inp.nextInt();
            if(birthdDay>31&&birthdDay<1){
                System.out.println("Geçerli gün giriniz!");
            }else  {

                birthDayControl++;
            }
        }
        while (birthMonthControl==1){
            System.out.println("Doğum ayınızı giriniz");
            birthMonth=inp.nextInt();
            if (birthMonth<1&&birthMonth>12){
                System.out.println("Geçerli ay giriniz");
            }else{

                birthMonthControl++;
            }
        }
        while (birthYearControl==1){
            System.out.println("Doğum yılınızı giriniz");
            birthYear= inp.nextInt();
            if(birthYear>2004){
                System.out.println("18 yaşından küçükler hesap açamaz!");
            }else {

                birthYearControl++;
            }
        }
        while (passwordControl==1){
            System.out.println("Şifrenizi giriniz");
            password=inp.next();

            if(controlPassword(password, birthdDay, birthMonth, birthYear)){

                passwordControl++;
            }
            else {
                System.out.println("Şifrenizde doğum tarihi kullanılamaz");
            }
        }
        System.out.println("Hesabınızdaki para miktarını giriniz");
        balance=inp.nextDouble();

        System.out.println("Kredi kartı borcunuz=");
        cardDept=inp.nextDouble();

        System.out.println("Kredi kart limitiniz=");
        limitCreditCard=inp.nextDouble();
        System.out.println("Kredi borcunuz");
        creditDept=inp.nextDouble();





    }
    public static boolean controlPassword(String password, int birthdDay, int birthMonth, int birthYear){
        int count=0;
        boolean d;
        boolean m;
        boolean y;
        boolean passwordCheck=true;
        String sB=String.valueOf(birthdDay);
        String sM=String.valueOf(birthMonth);
        String sY=String.valueOf(birthYear);
        d=password.contains(sB);
        m=password.contains(sM);
        y=password.contains(sY);
        if(d)count++;
        if(m)count++;
        if(y)count++;
        if(count>0)passwordCheck=false;

        return passwordCheck;
    }


    private void writeJson(Customer customer) {

        JSONObject customerDetails = new JSONObject();
        customerDetails.put("tcNo", customer.getTcNo());
        customerDetails.put("birthdDay", customer.getBirthdDay());
        customerDetails.put("birthMonth", customer.getBirthMonth());
        customerDetails.put("birthYear", customer.getBirthYear());
        customerDetails.put("password", customer.getPassword());
        customerDetails.put("balance", customer.getBalance());
        customerDetails.put("limitCreditCard", customer.getLimitCreditCard());
        customerDetails.put("creditDept", customer.getCreditDept());


        customerList.add(customerDetails);



        try (FileWriter file = new FileWriter("customers.json")) {

            BufferedWriter buffer = new BufferedWriter(file);

            buffer.write(customerList.toJSONString());
            buffer.close();



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private JSONArray readJson() {

        JSONArray customerList = new JSONArray();

        try (FileReader reader = new FileReader("customers.json"))
        {
            //Read JSON file
            Object obj =  jsonParser.parse(reader);

            customerList = (JSONArray) obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return customerList;
    }



}
