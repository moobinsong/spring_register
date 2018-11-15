<%@ page language="java" contentType="text/html; charset=UTF-8" session="true"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">  
    <title>Signin</title>
    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="resources/css/signin.css" rel="stylesheet">
  	<script>
  		var error='${error}';
  		if(error!=''){
  			alert(error);
  		}
  	</script>
  </head>
  <body class="text-center">
    <form class="form-signin" method="post">      
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>     
      <label for="inputId" class="sr-only">아이디</label>
      <input type="text" id="inputId" name="userid" class="form-control" placeholder="아이디" required autofocus>
      <label for="inputPassword" class="sr-only">비밀번호</label>
      <input type="password" id="inputPassword" name="current_password" class="form-control" placeholder="비밀번호" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <div>
      	<p style="color:red">${error}</p>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
</html>