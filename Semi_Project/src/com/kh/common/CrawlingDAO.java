package com.kh.common;

import java.io.IOException;
import java.util.ArrayList;

import com.kh.product.model.vo.Product;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingDAO {

	public ArrayList<Product> getCrawlingPro() {
		ArrayList<Product> pList = new ArrayList<>();
		
		String url = "https://starsportsmall.co.kr/goods/submain.asp?cate=781&sword=&swhat=&listtype=album&listsort=favorite";
		Document doc = null;
		Elements tmp;
		String proName;
		String proImg;
		String proPrice;
		
		try {
			doc =  Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements element = doc.select("ul.list-type1").eq(0).select("li");
		//Elements element2 = element.eq(0).select("a").eq(0).select("img");
		//.attr("src")
		//Elements element3 = element.eq(0).select("div.con").eq(0).select("p.price-area");
		//Elements element4 = element.eq(0).select("div.con").eq(0).select("a");
		for(int i=0;i<element.size();i++) {
			Product p = new Product();
			Elements element2 = element.eq(i).select("a").eq(0).select("img");
			p.setProImage(element2.attr("src"));
			Elements element3 = element.eq(i).select("div.con").eq(0).select("p.price-area");
			String str = element3.text();
			str = str.replaceAll(",", "");
			System.out.println(str);
			int proprice = Integer.parseInt(str);
			p.setProPrice(proprice);
			Elements element4 = element.eq(i).select("div.con").eq(0).select("a");
			p.setProName(element4.text());
			pList.add(p);
		}
		
		return pList;
	}
	
	public ArrayList<Product> getCrawlingProSin() {
		ArrayList<Product> pList = new ArrayList<>();
		
		String url = "http://soccerboom.co.kr/category/%EC%82%AC%EC%9D%B4%EC%A6%88%EB%B3%84%EC%B6%95%EA%B5%AC%ED%99%94/300/#none";
		Document doc = null;
		Elements tmp;
		String proName;
		String proImg;
		String proPrice;
		
		try {
			doc =  Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements element = doc.select("ul.prdList").eq(0).select("li");
//		Elements element2 = element.eq(0).select("div").eq(0).select("a").eq(0).select("img");
//		System.out.println(element2.attr("src"));
		//.attr("src")
		Elements element3 = element.eq(0).select("div.description").select("li.xans-record-").eq(2).select("span").eq(1);
		System.out.println(element3.html());
		
		//Elements element4 = element.eq(0).select("div.con").eq(0).select("a");
		
//		for(int i=0;i<element.size();i++) {
//			Product p = new Product();
//			Elements element2 = element.eq(0).select("div").eq(0).select("a").eq(0).select("img");
//			p.setProImage(element2.attr("src"));
//			Elements element3 = element.eq(i).select("div.con").eq(0).select("p.price-area");
//			String str = element3.text();
//			str = str.replaceAll(",", "");
//			System.out.println(str);
//			int proprice = Integer.parseInt(str);
//			p.setProPrice(proprice);
//			Elements element4 = element.eq(i).select("div.con").eq(0).select("a");
//			p.setProName(element4.text());
//			pList.add(p);
//		}
		
		return pList;
	}
}
