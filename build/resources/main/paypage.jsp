<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
  @import url(https://fonts.googleapis.com/css?family=Roboto:400,300,600,400italic);
* {
  margin: 0;
  padding: 10;
  box-sizing: border-box;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  -webkit-font-smoothing: antialiased;
  -moz-font-smoothing: antialiased;
  -o-font-smoothing: antialiased;
  font-smoothing: antialiased;
  text-rendering: optimizeLegibility;
}

body {
  font-family: "Roboto", Helvetica, Arial, sans-serif;
  font-weight: 100;
  font-size: 20px;
  line-height: 30px;
  color: #777;
  background: #8000ff;
}

.container {
  max-width: 400px;
  width: 100%;
  margin: 0 auto;
  position: relative;
  color: #897;
}

.container h1{
  max-width: 400px;
  width: 100%;
  margin: 0 auto;
  position: relative;
  color: #777;
}

#paypage {
  background: #F9F9F9;
  padding: 50px;
  margin: 150px 0;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

#paypage h1 {
  position: all;
  font-family: "Comic Sans MS", cursive, sans-serif;
  font-weight: 100;
  display: block;
  font-size: 30px;
  line-height: 70px;
  color: #777;
}

fieldset {
  font-family: "Comic Sans MS", cursive, sans-serif;
  border: medium none !important;
  margin: 0 0 10px;
  font-weight: 10;
  display: block;
  font-size: 20px;
  min-width: 100%;
  padding: 0;
  width: 100%;
}



#paypage input[type="submit"] {
  font-family: "Comic Sans MS", cursive, sans-serif;
  cursor: pointer;
  width: 40%;
  border: none;
  background: #8000ff;
  color: #FFF;
  margin: 0 0 5px;
  padding: 10px;
  font-size: 15px;
}
#paypage input[type="number"] {
  font-family: "Comic Sans MS", cursive, sans-serif;
  cursor: auto;
  width: 100%;
  border: none;
  background: #8080ff;
  color: #FFF;
  margin: 0 0 5px;
  padding: 10px;
  font-size: 15px;
}
#paypage input[type="password"] {
  cursor: auto;
  width: 100%;
  border: none;
  background: #8080ff;
  color: #FFF;
  margin: 0 0 5px;
  padding: 10px;
  font-size: 15px;
}
#paypage select{
  font-family: "Comic Sans MS", cursive, sans-serif;
  cursor: auto;
  width: 100%;
  border: none;
  background: #8080ff;
  color: #FFF;
  margin: 0 0 5px;
  padding: 20px;
  font-size: 15px;
}

</style>
<title>PayZ Payment Page</title>
</head>
<body>
<div class="container">  
<form id="paypage" action="/sampleCustomPG/makepayment" method="post">
			<h1>${invoiceNumber}</h1>
    <fieldset>
      <LABEL>Card Number </LABEL>
      <select id = "card" name="card_number">
                  <option value = "4111111111111111">4111111111111111 (Success)</option>
                  <option value = "4222222222222220">4222222222222220 (Failure)</option>
              </select>
    <fieldset>
      <input type="hidden" name="reference_id" value="${reference_id}">
    </fieldset>
    <fieldset></fieldset>
    <fieldset>
      <input type="submit" value=" Pay ${amount}" tabindex="4">
    </fieldset>
    </form>
    </div>
</body>
</html>