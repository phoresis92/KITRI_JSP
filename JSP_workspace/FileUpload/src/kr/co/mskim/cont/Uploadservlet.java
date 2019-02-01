package kr.co.mskim.cont;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class Uploadservlet
 */
@WebServlet("/uploadservlet")
public class Uploadservlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8645993219620521971L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        //form 태그 enctype 이 form-data 이기때문에 getParameter먹히지 않는다
        System.out.println(request.getParameter("test111"));

        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List<FileItem> items = upload.parseRequest(request);
                Iterator<FileItem> iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();

                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        System.out.println("FileName : " + fileName);
                        System.out.println(item.getFieldName());

                        String root = getServletContext().getRealPath("/");
                        File path = new File(root + "/uploads");
                        //File path = new File("C://uploads");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                            System.out.println("mkdirs : " + status);
                        }
                        
                        //File uploadedFile = new File(fileName);

                        File uploadedFile = new File(path + "/" + fileName);
                        System.out.println("uploadedFile : " + uploadedFile.getAbsolutePath());
                        item.write(uploadedFile);
                    }
                    else {
                    	System.out.println(item.getFieldName());
                    	System.out.println(item.getString());
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
