package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import _01_member.model.Member;
import _04_band.model.Band;
import _04_band.model.BandDAO;
import _04_band.model.BandHBN;

@WebServlet("/createBand")
public class createBand extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("create band");
		JsonObject bndInfo=new JsonParser().parse(req.getReader()).getAsJsonObject();
		JsonObject ret=new JsonObject();
		Member mem=(Member)req.getSession().getAttribute("Member");
		if(mem!=null){
			BandDAO bnd=new BandHBN();
			Band band=new Band();
			band.setArea(bndInfo.get("area").getAsString());
			band.setAuthor(mem.getUserId());
			band.setCategory(bndInfo.get("category").getAsString());
			band.setIsGrouped(bndInfo.get("isGrouped").getAsByte());
			band.setStyle(bndInfo.get("style").getAsString());
			band.setMateLink(bndInfo.get("mateLink").getAsString());
			band.setTitle(bndInfo.get("title").getAsString());
			band.setBandStatus(bndInfo.get("isGrouping").getAsByte());
			band.setDescription(bndInfo.get("intro").getAsString());
			band.setInstruments(bndInfo.get("wanted").getAsString());
			band.setImage(bndInfo.get("image").getAsString());
			bnd.saveBand(band);
			ret.addProperty("createSuccess", true);
		}else{
			System.out.println("probably not logged in");
			ret.addProperty("createSuccess", false);
		}
			
		PrintWriter pw=resp.getWriter();
		pw.write(ret.toString());
		pw.close();
		
		
		
	}

}
