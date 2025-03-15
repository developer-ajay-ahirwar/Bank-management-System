package com.bms.entity;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class GenerateAccountNum {
	
	public String genAccountNum() {
		String accountNum = "66666";
		Random random = new Random();
        String randomNumber= "";
        for(int i =0; i < 5 ; i++){
            String int_random_Number = String.valueOf(random.nextInt(10) + 1);
            randomNumber = randomNumber + int_random_Number;
        }
        
		return accountNum + randomNumber;
	}
}