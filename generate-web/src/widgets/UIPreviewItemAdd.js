import React, {Component} from "react";
import {connect} from "react-redux";

import {ButtonToolbar, MenuItem, SplitButton} from 'react-bootstrap'
import {addWidget} from "../business/widgets/action";

class UIPreviewItemAdd extends Component {
    render() {
        let {uiElements} = this.props;
        console.log("uiElements");
        console.log(uiElements);
        return (
            <div>
                <ButtonToolbar>
                    <SplitButton title="添加组件" dropup id="split-button-dropup">
                        {uiElements.map(element=>{
                          console.log(element);
                          let {type, name, def} = element
                          return (<MenuItem  eventKey={type} onSelect={this.props.onAddElement} >{name}</MenuItem>)
                        })}
                        <MenuItem divider/>
                    </SplitButton>
                </ButtonToolbar>
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
    return {
        onAddElement: (elementType, event) => {
            console.log("onAddElement")
            console.log(elementType, event)
            dispatch(addWidget(elementType));
        }
    }
}
export default connect(
    mapStateToProps,
    mapDispatchToProps)(
    UIPreviewItemAdd
);