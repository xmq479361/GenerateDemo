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
        // <i className="icon iconfont icon-input"></i>
        return (
            <li className="form-edit-widget-label">
                <span>{name}</span>
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
                    <li className="form-edit-widget-label">
                        <i className="icon iconfont icon-input"></i><span>单行文本</span>
                    </li>
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