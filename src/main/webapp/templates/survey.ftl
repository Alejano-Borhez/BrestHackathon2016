<#ftl output_format="HTML">

<!doctype html>
<meta charset="utf-8">
<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    </head>
    <body>
       <div class="container-fluid">
       <div class="row-fluid">
               <h1> Hello ${user.name!""}! </h1>
           </div>
           <div class="row-fluid">
               As an EPAM'er you were a participant of an event "${event.eventName}"!

               It was held in ${event.location} at ${event.eventDate?date}.

               Brief description of an event:
               <p> ${event.eventDescription} </p>

               And there were many interesting actions specially for you:
               <#list event.actions as action>
                   <div class="row-fluid" id="${action.actionId}">
                        <img src="localhost:8080/application/img/actions/${action.actionId}.jpg"/>
                        <p> ${action.actionName} </p>
                        <p> ${action.actionDescription} </p>
                   </div>
               </#list>

               <strong>We are waiting for your feedback, ${user.name}!</strong>
           </div>
       </div>
    </body>
</html>