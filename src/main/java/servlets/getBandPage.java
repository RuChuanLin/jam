package servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _01_member.model.Member;
import _04_band.model.Band;
import _04_band.model.BandHBN;


@WebServlet("/getBandPage")
public class getBandPage extends HttpServlet {
	
	private static final String band_self=("/band_detail_self.html");
	private static final String band="/band_detail.html";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWhatever(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWhatever(req,resp);
	}
	private void doWhatever(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Access-Control_Allow-Origin","*");
		resp.addHeader("Content-Type", "multipart/mixed");
		int bandId=Integer.parseInt(req.getParameter("bandId"));
		Band bnd=new BandHBN().getItem(bandId);
		Member mem=(Member)req.getSession().getAttribute("Member");		
		if(mem==null || mem.getUserId()!=bnd.getAuthor()){
			this.getServletContext().getRequestDispatcher(band).forward(req, resp);
		}else{
			this.getServletContext().getRequestDispatcher(band_self).forward(req, resp);
		}

	}
	
	
	

	
	
	
	
	
}
