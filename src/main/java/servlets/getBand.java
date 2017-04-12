package servlets;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import _01_member.model.Member;
import _01_member.model.MemberHBN;
import _04_band.model.Band;
import _04_band.model.BandHBN;


@WebServlet("/getBand")
public class getBand extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonObject bndInfo=(JsonObject)new JsonParser().parse(new InputStreamReader(req.getInputStream(),"utf-8"));
		JsonObject ret=new JsonObject();
		resp.setHeader("Access-Control_Allow-Origin","*");
		req.setCharacterEncoding("UTF-8");
		int bandId=bndInfo.get("bandId").getAsInt();		
		Band band=new BandHBN().getItem(bandId);
		Member mem=new MemberHBN().getMember(band.getAuthor());
		
		mem=new MemberHBN().getMember(band.getAuthor());
		ret.addProperty("bandId",band.getBandId());
		ret.addProperty("authorAlias",mem.getAccount());
		ret.addProperty("auhorPic", mem.getPic());
		ret.addProperty("area",band.getArea());
		ret.addProperty("category",band.getCategory());
		ret.addProperty("wanted",band.getInstruments());
		ret.addProperty("style",band.getStyle());
		ret.addProperty("isGrouped",band.getIsGrouped());
		String mate=band.getMateLink();
		String [] mates=mate.split("|");
		ret.addProperty("mateLink",band.getMateLink());
		JsonObject picSet=new JsonObject();
		
		for(int e=0;e<mates.length;e++){
			String pic=new MemberHBN().getMember(Integer.parseInt(mates[e])).getPic();
			picSet.addProperty(mates[e], pic);	
		}
		ret.add("matePic", picSet);
		ret.addProperty("image", band.getImage());
		
		
		
		PrintWriter pw=resp.getWriter();
		pw.write(ret.toString());
		pw.close();
		
		
		
		
	}
	
}
