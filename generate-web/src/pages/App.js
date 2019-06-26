import React, {Component} from 'react'
import UIPreviewBoard from '../widgets/UIPreviewBoard'
import {Provider} from 'react-redux'
import store from '../config/store'
import '../assets/app.css'
import UIElementBoard from "../widgets/UIElementBoard";
import UIAttributeBoard from "../widgets/UIAttributeBoard";
// import 'bootstrap/dist/css/bootstrap.css'
// import 'bootstrap/css/bootstrap.css'
// import 'rsuite/styles/less/index.less'; // 或者 'rsuite/dist/styles/rsuite.min.css'

class App extends Component {
    render() {
        return (
            <div className='App'>
                <div className="logo">
                    logo
                </div>
                <div className="container-fluid">
                    <div className="row main">
                        <div className="col-md-3 nav">
                            <UIElementBoard/>
                        </div>
                        <div className="col-md-3 nav-right">
                            <UIAttributeBoard/>
                        </div>
                        <div className="col-md-4 content">
                            <div className="content-body">
                                <UIPreviewBoard/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default () => (
    <Provider store={store}>
        <App/>
    </Provider>
)

