<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Automation REST API | The Force</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Ubuntu:400,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700italic' rel='stylesheet' type='text/css'>
    <style>
        html, body, .valign-wrapper {
            height: 100%;
            background-color: #222;
            font-family: 'Ubuntu', sans-serif;

        }
        .styled {
            font-family: "Droid Serif", serif;
            font-style: italic;
            color: #4db6ac;
            margin-top: 40px;
        }
        .route {
            display: inline-block;
            width: 40%;
        }

        .card-panel {
            margin: auto;
            color: white;
        }
        a, a:hover, a:visited {
            color: #4db6ac;
        }
        .route-box {
            max-width: 520px;
            margin: 60px auto;
        }
        .powered {
            margin-top: 40px;
        }

        @media screen and (max-width: 550px) {
            .route {
                display: inherit;
                width: inherit;
            }
        }
    </style>
</head>
<body>
    <div class="valign-wrapper">
        <div class="container card-panel indigo valign" style="margin:auto;color:white">
            <h2 class="center-align">Home Automation REST API<br>(The Force)</h2>
            <h5 class="styled center-align">Want to turn on the lights? Use The Force!</h5>
            <div class="route-box">
                <p><span class="route">Get a list of all devices:</span><code class="route">GET api/devices</code><a href="api/devices">Example</a>
                <p><span class="route">Get device by ID:</span><code class="route">GET api/devices/{id} </code><a href="api/devices/1">Example</a>
                <p><span class="route">Register a new Device: </span><code class="route">POST api/devices</code></p>
                <p><span class="route">Change the state of device:</span><code class="route">PUT api/devices/{id}</code></p>
                <p><span class="route">Delete a device:</span><code class="route">DELETE api/devices/{id}</code></p>
                <p class="center-align powered">Powered by <a href="http://jersey.java.net">Jersey</a> and <a href="http://hibernate.org/">Hibernate</a></p>
            </div>
        </div>
    </div>
</body>
</html>