import React from 'react'
import { connect } from 'react-redux'
import BaseComponent from '../../lib/BaseComponent'
import { HomeWrapper, HomeLeft } from './style'
import { actionCreators } from './store/index'
import Topic from './components/Topic'

class Home extends BaseComponent {
  componentDidMount() {
    this.props.changeHomeData()
  }
  render() { 
    return (
      <HomeWrapper>
        <HomeLeft>
          <img className='banner-img' alt=''
            src="//upload.jianshu.io/admin_banners/web_images/4318/60781ff21df1d1b03f5f8459e4a1983c009175a5.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/1250/h/540" />
          <Topic />
        </HomeLeft>
      </HomeWrapper>
    )
  }
}
// 映射到props
const mapDispatchToProps = (dispatch) => {
  return {
    changeHomeData() {
      // action {} 请求数据 redux-thunk => action成为一个function
      dispatch(actionCreators.getHomeInfo())
    }
  }
}
// connect： mapDispatchToProps与组件Home关联绑定
export default connect(null, mapDispatchToProps)(Home)