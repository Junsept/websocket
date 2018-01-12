$(function() {

    var websocket;


    // 首先判断是否 支持 WebSocket
    if('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/websocket-test/websocket?userId="+3);
    } else if('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://localhost:8080/websocket-test/websocket");
    } else {
        websocket = new SockJS("http://localhost:8080/websocket-test/sockjs/websocket");
    }

    // 打开时
    websocket.onopen = function(evnt) {
        console.log("  websocket.onopen  ");
    };


    // 处理消息时
    websocket.onmessage = function(evnt) {
        $("#msg").append("<p><font color='red'>" + evnt.data + "</font></p>");
        console.log("  websocket.onmessage   ");
    };


    websocket.onerror = function(evnt) {
        console.log("  websocket.onerror  ");
    };

    websocket.onclose = function(evnt) {
        console.log("  websocket.onclose  ");
    };


    // 点击了发送消息按钮的响应事件
    $("#TXBTN").click(function(){

        // 获取消息内容
        var text = $("#tx").val();

        // 判断
        if(text == null || text == ""){
            alert("发送消息不能为空!!");
            return false;
        }

        
        var msg = {
                msgContent: text,
                chatType: "one",
                fromUserId: "3",
                toUserId:"1"
            };

        // 发送消息
        websocket.send(JSON.stringify(msg));

    });


});