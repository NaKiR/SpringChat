<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>

<html>
    <head>
        <title>Spring Chat</title>
    </head>

    <body>
    <div id="container">
        <div id="top">
            <t:insertAttribute name="top" />
        </div>

        <div id="main">
            <t:insertAttribute name="content" />
        </div>
    </div>
    </body>
</html>
