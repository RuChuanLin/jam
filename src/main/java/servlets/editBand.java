package servlets;

import java.io.IOException;
import java.io.InputStreamReader;
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


@WebServlet("/editBand")
public class editBand extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonObject bndInfo=(JsonObject)new JsonParser().parse(new InputStreamReader(req.getInputStream(),"utf-8"));
		JsonObject ret=new JsonObject();
		
		req.setCharacterEncoding("UTF-8");
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
		
			ret.addProperty("editSuccess",true);
		
		}
		else{
			System.out.println("You probably not logged in");
			ret.addProperty("editSuccess", false);
		}
		
		
		PrintWriter pw=resp.getWriter();
		pw.write(ret.toString());
		pw.close();
		
		
		
		
	}
	
}
