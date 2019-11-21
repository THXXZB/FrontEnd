const koa = require('koa')
const router = require('./router')
const koaBody = require('koa-body')

const app = new koa()
// 处理post请求
app.use(koaBody())

app.use(router.routes())
app.listen(3000, () => {
  console.log('run in http://localhost:3000')
})