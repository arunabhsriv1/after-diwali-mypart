	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        body{padding-top:30px;}

     .glyphicon {  margin-bottom: 10px;margin-right: 10px;}

     small {
     display: block;
     line-height: 1.428571429;
     color: #999;
     }
    </style>
    <title>Document</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-sm-6 col-md-4">
                            <img src="http://placehold.it/380x500" alt="" class="img-rounded img-responsive" />
                        </div>
                        <div class="col-sm-6 col-md-8">
                            <h4>${managerprofile.username}</h4>
                            <p>
                                <i class="glyphicon glyphicon-envelope"></i>${managerprofile.email}
                                <br />
                                <i class="glyphicon glyphicon-phone"></i>${managerprofile.phone}
                                <br />
                                <i class="glyphicon glyphicon-user"></i>${managerprofile.role}
                                <br />
                                <i class="glyphicon glyphicon-home"></i>${managerprofile.address}
                                <br />

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>