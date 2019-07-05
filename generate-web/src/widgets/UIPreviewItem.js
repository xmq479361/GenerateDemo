import React, {Component} from "react";
import {updateWidget} from "../business/widgets/action";
import connect from "react-redux/es/connect/connect";

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

class _UIPreviewItem extends Component {
    constructor(props) {
        super(props)
        // this.onMouseEnter = this.onMouseEnter.bind(this);
        // this.onMouseLeave = this.onMouseLeave.bind(this);
    }

    getItemRender = (child, attrs = {}) => {
        let {type} = child
        let {style = {}} = attrs
        let {height} = style;
        switch (type) {
            case 'text':
                let {text = ""} = child
                if (height) {
                    style = push(style, {'line-height': height})
                }
                return (<label {...attrs} style={style}>{text}</label>)
            case 'input':
                return this.renderInput(child, attrs)
            case 'icon':
                return this.renderImage(child, attrs)
            // case 'spaceView':
            // return (<)
            default:
                return (<div {...attrs} />)
        }
    }

    renderInput(child, attrs = {}) {
        let {style = {}} = attrs
        let {hint = "", text = ""} = child
        let {height} = style;
        if (height) {
            style = push(style, {'height': height})
        }
        // if (background) {
        //     style = push(style, {'background-color': background})
        // }
        if (text) {
            attrs = push(attrs, {defaultValue: text})
        }
        console.log(attrs);
        attrs = push(attrs, {placeholder: hint})
        return (<input readOnly="true" style={style} {...attrs} type="text"/>)
    }

    renderImage = (child, style) => {
        let {src = ""} = child
        let attrs = {}
        if (src) {
            attrs = {src: require('../assets/' + src)}
        }
        return (<img style={style} {...attrs}/>)
    }
    renderAction = (type) => {
        // let {actionable = false} = this.props
        // if (!actionable) {
        //     return;
        // }
        if (type === 'container') {
            return (<div className="widget-view-action">
                <div className='widget-view-action-item'>+</div>
                <div className='widget-view-action-item'>X</div>
            </div>)
        }
        return (
            <div className="widget-view-action">
                <div className='widget-view-action-item'>X</div>
            </div>
        )
    }

    render() {
        let {width, height, grow, child, className, focusId} = this.props
        let {id} = child;
        let isFocused = id === focusId
        // console.log("focuseItem isFocused: ", isFocused, id, '===', focusId)
        if (isFocused) {
            console.log("focuseItem: ", child)
        }
        let {clzName, style, attrs} = attachStyleAndAttrs(width, height, child, getClassNameByGrow("", grow));
        if (className) {
            clzName += " " + className
        }
        let {type} = child
        className = clzName
        style = Object.assign(style, {position: 'relative'});
        let style2 = Object.assign({}, style, {height: ''});
        // console.log(typeof this.props, typeof style)
        if (isFocused) {
            let props = Object.assign(attrs, {height: '100%', className: className + " updating"})
            return (
                <div style={style2} {...props}  >
                    <div style={{'margin-left': '100px;','display': "block",}}>
                            <div className="" style={{"width": "100%;"}}>
                                {this.getItemRender(child, {className: "real_sub", style})}
                            </div>
                        {/*<span>*/}
                        {/*</span>*/}
                        <div className="widget-view-action">
                            {this.renderAction(type)}
                        </div>
                    </div>
                </div>
            )
        }
        let props = Object.assign(attrs, {height: '100%', className: className })
        return (
            <div style={style2} {...props} onClick={() => this.props.clickToUpdate(child)}>
                <div className={clzName} style={{'width': '100%'}}>
                    {this.getItemRender(child, {className: "real_sub", style})}
                </div>
            </div>
        )
    }

    // shouldComponentUpdate(nextProps, nextState) {
    //     this.setState({updating: true})
    //     this.state.isUpdating != nextState.isUpdating
    // }

}

const mapStateToProps = (state) => {
    let {focusWidget} = state
    let {id} = focusWidget
    return {
        focusId: id
    }
}
const mapDispatchToProps = (dispatch) => {
    return {
        clickToUpdate: (widget) => {
            dispatch(updateWidget(widget))
        }
    }
}
export default connect(
    mapStateToProps,
    mapDispatchToProps
)(_UIPreviewItem);
