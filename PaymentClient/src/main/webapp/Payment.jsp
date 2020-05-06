<%@page import="supportiveClasses.PaymentClient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.*" %>
   <%
	try{
		if(!request.getParameter("hiddenUpdate").equals(""))
		{
			System.out.println("Update");
			Payment p = new Payment();
			p.setPtid(Integer.parseInt(request.getParameter("hiddenUpdate")));
			p.setPtype(request.getParameter("payType"));
			p.setPrice(Double.parseDouble(request.getParameter("ammount")));
			
			request.getSession().setAttribute("status", PaymentClient.updatePayment(p));
			
		}
		else if(!request.getParameter("userid").equals(""))
		{
			
			savePayment sp = new savePayment();
			sp.setUserName(request.getParameter("userid"));
			sp.setpass(request.getParameter("pass"));
			sp.setPrice(Double.parseDouble(request.getParameter("ammount")));
			sp.setPtype(request.getParameter("payType"));
			
			request.getSession().setAttribute("status", PaymentClient.savePayment(sp));
			
		}
		
			
		}
  	 catch(Exception e)
   	{
		 try{
			 if(!request.getParameter("hiddenDelete").equals(""))
				{
					request.getSession().setAttribute("status", PaymentClient.deletePayment(Integer.parseInt(request.getParameter("hiddenDelete"))));
				}
		 }
		 catch(Exception c)
		 {
			 
		 }
   	}
   %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="Components/payment.js"></script>
<link rel="stylesheet" href="Components/payment.css">
</head>
<body>
    <div class="container">
        <div class="table-wrapper">
        <form id="inputForm" method="POST" hidden>
            <input type="text" id="hiddenUpdate" name="hiddenUpdate" hidden>
			  <div class="form-group row" id="userDiv">
			    <label  class="col-sm-2 col-form-label col-form-label-sm">User Name</label>
                  <div class="col-sm-10">
			         <input type="text" min="1" class="form-control form-control-sm" id="userid" name="userid" placeholder="User Name">
                      <span hidden id="useresult"></span>
                  </div>
			  </div>
            <div class="form-group row" id="passwordiv">
			    <label  class="col-sm-2 col-form-label col-form-label-sm">User Password</label>
                  <div class="col-sm-10">
			         <input type="Password" min="1" class="form-control form-control-sm" id="pass" name="pass" placeholder="Password">
                      <span hidden id="passrslt"></span>
                  </div>
			  </div>
             <div class="form-group row" id="paymentID" >
			    <label  class="col-sm-5 col-form-label col-form-label-sm">Payment ID</label>
                  <div class="col-sm-7">
                      <span><b id="displayid"></b></span>
                  </div>
			  </div>
			  <div class="form-group row">
			    <label  class="col-sm-5 col-form-label col-form-label-sm">Payment Type</label>
                <div class="col-sm-7">
                    <label class="radio-inline">
                        <input type="radio" name="payType" value="Cash" checked>Cash
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="payType" value="Card">Card
                    </label>
                </div>
            </div>
			  <div class="form-group row">
			    <label class="col-sm-2 col-form-label col-form-label-sm">Ammount</label>
                <div  class="col-sm-10">
                    <input type="text" min="1" class="form-control form-control-sm" name="ammount" id="ammount" placeholder="Ammount">
                     <span hidden id="priceresult"></span>
                </div>
			  </div>			  
			  <button disabled type="submit" id="saveBtn" class="btn btn-primary ">Submit</button>
			</form>
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2>Payment <b>Details</b></h2></div>
                    <div class="col-sm-4">
                        <button type="button" id="addNew" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New</button>
                    </div>
                </div>
              <%if(request.getSession().getAttribute("status") != null){
                    out.print(request.getSession().getAttribute("status"));
                   	request.getSession().invalidate();
              
                 }%>
            </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Payment ID</th>
                        <th>Payment Type</th>
                        <th>Payment Price</th>
                        <th>Payment Date</th>
                    </tr>
                </thead>
                <tbody>
					<%
						out.print(PaymentClient.getPayments());
					%>

                  </tbody>
                </table>
               </div>
             </div>

</body>
</html>