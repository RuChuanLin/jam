package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import _04_band.model.Band;
import _04_band.model.BandDAO;
import _04_band.model.BandHBN;

@WebServlet("/queryBand")
public class queryBand extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Content-Type", "multipart/mixed; application/json;");
		JsonArray result=new JsonArray();
		
		System.out.println("create band");
		JsonObject bndInfo=new JsonParser().parse(req.getReader()).getAsJsonObject();
		JsonObject ret=new JsonObject();
		BandDAO bnd=new BandHBN();
		int page=bndInfo.get("page").getAsInt();
		List<Band> bands=bnd.getAllItem(bndInfo.get("query").getAsString(), page);
		page+=1;
		for(int i=0;i<bands.size();i++){
			JsonObject tmp=new JsonObject();
			Band theBand=bands.get(i);
			tmp.addProperty("bandId", theBand.getBandId());
			tmp.addProperty("area", theBand.getArea());
			tmp.addProperty("category", theBand.getCategory());
			tmp.addProperty("wanted", theBand.getInstruments());
			tmp.addProperty("isGrouped", theBand.getIsGrouped());
			tmp.addProperty("mateLinks", theBand.getMateLink());
			tmp.addProperty("isGrouping", theBand.getBandStatus());
			tmp.addProperty("image", theBand.getImage());
			result.add(tmp);	
		}
		
		ret.addProperty("page", page);
		ret.add("bnds", result);

		PrintWriter pw=resp.getWriter();
		pw.write(ret.toString());
		pw.close();	
		
	}

}
