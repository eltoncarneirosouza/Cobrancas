package com.cobranca.CarteiraCobranca.time;

import java.util.Timer;

public class Main {

	public static void main(String[] args) {
		Timer t = new Timer();
		MyTask mTask = new MyTask();

		t.scheduleAtFixedRate(mTask, 0, 10000);
		
	}

}
