$(document).ready(function(){
    
    var user = false;
    var price = false;
    var pass = false;
    
    $("#addNew").click(function(){
        
        $("#paymentID").hide();
        $("#userDiv").show();
        $("#hiddenUpdate").val("");
        $("#passwordiv").show();
        
        $("#userid").val("");
        $("#ammount").val("");
        $("#pass").val("");
        $("#useresult").hide();
        $("#priceresult").hide();
        $("#passrslt").hide();
        user = false;
        price = false;
        pass = false;
        
        $("input[name='payType'][value='Cash']").prop('checked', true);
        $("#inputForm").toggle("slow", function(){
        });

    
         checkfunc();
        
  /*   
    $("#saveBtn").on("click", function(e)
    {
        
        e.preventDefault();
        $("saveBtn").attr("action","google.com").submit();
    
    
    });

 */
        
    $("#saveBtn").click(function()
    {
        $("saveBtn").submit();
    
    
    });    
        
   

    
});
    
    //update

   $(".btn-update").click(function(){
        $("#userDiv").hide();
        $("#passwordiv").hide();
        $("#paymentID").show();
        $("#userid").val("");
        $("#pass").val("");
        user = true;
        pass = true;
        price = false;


    $("#inputForm").toggle("slow", function(){
        });

       
    var payID = $(this).closest("tr").find("td:eq(0)").text();
    $("#displayid").text(payID);
    $("#hiddenUpdate").val(payID);
    var type = $(this).closest("tr").find("td:eq(1)").text();
    $("input[name='payType'][value='"+type+"']").prop('checked', true);
    $("#ammount").val($(this).closest("tr").find("td:eq(2)").text());


   checkfunc();
       
       
       
       
   }); 
         
    $("#saveBtn").click(function()
    {
        $("saveBtn").submit();
    
    
    });    
    
    
    
    
    function checkfunc()
    {
        $("#userid").blur(function()
        {
            var rslt = $("#useresult");
            if($("#userid").val().trim() == "")
            {
                $(rslt).text("Please enter User ID");
                $(rslt).css("color","red");
                $(rslt).show();

                user = false;
                btnControler();
            }
            else
            {
                $(rslt).hide();
                user = true;
                btnControler();

            }
        });
        
        $("#pass").blur(function()
        {
            var rslt = $("#passrslt");
            if($("#pass").val().trim() == "")
            {
                $(rslt).text("Please enter User Paasowrd");
                $(rslt).css("color","red");
                $(rslt).show();

                pass = false;
                btnControler();
            }
            else{
                $(rslt).hide();
                pass = true;
                btnControler();
            }
        });

        $("#ammount").blur(function()
        {
            var rslt = $("#priceresult");
            if($("#ammount").val().trim() == "")
            {
                $(rslt).text("Please enter Ammount");
                $(rslt).css("color","red");
                $(rslt).show();

                price = false;
                btnControler();

            }else{
            if(!$.isNumeric($("#ammount").val().trim())) 
            {
                $(rslt).text("Ammount must be Numerical Value");
                $(rslt).css("color","red");
                $(rslt).show();

                price = false;
                btnControler();
            }
            else
            {
                $(rslt).hide();
                price = true;
                btnControler();

            }}
        });
        

        function btnControler()
        {
            if(user == true && price == true && pass == true)
            {
                $("#saveBtn").prop("disabled",false);

            }
            else
            {
                $("#saveBtn").prop("disabled",true);
            }
        }
    }
    
    
    
    //delete
    $(".btn-delete").click(function(){
    	
     var payID = $(this).closest("tr").find("td:eq(0)").text();
   	 $(this).closest("tr").find("td:eq(4)").find("input").val(payID);
   	console.log($(this).closest("tr").find("td:eq(4)").find("input").val());
	
       $(this).closest("tr").find("td:eq(4)").find("form").submit();
    });
    
    
    
    
    
    
    });
    






