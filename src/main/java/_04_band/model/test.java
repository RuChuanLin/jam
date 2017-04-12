package _04_band.model;

import java.util.List;

import _00_init.util.HibernateUtil;

public class test {

	public static void main(String[] args) {
		BandHBN hbn =new BandHBN();
		Band band =  hbn.getItem(1);
		System.out.println(band.getTitle());
		band.setTitle("dasdasdsdada");
		hbn.updateBand(band);
		HibernateUtil.shutdown();
	}

}
