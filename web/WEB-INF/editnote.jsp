

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit_Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            <label>Title:</label>
            <input type="text" name="title" value="${note.title}">
            <br>
            <label>Contents</label>
            <textarea name ="content" rows="10" cols="20">${note.content} </textarea>
            <br>
            <input type="submit" value="Save">
            
        </form>
    </body>
</html>
