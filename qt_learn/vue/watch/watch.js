class watcher {
  constructor (opts) {
    this.$data = this.getBaseType(opts.data) === 'Object' ? opts.data : {}
    this.$watch = this.getBaseType(opts.watch) === 'Object' ? opts.watch : {}
    for (let key in opts.data) {
      this.setData(key, opts.data[key])
    }
  }

  getBaseType (target) {
    const typeStr = Object.prototype.toString.call(target)
    return typeStr.slice(8, -1)
  }

  setData(_key, _value) {
    // this: Object.defineProperty(this) 把上下文指向当前的对象
    Object.defineProperty(this, _key, {
      get: function () {
        return this.$data[_key]
      },
      set: function (val) {
        const oldVal = this.$data[_key]
        if (oldVal === val) return val
        this.$data[_key] = val
        this.$watch[_key] && typeof this.$watch[_key] === 'function' && this .$watch[_key].call(this, val, oldVal)
        return val
      }
    })
  }
}

let vm = new watcher({
  data: {
    a: 0,
    b: 'hello'
  },
  watch: {
    a(newVal, oldVal) {
      console.log(newVal, oldVal)
    }
  }
})

setTimeout(() => {
  vm.a = 7
}, 1000)