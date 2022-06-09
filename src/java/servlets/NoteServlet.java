
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;


public class NoteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        //read file
        BufferedReader buffer = new BufferedReader(new FileReader(new File(path)));
        String title = buffer.readLine();
        String content = buffer.readLine();
        
        Note note = new Note(title,content);
        request.setAttribute("note", note);
        
        
        buffer.close();
        
        String edit = request.getParameter("edit");
        
        if(edit == null){
             getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
             return;
        }
        else{
            //show the edit
             getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
             return;
        }
        
     
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        String getNewTitle = request.getParameter("title");
        String getNewContent = request.getParameter("content");
        
        pw.println(getNewTitle);
        pw.println(getNewContent);
        pw.close();
        
        Note note = new Note(getNewTitle, getNewContent);
        request.setAttribute("note", note);
        

        
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
        return;
     
    }



}
