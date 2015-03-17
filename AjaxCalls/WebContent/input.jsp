<html>
<head>
    <title>jQuery Ajax POST data Request and Response Example</title>
 
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="app.js"></script>
</head>
<script type="text/javascript">

$(document).ready(function() {
    //Stops the submit request
    $("#myAjaxRequestForm").submit(function(e){
           e.preventDefault();
    });
    //checks for the button click event
    $("#myButton").click(function(e){
            //get the form data and then serialize that
            dataString = $("#myAjaxRequestForm").serialize();
            //get the form data using another method 
            var countryCode = $("input#countryCode").val(); 
            dataString = "countryCode=" + countryCode;
            //make the AJAX request, dataType is set to json
            //meaning we are expecting JSON data in response from the server
            $.ajax({
                type: "POST",
                url: "CountryInformation",
                data: dataString,
                dataType: "json",
                //if received a response from the server
                success: function( data, textStatus, jqXHR) {
                    //our country code was correct so we have some information to display
                     if(data.success){
                         $("#ajaxResponse").html("");
                         $("#ajaxResponse").append("<b>Country Code:</b> " + data.countryInfo.code + "");
                         $("#ajaxResponse").append("<b>Country Name:</b> " + data.countryInfo.name + "");
                         $("#ajaxResponse").append("<b>Continent:</b> " + data.countryInfo.continent + "");
                         $("#ajaxResponse").append("<b>Region:</b> " + data.countryInfo.region + "");
                         $("#ajaxResponse").append("<b>Life Expectancy:</b> " + data.countryInfo.lifeExpectancy + "");
                         $("#ajaxResponse").append("<b>GNP:</b> " + data.countryInfo.gnp + "");
                     } 
                     //display error message
                     else {
                         $("#ajaxResponse").html("<div><b>Country code in Invalid!</b></div>");
                     }
                },
                
                //If there was no resonse from the server
                error: function(jqXHR, textStatus, errorThrown){
                     console.log("Something really bad happened " + textStatus);
                      $("#ajaxResponse").html(jqXHR.responseText);
                },
                
                //capture the request before it was sent to server
                beforeSend: function(jqXHR, settings){
                    //adding some Dummy data to the request
                    settings.data += "&dummyData=whatever";
                    //disable the button until we get the response
                    $('#myButton').attr("disabled", true);
                },
                
                //this is called after the response or error functions are finsihed
                //so that we can take some action
                complete: function(jqXHR, textStatus){
                    //enable the button 
                    $('#myButton').attr("disabled", false);
                }
      
            });        
    });
 
});
</script>

<body>
    <form id="myAjaxRequestForm">
        <fieldset>
            <legend>jQuery Ajax Form data Submit Request</legend>
                <p>
                    <label for="countryCode">Country Code:</label>
                    <input id="countryCode" type="text" name="countryCode" />
                </p>
                <p>
                    <input id="myButton" type="button" value="Submit" />
                </p>
        </fieldset>
    </form>
    <div id="anotherSection">
        <fieldset>
            <legend>Response from jQuery Ajax Request</legend>
                 <div id="ajaxResponse"></div>
        </fieldset>
    </div>   
</body>
</html>