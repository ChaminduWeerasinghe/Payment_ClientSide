package supportiveClasses;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;

public class PaymentClient 
{
	public static String updatePayment(Payment p) 
	{
		System.out.println("Update");
		System.out.println("ID"+p.getPtid());
		System.out.println("ID"+p.getPrice());
		System.out.println("ID"+p.getPtype());
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/HospitalManagementPAF2020/HealthCare/onlinepayment/updatepayment");
		Response response = target.request().put(Entity.json(p));
		
		String rslt = response.readEntity(String.class);
		
		if(rslt.equals("success"))
		{
			return "<div class=\"alert alert-success\" role=\"alert\">\r\n" + 
					"  Successfully Updated\r\n" + 
					"</div>";
		}
		else 
		{
			return "<div class=\"alert alert-danger\" role=\"alert\">\r\n" + 
					" Update Unsuccessfull\r\n" + 
					"</div>";
		}
	}
	
	public static String savePayment(savePayment sp)
	{
		System.out.println("save");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/HospitalManagementPAF2020/HealthCare/onlinepayment/savepayment");
		Response response = target.request().post(Entity.json(sp));
		
		String rslt = response.readEntity(String.class);
		
		if(rslt.equals("success"))
		{
			return "<div class=\"alert alert-success\" role=\"alert\">\r\n" + 
					"  Successfully Saved\r\n" + 
					"</div>";
		}else if(rslt.equals("invalid"))
		{
			
			return "<div class=\"alert alert-warning\" role=\"alert\">\r\n" + 
					"  Invalid User\r\n" + 
					"</div>";
		}
		else 
		{
			return "<div class=\"alert alert-danger\" role=\"alert\">\r\n" + 
					" Saving Unsuccessfull\r\n" + 
					"</div>";

		}
	}
	public static String deletePayment(int id)
	{
		System.out.println("Delete");
		System.out.println("ID : "+id);
		Client client = ClientBuilder.newClient();
		WebTarget basetarget = client.target("http://localhost:8080/HospitalManagementPAF2020/HealthCare/onlinepayment/");
		WebTarget deletetarget = basetarget.path("deletepayment");
		WebTarget parametertarget = deletetarget.path("{messageid}");

		System.out.println(parametertarget);
		String rslt = parametertarget.resolveTemplate("messageid", String.valueOf(id)).request(MediaType.APPLICATION_JSON).delete(String.class);

		if(rslt.equals("success"))
		{
			return "<div class=\"alert alert-success\" role=\"alert\">\r\n" + 
					"  Successfully Deleted\r\n" + 
					"</div>";
		}
		else 
		{
			return "<div class=\"alert alert-danger\" role=\"alert\">\r\n" + 
					" Deletion Unsuccessfull\r\n" + 
					"</div>";	
		}
	}
	
	public static String getPayments()
	{
		Client client = ClientBuilder.newClient();
		List<Payment> p = client.target("http://localhost:8080/HospitalManagementPAF2020/HealthCare/onlinepayment/")
				.path("paymentdetails").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Payment>>() {});
		
		String output = "" ;
		for(Payment pay : p)
		{
			output += "<tr>"
					 +"<td>"+pay.getPtid()+"</td>"
					 +"<td>"+pay.getPtype()+"</td>"
					 +"<td>"+pay.getPrice()+"</td>"
					 +"<td>"+pay.getDte()+"</td>"
					 +"<td>"
					 +"<button type='button'class='btn btn-xs btn-update'  style='background-color:transparent'  data-toggle='tooltip'><i class='material-icons update-icon'>&#xE254;</i></button>"
					 +"<form action=\"Payment.jsp\" class=\"deleteForm\" method=\"post\">"
					 +"<input type=\"text\" class=\"hiddenDelete\" name=\"hiddenDelete\" hidden>"
					 +"<button type='button'class='btn  btn-xs  btn-delete'  style='background-color:transparent'  data-toggle='tooltip'><i class='material-icons delete-icon'>&#xE872;</i></button>"
					 +"</form>"
					 +"</td>"
					 +"</tr>";
			
			
		}
		
		return output;
		
	}

}
