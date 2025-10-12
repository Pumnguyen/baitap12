<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Support Admin</title>
<script>
	let socket = new WebSocket("ws://localhost:8080/chat-socket");

	socket.onmessage = function(event) {
		const msg = document.createElement("div");
		msg.textContent = event.data;
		document.getElementById("chatBox").appendChild(msg);
	};

	function sendMessage() {
		const input = document.getElementById("message");
		socket.send("Support: " + input.value);
		input.value = "";
	}
</script>
</head>
<body>
	<h2>Support Admin</h2>
	<div id="chatBox"
		style="border: 1px solid gray; height: 200px; width: 400px; overflow: auto;"></div>
	<input id="message" type="text" placeholder="Reply...">
	<button onclick="sendMessage()">Send</button>
</body>
</html>
