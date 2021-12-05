package StudentCRUD.StudentCRUD;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
	@Path("getVendornos")
    @Produces("Application/json")
     */
   @GET   
   @Produces("Application/json")
    public List<StudentModel> getId() {
    	StudentDAO st=new StudentDAO();
    	List<StudentModel> stmdl=new ArrayList<StudentModel>() ;
    	stmdl= st.listAll();
    	return stmdl;
    }
   
   @GET
   @Path("/{StudentNo}")
   @Produces("Application/json")
    public StudentModel getId(@PathParam("StudentNo") int StudentNo) {
    	StudentDAO st=new StudentDAO();
    	List<StudentModel> stmdl=new ArrayList<StudentModel>() ;
    	StudentModel stData= st.getSingleStudDtls(StudentNo);
    	return stData;
    }
   
    @POST
    //@Path("/addNo")             
    @Produces("Application/json")
    public String AddNewStudent(StudentModel student) {
    	StudentDAO st=new StudentDAO();
    
    	boolean ss= st.add(student);
    	
    	if(ss)
    		return "Records Added Successfully";
    	else
    		return "Record Not Inserted";    				
    }
    
    @PUT 
    @Path("/{id}")
    @Produces("Application/json")
    public String UpdateStudent(@PathParam("id") int StudentNo,StudentModel stud) {
    	StudentDAO st=new StudentDAO();
    	stud.setStudent_no(StudentNo);
    	boolean ss= st.update(stud);
    	if(ss)
    		return "Updated Record Successfully.";
    	else
    		return "Records Not Updated.";    				
    }
    
    @DELETE
    @Path("/{id}")
    @Produces("Application/json")
    public String DeleteStudent(@PathParam("id") int StudentNo) {
    	StudentDAO st=new StudentDAO();
    	boolean ss= st.delete(StudentNo);
    	if(ss)
    		return "Record Deleted Successfully.";
    	else
    		return "Records Not Deleted.";    				
    }
}
