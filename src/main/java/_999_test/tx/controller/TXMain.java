package _999_test.tx.controller;

import _999_test.tx.model.TX;
import _999_test.tx.model.TXDAO;
import _999_test.tx.model.TXObject;

public class TXMain {
	public static void main(String[] args) {
		TX tx = new TXDAO();
		TXObject txo = new TXObject(1);
		
		tx.updateObject(txo);
	}
}
