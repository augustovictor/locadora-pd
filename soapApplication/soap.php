<html>
<head>
	<title>Log de ações</title>
	<meta charset="UTF-8">

</head>
<body>

<h1> Log de ações - Confia no monstro </h1>

	<?php 
		
		$clientSoap = new SoapClient("http://victor.local:8080/LogWebService/Logger?wsdl");

		$obj = $clientSoap->__call("logsList", array("parameters" => array()));
		echo "<ul>";
		    echo "<li>";
				echo "<p><pre>" . $obj->return . "</pre></p>";
				echo "<hr />";
		    echo "</li>";
		echo "</ul>";

	?>



</body>
</html>
