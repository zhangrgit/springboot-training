#  用WebSocket + tail命令实现Web实时日志


### 背景:

* 在Linux操作系统中，经常需要查看日志文件的实时输出内容，通常会使用tail -f或者tailf命令。查看实时日志可能会需要首先SSH连上Linux主机，步骤很麻烦不说，如果是生产环境的服务器，可能还会控制各种权限。基于Web的实时日志可以解决这个问题。由于传统的HTTP协议是请求/响应模式，而实时日志需要不定时的持续的输出，由服务器主动推送给客户端浏览器。所以这里使用的是HTML5的WebSocket协议。


 * [Real-time log monitoring in your browser | Powered by node.js + socket.io] (http://logio.org/)  