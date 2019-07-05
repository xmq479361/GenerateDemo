import React, {Component} from 'react'
import {connect} from 'react-redux'
// import '../assets/app.css'
import '../assets/preview.css'
import UIPreviewItemAdd from "./UIPreviewItemAdd";
import {Button, Modal} from "react-bootstrap";
import UIPreviewItem from "./UIPreviewItem";
// import { FontAwesomeIcon }from '@fortawesome/react-fontawesome'
// import { trash-alt } from '@fortawesome/fontawesome-free-solid'

const push = (source, attr) => {
    return Object.assign(source, attr)
}
const getClassNameByGrow = (clzName, grow = undefined) => {
    if (grow) {
        clzName += " flex-grow-" + grow;
    }
    return clzName
}

const isValidGrow = (value) => {
    return /^\d+$/.test(value);
}

const attachStyleAndAttrs = (width, height, child, clzName) => {
    let attrs = {}
    let style = {}
    console.log("attachStyleAndAttrs", width, height, child);
    let {background = ""} = child
    if (background) {
        style = push(style, {'background-color': background})
    }
    if (!height) {
        style = push(style, {height: '100%'})
    } else if (height.endsWith("px")) {
        // let sHeight = height.substring(0, height.length-2)
        // style = push(style, {height: parseInt(sHeight)+40+'px'})
        style = push(style, {height: height})
    } else {
    }
    if (width.endsWith("px")) {
        style = push(style, {width: width, "flex-grow": 0})
    } else if (width === "-1") {
        // style = push(style, {width: childWidth})
        clzName = getClassNameByGrow("", 0);
        style = push(style, {"flex-grow": 0})
    }
    return {clzName, style, attrs};
}


class UIPreviewWidget extends Component {
    constructor(props) {
        super(props)
        this.state = {
            updating: false,
        }
    }

    render() {
        return (
            <div onMouseDown={this.setState({updating: true})}>
                {this._renderWithState()}
            </div>
        )
    }

    _renderWithState() {
        if (this.state.updating) {
            return (<div
                style={"outline: 2px solid #409eff;border: 1px solid #409eff;"}
            ></div>)
        }
        return this.props.children
    }
}

class UIPreviewContainer extends Component {


}

const withContainerFloat = (children, flex_direction, clzName, style, attrs = {}, actionable = false) => {

    let styleee = Object.assign(style, {position: 'relative'});
    // let styleee = Object.assign(style, {});
    let className = "float-container " + clzName;
    switch (flex_direction) {
        case 'row':
            className += " flex-group-row widget-view-item";
            break;
        case 'column':
            className += " flex-group-column widget-view-item";
            break;
        default:
            break;
    }
    if (!actionable) {
        return (<div className={className} style={styleee} {...attrs}>
            <div className={clzName} style={{'width': '100%'}}>
                {children}
            </div>
        </div>)
    }
    {/*<div style={{height:"40px"}}></div>*/
    }
    return (<div className={className} style={styleee} {...attrs}>
        <div className={clzName} style={{'width': '100%'}}>
            {children}
        </div>
        <div className="widget-view-action">
            <div className='widget-view-action-item'>+</div>
            <div className='widget-view-action-item'>X</div>
        </div>
    </div>)
}

class FlexStrag {
    constructor(direction, justify, alignItems) {
        this.direction = direction;
        this.justify = direction;
        this.alignItems = alignItems;
    }

    getItemRenderWithContainer = (childWidth, childHeight, child, className, grow = undefined) => {
        return <UIPreviewItem className={className} width={childWidth} height={childHeight} grow={grow}
                              child={child}></UIPreviewItem>
    }


    getLayoutFromChild = (child, flex_direction, grow = undefined) => {
        let {width, height, type} = child
        console.log("getLayoutFromChild", type, flex_direction, width, height, grow);
        switch (type.toLowerCase()) {
            case "container":
                return this.getLayoutFromContainer(child, flex_direction, grow);
            default:
                return this.getItemRenderWithContainer(width, height, child, "", grow)
        }
    }
    getLayoutFromContainer = (container, flex_direction_parent = undefined, grow = undefined) => {
        let {
            flex_direction = 'column',
            justify_content = 'start',
            align_items = 'start',
            width,
            height,
            children = []
        } = container;
        // console.log("getLayoutFromContainer", flex_direction, justify_content, align_items);
        let flexStrag = new FlexStrag(flex_direction, justify_content, align_items);
        let childGrowMax = 0;
        let childGrowCount = 0;
        let childWraps = []
        let childGrows = []
        switch (flex_direction) {
            case 'row':
                childGrows = children.map(child => {
                    let {width,} = child
                    // console.log("childSize width: ", type, width, height);
                    if (isValidGrow(width)) {
                        childGrowMax += parseInt(width);
                        childGrowCount++
                    } else if (width === '-1') {
                        childWraps.push(child)
                    }
                    return width
                })
                break;
            case 'column':
                childGrows = children.map(child => {
                    let {height} = child
                    // console.log("childSize height: ", type, width, height);
                    if (isValidGrow(height)) {
                        childGrowMax += parseInt(height);
                        childGrowCount++
                    } else if (height === '-1') {
                        childWraps.push(child)
                    }
                    return height
                })
            default:
                break;
        }
        let growKey = 1;
        if (childGrowCount > 0) {
            growKey = childGrowCount / childGrowMax
        }
        console.log("row childSize: ", children.length, childGrowMax, childGrowCount,
            JSON.stringify(childGrows), childWraps.length, growKey)
        let className = getClassNameByGrow("", grow);
        switch (flex_direction) {
            case 'row':
                className += " flex-group-row";
                break;
            case 'column':
                className += " flex-group-column";
            default:
                break;
        }
        // return (
        //     <UIPreviewContainerItem className width={width} height={height} grow={grow} child={container}>
        //        {children.map(child => {
        //             let {width} = child;
        //             if (isValidGrow(width)) {
        //                 return flexStrag.getLayoutFromChild(child, width * growKey)
        //             } else {
        //                 return flexStrag.getLayoutFromChild(child, undefined)
        //             }
        //        })}</UIPreviewContainerItem>
        // )
        let {clzName, style, attrs} = attachStyleAndAttrs(width, height, container, className);
        return (
            withContainerFloat(children.map(child => {
                let {width} = child;
                if (isValidGrow(width)) {
                    return flexStrag.getLayoutFromChild(child, flex_direction, width * growKey)
                } else {
                    return flexStrag.getLayoutFromChild(child, flex_direction, undefined)
                }
            }), flex_direction_parent, `${clzName}`, style, attrs)
        )
    }
}


class UIPreviewBoard extends Component {
    constructor(props) {
        super(props);
        this.state = {dpName: false};
        this.onDisplayOverlays = this.onDisplayOverlays.bind(this);
        this.onCloseOverlays = this.onCloseOverlays.bind(this);
    }

    renderContainer = (container) => {
        let {
            flex_direction = 'column',
            justify_content = 'start',
            align_items = 'start',
        } = container;
        let flexStrag = new FlexStrag(flex_direction, justify_content, align_items);
        return (
            <div className="gridly">
                {flexStrag.getLayoutFromContainer(container)}
            </div>
        )
    }

    onDisplayOverlays = () => {
        this.setState({
            dpName: true
        });
    }

    onCloseOverlays = () => {
        this.setState({
            dpName: false
        });
    }

    render() {
        let {uiPage = {}} = this.props;
        console.log("UIPreviewBoard:: ")
        console.log(uiPage);
        let dialog = <div/>
        if (this.state.dpName) {
            dialog = (
                <Modal.Dialog>
                    <Modal.Header>
                        <Modal.Title>Modal title</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        One fine body...
                    </Modal.Body>
                    <Modal.Footer>
                        <Button onClick={this.onCloseOverlays}>Close</Button>
                        <Button bsStyle="primary">Save changes</Button>
                    </Modal.Footer>
                </Modal.Dialog>
            )
        }
        return (
            <div>
                {this.renderContainer(uiPage)}
                <UIPreviewItemAdd/>
                {dialog}
            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        uiPage: state.uiPage,
        focusWidget: state.focusWidget
    }
}
const mapDispatchToProps = (dispatch) => {
    return {}
}
export default connect(
    mapStateToProps,
    mapDispatchToProps
)(UIPreviewBoard);

