<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX calls using Jquery in Servlet</title>
        <script src="http://code.jquery.com/jquery-latest.js">   
        </script>
        <script>
            $(document).ready(function() {                        
                $('#submit').click(function(event) {  
                    var user=$('#user').val();
                 $.get('ajaxCall',{userName:user},function(responseText) { 
                        $('#welcometext').text(responseText);         
                    });
                });
            });
        </script>
</head>
<body>
<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
<br/>
<div id="welcometext">
</div>
</form>
</body>
</html>