package com.iwinner.mashap.utils;

public class Upto50NumberLogic {
public static void main(String[] args) {
	for(int i=1;i<=50;i++){
		if(i%3==0){
			System.out.println("Threee  Divided "+i);
		}
		if(i%5==0){
			System.out.println("Five Divided "+i);
		}
		if(i%(3*5)==0){
			System.out.println("Three *** Five Divided "+i);
		}
	}
}
}
