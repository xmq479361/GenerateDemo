import React, {Component} from 'react'
import {Provider} from 'react-redux'
import store from '../config/store'
import '../assets/app.css'
import UIElementBoard from "../widgets/UIElementBoard";
import UIAttributeBoard from "../widgets/UIAttributeBoard";
// import UIPreviewBoard from '../widgets/UIPreviewBoard'
import UIPreviewBoard from '../widgets/preview/index'
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
                <div className="rect-container">
                    <div className="rect-left">
                        <UIElementBoard/>
                    </div>
                    <div className="rect-center">
                        <UIPreviewBoard/>
                    </div>
                    <div className="rect-right">
                        <div  style={{width:'100%', height: '100%', backgroundColor: '#ffcccc'}}/>
                    </div>
                </div>
            </div>
        )
    }
// <UIAttributeBoard  style={{width:'100px','background-color': '#ffcccc', height: '100%'}}/>
}

{/*<div className="container-fluid">*/}
    {/*<div className="row main">*/}
        {/*<div className="nav ">*/}
            {/*<UIElementBoard/>*/}
        {/*</div>*/}
        {/*<div className="nav-right">*/}
            {/*<UIAttributeBoard/>*/}
        {/*</div>*/}
        {/*<div className="content">*/}
            {/*<div className="content-body">*/}
                {/*<UIPreviewBoard/>*/}
            {/*</div>*/}
        {/*</div>*/}
    {/*</div>*/}
{/*</div>*/}
export default () => (
    <Provider store={store}>
        <App/>
    </Provider>
)

