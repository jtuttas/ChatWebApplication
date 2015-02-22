/**
 * Via JQuery wird nach dem Laden des Dokumentes die Websocket Verbindung auggebaut
 * @type WebSocket
 */

var webSocket;

$(document).ready( function() {
     //webSocket = new WebSocket("ws://service.joerg-tuttas.de:8082/ChatWebApplication/chat");
     webSocket = new WebSocket("ws://raspi.joerg-tuttas.de:8081/ChatWebApplication/chat");
     //webSocket = new WebSocket("ws://localhost:8080/ChatWebApplication/chat");
     
     webSocket.onmessage = function(event){
                    $("#receive").prepend("<p>"+event.data+"</p>");
                };
    });

