/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import _01_member.model.Member;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Tutor  extends HttpServlet{
    private static final String CREATE_COURSE="createCrs";
    private static final String QUERY_COURSE="qCrs";
    private static final String EDIT_COURSE="editCrs";
    private static final String DELETE_COURSE="delCrs";
    private static final String GET_COURSE="getCrs";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObject ret=new JsonObject();
        JsonObject info=new JsonParser().parse(req.getReader()).getAsJsonObject();
        HttpSession ses=req.getSession(false);
        Member mem;
        if(ses==null){
            onFailed(ret);
        }
        else{   
            mem=(Member)ses.getAttribute("Member");
            switch(ret.get("servTyoe").getAsString()){
                case CREATE_COURSE : ret=createCourse(info,mem);break;
                case QUERY_COURSE : ret=queryCourse(info,mem);break;
                case  EDIT_COURSE :ret=editCourse(info,mem);break;
                case DELETE_COURSE :ret=deleteCourse(info,mem);break;
                case GET_COURSE : ret=getCourse(info,mem);break;     
                default :onFailed(ret);
                }
            }
        resp.setHeader("Access-Control-Allow-Origin","*");
        PrintWriter pw= resp.getWriter();
        pw.write(ret.toString());
        pw.close();
        
        
    }
    
    private void onFailed(JsonObject jso){
        jso.addProperty("error","somethings wrong");
    }
    private JsonObject createCourse(JsonObject info,Member mem){
        
        return new JsonObject();
    }
    
    private JsonObject queryCourse(JsonObject info,Member mem){
        
        return new JsonObject();
    }
    private JsonObject editCourse(JsonObject info,Member mem){
        
        return new JsonObject();
    }
    private JsonObject deleteCourse(JsonObject info,Member mem){
        
        return new JsonObject();
    }
    private JsonObject getCourse(JsonObject info,Member mem){
        
        return new JsonObject();
    }
    
    
    
    
    
}
