import React, {Component} from 'react'
import {connect} from 'react-redux'
import '../assets/app.css'

// function sliceArr(array, size) {
//     let result = [];
//     for (let x = 0; x < Math.ceil(array.length / size); x++) {
//         let start = x * size;
//         let end = start + size;
//         result.push(array.slice(start, end));
//     }
//     return result;
// }

class UIElementBoard extends Component {
    render() {
        return (
            <aside>
                <fieldset>
                    {this.renderElements()}
                </fieldset>
            </aside>
        )
    }

    renderElement = (element) => {
        let {name} = element
        return (
            <li className="form-edit-widget-label">
                <a href="#"><i className="icon iconfont icon-input"></i><span>{name}</span></a>
            </li>
        )
    }

    renderElements() {
        console.log("UIElementBoard: ")
        console.log(this.props.uiElements)
        let {uiElements} = this.props || [];
        return (
            <div className="components-list">
                <ul>
                    {uiElements.map(element => this.renderElement(element))}
                    <li className="form-edit-widget-label"><a href="#">
                    <i className="icon iconfont icon-input"></i><span>单行文本</span></a>
                    </li>
                    <li className="form-edit-widget-label"><a href="#"><i
                        className="icon iconfont icon-diy-com-textarea"></i><span>多行文本</span></a></li>
                    <li className="form-edit-widget-label"><a href="#"><i
                        className="icon iconfont icon-number"></i><span>计数器</span></a>
                    </li>
                    <li className="form-edit-widget-label"><a href="#"><i
                        className="icon iconfont icon-radio-active"></i><span>单选框组</span></a></li>
                    <li className="form-edit-widget-label"><a href="#"><i
                        className="icon iconfont icon-check-box"></i><span>多选框组</span></a></li>
                    <li className="form-edit-widget-label"><a href="#"><i
                        className="icon iconfont icon-time"></i><span>时间选择器</span></a>
                    </li>
                    <li className="form-edit-widget-label"><a href="#"><i
                        className="icon iconfont icon-date"></i><span>日期选择器</span></a>
                    </li>
                    <li className="form-edit-widget-label"><a href="#"><i
                        className="icon iconfont icon-icon-test"></i><span>评分</span></a></li>
                    <li className="form-edit-widget-label"><a href="#"><i
                        className="icon iconfont icon-color"></i><span>颜色选择器</span></a>
                    </li>
                    <li className="form-edit-widget-label"><a href="#"><i
                        className="icon iconfont icon-select"></i><span>下拉选择框</span></a></li>
                    <li className="form-edit-widget-label"><a href="#"><i
                        className="icon iconfont icon-switch"></i><span>开关</span></a></li>
                    <li className="form-edit-widget-label"><a href="#"><i
                        className="icon iconfont icon-slider"></i><span>滑块</span></a></li>
                </ul>
            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        uiElements: state.uiElements
    }
}
const mapDispatchToProps = (dispatch) => {
    return {}
}
export default connect(
    mapStateToProps,
    mapDispatchToProps
)(
    UIElementBoard
);