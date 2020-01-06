import React from 'react';
import { Consumer } from './index';
export default (mapStateToProps, mapDispatchToProps) => (Wrap) => {
  // get state、dispatch
  class Connected extends React.Component {
    render () {
      return (
        <Consumer>
          {
            store => {
              const state = store.getState()
              const dispatch = store.dispatch
              const stateToProps = mapStateToProps(state)
              const dispatchToProps = mapDispatchToProps(dispatch)
              return (<Wrap {...stateToProps} {...dispatchToProps}></Wrap>)
            }
          }
        </Consumer>
      )
    }
  }
  return Connected 
}