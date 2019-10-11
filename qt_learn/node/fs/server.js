let http = require('http')  // 创建web服务器
let fs = require('fs')  // fs 操作服务器的资源文件

let server = http.createServer()
server.on('request', (req, res) => {
  let url = req.url
  if (url === '/') {
    fs.readFile('./resource/index.html', (error, data) => {
      if (error) {
        res.setHeader('Content-Type', 'text/plain;charset=utf-8')
        res.end('资源不存在，请稍后子再试')
      } else {
        res.setHeader('Content-Type', 'text/html;charset=utf-8')
        res.end(data)
      }
    })
  } else if (url === '/img') {
    fs.readFile('./resource/hy.jpg', (error, data) => {
      if (error) {
        res.setHeader('Content-Type', 'text/plain;charset=utf-8')
        res.end('资源不存在，请稍后子再试')
      } else {
        res.setHeader('Content-Type', 'image/jpeg')
        res.end(data)
      }
    })
  }
})
server.listen(3000, () => {
  console.log('服务器已启动，可以访问啦。。。')
})