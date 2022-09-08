package com.pojo.test;

import java.util.Random;

public class RandomNum 
{
public int randomnum()
{
	Random ran = new Random();
	int rannum = ran.nextInt(100);
	return rannum;
}
}
