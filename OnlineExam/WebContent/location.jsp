

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Way2SMS.com - Mobile number tracker, find the location of the mobile number, Trace the location of mobile number</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page"> 
 <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
	var map;
    var geocoder;
  
  function initialize() {
  	 var latlng = new google.maps.LatLng(20.397, 82);
    var myOptions = {
      zoom: 5,
      center: latlng,
      mapTypeId: google.maps.MapTypeId.HYBRID
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
 	
    }

  function codeAddress(address1, provider,circle) {  
  	circle=circle.replace(/and/g,"&");
  	var address = address1;	
  	geocoder=new google.maps.Geocoder();  	
    if (geocoder) {    
      geocoder.geocode( { 'address': address}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
          map.setZoom(6);                             	
          map.setCenter(results[0].geometry.location);
          var marker = new google.maps.Marker({
              map: map,               
              position: results[0].geometry.location
          });
          infowindow.open(map,marker);
          google.maps.event.addListener(marker, 'click', function() {
          	infowindow.open(map,marker);
          });          
        } else {
          alert("Geocode was not successful for the following reason: " + status);
        }
      });
    }
    
    var contentString = '<div id="content">'+
        '<div id="siteNotice">'+
        '</div>'+        
        '<div id="bodyContent">'+
        '<table><tr><td>'+
        '<b>Mobile </b></td><td>: '+document.getElementById('hid_mobile').value+           
        '</td></tr><tr><td><b>State </b></td><td>: '+circle+  
        '</td></tr><tr><td><b>Provider </b></td><td>: '+provider+ 
        '</td></tr></table></div>'+
        '</div>';
        
        var infowindow = new google.maps.InfoWindow({
        content: contentString
    	});
  }  
</script>
  </head>
  <body onload="initialize();" leftmargin="0" rightmargin="0" topmargin="0" bottommargin="0">

		<input type="hidden" id="hid_mobile" name="hid_mobile" value=null >		
		<input type="hidden" id="hid_provider" name="hid_provider" value=null >
    	<div style="width:720px; _width:720px; height:598px; _height: 594px;"  id="map_canvas" ></div>

  </body>
<script> 
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-41615127-1', 'way2sms.com');
  ga('send', 'pageview');
</script>
</html>
