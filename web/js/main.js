/**
 * Via JQuery wird nach dem Laden des Dokumentes die Websocket Verbindung auggebaut
 * @type WebSocket
 */

var webSocket;

$(document).ready( function() {
     webSocket = new WebSocket("ws://service.joerg-tuttas.de:8082/ChatWebApplication/chat");
     
     webSocket.onmessage = function(event){
                    $("#receive").append("<p>"+event.data+"</p>");
                };
    });

