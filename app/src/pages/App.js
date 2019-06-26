import React, {Component} from 'react'
import UIPreviewBoard from '../widgets/UIPreviewBoard'
import UIAttributeBoard from '../widgets/UIAttributeBoard'
import {Provider} from 'react-redux'
import store from '../config/store'
import '../assets/app.css'
// import 'bootstrap/dist/css/bootstrap.css'
// import 'bootstrap/css/bootstrap.css'
// import 'rsuite/styles/less/index.less'; // 或者 'rsuite/dist/styles/rsuite.min.css'

class App extends Component {
    render() {
        return (
            <div className='App'>
                <UIPreviewBoard/>
                <UIAttributeBoard/>
            </div>
        )
    }
}

export default () => (
    <Provider store={store}>
        <App />
    </Provider>
)

