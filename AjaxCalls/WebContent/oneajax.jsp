<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Echo</title>

    <script>
        function dopost() {
            var xmlhttp = new XMLHttpRequest();
            var url = "./processServlet?say=" + document.getElementById('texthere').value;
            xmlhttp.open("POST", url, false);
            xmlhttp.send();
            document.getElementById('serverRes').innerHTML = xmlhttp.responseText;
        }
    </script>
</head>
<body>
    <textarea id="texthere" rows="3" cols="20"></textarea>
    <button onclick="dopost()">BUT</button>
    <textarea id="serverRes" rows="3" cols="20">

    </textarea>
</body>
</html>