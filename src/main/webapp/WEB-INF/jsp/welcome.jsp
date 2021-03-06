<html>
<head>
<title>Reservation Services Smoke Testing</title>
<style type="text/css">@import url(default.css);</style>
</head>
<body>
<font size="7">Welcome to the EHI Reservation Services Smoke Test Application.</font>
</body>
<br>
<br>
<script type='text/javascript' src='OTA30.js'></script>
<script type='text/javascript' src='XML.js'></script>
<script type='text/javascript'>
</script>
<input type="checkbox" name="alert" value="yes"><font size="4">Send alert to on-call upon failure</font><br>
<br>
<font size="3">Environment:</font>
<select id="environment" name="Environment">
<option value="xqa">xqa
<option value="pqa" selected>pqa
<option value="mint" selected>mint
<option value="pint" selected>pint
<option value="prod" selected>prod
</select>
<br>
<br>
<br>
<input type="checkbox" id="ota1" name="OTA" value="ota" checked><font size="6"><a href="http://www.google.com" onclick="MM_openBrWindow('C:\\Users\\e502dp\\Desktop\\otaSmokeTest.html','google','scrollbars=yes,width=650,height=500'); return false;">OTA</a></font><br>
<div id="myProgress">
  <div id="otaBar"></div>
  <div id="otaBarRed"></div>
</div>
<input type="checkbox" id="gds1" name="GDS" value="GDS" checked><font size="6"><a href="http://www.google.com" onclick="MM_openBrWindow('C:\\Users\\e502dp\\Desktop\\gdsSmokeTest.html','google','scrollbars=yes,width=650,height=500'); return false;">GDS</a></font><br>
<div id="myProgress">
  <div id="gdsBar"></div>
</div>
<br>
<input type="checkbox" id="services1" name="Res Services" value="services" checked><font size="6"><a href="http://www.google.com" onclick="MM_openBrWindow('C:\\Users\\e502dp\\Desktop\\resServiceSmokeTest.html','google','scrollbars=yes,width=650,height=500'); return false;">Res Services</a></font><br>
<div id="myProgress">
  <div id="servicesBar"></div>
</div>
<br>
<input type="checkbox" id="bridge1" name="Res Bridge" value="bridge" checked><font size="6"><a href="http://www.google.com" onclick="MM_openBrWindow('C:\\Users\\e502dp\\Desktop\\resBridgeSmokeTest.html','google','scrollbars=yes,width=650,height=500'); return false;">Res Bridge</a></font><br>
<div id="myProgress">
  <div id="bridgeBar"></div>
</div>
<br>
<input type="checkbox" id="natres1" name="Natres" value="natres" checked><font size="6"><a href="http://www.google.com" onclick="MM_openBrWindow('C:\\Users\\e502dp\\Desktop\\natresSmokeTest.html','google','scrollbars=yes,width=650,height=500'); return false;">Natres</a></font><br>
<div id="myProgress">
  <div id="natresBar"></div>
</div>
<br>
<input type="checkbox" id="ecom1" name="Legacy E.com" value="ecom" checked><font size="6"><a href="http://www.google.com" onclick="MM_openBrWindow('C:\\Users\\e502dp\Desktop\\ecomSmokeTest.html','google','scrollbars=yes,width=650,height=500'); return false;">Legacy E.com</a></font><br>
<div id="myProgress">
  <div id="ecomBar"></div>
</div>
<br>
<br>
<input type='button' value="Run" onclick='move()'>
<br>


<style>
#myProgress {
  width: 50%;
  background-color: #FFFFFF;
}

#otaBar {
  width: 0%;
  height: 30px;
  background-color: #4CAF50;
  }

  #otaBarRed {
    width: 0%;
    height: 30px;
    background-color: #FF0000;
   }

#gdsBar {
  width: 0%;
  height: 30px;
  background-color: #4CAF50;
}

#servicesBar {
  width: 0%;
  height: 30px;
  background-color: #4CAF50;
}
#bridgeBar {
  width: 0%;
  height: 30px;
  background-color: #4CAF50;
}
#natresBar {
  width: 0%;
  height: 30px;
  background-color: #4CAF50;
}
#ecomBar {
  width: 0%;
  height: 30px;
  background-color: #4CAF50;
}
</style>


<script>
function move() {
var x = document.getElementById("ota1").checked;
  if (x==true){
    var otaElem = document.getElementById("myProgress");
    var env = document.getElementById("environment");
   if (env[env.selectedIndex].value=="pqa") {
     var otaElem = document.getElementById("otaBarRed");
    } else {
      var otaElem = document.getElementById("otaBar");
    }
  var width = 1;
  var id = setInterval(frame, 190);
  function frame() {
    if (width >= 100) {
      clearInterval(id);
    } else {
      width++;
      otaElem.style.width = width + '%';
    }
  }
  }
  var x1 = document.getElementById("gds1").checked;
  if (x1==true){
  var gdsElem = document.getElementById("gdsBar");
  var width1 = 1;
  var id1 = setInterval(frame1, 160);
  function frame1() {
    if (width1 >= 100) {
      clearInterval(id1);
    } else {
      width1++;
      gdsElem.style.width = width1 + '%';
    }
  }
  }
  var x2 = document.getElementById("services1").checked;
  if (x2==true){
  var servicesElem = document.getElementById("servicesBar");
  var width2 = 1;
  var id2 = setInterval(frame2, 400);
  function frame2() {
    if (width2 >= 100) {
      clearInterval(id2);
    } else {
      width2++;
      servicesElem.style.width = width2 + '%';
    }
  }
  }
  var x3 = document.getElementById("bridge1").checked;
  if (x3==true){
  var bridgeElem = document.getElementById("bridgeBar");
  var width3 = 1;
  var id3 = setInterval(frame3, 600);
  function frame3() {
    if (width3 >= 100) {
      clearInterval(id3);
    } else {
      width3++;
      bridgeElem.style.width = width3 + '%';
    }
  }
  }
  var x4 = document.getElementById("natres1").checked;
  if (x4==true){
  var natresElem = document.getElementById("natresBar");
  var width4 = 1;
  var id4 = setInterval(frame4, 411);
  function frame4() {
    if (width4 >= 100) {
      clearInterval(id4);
    } else {
      width4++;
      natresElem.style.width = width4 + '%';
    }
  }
  }
  var x5 = document.getElementById("ecom1").checked;
  if (x5==true){
  var ecomElem = document.getElementById("ecomBar");
  var width5 = 2;
  var id5 = setInterval(frame5, 300);
  function frame5() {
    if (width5 >= 100) {
      clearInterval(id5);
    } else {
      width5++;
      ecomElem.style.width = width5 + '%';
    }
  }
  }
}
$("bereken").onclick = move;

</script>
<script type="text/javascript">
<!--

function MM_openBrWindow(theURL,winName,features) { //v2.0
window.open(theURL,winName,features);
}
//-->
</script>


</html>
